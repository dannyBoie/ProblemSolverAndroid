package com.boiex021.problemsolver20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //launches fwgc introduction activity
    public void launchFwgcIntro(View view) {
        Intent intent = new Intent(this, fwgcIntro.class);
        startActivity(intent);
    }

    //launches puzzle introduction activity
    public void launchPuzzleIntro(View view) {
        Intent intent = new Intent(this, puzzleIntro.class);
        startActivity(intent);
    }

}
