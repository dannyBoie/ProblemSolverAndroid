package com.boiex021.problemsolver20;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import domains.puzzle.PuzzleProblem;
import domains.puzzle.PuzzleState;
import framework.problem.Mover;
import framework.problem.State;
import framework.solution.AStarSolver;
import framework.solution.Solver;

@RequiresApi(api = Build.VERSION_CODES.N)
public class puzzle extends AppCompatActivity {

    TextView stateText;
    PuzzleProblem problem;
    Mover mover;
    TextView errMessage;
    TextView congratsMessage;
    TextView solutionText;
    boolean solved;
    Solver solver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        stateText = findViewById(R.id.textView12);
        problem = new PuzzleProblem();
        stateText.setText(problem.getInitialState().toString());
        mover = problem.getMover();

        errMessage = findViewById(R.id.textView15);
        congratsMessage = findViewById(R.id.textView16);
        solutionText = findViewById(R.id.textView14);

        solved = false;
        solver = new AStarSolver(problem);

    }

    public void onOneClick(View view) {

        State next = mover.doMove("Tile 1", problem.getCurrentState());

        if(next != null) {
            problem.setCurrentState(next);
            errMessage.setText(" ");
            stateText.setText(next.toString());
            if (next.equals(problem.getFinalState())) {
                congratsMessage.setText(R.string.congrats);
            }
        } else {
            errMessage.setText(R.string.errorMessage);
        }
    }

    public void onTwoClick(View view) {

        State next = mover.doMove("Tile 2", problem.getCurrentState());

        if(next != null) {
            problem.setCurrentState(next);
            errMessage.setText(" ");
            stateText.setText(next.toString());
            if (next.equals(problem.getFinalState())) {
                congratsMessage.setText(R.string.congrats);
            }
        } else {
            errMessage.setText(R.string.errorMessage);
        }
    }

    public void onThreeClick(View view) {

        State next = mover.doMove("Tile 3", problem.getCurrentState());

        if(next != null) {
            problem.setCurrentState(next);
            errMessage.setText(" ");
            stateText.setText(next.toString());
            if (next.equals(problem.getFinalState())) {
                congratsMessage.setText(R.string.congrats);
            }
        } else {
            errMessage.setText(R.string.errorMessage);
        }
    }

    public void onFourClick(View view) {

        State next = mover.doMove("Tile 4", problem.getCurrentState());

        if(next != null) {
            problem.setCurrentState(next);
            errMessage.setText(" ");
            stateText.setText(next.toString());
            if (next.equals(problem.getFinalState())) {
                congratsMessage.setText(R.string.congrats);
            }
        } else {
            errMessage.setText(R.string.errorMessage);
        }
    }

    public void onFiveClick(View view) {

        State next = mover.doMove("Tile 5", problem.getCurrentState());

        if(next != null) {
            problem.setCurrentState(next);
            errMessage.setText(" ");
            stateText.setText(next.toString());
            if (next.equals(problem.getFinalState())) {
                congratsMessage.setText(R.string.congrats);
            }
        } else {
            errMessage.setText(R.string.errorMessage);
        }
    }

    public void onSixClick(View view) {

        State next = mover.doMove("Tile 6", problem.getCurrentState());

        if(next != null) {
            problem.setCurrentState(next);
            errMessage.setText(" ");
            stateText.setText(next.toString());
            if (next.equals(problem.getFinalState())) {
                congratsMessage.setText(R.string.congrats);
            }
        } else {
            errMessage.setText(R.string.errorMessage);
        }
    }

    public void onSevenClick(View view) {

        State next = mover.doMove("Tile 7", problem.getCurrentState());

        if(next != null) {
            problem.setCurrentState(next);
            errMessage.setText(" ");
            stateText.setText(next.toString());
            if (next.equals(problem.getFinalState())) {
                congratsMessage.setText(R.string.congrats);
            }
        } else {
            errMessage.setText(R.string.errorMessage);
        }
    }

    public void onEightClick(View view) {

        State next = mover.doMove("Tile 8", problem.getCurrentState());

        if(next != null) {
            problem.setCurrentState(next);
            errMessage.setText(" ");
            stateText.setText(next.toString());
            if (next.equals(problem.getFinalState())) {
                congratsMessage.setText(R.string.congrats);
            }
        } else {
            errMessage.setText(R.string.errorMessage);
        }
    }

    public void onResetClick(View view) {
        problem.setCurrentState(problem.getInitialState());
        stateText.setText(problem.getInitialState().toString());
        errMessage.setText(" ");
        congratsMessage.setText(" ");
        solutionText.setText(" ");
        solved = false;
    }

    public void onSolveClick(View view) {
        solved = true;
        solver.solve();
        solver.getSolution().next();
        solutionText.setText(solver.getStatistics().toString());
    }

    public void nextOnClick(View view) {
        if(solved) {
            stateText.setText(solver.getSolution().next().toString());
            if(stateText.getText().equals(problem.getFinalState().toString())) {
                congratsMessage.setText(R.string.congrats);
                solved = false;
            }
        }
    }
}

