package com.example.android.polystore.model;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("error")
    private Boolean error;

    @SerializedName("message")
    private String message;

    @SerializedName("user")
    private RegistrationPojo registrationPojo;

    public Result(Boolean error, String message, RegistrationPojo registrationPojo) {
        this.error = error;
        this.message = message;
        this.registrationPojo = registrationPojo;
    }

    public Boolean getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public RegistrationPojo getUser() {
        return registrationPojo;
    }
}
