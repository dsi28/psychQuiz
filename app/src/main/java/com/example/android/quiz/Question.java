package com.example.android.quiz;

import java.util.HashMap;

public class Question {
    private int num;
    private String ans;
    private String optionPicked;
    private String option1;
    private String option2;
    private String option3;
    private String questionText;


    public Question(Integer qNum, Character qAns){
        num= qNum;
        ans=qAns.toString();
    }

    public String getOption1(){
        return option1;
    }
    public String getOption2(){
        return option2;
    }
    public String getOption3(){
        return option3;
    }
    public String getQuestionText(){
        return questionText;
    }


    public void setOption1(String option){
        option1=option;
    }
    public void setOption2(String option){
        option2=option;
    }
    public void setOption3(String option){
        option3=option;
    }
    public void setQuestionText(String questionText){
        this.questionText=questionText;
    }

    public String getAns() {
        return ans;
    }

    public int getNum() {
        return num;
    }

    public String getOptionPicked() {
        return optionPicked;
    }

    public void setOptionPicked(String optionPicked) {
        this.optionPicked = optionPicked;
    }
}
