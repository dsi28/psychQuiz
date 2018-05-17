package com.example.android.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Quiz_Activity extends AppCompatActivity {
    public final int numQuestions=7;
    public int curQuestion=1;
    Question quiz = new Question();

    TextView currentNumber;
    TextView currentQuestion;
    RadioButton currentA;
    RadioButton currentB;
    RadioButton currentC;
    RadioGroup answerChoices;
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
                        Intent result= new Intent(Quiz_Activity.this, Results_Activity.class);
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
                quiz.setQuestionText(getString(R.string.q1));
                quiz.setOption1(getString(R.string.q1o1));
                quiz.setOption2(getString(R.string.q1o2));
                quiz.setOption3(getString(R.string.q1o3));
                break;
            case 2:
                quiz.setQuestionText(getString(R.string.q2));
                quiz.setOption1(getString(R.string.q2o1));
                quiz.setOption2(getString(R.string.q2o2));
                quiz.setOption3(getString(R.string.q2o3));
                break;
            case 3:
                quiz.setQuestionText(getString(R.string.q3));
                quiz.setOption1(getString(R.string.q3o1));
                quiz.setOption2(getString(R.string.q3o2));
                quiz.setOption3(getString(R.string.q3o3));
                break;
            case 4:
                quiz.setQuestionText(getString(R.string.q4));
                quiz.setOption1(getString(R.string.q4o1));
                quiz.setOption2(getString(R.string.q4o2));
                quiz.setOption3(getString(R.string.q4o3));
                break;
            case 5:
                quiz.setQuestionText(getString(R.string.q5));
                quiz.setOption1(getString(R.string.q5o1));
                quiz.setOption2(getString(R.string.q5o2));
                quiz.setOption3(getString(R.string.q5o3));
                break;
            case 6:
                quiz.setQuestionText(getString(R.string.q6));
                quiz.setOption1(getString(R.string.q6o1));
                quiz.setOption2(getString(R.string.q6o2));
                quiz.setOption3(getString(R.string.q6o3));
                break;
            case 7:
                quiz.setQuestionText(getString(R.string.q7));
                quiz.setOption1(getString(R.string.q7o1));
                quiz.setOption2(getString(R.string.q7o2));
                quiz.setOption3(getString(R.string.q7o3));
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
        setContentView(R.layout.activity_quiz);
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
