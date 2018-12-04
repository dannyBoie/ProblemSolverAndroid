package domains.puzzle;


import framework.problem.Problem;



public class PuzzleProblem extends Problem {

    public PuzzleProblem() {
        super();
        super.setName("8 Tile Puzzle");
        super.setIntroduction(INTRO);
        super.setMover(new PuzzleMover());
        puzzle[0][0] = 2;
        puzzle[0][1] = 8;
        puzzle[0][2] = 3;
        puzzle[1][0] = 1;
        puzzle[1][1] = 6;
        puzzle[1][2] = 4;
        puzzle[2][0] = 7;
        puzzle[2][1] = 0;
        puzzle[2][2] = 5;
        super.setInitialState(new PuzzleState(puzzle));
        super.setCurrentState(super.getInitialState());
        puzzleFinal[0][0] = 1;
        puzzleFinal[0][1] = 2;
        puzzleFinal[0][2] = 3;
        puzzleFinal[1][0] = 8;
        puzzleFinal[1][1] = 0;
        puzzleFinal[1][2] = 4;
        puzzleFinal[2][0] = 7;
        puzzleFinal[2][1] = 6;
        puzzleFinal[2][2] = 5;
        super.setFinalState(new PuzzleState(puzzleFinal));
    }

    int [][] puzzle = new int [3][3];
    int [][] puzzleFinal = new int [3][3];

    private static final String INTRO =
            "There is a board upon which numbered tiles are placed in a semi"
                    + "random order. A legal move is moving a tile into the blank space"
                    + "which is adjacent to it. When the puzzle is finished it will look"
                    + "like the final board placed below.\n"
                    +  "+---+---+---+\n" +
                    "| 1 | 2 | 3 |\n" +
                    "+---+---+---+\n" +
                    "| 8 |   | 4 |\n" +
                    "+---+---+---+\n" +
                    "| 7 | 6 | 5 |\n" +
                    "+---+---+---+";

}