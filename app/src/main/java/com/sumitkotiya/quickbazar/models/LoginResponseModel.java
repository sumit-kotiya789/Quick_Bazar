package com.sumitkotiya.quickbazar.models;

public class LoginResponseModel {
    String message;

    public LoginResponseModel(String message) {
        this.message = message;
    }

    public LoginResponseModel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
