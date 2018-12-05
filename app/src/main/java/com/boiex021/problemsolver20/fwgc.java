package com.boiex021.problemsolver20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import domains.farmer.FarmerMover;
import domains.farmer.FarmerState;
import framework.problem.State;
import framework.solution.SolvingAssistant;

public class fwgc extends AppCompatActivity {

    TextView textView = null;
    Button farmerButton;
    Button wolfButton;
    Button goatButton;
    Button cabbageButton;


    FarmerState problem = new FarmerState("West",
                                          "West",
                                          "West",
                                          "West");
    FarmerState goal = new FarmerState( "East",
                                        "East",
                                        "East",
                                        "East");


    SolvingAssistant solver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwgc);

        textView = findViewById(R.id.textView9);
        textView.setText(problem.toString());

        farmerButton = findViewById(R.id.button8);
        farmerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String testString = farmerChangeString();
                if(testString != null) {
                    textView.setText(testString);
                }
            }
        });
    }

    //helper methods

//    public  void goesAlone(View view) {
//        TextView displayState = findViewById(R.id.textView9);
//        TextView message1 = findViewById(R.id.textView7);
////        TextView numCount1 = findViewById();
//        solver.tryMove("Goes Alone");
//        if (!solver.isMoveLegal()) {
//            String message = "Invalid Move. Try Again";
//        } else if (problem.success())
//    }

    public String farmerChangeString() {

        String returnString = null;
        if(solver.isMoveLegal()) {
            solver.tryMove("FARMER");
        }
        return returnString;
    }
}


