package com.example.wordsgame;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class gameFragment extends Fragment {
    private Level item;
    private static final String TAG = "gameFragment";
    private View guessRvView;
    private View guessOkBtn;
    private View guessCancelBtn;
    private CharacterAdapter guessAdapter;
    private CharacterAdapter answersAdapter;

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

        CharacterAdapter characterAdapter = new CharacterAdapter(charactersListClasses);
        charactersRv.setAdapter(characterAdapter);

        guessRvView = view.findViewById(R.id.guess_layout_main);
        guessOkBtn = view.findViewById(R.id.guess_ok_btn);
        guessCancelBtn = view.findViewById(R.id.guess_cancel_btn);

        guessCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guessRvView.setVisibility(View.GONE);
                guessAdapter.clear();
            }
        });

        guessOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = guessAdapter.getWord();
                for (int i = 0; i < item.getWords().size(); i++) {
                    String word = item.getWords().get(i);
                    if (word.equalsIgnoreCase(answer)) {
                        answersAdapter.setString(answer);
                        guessCancelBtn.performClick();
                        return;
                    }
                }
                guessCancelBtn.performClick();
                Toast.makeText(getContext(), "صحیح نیست!", Toast.LENGTH_SHORT).show();
            }
        });

        characterAdapter.setGuessOnClickedListener(new OnClickedItemListener<CharactersListClass>() {
            @Override
            public void onClickedStep(CharactersListClass item, int position) {
                guessRvView.setVisibility(View.VISIBLE);
                guessAdapter.add(item);
            }
        });

        RecyclerView guessRvMain = view.findViewById(R.id.guess_rv);
        guessAdapter = new CharacterAdapter();
        guessRvMain.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        guessRvMain.setAdapter(guessAdapter);

        RecyclerView answersRv = view.findViewById(R.id.answers_rv);

        int maxLength = 0;
        for (int i = 0; i < item.getWords().size(); i++) {
            int currentLength = item.getWords().get(i).length();
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        List<CharactersListClass> answersList = new ArrayList<>();
        for (int i = 0; i < item.getWords().size(); i++) {
            for (int j = 0; j < maxLength; j++) {
                CharactersListClass answersItem = new CharactersListClass();
                int itemLength = item.getWords().get(i).length();
                if (j < itemLength) {
                    answersItem.setVisible(false);
                    answersItem.setCharacter(item.getWords().get(i).charAt(j));
                    answersItem.setNull(false);
                    answersItem.setTag(item.getWords().get(i));
                }else{
                    answersItem.setNull(true);
                }
                answersList.add(answersItem);
            }
        }

        answersAdapter = new CharacterAdapter(answersList);
        answersRv.setLayoutManager(new GridLayoutManager(getContext(), maxLength, RecyclerView.VERTICAL, false));
        answersRv.setAdapter(answersAdapter);
    }
}
