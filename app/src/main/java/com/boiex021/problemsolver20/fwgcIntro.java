package com.boiex021.problemsolver20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class fwgcIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwgc_intro);
    }

    //launches fwgc activity
    public void launchFwgc(View view) {
        Intent intent = new Intent(this, fwgc.class);
        startActivity(intent);
    }
}
