package com.example.pokemonexplorerapp;

import java.io.Serializable;

/*
Aillen Teixeira
Student ID: 5120294
BIT603 Programming II
Assessment I

• Why is the class important in the OOP design of the app?
It is essential in the construction of Pokemon objects that will be added to a pokemonList and matched with the correct index.
The UI will rely on the names, images and descriptions of the pokemons.
• Describe the OOP concepts used in the class.
This class represents the Pokemon objects and its categories. It has a constructor that creates a new Pokemon object with the given parameters.
It also has getters and setters for each of the parameters.
 */
public class Pokemon implements Serializable {

    private String name;
    private String description;
    private String height;
    private String weight;
    private String category;
    private String ability;
    private int imageResourceID;

    public Pokemon(String name, String description, String height, String weight, String category, String ability, int imageResourceID) {
        this.name = name;
        this.description = description;
        this.height = height;
        this.weight = weight;
        this.category = category;
        this.ability = ability;
        this.imageResourceID = imageResourceID;
    }

    public Pokemon() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

}
