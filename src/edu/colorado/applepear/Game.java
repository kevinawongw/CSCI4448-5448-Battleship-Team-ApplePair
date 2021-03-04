package edu.colorado.applepear;

public class Game {
    // Kevina was here

    // Private Variables
    private final Player p1, p2;
    private final GameBoard g1, g2;


    //constructor
    public Game(Player p1, Player p2, GameBoard g1, GameBoard g2){
        this.p1 = p1;
        this.p2 = p2;
        this.g1 = g1;
        this.g2 = g2;
    }

    // Function 1: Update Map
    // Param:
    // 1. Current Player's Game Board
    // 2. Opponent's Game Board
    // 3. Player input point
    // Returns: boolean & updates attackMap within gameBoard directly
    // Returns: boolean & updates attackMap within gameBoard directly

    //Yubin
    //Call the function: checkLose() from Player to check which player lose or win the game
    //Calling this function inside the while loop of main class
    public boolean isGameOver()
    {
        if(p1.getGb().getShips().size() == 0){ //if player 1 have 0 ships left, then 2 win
            System.out.println("Winner is " + p1.getName() + " Congratulations!");
            System.out.println("=============GAME OVER==============");
            return true;
        }
        else if(p1.getGb().getShips().size() == 0){
            System.out.println("Winner is " + p1.getName() + " Congratulations!");
            System.out.println("=============GAME OVER==============");
            return true;
        }
        return false;

    }

}
