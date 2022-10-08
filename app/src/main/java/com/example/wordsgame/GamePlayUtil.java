package com.example.wordsgame;

import java.util.ArrayList;
import java.util.List;

public class GamePlayUtil {
    public static List<Level> createList() {
        List<Level> levelList = new ArrayList<>();

        Level level1 = new Level(1);
        level1.getWords().add("اش");
        level1.getWords().add("اتش");
        levelList.add(level1);

        Level level2 = new Level(2);
        level2.getWords().add("خاک");
        level2.getWords().add("کاخ");
        levelList.add(level2);

        Level level3 = new Level(3);
        level3.getWords().add("اهو");
        level3.getWords().add("هوا");
        levelList.add(level3);

        Level level4 = new Level(4);
        level4.getWords().add("خرس");
        level4.getWords().add("سرخ");
        level4.getWords().add("سر");
        level4.getWords().add("خر");
        level4.getWords().add("رس");
        levelList.add(level4);

        Level level5 = new Level(5);
        level5.getWords().add("فک");
        level5.getWords().add("کف");
        level5.getWords().add("کفش");
        level5.getWords().add("کشف");
        level5.getWords().add("شک");
        levelList.add(level5);

        return levelList;
    }

    public static List<Character> createCharactersList(List<String> items) {
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.get(i).length(); j++) {
                Character character = items.get(i).charAt(j);
                if (!characterList.contains(character)) {
                    characterList.add(character);
                }
            }
        }
        return characterList;
    }
}
