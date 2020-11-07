package com.example.coderetreat;

import lombok.Data;

@Data
public class Cellule {

    private boolean isAlive = false;

    public String toString() {
        return this.isAlive() ? "X" : " ";
    }

}
