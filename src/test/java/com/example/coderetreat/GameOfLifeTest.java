package com.example.coderetreat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {

    @Test
    public void toString_should_return_a_string_representation_of_game_of_life() {
        // Given
        GameOfLife gol = new GameOfLife(1, 1);

        // When
        String result = gol.toString();

        // Then
        assertEquals("[ ]\n", result);
    }

    @Test
    public void toString_should_return_a_string_representation_of_game_of_life_when_cell_is_alive() {
        // Given
        GameOfLife gol = new GameOfLife(1, 1);

        Cellule cell = new Cellule(true);

        gol.setCell(0, 0, cell);
        // When
        String result = gol.toString();

        // Then
        assertEquals("[X]\n", result);
    }

    @Test
    public void toString_should_return_a_string_representation_of_game_of_life_when_have_several_lines() {
        // Given
        GameOfLife gol = new GameOfLife(2, 2);
        gol.setCell(0, 0, new Cellule(true));
        gol.setCell(1, 1, new Cellule(true));

        // When
        String result = gol.toString();

        // Then
        assertEquals("[X][ ]\n[ ][X]\n", result);
    }

    @Test
    public void step_should_kill_a_cell_if_it_has_less_than_two_alive_adjacent_cells() {
        // Given
        // [X][ ]
        // [ ][ ]
        GameOfLife gol = new GameOfLife(2, 2);
        gol.setCell(0, 0, new Cellule(true));

        // When
        gol.step();

        // Then
        Cellule[][] cells = gol.getCells();
        assertFalse(cells[0][0].isAlive());
    }

}