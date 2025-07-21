package com.example.pokemonexplorerapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/*
Aillen Teixeira
Student ID: 5120294
BIT603 Programming II
Assessment I

• Why is the class important in the OOP design of the app?
By orchestrating the recycler view and adapter for displaying a pokemonList.
• Describe the OOP concepts used in the class.
Inheritance by extending AppCompatActivity.
Polymorphism by overriding the onCreate method.
Encapsulates the logic of setting up the recycler view and adapter for displaying a pokemonList.

 */
public class PokemonListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);

        String userName = getIntent().getStringExtra(getResources().getString(R.string.user_name_key));
        TextView welcomeMessage = findViewById(R.id.welcomeMessage);
        String welcome = getString(R.string.welcome_message);

        welcomeMessage.setText(String.format("%s, %s!", welcome, userName));
        RecyclerView pokemonListRecyclerView = findViewById(R.id.pokemonListRecyclerView);
        pokemonListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        PokemonNamesRecyclerViewAdapter adapter = new PokemonNamesRecyclerViewAdapter(MainActivity.pokemonList);
        pokemonListRecyclerView.setAdapter(adapter);
    }
}