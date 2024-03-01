package com.example.road_sign_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView answerTextView = (TextView) findViewById(R.id.answerTextView);
        TextView promptTextView = (TextView) findViewById(R.id.promptTextView);

        ImageView roadSign = (ImageView) findViewById(R.id.signImageView);

        Button answer1 = (Button) findViewById(R.id.answer1Button);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (questionNumber) {
                    case 0:
                        nextQuestion(roadSign, answerTextView, promptTextView);
                        promptTextView.setText("Guess the road sign...");
                        break;
                    case 1:
                        answerTextView.setText("Correct! Next Question...");
                        nextQuestion(roadSign, answerTextView, promptTextView);
                        break;
                    case 2:
                    case 3:
                    case 4:
                        answerTextView.setText("Incorrect. Try again...");
                        break;
                }

            }
        });

        Button answer2 = (Button) findViewById(R.id.answer2Button);
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (questionNumber) {
                    case 0:
                        nextQuestion(roadSign, answerTextView, promptTextView);
                        promptTextView.setText("Guess the road sign...");
                        break;
                    case 2:
                        answerTextView.setText("Correct! Next Question...");
                        nextQuestion(roadSign, answerTextView, promptTextView);
                        break;
                    case 1:
                    case 3:
                    case 4:
                        answerTextView.setText("Incorrect. Try again...");
                        break;
                }

            }
        });

        Button answer3 = (Button) findViewById(R.id.answer3Button);
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (questionNumber) {
                    case 0:
                        nextQuestion(roadSign, answerTextView, promptTextView);
                        promptTextView.setText("Guess the road sign...");
                        break;
                    case 3:
                        answerTextView.setText("Correct! Next Question...");
                        nextQuestion(roadSign, answerTextView, promptTextView);
                        break;
                    case 1:
                    case 2:
                    case 4:
                        answerTextView.setText("Incorrect. Try again...");
                        break;
                }

            }
        });

        Button answer4 = (Button) findViewById(R.id.answer4Button);
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (questionNumber) {
                    case 0:
                        nextQuestion(roadSign, answerTextView, promptTextView);
                        promptTextView.setText("Guess the road sign...");
                        break;
                    case 4:
                        answerTextView.setText("Correct! Next Question...");
                        nextQuestion(roadSign, answerTextView, promptTextView);
                        break;
                    case 1:
                    case 2:
                    case 3:
                        answerTextView.setText("Incorrect. Try again...");
                        break;
                }

            }
        });

        }

        private void nextQuestion(ImageView targetImage, TextView answerText, TextView promptText) {
            questionNumber += 1;
            switch (questionNumber) {
                case 1:
                    targetImage.setImageResource(R.drawable.merge_left);
                    break;
                case 2:
                    targetImage.setImageResource(R.drawable.no_u_turn);
                    break;
                case 3:
                    targetImage.setImageResource(R.drawable.school_crossing);
                    break;
                case 4:
                    targetImage.setImageResource(R.drawable.slippery);
                    break;
                case 5:
                    targetImage.setImageResource(R.drawable.finish);
                    answerText.setText("Correct!");
                    promptText.setText("Congratulations, you've finished the quiz!");
                    break;
            }
    }

}