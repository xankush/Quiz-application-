package com.mycompany.quizapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline; 
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage; 
import javafx.util.Duration;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * JavaFX App
 */
public class App extends Application {
    
    private static Scene scene;
//    private int timeSeconds = 30;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent root = loader.load();
        PrimaryController primary = loader.getController();
//        primary.startclock(timeSeconds);
//        Timeline timeline = new Timeline(
//                new KeyFrame(Duration.seconds(1), event -> { 
//                    timeSeconds--;
//                   primary.startclock(timeSeconds);
//                    if (timeSeconds <= 0) {
//                        ((Timeline) event.getSource()).stop(); }
//                }) ); 
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
        scene = new Scene(root, 750, 500);
        stage.setTitle("QUIZ_APPLICATION v: 1.00000");
        stage.setScene(scene);
        stage.show();
        clock.createInstance().startclock(primary,stage);
    }

    

    public static void main(String[] args) {
        launch();
        
    }

}