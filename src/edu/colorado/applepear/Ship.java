package edu.colorado.applepear;
import java.util.ArrayList;

//Yubin was here

// --5 Types of Ships--:
// Minesweeper (2 blocks)
// Destroyer (3 blocks)
// Battleship (4 Blocks)
// Tower (1 block x 3 hits)
// L - Ship (3 blocks shaped like "L")



public class Ship {
    public ArrayList<Point> location;
    public String shipType;
    GameBoard gb;

    //Constructor
    public Ship(String shipType){
        location = new ArrayList<Point>();
        this.shipType = shipType;
        this.gb = gb;
    }


    //getter
//    public ArrayList<Point> getlocation(){
//        return location;
//    }


    /*function to determine which ship did the player hit and if the player sink the entire ship.
        if then, call each sunken functions by the location. */
    //calling it in main class
//    public void determineShip(){
//        if(shipType == "minesweeper"){
//            getlocation();
//        }
//        else if(shipType == "destroyer"){
//            getlocation();
//        }
//        else if(shipType == "battleship"){
//            getlocation();
//
//        }
//        else if(shipType == "tower"){
//            getlocation();
//            sunkenTower();
//
//        }
//        else{
//            getlocation();
//            sunkenLShip();
//        }
//
//    }

    //Function to determine did the player has sunken the Minesweeper or not, by getting the attackMap function from Gameboard class
    // pseudocode:
    // for coordinatepoints (x,y) in ship location:
    // if ALL attackmaps[x][y] == 2
    // then ship sunk, ship --

    public boolean issunkenShip(){
//        int numShips= p.getNumShips();
        for(int i=0; i<location.size(); i++){
            int x = location.get(i).getX();
            int y = location.get(i).getY();

            if(gb.attackMap[x][y] != 2){
                return false;
            }
        }
//        p.setNumShips(numShips--);
        return true;
    }

}
