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
