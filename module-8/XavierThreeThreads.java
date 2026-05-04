/*
    Xavier Grunitzky
    Module Assignment 8.2
    5/3/26
    This program uses three threads to output three types of characters to a text area for display.
 */
package com.example.demo;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class XavierThreeThreads extends Application {

    private TextArea textArea = new TextArea();

    @Override
    public void start(Stage stage) {

        textArea.setWrapText(true);

        VBox root = new VBox(textArea);
        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Three Threads Generator");
        stage.setScene(scene);
        stage.show();

        // Start threads
        Thread letters = new Thread(new LetterTask());
        Thread numbers = new Thread(new NumberTask());
        Thread symbols = new Thread(new SymbolTask());

        letters.start();
        numbers.start();
        symbols.start();
    }

    /* ---------------- LETTER THREAD ---------------- */
    class LetterTask implements Runnable {
        Random random = new Random();

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                char letter = (char) (random.nextInt(26) + 'a');

                Platform.runLater(() -> {
                    textArea.appendText(String.valueOf(letter));
                });

                sleep();
            }
        }
    }

    /* ---------------- NUMBER THREAD ---------------- */
    class NumberTask implements Runnable {
        Random random = new Random();

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                int num = random.nextInt(10);

                Platform.runLater(() -> {
                    textArea.appendText(String.valueOf(num));
                });

                sleep();
            }
        }
    }

    /* ---------------- SYMBOL THREAD ---------------- */
    class SymbolTask implements Runnable {
        Random random = new Random();
        String symbols = "!@#$%&*";

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                char symbol = symbols.charAt(random.nextInt(symbols.length()));

                Platform.runLater(() -> {
                    textArea.appendText(String.valueOf(symbol));
                });

                sleep();
            }
        }
    }

    /* ---------------- SLEEP HELPER ---------------- */
    private void sleep() {
        try {
            Thread.sleep(1); // slows output slightly so UI can keep up
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}