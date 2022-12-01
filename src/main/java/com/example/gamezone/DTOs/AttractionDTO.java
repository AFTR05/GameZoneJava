package com.example.gamezone.DTOs;

public class AttractionDTO {
    private String name;
    private String code;
    private String category;
    private Double price;

    public AttractionDTO(String name, String code, String category, Double price) {
        this.name = name;
        this.code = code;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
