package edu.colorado.applepear;

import java.util.ArrayList;
// --Ships--:
// Minesweeper (2 blocks)
// Destroyer (3 blocks)
// Battleship (4 Blocks)
// Tower (1 block x 3 hits)
// L - Ship (3 blocks shaped like "L")

public class Ship {
    protected int posY;
    protected int posX;
    private GameBoard gb;
    public ArrayList<Point> location;
    //    private int Destroyer =3;
    //    private int Battleship = 4;
    //    private int Tower = 1;
    //    private int L = 3;

    //Constructor
//    public Ship(){
//        location = new ArrayList<Point>();
//    }
    public Ship(int posX, int posY){

        this.posX = posX;
        this.posY = posY;
    }

    public void sunkenMinesweeper(int posX, int posY){
        int count =0;
        int minesweeper = 2;

        for(int i = 0; i< minesweeper; i++){
            if(gb.attackMap[posY][posX] == 2){ // if ship found

                if(count == minesweeper){
                    System.out.println("You sunk the Minesweeper! Congratulations");

                }
                count++;
            }
        }
        System.out.println("You have not sunken the Minesweeper.");

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


    public void determineSunkenShip(int posX, int posY){
        //put if statement to check each shape of ship is sunken or not
        //If specific shape of ship is sunken, it will return true;
        //because anyway every player has to place 5 ships
        sunkenMinesweeper(posX,posY);
//        sunkenDestroyer();
//        sunkenBattleship();
//        sunkenTower();
//        sunkenLShip();
    }

}
