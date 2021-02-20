package edu.colorado.applepear;

public class Game {
    // Kevina was here
    // Private Variables
    private Player p1;
    private Player p2;
    private GameBoard g1;
    private GameBoard g2;


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
    // 3. Player input X coord
    // 4. Player input y coord
    // Returns: boolean & updates attackMap within gameBoard directly
    // Returns: boolean & updates attackMap within gameBoard directly
    public static boolean updateMap(GameBoard myMap, GameBoard oppMap, String myX, String myY) {
        if (oppMap.getShipMap()[Integer.parseInt(myY)][Integer.parseInt(myX)] == 1){
            myMap.attackMap[Integer.parseInt(myY)][Integer.parseInt(myX)] = 2;
            return true;
        }
        else if (oppMap.getShipMap()[Integer.parseInt(myY)][Integer.parseInt(myX)] == 0){
            myMap.attackMap[Integer.parseInt(myY)][Integer.parseInt(myX)] = 1;
            return false;
        }
        return false;
    }
    //Yubin
    public void isGameOver()
    {
        if(p1.checkLose() == true){ //if player 1 have 0 ships left
            System.out.println("Winner is " + g1.getPlayer().getName() + " Congratulations!");
            System.out.println("=============GAME OVER==============");
            System.exit(0);
        }
        else if(p2.checkLose() == true){
            System.out.println("Winner is " + g2.getPlayer().getName() + " Congratulations!");
            System.out.println("=============GAME OVER==============");
            System.exit(0);
        }


    }

}
