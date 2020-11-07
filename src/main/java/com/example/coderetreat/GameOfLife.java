package com.example.coderetreat;

import java.util.HashSet;
import java.util.Set;

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

    public void step() {

        Cellule[][] tmp_cells = new Cellule[cells.length][cells[0].length];


        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[i].length; j++) {
                Cellule currentCell = this.cells[i][j];
                boolean newIsAliveStatus = currentCell.isAlive();

                Set<Cellule> adjacentCells = getAdjacentCells(i, j);
                long nbAlives = adjacentCells.stream().filter(Cellule::isAlive).count();

                if (currentCell.isAlive()) {
                    if (nbAlives < 2) {
                        newIsAliveStatus = false;
                    }
                } else {
                    if (nbAlives == 3) {
                        newIsAliveStatus = true;
                    }
                }

                tmp_cells[i][j] = new Cellule(newIsAliveStatus);
            }
        }

        this.cells = tmp_cells;
    }

    private Set<Cellule> getAdjacentCells(int row, int col) {
        Set<Cellule> adjacents = new HashSet<>();

        if (col > 0)
            adjacents.add(this.cells[row][col-1]);

        if (row > 0)
            adjacents.add(this.cells[row-1][col]);

        if (col < this.cells[0].length - 1)
            adjacents.add(this.cells[row][col+1]);

        if(row < this.cells.length - 1)
            adjacents.add(this.cells[row+1][col]);


        return adjacents;
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