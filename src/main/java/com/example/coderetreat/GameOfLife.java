package com.example.coderetreat;

public class GameOfLife {

    private Cellule[][] cells;

    public GameOfLife(int rows, int cols) {
        this.cells = new Cellule[rows][cols];
        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[i].length; j++) {
                this.cells[i][j] = new Cellule();
            }
        }
    }

    public void setCell(int row, int col, Cellule cell) {
        this.cells[row][col] = cell;
    }

    public Cellule[][] getCells() {
        return this.cells;
    }

    public String toString() {
        StringBuilder str = new StringBuilder("");

        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[i].length; j++) {
                str.append(String.format("[%s]", cells[i][j]));
            }
            str.append("\n");
        }
        return str.toString();
    }
}