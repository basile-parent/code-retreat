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

}