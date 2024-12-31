package com.mycompany.quizapplication;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SecondaryController {
   @FXML
    Label question;
   @FXML
   private Button mybutton;
   private Parent root;
   private Stage stage;
   private Scene scene ;
   
          
   public void tryagain(ActionEvent event) throws IOException{
       
      
       FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
       
       
       root = loader.load();
          PrimaryController primary = loader.getController();
          int a = indexmanager.getInstance().getIndex();
          primary.loadquestion(a,event);
          primary.loadoption(a);
          indexmanager.getInstance().incrementIndex();
          
        
          try{
          stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          clock.createInstance().startclock(primary,stage);
          scene = new Scene(root,750, 500);
          stage.setScene(scene);
          stage.show();
          }
          catch(NullPointerException execption){
              System.out.println("happy ending");
          }
          
   }
   
}
