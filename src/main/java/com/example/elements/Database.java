package com.example.elements;

/*
Taking data ( words ) from a file, creating password
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Database {
    private static Database instance;
    private final List<String> words;
    private String password;
    private Database(){
        words = new ArrayList<>();
        Path path = Paths.get("src/main/resources/com/example/wordlefx/words.txt");
        try {
            words.addAll(Files.readAllLines(path));
        }catch(IOException e){
            e.printStackTrace();
        }
        generateNewPassword();
    }
    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }
    public void generateNewPassword(){
        Random random = new Random();
        this.password = words.get(random.nextInt(0, words.size()));
    }
    public boolean checkWord(String word){
        return word.equals(getInstance().password.toUpperCase());
    }
    public String getPassword() {
        return password;
    }
    public boolean checkIfExists(String word){
        return words.contains(word.toLowerCase());
    }
}
