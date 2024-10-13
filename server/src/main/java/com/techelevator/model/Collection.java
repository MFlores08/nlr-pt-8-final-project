package com.techelevator.model;

import jakarta.validation.constraints.NotBlank;

public class Collection {


    private int collectionId;
    @NotBlank(message = "The collection_name field must not be blank.")
    private String collectionName;

    public Collection (int collectionId, String collectionName){
        this.collectionId = collectionId;
        this.collectionName= collectionName;
    }

    public int getId(){
        return collectionId;
    }

    public void setId(int collectionId){
        this.collectionId = collectionId;
    }

    public String getName(){
        return collectionName;
    }

    public void setName(String collectionName) {
        this.collectionName = collectionName;
    }

    @Override
    public String toString(){
        return collectionName;
    }

}
