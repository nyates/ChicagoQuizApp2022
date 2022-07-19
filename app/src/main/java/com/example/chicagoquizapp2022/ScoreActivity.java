package com.example.chicagoquizapp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreNumberTV;
    Button emailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreNumberTV = (TextView) findViewById(R.id.scoreNumberTV);
        emailBtn = (Button) findViewById(R.id.emailButton);

        Intent incomingIntent = getIntent();
        int score = incomingIntent.getIntExtra("scoreName", 0);
        scoreNumberTV.setText(""+score);

        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subj = "New score on the Chicago Quiz App";
                String bod = "I just got a " + score + " on the Chicago Quiz App!";
                composeEmail(subj, bod);
            }
        });

    }

    public void composeEmail(String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // Define what your app should do if no activity can handle the intent.
        }

    }
}