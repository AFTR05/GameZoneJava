package com.example.gamezone.model;

public enum TypeAttraction {
    CONSOLE("Console","@../../images/console.png","A"),PC("PC","@../../images/pc.png","B"),BOARDGAME("Board game","@../../images/boardGame.png","C"),OTHER("Other","@../../images/others.png","D");

    private String category;
    private String image;

    TypeAttraction(String category, String image, String letterCode) {
        this.category = category;
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

}
