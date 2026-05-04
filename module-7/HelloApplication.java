/*
     Xavier Grunitzky
      Module Assignment 7.2
      5/2/26
      This program uses java fx to display 4 circles with 3 being a white circle with black outline and the last being a
      red circle with a green outline using css external file.
 */


package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {

        // Create a Pane layout to hold the circles
        Pane pane = new Pane();

        // Create circle 1 and apply the CSS class (white fill, black stroke)
        Circle circle1 = new Circle(70, 70, 30);
        circle1.getStyleClass().add("whiteBlackCircle");

        // Create circle 2 and apply the CSS class (white fill, black stroke)
        Circle circle2 = new Circle(170, 70, 30);
        circle2.getStyleClass().add("whiteBlackCircle");

        // Create circle 3 and apply the CSS class (white fill, black stroke)
        Circle circle3 = new Circle(270, 70, 30);
        circle3.getStyleClass().add("whiteBlackCircle");

        // Create circle 4 and apply the CSS ID (red fill, green stroke)
        Circle circle4 = new Circle(170, 160, 30);
        circle4.setId("redGreenCircle");

        // Add all circles to the pane
        pane.getChildren().addAll(circle1, circle2, circle3, circle4);

        // Create a scene and place the pane inside it
        Scene scene = new Scene(pane, 350, 250);

        // Print CSS file location (debugging to confirm CSS is found)
        System.out.println(getClass().getResource("/com/example/demo/mystyle.css"));

        // Load the external CSS stylesheet and apply it to the scene
        scene.getStylesheets().add(
                Objects.requireNonNull(
                        getClass().getResource("/com/example/demo/mystyle.css")
                ).toExternalForm()
        );

        // Set window title
        stage.setTitle("Four Circles with CSS");

        // Attach the scene to the stage (window)
        stage.setScene(scene);

        // Display the JavaFX window
        stage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch();
    }
}