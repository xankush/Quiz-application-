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
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class PrimaryController {
  @FXML
   Label question;
  @FXML
  private RadioButton button1,button2,button3,button4;
  @FXML
  private Button submit;
  @FXML
  private Label myclock;
  private Scene scene;
  private Parent root;
  private Stage stage;

  
  
 
    
 
  String[] questionstring = {"what is my name ","what is my favorate color","what is my favorite food","what is my favorite sport","what is my favorite hobby","what is 2+2"};
  String[][] option = {{"Hemant","Ankush","Brajesh","Munasif"},{"Blue","Brown","Black","pink"},{"aloo paratha","burger","magie","aloo gobhi"},{"hockey","kabaddi","voleyball","cricket"},{"playing","studying","sleeping","drawing"},{"5","3","1","4"}};
  String[] answer = {"ankush","blue","aloo paratha","cricket","sleeping","4"};
  
  
  
  
  public void printchoice(ActionEvent event) throws IOException{
      System.out.println(question.getText());
      clock.getInstance().stopclock();
      if(button1.isSelected()){
          checkanswer(button1.getText(), event);
      }
     else if(button2.isSelected()){
         checkanswer(button2.getText(), event);
      }
     else if(button3.isSelected()){
          checkanswer(button3.getText(), event);
      }
     else if(button4.isSelected()){
          checkanswer(button4.getText(), event);
      }
      
      
  }
  
  public void showcorrectscene(ActionEvent event) throws IOException{
          FXMLLoader loader = new FXMLLoader(getClass().getResource("correct.fxml"));
          root = loader.load();
          
          this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          scene = new Scene(root,750, 500);
          stage.setScene(scene);
          stage.show();
  }
    public void showwrongscene(ActionEvent event) throws IOException{
          FXMLLoader loader = new FXMLLoader(getClass().getResource("incorrect.fxml"));
          root = loader.load();
          
          this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          scene = new Scene(root,750, 500);
          stage.setScene(scene);
          stage.show();
  }
    public void loadquestion(int a,ActionEvent event) throws IOException{
        
        System.out.println(a);
        try{
        question.setText("Q. "+questionstring[a]+" ?");
        }
        catch(IndexOutOfBoundsException e){
             FXMLLoader Fxmlloader =new FXMLLoader(getClass().getResource("thanku.fxml"));
           root = Fxmlloader.load();
           thirdontroller third =Fxmlloader.getController();
           third.setresult();
           stage = (Stage)((Node)event.getSource()).getScene().getWindow();
           scene = new Scene(root,750, 500);
           stage.setScene(scene);
           stage.show();

        }
        
    }
    public void loadoption(int a){
       try{ 
           
       button1.setText(option[a][0]);
       button2.setText(option[a][1]);
       button3.setText(option[a][2]);
       button4.setText(option[a][3]);
       }
       catch(IndexOutOfBoundsException e){
           System.out.println("thanku");
           System.out.println(indexmanager.getInstance().getnoofcorrectchoice());
            System.out.println(indexmanager.getInstance().getnoofwrongchoice());
       }
    }
    public void checkanswer(String choice, ActionEvent event) throws IOException{
        
        int a = (indexmanager.getInstance().getIndex())-1;
        try{
        if(choice.equalsIgnoreCase(answer[a])){
            indexmanager.getInstance().incrementnoofcorrectchoice();
            showcorrectscene(event);
        }
        else{
            indexmanager.getInstance().incrementnoofwrongchoice();
            showwrongscene(event);
        }
        }
        catch(IndexOutOfBoundsException e){
           FXMLLoader Fxmlloader =new FXMLLoader(getClass().getResource("thanku.fxml"));
           root = Fxmlloader.load();
           stage = (Stage)((Node)event.getSource()).getScene().getWindow();
           scene = new Scene(root,750, 500);
           stage.setScene(scene);
           stage.show();
//            System.out.println(indexmanager.getInstance().getnoofcorrectchoice());
//            System.out.println(indexmanager.getInstance().getnoofwrongchoice());
            System.out.println("thanku");
        }
    }
    

    public void startclock(int i) {
        System.out.println("this is startclock function in primary");
        System.out.println(i);
        myclock.setText("Remaining TIme 00:"+Integer.toString(i));
       
    }
    
    
}
