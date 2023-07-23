package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.files.FileHandle;
import java.util.Random;
import com.badlogic.gdx.graphics.Texture;


public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private BitmapFont font;
    private Array<String> dictionaryWords;
    private String currentWord;
    private StringBuilder currentWordState;
    private Array<Character> guessedLetters;
    private int remainingAttempts;
    private long lastInputTime;
    private boolean gameOver;
    private Texture texture0;
    private Texture texture1;
    private Texture texture2;
    private Texture texture3;
    private Texture texture4;
    private Texture texture5;
    private Texture texture6;
    


    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();

        // read the dictionary file and extract the words
        dictionaryWords = getDictionaryWords("dictionary.txt");

        // choose a random word from the dictionary
        Random random = new Random();
        currentWord = dictionaryWords.get(random.nextInt(dictionaryWords.size));
        
        texture0 = new Texture("a0.png");
        texture1 = new Texture("a1.png");
        texture2 = new Texture("a2.png");
        texture3 = new Texture("a3.png");
        texture4 = new Texture("a4.png");
        texture5 = new Texture("a5.png");
        texture6 = new Texture("a6.png");


        // initialize the state of the game
        currentWordState = new StringBuilder();
        for (int i = 0; i < currentWord.length(); i++) {
            currentWordState.append("_");
        }
        guessedLetters = new Array<>();
        remainingAttempts = 6;
        lastInputTime = TimeUtils.nanoTime();
        gameOver = false;
    }

    @Override
    public void render() {
        // clear the screen
        Gdx.gl.glClearColor(0.0196f, 0.0784f, 0.1961f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        
        
        // check if the game is over
        if (gameOver) {
            batch.begin();
            font.draw(batch, "Game Over", 100, 100);
            batch.draw(texture0, 420, 300);
            batch.end();
            return;
        }

        // check if the player has run out of attempts
        if (remainingAttempts <= 0) {
            gameOver = true;
            return;
        }

        // check if the word has been guessed
        if (currentWordState.indexOf("_") == -1) {
            batch.begin();
            font.draw(batch, "You Win!", 100, 100);
            batch.end();
            gameOver = true;
            return;
        }

        // begin the sprite batch rendering process
        batch.begin();
        
        if(remainingAttempts == 6 ) {
        	batch.draw(texture1, 420, 300);
        }
        else if (remainingAttempts == 5 ){
        	batch.draw(texture2, 420, 300);
        }
        else if (remainingAttempts == 4 ){
        	batch.draw(texture3, 420, 300);
        }
        else if (remainingAttempts == 3 ){
        	batch.draw(texture4, 420, 300);
        }
        else if (remainingAttempts == 2 ){
        	batch.draw(texture5, 420, 300);
        }
        else if (remainingAttempts == 1 ){
        	batch.draw(texture6, 420, 300);
        }
        else if (remainingAttempts == 0 ){
        	batch.draw(texture0, 420, 300);
        }
        
        
        
        

        font.draw(batch, "HANGMAN GAME", 270, 400);
        
        // draw the current word state
        font.draw(batch, currentWordState.toString(), 100, 300);

        // draw the remaining attempts
        font.draw(batch, "Attempts: " + remainingAttempts, 100, 200);

        // draw the guessed letters
        StringBuilder guessedLettersString = new StringBuilder();
        for (char c : guessedLetters) {
            guessedLettersString.append(c);
            guessedLettersString.append(" ");
        }
        font.draw(batch, "Guessed Letters: " + guessedLettersString.toString(), 100, 150);

        // end the sprite batch rendering process
        batch.end();

        // handle user input
        if (TimeUtils.nanoTime() - lastInputTime > 100000000) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                handleGuess('a');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.B)) {
                handleGuess('b');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.C)) {
                handleGuess('c');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                handleGuess('d');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.E)) {
                handleGuess('e');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.F)) {
                handleGuess('f');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.G)) {
                handleGuess('g');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.H)) {
                handleGuess('h');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.I)) {
                handleGuess('i');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.J)) {
                handleGuess('j');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.K)) {
                handleGuess('k');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.L)) {
                handleGuess('l');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.M)) {
                handleGuess('m');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.N)) {
                handleGuess('n');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.O)) {
                handleGuess('o');
                lastInputTime = TimeUtils.nanoTime();
                
            }
            if (Gdx.input.isKeyPressed(Input.Keys.P)) {
                handleGuess('p');
                lastInputTime = TimeUtils.nanoTime();
                
            }
            if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
                handleGuess('q');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.R)) {
                handleGuess('r');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                handleGuess('s');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.T)) {
                handleGuess('t');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.U)) {
                handleGuess('u');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.V)) {
                handleGuess('v');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                handleGuess('w');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.X)) {
                handleGuess('x');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.Y)) {
                handleGuess('y');
                lastInputTime = TimeUtils.nanoTime();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
                handleGuess('z');
                lastInputTime = TimeUtils.nanoTime();
            }
        
          
        }
    }

    private Array<String> getDictionaryWords(String filename) {
        Array<String> words = new Array<>();

        // read the dictionary file and extract the words
        FileHandle file = Gdx.files.internal(filename);
        String fileContents = file.readString();
        String[] lines = fileContents.split("\\r?\\n");
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                words.add(line.trim().toLowerCase());
            }
        }

        return words;
    }

    private void handleGuess(char c) {
        // check if the letter has already been guessed
        if (guessedLetters.contains(c, false)) {
            return;
        }

        // add the letter to the guessed letters array
        guessedLetters.add(c);

        // check if the letter is in the word
        boolean letterFound = false;
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) == c) {
                currentWordState.setCharAt(i, c);
                letterFound = true;
            }
        }

        // decrement the remaining attempts if the letter is not in the word
        if (!letterFound) {
            remainingAttempts--;
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}

