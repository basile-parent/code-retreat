package com.example.coderetreat;

import java.util.Set;

public class StepBo {

    private StepAdjacentBo stepAdjacentBo = new StepAdjacentBo();

    public Cellule[][] step(Cellule[][] cells) {
        Cellule[][] tmp_cells = new Cellule[cells.length][cells[0].length];

        for(int i = 0; i < cells.length; i++) {
            calculateLine(cells, tmp_cells, i);
        }

        return tmp_cells;
    }

    private void calculateLine(Cellule[][] cells, Cellule[][] tmp_cells, int i) {
        for(int j = 0; j < cells[i].length; j++) {
            calculateCell(cells, tmp_cells, i, j);
        }
    }

    private void calculateCell(Cellule[][] cells, Cellule[][] tmp_cells, int i, int j) {
        Cellule currentCell = cells[i][j];
        boolean newIsAliveStatus;

        Set<Cellule> adjacentCells = stepAdjacentBo.getAdjacentCells(i, j, cells);
        long nbAlives = adjacentCells.stream().filter(Cellule::isAlive).count();

        if (currentCell.isAlive()) {
            newIsAliveStatus = isCellStillAlive(nbAlives);
        } else {
            newIsAliveStatus = isDeadCellNowAlive(nbAlives);
        }

        tmp_cells[i][j] = new Cellule(newIsAliveStatus);
    }

    private boolean isDeadCellNowAlive(long nbAlives) {
        if (nbAlives == 3) {
            return true;
        }
        return false;
    }

    private boolean isCellStillAlive(long nbAlives) {
        if (nbAlives < 2) {
            return false;
        }
        return true;
    }

}
