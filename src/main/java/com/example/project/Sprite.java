package com.example.project;

public class Sprite {
    private int x, y;
    /** The emoji to use when displaying the sprite */
    private String text = "🟨";

    /**
     * Constructs a sprite with the default text
     * @param x The sprite's x
     * @param y The sprite's y
     */
    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a sprite with a specified text attribute
     * @param x The sprite's x
     * @param y The sprite's y
     * @param text The text to print when displaying the sprite
     */
    public Sprite(int x, int y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
    }

    public int getX(){return x;}//placeholder
    public int getY(){return y;}

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public String getCoords(){ //returns the coordinates of the sprite ->"(x,y)"
        return "(" + x + "," + y + ")";
    }

    public String getRowCol(int size){ //returns the row and column of the sprite -> "[row][col]"
        return "[" +  (size - 1  - y) + "][" + x + "]";
    }

    /**
     * The array row that this sprite is in based on the size of the array and the sprite's y position
     * @param size The size of the array
     * @return The row of the grid array that the Sprite is in
     */
    public int getRow(int size){
        return size - 1 - y;
    }

    /**
     * The array column that this sprite is in
     * @return The column of the grid array thtat the Sprite is in
     */
    public int getCol(){
        return x;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void move(String direction) { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }

    public void interact() { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }



}
