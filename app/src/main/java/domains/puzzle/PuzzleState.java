package domains.puzzle;

import framework.problem.State;
import java.util.Arrays;

public class PuzzleState implements State {


    private final int[][] tiles;

    public int[][] getTiles() {
        return tiles;
    }

    public PuzzleState(int[][] tiles) {
        this.tiles = tiles;
    }


    public static class Location {


        public Location(int row, int column) {
            this.row = row;
            this.column = column;
        }


        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        @Override
        public String toString() {
            return "(" +row+ "," +column+ ")";
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (o.getClass() != this.getClass()) return false;
            Location other = (Location) o;
            return this.row == other.row && this.column == other.column;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 29 * hash + this.row;
            hash = 29 * hash + this.column;
            return hash;
        }

        private int row;
        private int column;
    }


    public PuzzleState (PuzzleState state, Location loc1, Location loc2) {
        tiles = copyTiles(state.tiles);
        int temp = tiles[loc1.row][loc1.column];
        tiles[loc1.row][loc1.column] = tiles[loc2.row][loc2.column];
        tiles[loc2.row][loc2.column] = temp;
    }


    public Location getLocation(int tile) {
        for (int r = 0; r < tiles.length; r++) {
            for (int c = 0; c < tiles[r].length; c++) {
                if (tiles[r][c] == tile) {
                    return new Location(r,c);
                }
            }
        }
        throw new RuntimeException("Tile " +tile+ " not found in\n" +toString());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o.getClass() != PuzzleState.class) return false;
        PuzzleState other = (PuzzleState) o;
        if (this == other) return true;
        return Arrays.deepEquals(this.tiles, other.tiles);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Arrays.deepHashCode(this.tiles);
        return hash;
    }


    @Override
    public String toString() {
        int width = tiles[0].length;
        StringBuilder builder = new StringBuilder();
        for (int[] row : tiles) {
            builder.append(horizontalDivider(width));
            builder.append("\n");
            builder.append(horizontalRow(row));
            builder.append("\n");
        }
        builder.append(horizontalDivider(width));
        return builder.toString();
    }



    private static String horizontalDivider(int width) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < width; i++) {
            builder.append("+---");
        }
        builder.append("+");
        return builder.toString();
    }

    private static String horizontalRow(int[] tiles) {
        StringBuilder builder = new StringBuilder();
        for (int tile : tiles) {
            builder.append("|");
            builder.append(tileString(tile));
        }
        builder.append("|");
        return builder.toString();
    }

    private static String tileString(int tile) {
        if ( tile == 0 ) return "   ";
        if ( tile/10 == 0 ) return " " + tile + " ";
        return tile + " ";
    }

    private static int[][] copyTiles(int[][] source) {
        int rows = source.length;
        int columns = source[0].length;
        int[][] dest = new int[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                dest[r][c] = source[r][c];
            }
        }
        return dest;
    }

    public int getHueristic(State goal) {
        return sumManhattan(this, goal);
    }

    public static int sumManhattan(State current, State goal) {
        int sum = 0;

        PuzzleState curr = (PuzzleState)current;
        PuzzleState fin = (PuzzleState)goal;

        int currTiles[][] = curr.getTiles();
        int finTiles[][] = fin.getTiles();

        for(int r = 0; r < currTiles.length; r++) {
            for(int c = 0; c < currTiles[0].length; c++) {
                if(currTiles[r][c] != 0) {
                    Location currLoc = curr.getLocation(currTiles[r][c]);
                    Location finLoc = fin.getLocation(currTiles[r][c]);
                    sum += Math.abs(currLoc.getRow() - finLoc.getRow());
                    sum += Math.abs(currLoc.getColumn() - finLoc.getColumn());
                }
            }
        }

        return sum;
    }


}