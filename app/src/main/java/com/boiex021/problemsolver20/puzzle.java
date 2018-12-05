package com.boiex021.problemsolver20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import domains.puzzle.PuzzleProblem;
import domains.puzzle.PuzzleState;

public class puzzle extends AppCompatActivity {

    TextView stateText;

    PuzzleProblem problem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        stateText = findViewById(R.id.textView12);

        problem = new PuzzleProblem();

    }
}

