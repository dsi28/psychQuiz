package com.example.android.quiz;
import java.util.HashMap;
public class Question {
    private int num;
    private String optionPicked;
    private String option1;
    private String option2;
    private String option3;
    private String questionText;
    private double numRight;
    private int questionType; //1 multiple choice, 2 checkbox
    public int checked[] = {0, 0, 0};
    public HashMap<Integer, Character> ansKey = new HashMap<>();
    public HashMap<Integer, Integer> score = new HashMap<>(); // 1 for correct, 0 for incorrect.
    public Question() {
        setAnsKey();
    }
    private void setAnsKey() {
        ansKey.put(1, 'b');
        ansKey.put(2, 'a');
        ansKey.put(3, '7');//checkboxes: 1 is only c1 is selected, 2 is only c2 is selected,  3 is only c3 is selected,  4 is only c1,c2 is selected, 5 is only c1,c3 is selected, 6 is only c2,c3 is selected, 7 is only c1,c2,c3 is selected,
        ansKey.put(4, 'a');
        ansKey.put(5, 'c');
        ansKey.put(6, 'c');
        ansKey.put(7, 'b');
    }
    public void reviewCheckBoxChoice(int currentNumber) {
        char ans = ' ';
        if (checked[0] == 1 && checked[1] == 0 && checked[2] == 0) {
            ans = '1';
        } else if (checked[0] == 0 && checked[1] == 1 && checked[2] == 0) {
            ans = '2';
        } else if (checked[0] == 0 && checked[1] == 0 && checked[2] == 1) {
            ans = '3';
        } else if (checked[0] == 1 && checked[1] == 1 && checked[2] == 0) {
            ans = '4';
        } else if (checked[0] == 1 && checked[1] == 0 && checked[2] == 1) {
            ans = '5';
        } else if (checked[0] == 0 && checked[1] == 1 && checked[2] == 1) {
            ans = '6';
        } else if (checked[0] == 1 && checked[1] == 1 && checked[2] == 1) {
            ans = '7';
        } else {
            ans = '0';
        }
        if (ansKey.get(currentNumber) == ans) {
            score.put(currentNumber, 1);
        } else {
            score.put(currentNumber, 0);
        }
    }
    public void checkChoice(int currentQuestionNumber) {
        num = currentQuestionNumber;
        if (optionPicked.equals(ansKey.get(num).toString())) {
            score.put(num, 1);
        } else {
            score.put(num, 0);
        }
    }
    public int calculateScore(int numberOfQuestions) {
        numRight = 0;
        for (Integer i : score.keySet()) {
            if (score.get(i) == 1) {
                numRight++;
            }
        }
        return (int) ((numRight / numberOfQuestions) * 100);
    }
    public String getOption1() {
        return option1;
    }
    public String getOption2() {
        return option2;
    }
    public String getOption3() {
        return option3;
    }
    public String getQuestionText() {
        return questionText;
    }
    public void setOption1(String option) {
        option1 = option;
    }
    public void setOption2(String option) {
        option2 = option;
    }
    public void setOption3(String option) {
        option3 = option;
    }
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
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
    public int getQuestionType() {
        return questionType;
    }
    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }
    public double getNumRight() {
        return numRight;
    }
}
