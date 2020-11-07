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
                }

                currentCell.setAlive(newIsAliveStatus);
            }
        }
    }

    private Set<Cellule> getAdjacentCells(int i, int j) {
        Set<Cellule> adjacents = new HashSet<>();

        if (i > 0) {
            adjacents.add(this.cells[i-1][j]);
            if (j > 0) {
                adjacents.add(this.cells[i-1][j-1]);
            }
            if (j < this.cells[i].length - 1) {
                adjacents.add(this.cells[i-1][j+1]);
            }
        }
        if (i < this.cells.length - 1) {
            adjacents.add(this.cells[i+1][j]);
            if (j > 0) {
                adjacents.add(this.cells[i+1][j-1]);
            }
            if (j < this.cells[i].length - 1) {
                adjacents.add(this.cells[i+1][j+1]);
            }
        }
        if (j > 0) {
            adjacents.add(this.cells[i][j-1]);
        }
        if (j < this.cells[i].length - 1) {
            adjacents.add(this.cells[i][j+1]);
        }

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