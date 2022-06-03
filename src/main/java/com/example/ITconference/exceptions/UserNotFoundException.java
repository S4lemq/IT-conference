package com.example.ITconference.exceptions;

import com.example.ITconference.enums.exceptions.AuthenticationMessageEnum;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super(AuthenticationMessageEnum.USER_NOT_FOUND.getMessage());
    }
}
