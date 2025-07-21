package com.example.pokemonexplorerapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*
Aillen Teixeira
Student ID: 5120294
BIT603 Programming II
Assessment I

• Why is the class important in the OOP design of the app?
Another class that inherits from AppCompatActivity e overwrites the onCreate method.
It manages the logic for displaying pokemon names, details and photos in the activity.
• Describe the OOP concepts used in the class.
Inheritance by extending AppCompatActivity.
Encapsulation: Code to update screen elements are encapsulated in this class.
Pokemon Objects: It uses a Pokemon object to get the data it needs to show.
 */

public class PokemonDetailActivity extends AppCompatActivity {
    private Pokemon currentPokemon;
    private TextView pokemonNameTextView;
    private ImageView pokemonImageView;
    private TextView descriptionTextView;
    private TextView itemDescriptionTextView;
    private RadioButton heightRadioButton, categoryRadioButton, weightRadioButton, abilityRadioButton;
    private Button exploreMoreButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        initializeViews();

        int pokemonIndex = getIntent().getIntExtra("pokemon_index", -1);

        this.currentPokemon = MainActivity.pokemonList.get(pokemonIndex);

        setPokemonData();
        addRadioButtonListeners();
        configureExploreMoreButton();
        setupActionBar();
    }

    private void initializeViews() {
        pokemonNameTextView = findViewById(R.id.pokemonItemName);
        pokemonImageView = findViewById(R.id.pokemonItemImage);
        descriptionTextView = findViewById(R.id.description);
        itemDescriptionTextView = findViewById(R.id.itemDescription);
        heightRadioButton = findViewById(R.id.heightRadioButton);
        categoryRadioButton = findViewById(R.id.categoryRadioButton);
        weightRadioButton = findViewById(R.id.weightRadioButton);
        abilityRadioButton = findViewById(R.id.abilityRadioButton);
        exploreMoreButton = findViewById(R.id.recyclerViewActivityExploreMoreButton);
    }

    private void setPokemonData() {
        pokemonNameTextView.setText(currentPokemon.getName());
        descriptionTextView.setText(currentPokemon.getDescription());
        pokemonImageView.setImageResource(currentPokemon.getImageResourceID());

        heightRadioButton.setChecked(true);
        getPokemonAttributes("height");
    }

    private void addRadioButtonListeners() {
        heightRadioButton.setOnClickListener(v -> getPokemonAttributes("height"));
        categoryRadioButton.setOnClickListener(v -> getPokemonAttributes("category"));
        weightRadioButton.setOnClickListener(v -> getPokemonAttributes("weight"));
        abilityRadioButton.setOnClickListener(v -> getPokemonAttributes("ability"));
    }

    private void getPokemonAttributes(String type) {
        String detailToShow = "";
        switch (type) {
            case "height":
                detailToShow = currentPokemon.getHeight();
                break;
            case "category":
                detailToShow = currentPokemon.getCategory();
                break;
            case "weight":
                detailToShow = currentPokemon.getWeight();
                break;
            case "ability":
                detailToShow = currentPokemon.getAbility();
                break;
            default:
                detailToShow = "";
                break;
        }
        itemDescriptionTextView.setText(detailToShow);
    }

    private void configureExploreMoreButton() {
        exploreMoreButton.setOnClickListener(v -> finish());
    }

    private void setupActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(currentPokemon.getName());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}