package com.example.ITconference.mappers;

import com.example.ITconference.repositories.entities.UserEntity;
import com.example.ITconference.services.dtos.UserDto;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity fromDtoToEntity(UserDto userDto){
        var entity = new UserEntity();

        entity.setUsername(userDto.getUsername());
        entity.setPassword(encodedPassword(userDto.getPassword()));
        entity.setEmail(userDto.getEmail());
        entity.setRole(userDto.getRole());

        return entity;
    }

    public UserDto fromEntityToDto(UserEntity userEntity){
        var dto = new UserDto();

        dto.setUsername(userEntity.getUsername());
        dto.setPassword(userEntity.getPassword());
        dto.setEmail(userEntity.getEmail());
        dto.setRole(userEntity.getRole());

        return dto;
    }

    private String encodedPassword(String password){
        var salt = BCrypt.gensalt();
        return BCrypt.hashpw(password,salt);
    }

}
