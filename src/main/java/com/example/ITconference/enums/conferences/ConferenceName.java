package com.example.ITconference.enums.conferences;

public enum ConferenceName {
    WEB_APP("Web application development process"),
    MOBILE_APP("Mobile application development process"),
    DOCKER("How to setup docker");

    private final String message;

    ConferenceName(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
