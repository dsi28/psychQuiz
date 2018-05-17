package com.example.android.quiz;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class Results_Activity extends AppCompatActivity {
    public TextView scoreText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        scoreText= (TextView) findViewById(R.id.scoreText);
        Intent intent =getIntent();
        int score = (int) intent.getSerializableExtra("score");
        scoreText.setText(score+"%");
    }
}
