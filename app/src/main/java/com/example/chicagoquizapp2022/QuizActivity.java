package com.example.chicagoquizapp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    // declare variables for your UI elements
    TextView qText;
    Button trueBtn, falseBtn, scoreBtn;
    String message;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // initialize / inflate your UI elements
        qText = (TextView) findViewById(R.id.questionText);
        trueBtn = (Button) findViewById(R.id.trueButton);
        falseBtn = (Button) findViewById(R.id.falseButton);
        scoreBtn = (Button) findViewById(R.id.scoreButton);
        score = 0;

        // do something with UI elements
        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "You got it wrong.";
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();
            }
        });

        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "You got it right.";
                score++;
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();
            }
        });

        scoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showScore = new Intent(QuizActivity.this, ScoreActivity.class);
                showScore.putExtra("scoreName", score);
                startActivity(showScore);
            }
        });

    }
}