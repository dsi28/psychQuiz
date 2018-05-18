package com.example.android.quiz;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Quiz_Activity extends AppCompatActivity {
    public final int numQuestions = 7;
    public int curQuestion = 1;
    Question quiz = new Question();
    private void isCheckedBox() {
        if (cb1.isChecked()) {
            quiz.checked[0] = 1;
        }
        if (cb2.isChecked()) {
            quiz.checked[1] = 1;
        }
        if (cb3.isChecked()) {
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
                            if (rbA.isChecked()) {
                                quiz.setOptionPicked("a");
                            } else if (rbB.isChecked()) {
                                quiz.setOptionPicked("b");
                            } else if (rbC.isChecked()) {
                                quiz.setOptionPicked("c");
                            }
                            quiz.checkChoice(curQuestion);
                        }else{
                            curQuestion--;
                            questionSelection();
                        }
                        break;
                    case 2:
                        isCheckedBox();
                        quiz.reviewCheckBoxChoice(curQuestion);
                        break;
                    case 3:
                        String answerEditText= optionEditText.getText().toString();
                        if(answerEditText.equals("")){
                            curQuestion--;
                            questionSelection();
                        }else{
                            quiz.reviewEditTextChoice(answerEditText, curQuestion);
                        }
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

    private void showMuitipleChoiceOptions(){
        optionEditText.setVisibility(View.INVISIBLE);
        cb1.setVisibility(View.INVISIBLE);
        cb2.setVisibility(View.INVISIBLE);
        cb3.setVisibility(View.INVISIBLE);
        rbA.setVisibility(View.VISIBLE);
        rbB.setVisibility(View.VISIBLE);
        rbC.setVisibility(View.VISIBLE);
        rbA.setText(quiz.getOption1());
        rbB.setText(quiz.getOption2());
        rbC.setText(quiz.getOption3());
    }

    private void showCheckBoxOptions(){
        optionEditText.setVisibility(View.INVISIBLE);
        rbA.setVisibility(View.INVISIBLE);
        rbB.setVisibility(View.INVISIBLE);
        rbC.setVisibility(View.INVISIBLE);
        cb1.setVisibility(View.VISIBLE);
        cb2.setVisibility(View.VISIBLE);
        cb3.setVisibility(View.VISIBLE);
        cb1.setText(quiz.getOption1());
        cb2.setText(quiz.getOption2());
        cb3.setText(quiz.getOption3());
    }

    private void showEditTextOptions(){
        cb1.setVisibility(View.INVISIBLE);
        cb2.setVisibility(View.INVISIBLE);
        cb3.setVisibility(View.INVISIBLE);
        rbA.setVisibility(View.INVISIBLE);
        rbB.setVisibility(View.INVISIBLE);
        rbC.setVisibility(View.INVISIBLE);
        optionEditText.setVisibility(View.VISIBLE);
    }

    private void fillScreenTextInfo() {
        currentNumber.setText(curQuestion + "");
        currentQuestion.setText(quiz.getQuestionText());
        switch (quiz.getQuestionType()) {
            case 1:
                showMuitipleChoiceOptions();
                break;
            case 2:
                showCheckBoxOptions();
                break;
            case 3:
                showEditTextOptions();
            default:
                break;
        }
    }
    private void questionSelection() {
        quiz.setQuestionType(1);
        switch (curQuestion) {
            case 1:
                quiz.setQuestionType(3);
                quiz.setQuestionText(getString(R.string.q1));
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
    @BindView(R.id.questionText) TextView currentQuestion;
    @BindView(R.id.curNum) TextView currentNumber;
    @BindView(R.id.rb_a) RadioButton rbA;
    @BindView(R.id.rb_b) RadioButton rbB;
    @BindView(R.id.rb_c) RadioButton rbC;
    @BindView(R.id.radio) RadioGroup answerChoices;
    @BindView(R.id.cb_a) CheckBox cb1;
    @BindView(R.id.cb_b) CheckBox cb2;
    @BindView(R.id.cb_c) CheckBox cb3;
    @BindView(R.id.editTextBoxOption) EditText optionEditText;
    @BindView(R.id.btnSubmit) Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ButterKnife.bind(this);
        questionSelection();
    }
}
