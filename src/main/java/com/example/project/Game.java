package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 

    public Game(int size){ //the constructor should call initialize() and play()
        this.size = size;
        initialize();
        play();
    }

    public static void clearScreen() { //do not modify
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){ //write your game logic here
        Scanner scanner = new Scanner(System.in);


        while(!player.getWin() && player.getLives() > 0){
            try {
                Thread.sleep(100); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen(); // Clear the screen at the beggining of the while loop

            // Displaying screen:
            grid.display();
            System.out.println(player.getCoords());
            System.out.println("Health: " + player.getLives());
            System.out.println("Treasure: " + player.getTreasureCount());
            System.out.println("Has won: " + player.getWin());

            // Getting input
            String moveDirection = scanner.nextLine();

            // Makes sure the player is not trying to move off the board:
            if(player.isValid(size, moveDirection)){
                // The Sprite that the player is trying to move onto:
                Sprite targetObj = grid.getGrid()[player.getNewRow(moveDirection, size)][player.getNewCol(moveDirection)];

                player.interact(size, moveDirection, treasures.length, targetObj);

                // If the player can move, they move
                if((!(targetObj instanceof Trophy) || player.getWin()) && !(targetObj instanceof River)){
                    player.move(moveDirection);
                    grid.placeSprite(player, moveDirection);
                }
            }
        }
    
        // If the player won:
        if(player.getWin()){
            clearScreen();
            grid.win();
            grid.display();
            System.out.println("YOU WIN!");
        }
        
        // If the player lost:
        else if (player.getLives() == 0){
            clearScreen();
            grid.gameover();
            grid.display();
            System.out.println("YOU LOSE!");

        }
    }

    public void initialize(){

        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
        
        grid = new Grid(size);

        // Setting up player:
        player = new Player(0, 0);
        grid.placeSprite(player);

        // Setting up treasure:
        treasures = new Treasure[2];
        treasures[0] = new Treasure(5, 7);
        treasures[1] = new Treasure(2, 1);
        grid.placeSprite(treasures[0]);
        grid.placeSprite(treasures[1]);

        // Setting up trophy:
        trophy = new Trophy(8, 5);
        grid.placeSprite(trophy);
   
        // Setting up enemies:
        enemies = new Enemy[2];
        enemies[0] = new Enemy(8, 2);
        enemies[1] = new Enemy(2, 7);
        grid.placeSprite(enemies[0]);
        grid.placeSprite(enemies[1]);

        // Setting up river
        grid.placeSprite(new River(4, 1));
        grid.placeSprite(new River(4, 2));
        grid.placeSprite(new River(4, 3));
        grid.placeSprite(new River(3, 3));
        grid.placeSprite(new River(2, 3));
        grid.placeSprite(new River(1, 3));
        grid.placeSprite(new River(1, 4));
        grid.placeSprite(new River(1, 5));
        grid.placeSprite(new River(5, 3));
        grid.placeSprite(new River(5, 4));
        grid.placeSprite(new River(5, 5));
        grid.placeSprite(new River(5, 6));
        grid.placeSprite(new River(6, 6));
        grid.placeSprite(new River(7, 6));
        grid.placeSprite(new River(8, 6));
        grid.placeSprite(new River(9, 6));
    }

    public static void main(String[] args) {
        System.out.println("STARTING");
        Game game = new Game(10);
    }
}