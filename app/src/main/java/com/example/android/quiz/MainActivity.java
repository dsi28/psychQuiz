package com.example.android.quiz;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
//    public HashMap<Integer, Character> ansKey= new HashMap<>();
//    public HashMap<Integer,Integer> score= new HashMap<>(); // 1 for correct, 0 for incorrect.
    public final int numQuestions=7;
    public int curQuestion=1;
    Question quiz = new Question();
//    Question number1;
//    Question number2;
//    Question number3;
//    Question number4;
//    Question number5;
//    Question number6;
//    Question number7;

    TextView currentNumber;
    TextView currentQuestion;
    RadioButton currentA;
    RadioButton currentB;
    RadioButton currentC;
    RadioGroup  answerChoices;
    Button btnSubmit;

    private void submitChoice(final Question number){
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answerChoices.getCheckedRadioButtonId()==-1){

                }else{
                    if(currentA.isChecked()){
                        number.setOptionPicked("a");
                    }else if(currentB.isChecked()){
                        number.setOptionPicked("b");
                    }else if(currentC.isChecked()){
                        number.setOptionPicked("c");
                    }
                    if(number.getOptionPicked().equals(number.ansKey.get(curQuestion).toString())){
                        number.score.put(curQuestion,1);
                    }else{
                        number.score.put(curQuestion,0);
                    }
                    curQuestion++;
                    answerChoices.clearCheck();
                    questionSelection();
                }
            }
        });
    }


    private void fillScreenTextInfo(Question number){
        currentNumber.setText(curQuestion+"");
        currentQuestion.setText(number.getQuestionText());
        currentA.setText(number.getOption1());
        currentB.setText(number.getOption2());
        currentC.setText(number.getOption3());
    }

    private void questionSelection(){
        switch (curQuestion){
            case 1:
                quiz.setQuestionText("Number 1 asking this question?");
                quiz.setOption1("number 1 option1");
                quiz.setOption2("number 1 option3");
                quiz.setOption3("number 1 option3");
                break;
            case 2:
                quiz.setQuestionText("Number 2 asking this question?");
                quiz.setOption1("number 2 option1");
                quiz.setOption2("number 2 option2");
                quiz.setOption3("number 2 option3");
                break;
            case 3:
                quiz.setQuestionText("Number 3 asking this question?");
                quiz.setOption1("number 3 option1");
                quiz.setOption2("number 3 option2");
                quiz.setOption3("number 3 option3");
                break;
            default:
                break;

        }

        fillScreenTextInfo(quiz);
        submitChoice(quiz);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentQuestion= (TextView) findViewById(R.id.questionText);
        currentNumber=(TextView) findViewById(R.id.curNum);
        currentA=(RadioButton) findViewById(R.id.a);
        currentB=(RadioButton) findViewById(R.id.b);
        currentC=(RadioButton) findViewById(R.id.c);
        answerChoices=(RadioGroup) findViewById(R.id.radio);
        btnSubmit=(Button)findViewById(R.id.btnSubmit);
        questionSelection();
    }
}
