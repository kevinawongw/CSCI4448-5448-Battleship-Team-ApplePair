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

    // If p1 hits p2 at point p

    public Boolean hitOrMiss(Point p, Player p1, Player p2){

        if (p2.getGb().getShipMap()[p.getY()][p.getX()] == 1){
            return true;
        }
        else if (p2.getGb().getShipMap()[p.getY()][p.getX()] == 0){
            return false;

        }
        return false;
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
