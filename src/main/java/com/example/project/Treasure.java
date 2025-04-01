package com.example.project;

//only needs a constructor
public class Treasure extends Sprite{ //child of Sprite

    /**
     * A constructor to create a basic Treasure object
     * @param x The Treasure's x coordinate
     * @param y The Treasure's y coordinate
     */
    public Treasure(int x, int y) {
        super(x, y, "🐮");
    }

    /**
     * Constructor for the Trophy class so that it can create a Treasure with a text other than 🐮
     * @param x The Treasure's x coordinate
     * @param y The Treasure's y coordinate
     * @param text The text to use when displaying the Treasure
     */
    public Treasure(int x, int y, String text) {
        super(x, y, text);
    }

}