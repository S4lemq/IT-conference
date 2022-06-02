package com.example.ITconference.enums;

public enum ApplicationUserRole {
    ADMIN(ApplicationUserRole.APP_ADMIN),
    USER(ApplicationUserRole.APP_USER);

    public static final String APP_ADMIN = "ADMIN";
    public static final String APP_USER = "USER";

    ApplicationUserRole(String myAdmin) {
    }
}
