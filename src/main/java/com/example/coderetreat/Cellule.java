package com.example.coderetreat;

public class Cellule {

    private boolean isAlive = false;

    public Cellule(boolean alive) {
        this.isAlive = alive;
    }

    public Cellule() {
        this.isAlive = false;
    }

    public String toString() {
        return this.isAlive() ? "X" : " ";
    }

    public Boolean isAlive() { return this.isAlive; }

    public void setAlive(Boolean alive){ this.isAlive = alive; }

}
