package com.chiquete.portafolio.dtoClasses;

public class MailDto {

    public MailDto(){}

    private String from;
    private String message;
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
}
