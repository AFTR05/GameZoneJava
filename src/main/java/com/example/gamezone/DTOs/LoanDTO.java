package com.example.gamezone.DTOs;

public class LoanDTO {
    private String beginHour;
    private String endHour;
    private String nameAttraction;
    private String codeAttraction;

    public LoanDTO(String beginHour, String endHour, String nameAttraction,String codeAttraction) {
        this.beginHour = beginHour;
        this.endHour = endHour;
        this.nameAttraction = nameAttraction;
        this.codeAttraction=codeAttraction;
    }

    public String getCodeAttraction() {
        return codeAttraction;
    }

    public void setCodeAttraction(String codeAttraction) {
        this.codeAttraction = codeAttraction;
    }

    public String getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(String beginHour) {
        this.beginHour = beginHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getNameAttraction() {
        return nameAttraction;
    }

    public void setNameAttraction(String nameAttraction) {
        this.nameAttraction = nameAttraction;
    }
}
