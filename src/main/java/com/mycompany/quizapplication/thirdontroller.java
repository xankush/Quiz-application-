/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author ankush
 */
public class thirdontroller {
    @FXML
    private Label correct;
    @FXML
    private Label wrong;
    
    public void setresult(){
        correct.setText( Integer.toString(indexmanager.getInstance().getnoofcorrectchoice()));
        wrong.setText( Integer.toString(indexmanager.getInstance().getnoofwrongchoice()));
    }
    
}
