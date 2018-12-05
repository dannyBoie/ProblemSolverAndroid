package com.boiex021.problemsolver20;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import domains.farmer.FarmerProblem;
import framework.problem.Mover;
import framework.problem.State;
import framework.solution.AStarSolver;
import framework.solution.Solver;

public class fwgc extends AppCompatActivity {

    FarmerProblem problem;
    Mover mover;
    List<String> moveNames;
    String farmerMove;
    TextView stateText;
    TextView errMessage;
    TextView congratMessage;
    AStarSolver solver;
    TextView solutionText;
    boolean solved;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwgc);

        stateText = findViewById(R.id.textView9);
        problem = new FarmerProblem();
        stateText.setText(problem.getInitialState().toString());

        errMessage = findViewById(R.id.textView7);
        congratMessage = findViewById(R.id.textView10);

        mover = problem.getMover();
        moveNames = mover.getMoveNames();
        farmerMove = moveNames.get(0);

        solver = new AStarSolver(problem);
        solutionText = findViewById(R.id.textView11);
        solved = false;


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
        problem.setCurrentState(problem.getInitialState());
        stateText.setText(problem.getInitialState().toString());
        errMessage.setText(" ");
        congratMessage.setText(" ");
        solutionText.setText(" ");
        solved = false;

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void solveOnClick(View view) {
        solved = true;
        solver.solve();
        solver.getSolution().next();
        solutionText.setText(solver.getStatistics().toString());
    }

    public void nextOnClick(View view) {
        if(solved) {
        stateText.setText(solver.getSolution().next().toString());
            if(stateText.getText().equals(problem.getFinalState().toString())) {
              congratMessage.setText(R.string.congrats);
              solved = false;
          }
        }
    }
}


