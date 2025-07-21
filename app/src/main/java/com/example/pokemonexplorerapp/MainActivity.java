package com.example.pokemonexplorerapp;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/*
Aillen Teixeira
Student ID: 5120294
BIT603 Programming II
Assessment I

• Why is the class important in the OOP design of the app?
This is the main class that will start the application. It extends appCompatActivity which is the parent class for all activities.
• Describe the OOP concepts used in the class.
It inherits from AppCompatActivity which has base functions for the app.
It overrides the onCreate method which is called when the activity is created, using polymorphism.
 */

public class MainActivity extends AppCompatActivity {

    public static List<Pokemon> pokemonList;
    public EditText userName;


    //Recycler View
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.user);
        Button exploreMoreButton = findViewById(R.id.recyclerViewActivityExploreMoreButton);

        exploreMoreButton.setOnClickListener(view -> {
            String user = userName.getText().toString().trim();

            if (user.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter your name before proceeding.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Hello, " + user + "! Welcome to the Pokémon Explorer App.", Toast.LENGTH_SHORT).show();
                loadPokemonList();
                Intent intent = new Intent(getApplicationContext(), PokemonListActivity.class);
                intent.putExtra(getResources().getString(R.string.user_name_key), user);
                startActivity(intent);
            }
        });
    }

    public void loadPokemonList() {
        pokemonList = new ArrayList<>();

        String[] pokemonNames = getResources().getStringArray(R.array.pokemon_names);
        String[] pokemonDescriptions = getResources().getStringArray(R.array.pokemon_descriptions);
        String[] pokemonHeights = getResources().getStringArray(R.array.pokemon_heights);
        String[] pokemonWeights = getResources().getStringArray(R.array.pokemon_weights);
        String[] pokemonCategories = getResources().getStringArray(R.array.pokemon_categories);
        String[] pokemonAbilities = getResources().getStringArray(R.array.pokemon_abilities);

        try (TypedArray pokemonImages = getResources().obtainTypedArray(R.array.images)) {

            for (int i = 0; i < pokemonNames.length; i++) {
                Pokemon pokemon = new Pokemon();

                pokemon.setName(pokemonNames[i]);
                pokemon.setDescription(pokemonDescriptions[i]);
                pokemon.setHeight(pokemonHeights[i]);
                pokemon.setWeight(pokemonWeights[i]);
                pokemon.setCategory(pokemonCategories[i]);
                pokemon.setAbility(pokemonAbilities[i]);
                pokemon.setImageResourceID(pokemonImages.getResourceId(i, 0));

                pokemonList.add(pokemon);
            }
            System.out.println(pokemonList);
        }
    }
}