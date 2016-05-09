package com.dagong.service;

/**
 * Created by liuchang on 16/2/24.
 */
public enum UserInformationKey {
    DEFAULT_ADDRESS_KEY("defaultAddress"),
    OPEN_PHONENUMBER_KEY("openPhoneNumber"),
    OPEN_RESUME_KEY("openResume");

    private String name;

    UserInformationKey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
