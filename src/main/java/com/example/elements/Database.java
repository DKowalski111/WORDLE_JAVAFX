package com.example.elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Database {
    private static Database instance;
    private List<String> words;
    private String password;
    private Database(){
        words = new ArrayList<>();
        Random random = new Random();
        Path path = Paths.get("src/main/resources/com/example/wordlefx/words.txt");
        try {
            words.addAll(Files.readAllLines(path));
            System.out.println(words.get(1));
        }catch(IOException e){
            e.printStackTrace();
        }
        password = words.get(random.nextInt(0, words.size()));
        System.out.println(password);
    }
    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }
}
