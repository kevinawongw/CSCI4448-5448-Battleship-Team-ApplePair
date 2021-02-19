package edu.colorado.applepear;

import java.util.ArrayList;

// This is the  baseclass for your ship.  Modify accordingly
// TODO: practice good OO design
public class Ship {
    // TODO: create appropriate getter and setter methods
    // TODO: Understand encapsulation
    // TODO: Understand what these todo comments mean
    //Team applepear, pair 2: Yvonne and Yubin are here.
    //Team applepear, pair 1: Vienna and Kevina are here.
    private int shipSize;
    private int Minesweeper = 2;
    private int Destroyer =3;
    private int Battleship = 4;
    private int Tower = 1;
    private int L = 3;
    private int posX;
    private int posY;
    private int coord [][];



    //how many coordinates the ship has to hit
    //if the health become 0 then, determinate if the ship is sunken or not

    // --Ships--:
    // Minesweeper (2 blocks)
    // Destroyer (3 blocks)
    // Battleship (4 Blocks)
    // Tower (1 block x 3 hits)
    // L - Ship (3 blocks shaped like "L")
    public ArrayList<Point> location;

    //Constructor
    public Ship(){
        location = new ArrayList<Point>();
    }

//    public boolean sunkenOrNot(){ //checking to see if the ship is sunken or not
//        //get the location
//        GameBoard p1Map = new GameBoard(gb1.getPlayer());
//        GameBoard p2Map = new GameBoard(gb2.getPlayer());
//
//
//        if(p1Map.equals(p1.getName())){
//            return true;
//        }
//        else if (p2Map.equals(p2.getName())){
//            return true;
//        }
//
//        return false;
//    }

    public boolean sunkenMinesweeper(){

        return false;
    }
    public boolean sunkenDestroyer(){
        return false;
    }
    public boolean sunkenBattleship(){

        return false;
    }
    public boolean sunkenTower(){
        return false;
    }
    public boolean sunkenLShip(){

        return false;
    }


    public void determineSunkenShip(){
        //maybe i can create 5 functions for ship shape and call it here
        //put if statement to check each shape of ship is sunken or not
        //If specific shape of ship is sunken, it will return true;
        //because anyway every player has to place 5 ships
        sunkenMinesweeper();
        sunkenDestroyer();
        sunkenBattleship();
        sunkenTower();
        sunkenLShip();
    }

}
