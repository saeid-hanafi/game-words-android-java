package com.example.wordsgame;

import java.util.ArrayList;
import java.util.List;

public class GamePlayUtil {
    public static List<Level> createList() {
        List<Level> levelList = new ArrayList<>();

        Level level1 = new Level();
        level1.setId(1);
        level1.getWords().add("اش");
        level1.getWords().add("اتش");
        levelList.add(level1);

        Level level2 = new Level();
        level2.setId(2);
        level2.getWords().add("خاک");
        level2.getWords().add("کاخ");
        levelList.add(level2);

        Level level3 = new Level();
        level3.setId(3);
        level3.getWords().add("اهو");
        level3.getWords().add("هوا");
        levelList.add(level3);

        return levelList;
    }
}
