/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizapplication;

/**
 *
 * @author ankush
 */
class indexmanager {
    private static indexmanager instance;
    private int index = 1;
    private int noofcorrect =0;
    private int noofwrong = 0;

    private indexmanager() {}

    public static indexmanager getInstance() {
        if (instance == null) {
            instance = new indexmanager();
        }
        return instance;
    }

    public int getIndex() {
        return index;
    }

    public void incrementIndex() {
        index++;
    } 
    public int getnoofcorrectchoice(){
        return noofcorrect;
    }
    public void incrementnoofcorrectchoice(){
        noofcorrect++;
    }
    public int getnoofwrongchoice(){
        return noofwrong;
    }
    public void incrementnoofwrongchoice(){
        noofwrong++;
    }
    
}
