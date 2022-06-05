package com.example.ITconference.services;

import com.example.ITconference.exceptions.UserNotFoundException;
import com.example.ITconference.repositories.UserRepository;
import com.example.ITconference.repositories.entities.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserLogInfoService {

    private final UserRepository userRepository;

    public UserLogInfoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getLoggedUserEntity(){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();

        return userRepository.findByUsername(username)
                .orElseThrow(UserNotFoundException::new);
    }
}

