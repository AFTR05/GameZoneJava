package com.example.gamezone.utilities;

import com.example.gamezone.model.TypeAttraction;

public class TypeConverter {
    public TypeAttraction stringToType(String type){
        if(type.equals(TypeAttraction.CONSOLE.getCategory())){
            return TypeAttraction.CONSOLE;
        }
        if (type.equals(TypeAttraction.PC.getCategory())){
            return TypeAttraction.PC;
        }
        if(type.equals(TypeAttraction.BOARDGAME.getCategory())){
            return TypeAttraction.BOARDGAME;
        }
        if(type.equals(TypeAttraction.OTHER.getCategory())){
            return TypeAttraction.OTHER;
        }else return null;
    }
}
