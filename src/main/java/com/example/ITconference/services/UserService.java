package com.example.ITconference.services;

import com.example.ITconference.mappers.UserMapper;
import com.example.ITconference.repositories.UserRepository;
import com.example.ITconference.repositories.entities.UserEntity;
import com.example.ITconference.services.dtos.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

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
        var userEntity = (List<UserEntity>) userRepository.findAll();
        return userEntity.stream()
                .map(userMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
