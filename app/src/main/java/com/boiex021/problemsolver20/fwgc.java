package com.boiex021.problemsolver20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import domains.farmer.FarmerMover;
import domains.farmer.FarmerProblem;
import domains.farmer.FarmerState;
import framework.problem.Mover;
import framework.problem.State;
import framework.solution.SolvingAssistant;

public class fwgc extends AppCompatActivity {

    FarmerState initial = new FarmerState("West",
                                        "West",
                                        "West",
                                        "West");

    TextView initialText;

    FarmerProblem problem;
    SolvingAssistant solver;
    Mover mover;
    List<String> moveNames;
    String farmerMove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwgc);

        initialText.setText(initial.toString());

        problem = new FarmerProblem();
        solver = new SolvingAssistant(problem);
        mover = problem.getMover();
        moveNames = mover.getMoveNames();
        farmerMove = moveNames.get(0);


    }

    //helper method

    public void farmerOnClick(View view) {
        TextView toStringView = findViewById(R.id.textView9);

        solver.tryMove(farmerMove);
        if(solver.isMoveLegal()) {
            toStringView.setText(problem.getCurrentState().toString());
        }

    }

}


