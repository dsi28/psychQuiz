package com.example.android.quiz;

import java.util.HashMap;

public class Question {
    private int num;
    private String optionPicked;
    private String option1;
    private String option2;
    private String option3;
    private String questionText;
    public HashMap<Integer, Character> ansKey= new HashMap<>();
    public HashMap<Integer,Integer> score= new HashMap<>(); // 1 for correct, 0 for incorrect.

    public  Question(){
        setAnsKey();
    }

    private void setAnsKey(){
        ansKey.put(1,'b');
        ansKey.put(2,'a');
        ansKey.put(3,'c');
        ansKey.put(4,'a');
        ansKey.put(5,'c');
        ansKey.put(6,'c');
        ansKey.put(7,'b');
    }

    public void checkChoice(int currentQuestionNumber){
        num=currentQuestionNumber;
        if(optionPicked.equals(ansKey.get(num).toString())){
            score.put(num, 1);
        }else{
            score.put(num,0);
        }
    }
    
    public int calculateScore(int numberOfQuestions){
        double temp=0;
        for (Integer i: score.keySet()) {
            if(score.get(i)==1){
                temp++;
            }
        }
        return (int)((temp/numberOfQuestions)*100);
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
