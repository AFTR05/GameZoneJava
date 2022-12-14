package com.example.gamezone.model;

public class Attraction {
    private String name;
    private String code;
    private Double price;
    private TypeAttraction typeAttraction;


    public TypeAttraction getTypeAttraction() {
        return typeAttraction;
    }

    public void setTypeAttraction(TypeAttraction typeAttraction) {
        this.typeAttraction = typeAttraction;
    }

    public Attraction(String name, String code, Double price, TypeAttraction typeAttraction) {
        this.name = name;
        this.price = price;
        this.code=code;
        this.typeAttraction=typeAttraction;
    }

    public Attraction(){
        super();
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
