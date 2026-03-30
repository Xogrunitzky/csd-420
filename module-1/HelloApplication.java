/*
Xavier Grunitzky
Module 1.3 Programming Assignment
3/29/26
This program will pick 4 random card photos from a folder and display it using JavaFX and has a button below
to pick another set of cards.
 */
package com.example.projectclassfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;


public class HelloApplication extends Application {

    // Folder containing PNG images
    private final File folder = new File("C:\\Users\\Xavie\\IdeaProjects\\projectclassFX\\src\\main\\java\\cards");
    private final GridPane grid = new GridPane();   // Grid to display images
    private final ArrayList<File> images = new ArrayList<>(); // List of all images

    @Override
    public void start(Stage primaryStage) {
        // Load all PNG images
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
        if (files == null || files.length < 4) {
            System.out.println("Need at least 4 PNG images in 'cards' folder.");
            return;
        }
        Collections.addAll(images, files);

        // Display 4 random images initially
        showRandomImages();

        // Refresh button to pick new 4 images
        Button refresh = new Button("Refresh");
        refresh.setOnAction(e -> showRandomImages()); // Lambda for button click

        // Layout: grid in center, button at bottom
        BorderPane root = new BorderPane();
        root.setCenter(grid);
        root.setBottom(refresh);
        BorderPane.setAlignment(refresh, javafx.geometry.Pos.CENTER);

        primaryStage.setScene(new Scene(root, 500, 550));
        primaryStage.setTitle("Random Cards");
        primaryStage.show();
    }

    // Display 4 random images in a 2x2 grid
    private void showRandomImages() {
        grid.getChildren().clear(); // Clear old images
        Collections.shuffle(images); // Shuffle list
        for (int i = 0; i < 4; i++) {
            try {
                ImageView iv = new ImageView(new Image(new FileInputStream(images.get(i))));
                iv.setFitWidth(200);
                iv.setFitHeight(200);
                iv.setPreserveRatio(true);
                grid.add(iv, i % 2, i / 2); // Place in 2x2 grid
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
