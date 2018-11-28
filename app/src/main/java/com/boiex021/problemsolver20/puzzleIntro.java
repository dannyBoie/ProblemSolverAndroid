package com.boiex021.problemsolver20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class puzzleIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_intro);
    }

    //launches 8 puzzle problem
    public void launchPuzzle(View view) {
        Intent intent = new Intent(this, puzzle.class);
        startActivity(intent);
    }
}
