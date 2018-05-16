package com.example.android.quiz;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public final int numQuestions=7;
    public int curQuestion=1;
    Question quiz = new Question();

    TextView currentNumber;
    TextView currentQuestion;
    RadioButton currentA;
    RadioButton currentB;
    RadioButton currentC;
    RadioGroup  answerChoices;
    Button btnSubmit;

    private void submitChoice(){
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answerChoices.getCheckedRadioButtonId()!=-1){
                    if(currentA.isChecked()){
                        quiz.setOptionPicked("a");
                    }else if(currentB.isChecked()){
                        quiz.setOptionPicked("b");
                    }else if(currentC.isChecked()){
                        quiz.setOptionPicked("c");
                    }
                    quiz.checkChoice(curQuestion);
                    curQuestion++;
                    if(curQuestion==8){
                        int score=quiz.calculateScore(numQuestions);
                        Intent result= new Intent(MainActivity.this, Results.class);
                        result.putExtra("score", score);
                        startActivity(result);
                    }else{
                    answerChoices.clearCheck();
                    questionSelection();
                    }
                }
            }
        });
    }

    private void fillScreenTextInfo(){
        currentNumber.setText(curQuestion+"");
        currentQuestion.setText(quiz.getQuestionText());
        currentA.setText(quiz.getOption1());
        currentB.setText(quiz.getOption2());
        currentC.setText(quiz.getOption3());
    }

    private void questionSelection(){
        switch (curQuestion){
            case 1:
                quiz.setQuestionText("Number 1 asking this question?");
                quiz.setOption1("number 1 option1");
                quiz.setOption2("number 1 option2");
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
            case 4:
                quiz.setQuestionText("Number 4 asking this question?");
                quiz.setOption1("number 4 option1");
                quiz.setOption2("number 4 option2");
                quiz.setOption3("number 4 option3");
                break;
            case 5:
                quiz.setQuestionText("Number 5 asking this question?");
                quiz.setOption1("number 5 option1");
                quiz.setOption2("number 5 option2");
                quiz.setOption3("number 5 option3");
                break;
            case 6:
                quiz.setQuestionText("Number 6 asking this question?");
                quiz.setOption1("number 6 option1");
                quiz.setOption2("number 6 option2");
                quiz.setOption3("number 6 option3");
                break;
            case 7:
                quiz.setQuestionText("Number 7 asking this question?");
                quiz.setOption1("number 7 option1");
                quiz.setOption2("number 7 option2");
                quiz.setOption3("number 7 option3");
                break;
            default:
                break;

        }

        fillScreenTextInfo();
        submitChoice();

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
