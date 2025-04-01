package com.example.project;


/** The grid that houses all of the game's Sprite objects */
public class Grid{
    /** The grid that houses all fo the game's Sprite objects */
    private Sprite[][] grid;
    /** The side length of the grid */
    private int size;

    /**
     * Initializes the grid with all Dot objects
     * @param size The side length of the grid to create
     */
    public Grid(int size) {
        this.size = size;
        grid = new Sprite[size][size]; // Creates a size x size array
        for(int i = 0; i < size; i ++){
            for(int j = 0; j < size; j ++){
                placeSprite(new Dot(i, j)); // Fills the array with Dots
            }
        }
    }

 
    public Sprite[][] getGrid(){return grid;}


    /**
     * Places a Sprite on the grid
     * @param s The Sprite to place
     */
    public void placeSprite(Sprite s){ //place sprite in new spot
        grid[s.getRow(size)][s.getCol()] = s;
    }

    /**
     * Places a sprite, and updates the location where it previously was based on its move direction to be an empty space again
     * @param s The sprite to move
     * @param direction The direction to move it in
     */
    public void placeSprite(Sprite s, String direction) {
        placeSprite(s); // Places the sprite

        // Determines where the sprite was before it last moved, and then places a Dot there to overwrite the Player object that was once there.
        if(direction.equals("w")){ // If the player moved up
            placeSprite(new Dot(s.getX(), s.getY()-1)); // Places a Dot in the postion where the sprite used to be
        }
        else if(direction.equals("a")){ // If the player moved left
            placeSprite(new Dot(s.getX() + 1, s.getY())); // Places a Dot in the postion where the sprite used to be
        }
        if(direction.equals("s")){ // If the player moved down
            placeSprite(new Dot(s.getX(), s.getY() + 1)); // Places a Dot in the postion where the sprite used to be
        }
        if(direction.equals("d")){ // If the player moved right
            placeSprite(new Dot(s.getX() - 1, s.getY())); // Places a Dot in the postion where the sprite used to be
        }
    }


    /** Prints the grid so the player can view it */
    public void display() {
        for(Sprite[] row: grid){
            for(Sprite s: row){
                System.out.print(s.getText());
            }
            System.out.println();
        }
    }
    
    public void gameover(){ //use this method to display a loss
        for(Sprite[] row: grid){
            for(Sprite sprite: row){
                if(!(sprite instanceof Player)){
                    sprite.setText("🐍");
                }
            }
        }
    }

    /** Fills the grid with money bags to indicate that the player won */
    public void win(){ //use this method to display a win 
        for(Sprite[] row: grid){
            for(Sprite sprite: row){
                if(!(sprite instanceof Player)){
                    sprite.setText("💰");
                }
            }
        }
    }


}