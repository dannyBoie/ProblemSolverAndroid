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

public class fwgc extends AppCompatActivity {

    TextView textView;
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

    FarmerMover mover;
//    List<String> moveNames = mover.getMoveNames();

//    int duration = Toast.LENGTH_SHORT;
//    Toast errToast = Toast.makeText(getApplicationContext(), "Illegal Move", duration);

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
                textView.setText(farmerChangeString());
            }
        });

//        wolfButton = findViewById(R.id.button9);
//        wolfButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView.setText(wolfChangeString());
//            }
//        });
//
//        goatButton = findViewById(R.id.button10);
//        goatButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView.setText(goatChangeString());
//            }
//        });
//
//        cabbageButton = findViewById(R.id.button11);
//        cabbageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView.setText(cabbageChangeString());
//            }
//        });
    }

    //helper methods

    public String farmerChangeString() {

        String returnString = problem.toString();

        

        return returnString;
    }

//    public String wolfChangeString() {
//
//        //errToast.show();
//        String returnString = problem.toString();
//
//        return returnString;
//    }
//
//    public String goatChangeString() {
//
//        //errToast.show();
//        String returnString = problem.toString();
//
//        return returnString;
//    }
//
//    public String cabbageChangeString() {
//
//        //errToast.show();
//        String returnString = problem.toString();
//
//        return returnString;
//    }



}


