package com.example.project;

/** An enemy that damages the player if stepped on */
public class Enemy extends Sprite { //child  of Sprite
    
    /**
     * Creates an enemy object
     * @param x The x coordinate of the enemy
     * @param y The y coordinate of the enemy
     */
    public Enemy(int x, int y) {
        super(x, y, "🐍");
    }


    /** Returns a formatted string witht the enemy's coordinates */
    @Override
    public String getCoords(){ //returns "Enemy:"+coordinates
        return "Enemy:" + super.getCoords();
    }

    /** Returns a formatted string with the enemy's row and column within the grid
     * @param size The size of the grid that the enenmy is in
     */
    @Override
    public String getRowCol(int size){ //return "Enemy:"+row col
        return "Enemy:" + super.getRowCol(size);
    }
}