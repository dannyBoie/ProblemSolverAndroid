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

    FarmerProblem problem;
    SolvingAssistant solver;
    Mover mover;
    List<String> moveNames;
    String farmerMove;
    TextView stateText;
    TextView errMessage;
    TextView congratMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwgc);

        stateText = findViewById(R.id.textView9);
        problem = new FarmerProblem();
        stateText.setText(problem.getInitialState().toString());

        errMessage = findViewById(R.id.textView7);
        congratMessage = findViewById(R.id.textView10);

        solver = new SolvingAssistant(problem);
        mover = problem.getMover();
        moveNames = mover.getMoveNames();
        farmerMove = moveNames.get(0);


    }

    //helper method


    public void farmerOnClick(View view) {

        State next = mover.doMove("Farmer is going alone", problem.getCurrentState());

        if (next != null) {
            problem.setCurrentState(next);
            errMessage.setText(" ");
            stateText.setText(next.toString());
            if (next.equals(problem.getFinalState())) {
                congratMessage.setText(R.string.congrats);
            }
        } else {
            errMessage.setText(R.string.errorMessage);
        }
    }


    public void wolfOnClick(View view) {
        State next = mover.doMove("Farmer is taking the Wolf", problem.getCurrentState());

        if (next != null) {
            problem.setCurrentState(next);
            errMessage.setText(" ");
            stateText.setText(next.toString());
            if (next.equals(problem.getFinalState())) {
                congratMessage.setText(R.string.congrats);
            }
        } else {
            errMessage.setText(R.string.errorMessage);
        }
    }


    public void goatOnClick(View view) {
        State next = mover.doMove("Farmer is taking the Goat", problem.getCurrentState());

        if (next != null) {
            problem.setCurrentState(next);
            errMessage.setText(" ");
            stateText.setText(next.toString());
            if (next.equals(problem.getFinalState())) {
                congratMessage.setText(R.string.congrats);
            }
        } else {
            errMessage.setText(R.string.errorMessage);
        }
    }


    public void cabbageOnClick(View view) {
        State next = mover.doMove("Farmer is taking the Cabbage", problem.getCurrentState());

        if (next != null) {
            problem.setCurrentState(next);
            errMessage.setText(" ");
            stateText.setText(next.toString());
            if (next.equals(problem.getFinalState())) {
                congratMessage.setText(R.string.congrats);
            }
        } else {
            errMessage.setText(R.string.errorMessage);
        }
    }

    public void resetOnClick(View view) {
        stateText.setText(problem.getInitialState().toString());
        errMessage.setText(" ");
        congratMessage.setText(" ");
    }
}


