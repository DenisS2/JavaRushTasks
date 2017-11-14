package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency> {

    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    //@Override
   /* public int compareTo(Object o) {
        if (o == null) return 1;
        MoveEfficiency moveEfficiency = (MoveEfficiency) o;
        if (this.numberOfEmptyTiles != moveEfficiency.numberOfEmptyTiles) {
            return this.numberOfEmptyTiles - moveEfficiency.numberOfEmptyTiles;
        }
        return this.score - moveEfficiency.score;
    }

    @Override
    public int compareTo(Object another) {
        MoveEfficiency me=(MoveEfficiency)another;
        if (numberOfEmptyTiles != me.numberOfEmptyTiles) {
            return Integer.compare(numberOfEmptyTiles, me.numberOfEmptyTiles);
        } else {
            return Integer.compare(score, me.score);
        }
    }*/

    @Override
    public int compareTo(MoveEfficiency another) {
        if (numberOfEmptyTiles != another.numberOfEmptyTiles) {
            return Integer.compare(numberOfEmptyTiles, another.numberOfEmptyTiles);
        } else {
            return Integer.compare(score, another.score);
        }
    }

}
