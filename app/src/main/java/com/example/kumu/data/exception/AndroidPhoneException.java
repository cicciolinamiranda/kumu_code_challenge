package com.example.kumu.data.exception;

public class AndroidPhoneException extends Exception {
    int code;
    String message;

    public AndroidPhoneException(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
