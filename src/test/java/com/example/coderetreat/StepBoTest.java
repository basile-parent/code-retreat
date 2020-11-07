package com.example.coderetreat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StepBoTest {

    @Test
    public void step_should_kill_a_cell_if_it_has_less_than_two_alive_adjacent_cells() {
        // Given
        // [X][ ]
        // [ ][ ]
        GameOfLife gol = new GameOfLife(2, 2);
        gol.setCell(0, 0, new Cellule(true));
        StepBo stepBo = new StepBo();

        // When
        Cellule[][] stepCells = stepBo.step(gol.getCells());

        // Then
        assertFalse(stepCells[0][0].isAlive());
    }

    @Test
    public void step_should_let_a_cell_alive_if_it_has_two_alive_adjacent_cells() {
        // Given
        // [X][X]
        // [X][ ]
        GameOfLife gol = new GameOfLife(2, 2);
        gol.setCell(0, 0, new Cellule(true));
        gol.setCell(0, 1, new Cellule(true));
        gol.setCell(1, 0, new Cellule(true));
        StepBo stepBo = new StepBo();

        // When
        Cellule[][] stepCells = stepBo.step(gol.getCells());

        // Then
        assertTrue(stepCells[0][0].isAlive());
    }

    @Test
    public void step_if_there_is_3_adjacents_cells_alive_a_cell_is_alive() {
        // Given
        // [ ][X][ ]
        // [X][ ][X]
        GameOfLife gol = new GameOfLife(2, 3);
        gol.setCell(0, 1, new Cellule(true));
        gol.setCell(1, 0, new Cellule(true));
        gol.setCell(1, 2, new Cellule(true));
        StepBo stepBo = new StepBo();

        // When
        Cellule[][] stepCells = stepBo.step(gol.getCells());

        // Then
        assertTrue(stepCells[1][1].isAlive());
    }

}