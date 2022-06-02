package com.example.ITconference.services;

import com.example.ITconference.exceptions.UserNotFoundException;
import com.example.ITconference.mappers.UserMapper;
import com.example.ITconference.repositories.UserRepository;
import com.example.ITconference.repositories.entities.UserEntity;
import com.example.ITconference.services.dtos.UserDto;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var entity = userRepository
                .findByUsername(username)
                .orElseThrow(UserNotFoundException::new);

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(entity.getRole().toString()));
        return new org.springframework.security.core.userdetails.User(entity.getUsername(), entity.getPassword(), authorities);
    }

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UUID saveUser(UserDto userDto){
        var userEntity = userMapper.fromDtoToEntity(userDto);
        var savedUserEntity = userRepository.save(userEntity);
        return savedUserEntity.getId();
    }

    public List<UserDto> getAllUsers(){
        var userEntities = (List<UserEntity>) userRepository.findAll();
        return userEntities.stream()
                .map(userMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public UserDto getUser(String username){
        var userEntity = userRepository.findByUsername(username);
        return userMapper.fromEntityToDto(userEntity.orElseThrow());
    }

}
