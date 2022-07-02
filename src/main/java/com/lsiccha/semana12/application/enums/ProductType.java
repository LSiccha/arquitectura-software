package com.lsiccha.semana12.application.enums;

public enum ProductType {
    DOG("dog"),
    CAT("cat"),
    FISH("FISH");

    private String description;

    ProductType(String type){
        this.description = type;
    }

    public String getType(){
        return this.description;
    }
}
