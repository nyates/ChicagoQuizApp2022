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

    // declare variables (for your UI elements)
    TextView qTextTV;
    Button trueBtn, falseBtn, nextBtn, scoreBtn;
    String message;
    int score;
    int currentIndex;
    Question q1,q2,q3,q4,q5, currentQ;
    Question[] questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // initialize variables / inflate your UI elements
        qTextTV = (TextView) findViewById(R.id.questionText);
        trueBtn = (Button) findViewById(R.id.trueButton);
        falseBtn = (Button) findViewById(R.id.falseButton);
        nextBtn = (Button) findViewById(R.id.nextButton);
        scoreBtn = (Button) findViewById(R.id.scoreButton);
        score = 0;
        q1 = new Question("Chicago is home to the Red Sox baseball team.", false);
        q2 = new Question("Chicago is home to the Willis Tower.", true);
        q3 = new Question("CSTA Conference 2022 was held in Chicago.", true);
        q4 = new Question("The tallest building in the world is in Chicago.", false);
        q5 = new Question("Chicago's transit system is called \'the El\'.", true);
        questions = new Question[] {q1, q2, q3, q4, q5};
        currentIndex = 0;
        currentQ = questions[currentIndex];

        // do something with UI elements
        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQ.getCorrectAnswer()) {
                    message = "You got it right.";
                    score++;
                }
                else {
                    message = "You got it wrong.";
                }
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();
            }
        });

        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!currentQ.getCorrectAnswer()) {
                    message = "You got it right.";
                    score++;
                }
                else {
                    message = "You got it wrong.";
                }
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex++;
                if (currentIndex >= questions.length)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "No more questions available. Click View Score.", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    currentQ = questions[currentIndex];
                    String currentQText = currentQ.getQText();
                    qTextTV.setText(currentQText);
                }

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