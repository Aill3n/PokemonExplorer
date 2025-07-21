package com.example.pokemonexplorerapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

/*
Aillen Teixeira
Student ID: 5120294
BIT603 Programming II
Assessment I

• Why is the class important in the OOP design of the app?
Manages how the pokemon names and images are displayed in the recycler view.
• Describe the OOP concepts used in the class.
Inheritance by extending RecyclerView.ViewHolder.
Encapsulation hiding the implementation logic of the class.
 */

public class PokemonViewHolder extends RecyclerView.ViewHolder {
    ImageView pokemonImage;
    TextView pokemonName;
    CardView cardView;

    public PokemonViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.pokemonCardView);
        pokemonImage = itemView.findViewById(R.id.pokemonItemImage);
        pokemonName = itemView.findViewById(R.id.pokemonItemName);
    }

    public void bind(Pokemon pokemon) {
        pokemonName.setText(pokemon.getName());
        pokemonImage.setImageResource(pokemon.getImageResourceID());
    }
}
