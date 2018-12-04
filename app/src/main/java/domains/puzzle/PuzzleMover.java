package domains.puzzle;


import framework.problem.Mover;
import framework.problem.State;


public class PuzzleMover extends Mover {

    public static final String T1 = "Tile 1";
    public static final String T2 = "Tile 2";
    public static final String T3 = "Tile 3";
    public static final String T4 = "Tile 4";
    public static final String T5 = "Tile 5";
    public static final String T6 = "Tile 6";
    public static final String T7 = "Tile 7";
    public static final String T8 = "Tile 8";

    public PuzzleMover() {
        super.addMove(T1, s -> tryOne(s));
        super.addMove(T2, s -> tryTwo(s));
        super.addMove(T3, s -> tryThree(s));
        super.addMove(T4, s -> tryFour(s));
        super.addMove(T5, s -> tryFive(s));
        super.addMove(T6, s -> trySix(s));
        super.addMove(T7, s -> trySeven(s));
        super.addMove(T8, s -> tryEight(s));
    }

    private State tryOne(State state)
    {
        PuzzleState s = (PuzzleState)state;
        if(CheckNear(state,1))
        {
            return new PuzzleState(s, s.getLocation(1), s.getLocation(0));
        }
        return null;
    }

    private State tryTwo(State state)
    {
        PuzzleState s = (PuzzleState)state;
        if(CheckNear(state,2))
        {
            return new PuzzleState(s, s.getLocation(2), s.getLocation(0));
        }
        return null;
    }

    private State tryThree(State state)
    {
        PuzzleState s = (PuzzleState)state;
        if(CheckNear(state,3))
        {
            return new PuzzleState(s, s.getLocation(3), s.getLocation(0));
        }
        return null;
    }

    private State tryFour(State state)
    {
        PuzzleState s = (PuzzleState)state;
        if(CheckNear(state,4))
        {
            return new PuzzleState(s, s.getLocation(4), s.getLocation(0));
        }
        return null;
    }

    private State tryFive(State state)
    {
        PuzzleState s = (PuzzleState)state;
        if(CheckNear(state,5))
        {
            return new PuzzleState(s, s.getLocation(5), s.getLocation(0));
        }
        return null;
    }

    private State trySix(State state)
    {
        PuzzleState s = (PuzzleState)state;
        if(CheckNear(state,6))
        {
            return new PuzzleState(s, s.getLocation(6), s.getLocation(0));
        }
        return null;
    }

    private State trySeven(State state)
    {
        PuzzleState s = (PuzzleState)state;
        if(CheckNear(state,7))
        {
            return new PuzzleState(s, s.getLocation(7), s.getLocation(0));
        }
        return null;
    }

    private State tryEight(State state)
    {
        PuzzleState s = (PuzzleState)state;
        if(CheckNear(state,8))
        {
            return new PuzzleState(s, s.getLocation(8), s.getLocation(0));
        }
        return null;
    }

    private boolean CheckNear(State state, int tile)
    {
        PuzzleState s = (PuzzleState)state;
        boolean fin = false;

        //Check Above
        if(s.getLocation(tile).getColumn() == s.getLocation(0).getColumn() &&
                s.getLocation(tile).getRow() == s.getLocation(0).getRow()-1)
        {
            return true;
        }
        //Check Below
        else if(s.getLocation(tile).getColumn() == s.getLocation(0).getColumn() &&
                s.getLocation(tile).getRow() == s.getLocation(0).getRow()+1)
        {
            return true;
        }
        //Check Left
        else if(s.getLocation(tile).getColumn() == s.getLocation(0).getColumn()-1 &&
                s.getLocation(tile).getRow() == s.getLocation(0).getRow())
        {
            return true;
        }
        //Check Right
        else if(s.getLocation(tile).getColumn() == s.getLocation(0).getColumn()+1 &&
                s.getLocation(tile).getRow() == s.getLocation(0).getRow())
        {
            return true;
        }
        return fin;
    }
}