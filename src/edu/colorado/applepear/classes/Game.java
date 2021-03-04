package edu.colorado.applepear.classes;

public class Game {
    // Kevina was here

    // Private Variables
    private GameBoard g1 = new GameBoard(), g2 = new GameBoard();
    private Player p1 = new Player(g1), p2 = new Player(g2);


    //constructor
    public Game(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
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
            return true;
        }
        else if(p2.getGb().getShips().size() == 0){
            return true;
        }
        else{
            return false;
        }

    }

}
