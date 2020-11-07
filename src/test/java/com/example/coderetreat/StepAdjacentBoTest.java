package com.example.coderetreat;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StepAdjacentBoTest {

    @Test
    public void getAdjacentCells_should_return_8_cells_when_in_the_middle() {
        // Given
        // [ ][ ][ ]
        // [ ][o][ ]
        // [ ][ ][ ]
        Cellule[][] cells = new Cellule[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cellule(false);
            }
        }
        StepAdjacentBo stepAdjacentBo = new StepAdjacentBo();

        // When
        Set<Cellule> adjacentCells = stepAdjacentBo.getAdjacentCells(1, 1, cells);

        // Then
        assertEquals(8, adjacentCells.size());
    }


    @Test
    public void getAdjacentCells_should_return_3_cells_when_in_the_corner() {
        // Given
        // [o][ ][ ]
        // [ ][ ][ ]
        // [ ][ ][ ]
        Cellule[][] cells = new Cellule[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cellule(false);
            }
        }
        StepAdjacentBo stepAdjacentBo = new StepAdjacentBo();

        // When
        Set<Cellule> adjacentCells = stepAdjacentBo.getAdjacentCells(0, 0, cells);

        // Then
        assertEquals(3, adjacentCells.size());
    }

    @Test
    public void getAdjacentCells_should_return_5_cells_when_if_have_no_bottom_line() {
        // Given
        // [ ][ ][ ]
        // [ ][o][ ]
        Cellule[][] cells = new Cellule[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                cells[i][j] = new Cellule(false);
            }
        }
        StepAdjacentBo stepAdjacentBo = new StepAdjacentBo();

        // When
        Set<Cellule> adjacentCells = stepAdjacentBo.getAdjacentCells(1, 1, cells);

        // Then
        assertEquals(5, adjacentCells.size());
    }

}