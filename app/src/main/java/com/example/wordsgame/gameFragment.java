package com.example.wordsgame;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class gameFragment extends Fragment {
    private Level item;
    private static final String TAG = "gameFragment";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item = getArguments().getParcelable("level");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.game_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView charactersRv = view.findViewById(R.id.characters_rv);
        charactersRv.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        List<String> stringList = item.getWords();
        List<Character> characterList = GamePlayUtil.createCharactersList(stringList);
        List<CharactersListClass> charactersListClasses = new ArrayList<>();
        for (int i = 0; i < characterList.size(); i++) {
            CharactersListClass charactersListClassItem = new CharactersListClass();
            Character characterItem = characterList.get(i);
            charactersListClassItem.setVisible(true);
            charactersListClassItem.setCharacter(characterItem);
            charactersListClasses.add(charactersListClassItem);
        }

        charactersRv.setAdapter(new CharacterAdapter(charactersListClasses));
    }
}
