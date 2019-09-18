package com.example.nitinr.fblaqtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Collections;


public class QuizActivity extends AppCompatActivity {
    TextView q;
    Button c1,c2,c3;
    int count = 0;
    int NUMBER_OF_QUESTIONS = 25;
    int score = 0;
    ArrayList<Integer> numberHolder;
    private String answer = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        //initializing the Question textbox and multiple choice boxes
         q = (TextView) findViewById(R.id.tvquestion);
         c1 = (Button) findViewById(R.id.bt1);
         c2 = (Button) findViewById(R.id.bt2);
         c3 = (Button) findViewById(R.id.bt3);

        //generate list of random questions whenever the app is launched
        generateRandomQuestions();

        loadQuestion();




    }
    //this method generates random questions by creating an array of question numbers and then shuffling it randomly
    public void  generateRandomQuestions(){
        numberHolder = new ArrayList<>(NUMBER_OF_QUESTIONS);
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++)
            numberHolder.add(i);

        Collections.shuffle(numberHolder);
        System.out.println(numberHolder);

    }
    //method to change the question, multiple choices, and answer each time the user selects an answer
    public void loadQuestion() {

        //getting the number of the question stored in variable r
        //making sure that a question is not loaded up if the count exceeds the number of total questions
        if(count <NUMBER_OF_QUESTIONS) {
            int r = numberHolder.get(count);
            //creating object that will access the QuestionStore class and retrieve values and passing the value of the random question number to the class
            QuestionStore qs = new QuestionStore(r);
            //calling methods in order to fill up question text and mutliple choices and load the answer
            qs.storeQuestions();
            qs.storeChoices();
            qs.storeAnswers();
            //setting the question and multiple choices

            q.setText(qs.getQuestion());
            c1.setText(qs.getChoice1());
            c2.setText(qs.getChoice2());
            c3.setText(qs.getChoice3());
            answer = qs.getAnswer();
        }
        else{
            endGame();
        }




    }
    //method to determine whether the answer is correct. This works by accepting the string of the button as a parameter and checking it the answer
    //for the question
    public void checkAnswer(String a){
        if(a.equals(answer)) {
            displayAnswer();
            score++;
        }
        else{
            Toast.makeText(QuizActivity.this,
                    "Incorrect Choice", Toast.LENGTH_SHORT).show();
        }

    }
    //simple message to inform user that the answer is correct
    public void displayAnswer(){
        String message = "That is the correct answer!";

        Toast.makeText(QuizActivity.this,
                message, Toast.LENGTH_SHORT).show();
    }
    //code for selecting the multiple choice answers
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt1:
                checkAnswer(String.valueOf(c1.getText()));
                count++;
                loadQuestion();
                break;

            case R.id.bt2:
                checkAnswer(String.valueOf(c2.getText()));
                count++;
                loadQuestion();
                break;

            case R.id.bt3:
                checkAnswer(String.valueOf(c3.getText()));
                count++;
                loadQuestion();
                break;

        }





    }

    public void endGame(){
        Intent i = new Intent(QuizActivity.this, PopUpActivity.class);
        i.putExtra("participantScore",score);
        startActivity(i);
    }

}