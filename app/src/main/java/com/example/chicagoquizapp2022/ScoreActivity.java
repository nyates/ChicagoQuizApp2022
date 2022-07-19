package com.example.chicagoquizapp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreNumberTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreNumberTV = (TextView) findViewById(R.id.scoreNumberTV);

        Intent incomingIntent = getIntent();
        int score = incomingIntent.getIntExtra("scoreName", 0);
        scoreNumberTV.setText(""+score);
    }
}