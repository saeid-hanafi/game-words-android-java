package com.example.wordsgame;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private List<CharactersListClass> listClasses = new ArrayList<>();

    public CharacterAdapter(List<CharactersListClass> list) {
        listClasses = list;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.character_layout, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        holder.bindCharacters(listClasses.get(position));
    }

    @Override
    public int getItemCount() {
        return listClasses.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        private TextView charTv;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            charTv = itemView.findViewById(R.id.character_tv);
        }

        public void bindCharacters(CharactersListClass charactersListClasses) {
            if (charactersListClasses.isVisible()) {
                charTv.setText(charactersListClasses.getCharacter().toString());
                charTv.setVisibility(View.VISIBLE);
            }else{
                charTv.setVisibility(View.INVISIBLE);
            }
        }
    }
}
