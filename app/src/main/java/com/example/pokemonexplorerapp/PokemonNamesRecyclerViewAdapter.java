package com.example.pokemonexplorerapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/*
Aillen Teixeira
Student ID: 5120294
BIT603 Programming II
Assessment I

• Why is the class important in the OOP design of the app?
This class uses the Adapter Design Pattern to connect Pokemon Data to the RecyclerView.
Handles user interaction with the RecyclerView.
• Describe the OOP concepts used in the class.
Inheritance by extending RecyclerView.Adapter
Polymorphism by overriding certain methods.
Abstraction by providing data to RecyclerView.
Encapsulation for hiding the implementation details.
 */

public class PokemonNamesRecyclerViewAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    private final List<Pokemon> pokemonList;

    public PokemonNamesRecyclerViewAdapter(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_pokemon_list_recycler_view, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);

        holder.bind(pokemon);

        holder.cardView.setOnClickListener(v -> {
            Context context = v.getContext();

            Intent intent = new Intent(context, PokemonDetailActivity.class);

            intent.putExtra("pokemon_name", pokemon.getName());
            intent.putExtra("pokemon_index", position);

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }
}