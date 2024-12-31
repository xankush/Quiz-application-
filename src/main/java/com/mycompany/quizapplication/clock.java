/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizapplication;

import java.io.IOException;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author ankush
 */
public class clock {
    private static clock clock1;
    private Timeline timeline;
    public static clock  createInstance(){
     return    clock1 = new clock();    
    }
    public static clock getInstance(){
        if(clock1==null){
            return clock1 = new clock();
        }else{
        return clock1;
        }
     
    }
    private Parent root ;
    private Scene scene;
    private Stage stage;
    private int timeSeconds = 30;
    public void startclock(PrimaryController primary,Stage stage) throws IOException{
        System.out.println("clock ios starting");
        primary.startclock(timeSeconds);
//        Timeline timeline;
//        timeline = new Timeline( 
//                new KeyFrame(Duration.seconds(1), event -> {
//                    timeSeconds--;
//                    primary.startclock(timeSeconds);
//                    if (timeSeconds <= 0) {
//                        timeline.stop();}
//                }) ); 
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        timeSeconds--;
    
 System.out.println("Time remaining: " + timeSeconds + " seconds");
 primary.startclock(timeSeconds);
if (timeSeconds <= 0) {
    timeline.stop();
    FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("timeout.fxml"));
            try {
                root = fxmlloader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
     scene = new Scene(root);
     stage.setScene(scene);
     stage.show();
     indexmanager.getInstance().incrementnoofwrongchoice();
    // Stop the timeline using the class-level reference 
System.out.println("Timer stopped");
    }
}
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
    }
    
   public void stopclock(){
       if(timeline.getStatus()==Animation.Status.RUNNING){
           timeline.stop();
       }
   }
    
}
