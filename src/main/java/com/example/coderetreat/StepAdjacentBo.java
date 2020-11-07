package com.example.coderetreat;

import java.util.HashSet;
import java.util.Set;

public class StepAdjacentBo {

    public Set<Cellule> getAdjacentCells(int row, int col, Cellule[][] cells) {
        Set<Cellule> adjacents = new HashSet<>();

        if (col > 0) {
            adjacents.add(cells[row][col-1]);
            adjacents.addAll(getBeforeAndAfterCells(row, col - 1, cells));
        }

        if (col < cells[0].length - 1) {
            adjacents.add(cells[row][col + 1]);
            adjacents.addAll(getBeforeAndAfterCells(row, col + 1, cells));
        }

        adjacents.addAll(getBeforeAndAfterCells(row, col, cells));
        return adjacents;
    }

    private Set<Cellule> getBeforeAndAfterCells(int row, int col, Cellule[][] cells) {
        Set<Cellule> adjacentCells = new HashSet<>();
        if (row > 0) {
            adjacentCells.add(cells[row - 1][col]);
        }
        if (row < cells.length - 1) {
            adjacentCells.add(cells[row + 1][col]);
        }
        return adjacentCells;
    }

}
