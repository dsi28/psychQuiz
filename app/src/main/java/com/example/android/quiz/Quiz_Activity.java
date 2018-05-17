package com.example.android.quiz;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
public class Quiz_Activity extends AppCompatActivity {
    public final int numQuestions = 7;
    public int curQuestion = 1;
    Question quiz = new Question();
    TextView currentNumber;
    TextView currentQuestion;
    RadioButton currentA;
    RadioButton currentB;
    RadioButton currentC;
    RadioGroup answerChoices;
    Button btnSubmit;
    CheckBox c1;
    CheckBox c2;
    CheckBox c3;
    private void isCheckedBox() {
        if (c1.isChecked()) {
            quiz.checked[0] = 1;
        }
        if (c2.isChecked()) {
            quiz.checked[1] = 1;
        }
        if (c3.isChecked()) {
            quiz.checked[2] = 1;
        }
    }
    private void submitChoice() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (quiz.getQuestionType()) {
                    case 1:
                        if (answerChoices.getCheckedRadioButtonId() != -1) {
                            if (currentA.isChecked()) {
                                quiz.setOptionPicked("a");
                            } else if (currentB.isChecked()) {
                                quiz.setOptionPicked("b");
                            } else if (currentC.isChecked()) {
                                quiz.setOptionPicked("c");
                            }
                            quiz.checkChoice(curQuestion);
                        }
                        break;
                    case 2:
                        isCheckedBox();
                        quiz.reviewCheckBoxChoice(curQuestion);
                        break;
                }
                curQuestion++;
                if (curQuestion == 8) {
                    int score = quiz.calculateScore(numQuestions);
                    Intent result = new Intent(Quiz_Activity.this, Results_Activity.class);
                    result.putExtra("score", score);
                    Toast.makeText(Quiz_Activity.this, "You got " + (int) quiz.getNumRight() + " questions right!", Toast.LENGTH_LONG).show();
                    startActivity(result);
                } else {
                    answerChoices.clearCheck();
                    questionSelection();
                }
            }
        });
    }
    private void fillScreenTextInfo() {
        currentNumber.setText(curQuestion + "");
        currentQuestion.setText(quiz.getQuestionText());
        switch (quiz.getQuestionType()) {
            case 1:
                c1.setVisibility(View.INVISIBLE);
                c2.setVisibility(View.INVISIBLE);
                c3.setVisibility(View.INVISIBLE);
                currentA.setVisibility(View.VISIBLE);
                currentB.setVisibility(View.VISIBLE);
                currentC.setVisibility(View.VISIBLE);
                currentA.setText(quiz.getOption1());
                currentB.setText(quiz.getOption2());
                currentC.setText(quiz.getOption3());
                break;
            case 2:
                currentA.setVisibility(View.INVISIBLE);
                currentB.setVisibility(View.INVISIBLE);
                currentC.setVisibility(View.INVISIBLE);
                c1.setVisibility(View.VISIBLE);
                c2.setVisibility(View.VISIBLE);
                c3.setVisibility(View.VISIBLE);
                c1.setText(quiz.getOption1());
                c2.setText(quiz.getOption2());
                c3.setText(quiz.getOption3());
                break;
            default:
                break;
        }
    }
    private void questionSelection() {
        quiz.setQuestionType(1);
        switch (curQuestion) {
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
                quiz.setQuestionType(2);
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
        currentQuestion = (TextView) findViewById(R.id.questionText);
        currentNumber = (TextView) findViewById(R.id.curNum);
        currentA = (RadioButton) findViewById(R.id.a);
        currentB = (RadioButton) findViewById(R.id.b);
        currentC = (RadioButton) findViewById(R.id.c);
        answerChoices = (RadioGroup) findViewById(R.id.radio);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        c1 = (CheckBox) findViewById(R.id.ca);
        c2 = (CheckBox) findViewById(R.id.cb);
        c3 = (CheckBox) findViewById(R.id.cc);
        questionSelection();
    }
}
