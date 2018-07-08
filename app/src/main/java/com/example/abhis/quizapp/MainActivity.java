package com.example.abhis.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Question 1
    RadioButton question1_choice3;
    // Question 2
    EditText question2_answer;
    // Question 3
    CheckBox question3_choice1;
    CheckBox question2_choice2;
    CheckBox question3_choice3;
    CheckBox question3_choice4;
    // Question 4
    EditText question4_answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when submit score is clicked
     */
public void submitanswers(View view){
    CharSequence resultsDisplay;
    int score=0;
    int final_score;

    //------------------------------------------------------------------------------------------
    // Question 1 - Correct Answer is #3 (Stark Tower)
    //------------------------------------------------------------------------------------------
    Boolean answer1;

    question1_choice3 = (RadioButton) this.findViewById(R.id.question1_choice3);
    answer1 = question1_choice3.isChecked();
    if (answer1) {
        score +=1;
        display(score);
    }
    //------------------------------------------------------------------------------------------
    // Question 2 - Correct Answer is "Stan Lee"
    //------------------------------------------------------------------------------------------
    String answer2;
    question2_answer = (EditText) this.findViewById(R.id.question2_answer);
    answer2 = question2_answer.getText().toString().toLowerCase();
    if (answer2.equals("stan lee")) {
        score +=1;
        display(score);
    }
    //------------------------------------------------------------------------------------------
    // Question 3  - Correct Answers are #1 (Hulk) and #2 (Iron Man)
    //------------------------------------------------------------------------------------------
    Boolean answer3_choice1;
    Boolean answer3_choice2;
    Boolean answer3_choice3;
    Boolean answer3_choice4;
    question3_choice1 = (CheckBox) this.findViewById(R.id.question3_choice1);
    question2_choice2 = (CheckBox) this.findViewById(R.id.question3_choice2);
    question3_choice3 = (CheckBox) this.findViewById(R.id.question3_choice3);
    question3_choice4 = (CheckBox) this.findViewById(R.id.question3_choice4);
    answer3_choice1 = question3_choice1.isChecked();
    answer3_choice2 = question2_choice2.isChecked();
    answer3_choice3 = question3_choice3.isChecked();
    answer3_choice4 = question3_choice4.isChecked();
    if (answer3_choice1 && answer3_choice2 && !answer3_choice3 && !answer3_choice4) {
        score+=1;
        display(score);
    }
    //------------------------------------------------------------------------------------------
    // Question 4 - Correct Answer is "Graviton"
    //------------------------------------------------------------------------------------------
    String answer4;
    question4_answer = (EditText) this.findViewById(R.id.question4_answer);
    answer4 = question4_answer.getText().toString().toLowerCase();
    if (answer4.equals("graviton")) {
        score += 1;
        display(score);
    }
    //------------------------------------------------------------------------------------------
    // Final Score
    //------------------------------------------------------------------------------------------
    final_score = score;

    if (final_score == 4) {
        resultsDisplay = "Perfect! You scored 4 out of 4";
    } else {
        resultsDisplay = "Try again. You scored " + final_score + " out of 4";
    }

    Context context = getApplicationContext();
    int duration = Toast.LENGTH_LONG;
    Toast toast = Toast.makeText(context, resultsDisplay, duration);
    toast.setGravity(Gravity.CENTER, 0, 0);
    toast.show();

}

    /**
     * This method displays the score.
     */
    private void display( int score){

        TextView quantityTextView = (TextView) findViewById(R.id.score_view);
        quantityTextView.setText("" + score);
    }
}
