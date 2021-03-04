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
    public static boolean hitOrMiss(GameBoard myMap, GameBoard oppMap, Point p1) {
        if (oppMap.getShipMap()[p1.getY()][p1.getX()] == 1){
            myMap.attackMap[p1.getY()][p1.getX()] = 2;
            return true;
        }
        else if (oppMap.getShipMap()[p1.getY()][p1.getX()] == 0){
            myMap.attackMap[p1.getY()][p1.getX()] = 1;
            return false;
        }
        return false;
    }
    //Yubin
    //Call the function: checkLose() from Player to check which player lose or win the game
    //Calling this function inside the while loop of main class
    public boolean isGameOver()
    {
        if(p1.checkLose()){ //if player 1 have 0 ships left, then 2 win
            System.out.println("Winner is " + g2.getPlayer().getName() + " Congratulations!");
            System.out.println("=============GAME OVER==============");
            return true;
        }
        else if(p2.checkLose()){
            System.out.println("Winner is " + g1.getPlayer().getName() + " Congratulations!");
            System.out.println("=============GAME OVER==============");
            return true;
        }
        return false;

    }

}
