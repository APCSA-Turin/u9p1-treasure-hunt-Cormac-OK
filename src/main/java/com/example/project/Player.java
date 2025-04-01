package com.example.project;

/** A Sprite which can move around and interact with the world.
 */
public class Player extends Sprite {
    private int treasureCount;
    private int numLives;
    private boolean win;

    /**
     * Creates a Player object
     * <p>
     * Sets treasureCount and numLives to defaults of 0 and 2, respectively 
     * @param x The player's x coordinate
     * @param y The player's y coordinate
     */
    public Player(int x, int y) {
        super(x, y, "🤠");
        treasureCount = 0;
        numLives = 2;

    }


    public int getTreasureCount(){return treasureCount;}
    public int getLives(){return numLives;}
    public boolean getWin(){return win;}

  
    /**
     * Moves the player in a direction specified by the input
     * @param direction The direction to move, based on wasd
     */
    @Override
    public void move(String direction) { //move the (x,y) coordinates of the player
        direction = direction.toLowerCase();
        if(isValid(10, direction)){
            if(direction.equals("w")){
                setY(getY()+1);
            }
            else if(direction.equals("a")){
                setX(getX()-1);
            }
            else if(direction.equals("s")){
                setY(getY()-1);
            }
            else if(direction.equals("d")){
                setX(getX()+1);
            }
        }
    }


    /**
     * Checks if the player can interact with the object at the location they are trying to move to
     * @param size The size of the grid
     * @param direction The direction the player wants to move in
     * @param numTreasures The initial number of treasures
     * @param obj The object at the position the player wants to move to
     */
    public void interact(int size, String direction, int numTreasures, Object obj) {
        if(obj instanceof Trophy){
            if(treasureCount == numTreasures){
                win = true;
            }
        }
        else if(obj instanceof Treasure){
            treasureCount ++;
        }
        else if(obj instanceof Enemy){
            numLives --;
        }
        
    }


    /**
     * Determines whether the specified movement direction is unobstructed for the player
     * @param size The size of the grid
     * @param direction The direction the player wants to move in, in the format of WASD
     * @return Whether the player can move in the specified direction
     */
    public boolean isValid(int size, String direction){
        direction = direction.toLowerCase();
        if(direction.equals("w") && getY() < size - 1){
            return true;
        }
        else if(direction.equals("a") && getX() > 0){
            return true;
        }
        if(direction.equals("s") && getY() > 0){
            return true;
        }
        if(direction.equals("d") && getX() < size - 1){
            return true;
        }
        return false;
    }

    // public boolean isUnobstructed(Grid grid, String direction){

    // }

    @Override
    public String getRowCol(int size) {
        return "Player:" + super.getRowCol(size);
    }

    @Override
    public String getCoords() {
        return "Player:" + super.getCoords();
    }

    /**
     * The grid column of the player after they move in the specified direction
     * @param direction The direction to move
     * @return The grid column the player will be in after the move is made
     */
    public int getNewCol(String direction){
        direction = direction.toLowerCase();
        if(direction.equals("a")){
            return getCol() - 1;
        }
        else if(direction.equals("d")){
            return getCol() + 1;
        }
        else{
            return getCol();
        }
    }

    /**
     * The grid row of the player after they move in the specified direction
     * @param direction The direction to move
     * @param size The size of the grid
     * @return The grid row the player will be after the move is made
     */
    public int getNewRow(String direction, int size){
        direction = direction.toLowerCase();
        if(direction.equals("w")){
            return getRow(size) - 1;
        }
        else if(direction.equals("s")){
            return getRow(size) + 1;
        }
        else{
            return getRow(size);
        }
    }

   
}



