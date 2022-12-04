package com.example.gamezone.model;

public enum TypeAttraction {
    CONSOLE("Console","src/main/resources/com/example/gamezone/images/console.png","A"),PC("PC","src/main/resources/com/example/gamezone/images/pc.png","B"),BOARDGAME("Board game","src/main/resources/com/example/gamezone/images/boardGame.png","C"),OTHER("Other","src/main/resources/com/example/gamezone/images/others.png","D");

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
