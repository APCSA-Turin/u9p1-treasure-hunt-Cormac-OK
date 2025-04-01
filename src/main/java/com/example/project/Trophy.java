package com.example.project;

/** A subclass of Treasure that when collected, ends the game in a victory */
public class Trophy extends Treasure { 
    public Trophy(int x, int y){
        super(x, y, "🚂");
    }
}
