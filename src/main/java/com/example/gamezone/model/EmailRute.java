package com.example.gamezone.model;

public enum EmailRute {
    YAHOO("yahoo.com"),GOOGLE("gmail.com"),HOTMAIL("hotmail.com"),OUTLOOK("outlook.com");
    private String emailRute;

    public String getEmailRute() {
        return emailRute;
    }
    EmailRute(String emailRute) {
        this.emailRute = emailRute;
    }
}
