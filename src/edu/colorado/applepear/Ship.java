package edu.colorado.applepear;
// This is the  baseclass for your ship.  Modify accordingly
// TODO: practice good OO design
public class Ship {
    // TODO: create appropriate getter and setter methods
    // TODO: Understand encapsulation
    // TODO: Understand what these todo comments mean
    //Team applepear, pair 2: Yvonne and Yubin are here.
    //Team applepear, pair 1: Vienna and Kevina are here.
    private GameBoard gb1;
    private GameBoard gb2;
    private Player p1;
    private Player p2;
    private Game g;
    private int shipSize;
    private int Minesweeper = 2;
    private int Destroyer =3;
    private int Battleship = 4;
    private int Tower = 1;
    private int L = 3;


    //how many coordinates the ship has to hit
    //if the health become 0 then, determinate if the ship is sunken or not

    // --Ships--:
    // Minesweeper (2 blocks)
    // Destroyer (3 blocks)
    // Battleship (4 Blocks)
    // Tower (1 block x 3 hits)
    // L - Ship (3 blocks shaped like "L")


    //Constructor
    public Ship(Player p1, Player p2, GameBoard gb1, GameBoard gb2, Game g){
        this.p1 = p1;
        this.gb1 = gb1;
        this.p2 = p2;
        this.gb2 = gb2;
        this.g  = g;
    }

    public void sunkenOrNot(){ //checking to see if the ship is sunken or not
        //get the location
        GameBoard p1Map = new GameBoard(gb1.getPlayer());
        GameBoard p2Map = new GameBoard(gb2.getPlayer());
        String x = null;
        String y = null;

        if(p1Map.equals(p1.getName())){

        }
        else if (p2Map.equals(p2.getName())){

        }


    }

}
