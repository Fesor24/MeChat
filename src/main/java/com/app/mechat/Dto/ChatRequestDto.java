package com.app.mechat.Dto;

public class ChatRequestDto {
    private String message;

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
