package edu.colorado.applepear.classes;
import java.util.ArrayList;
import java.util.Scanner;

//Yubin was here

// --5 Types of Ships--:
// Minesweeper (2 blocks)
// Destroyer (3 blocks)
// Battleship (4 Blocks)
// Tower (1 block x 3 hits)
// L - Ship (3 blocks shaped like "L")

public class Ship {
    public ArrayList<Point> location;
    private String shipName;
    private GameBoard gb;
    private boolean isSunken;

    //Constructor

    public Ship(){
        location = new ArrayList<>();
        this.isSunken = false;
    }

    public void setIsSunken(boolean isSunken){
        this.isSunken = isSunken;
    }

    public boolean getIsSunken(){
        return isSunken;
    }

    public void setShipName() {
        Scanner myInput = new Scanner(System.in);

        if (location.size() < 1) {
            shipName = "";
            System.out.println("Enter coordinates First.");
        }
        else if (location.size() == 2){
            shipName = "minesweeper";
        }
        else if (location.size() == 3){
            if ( (location.get(0).y) == ((location.get(1).y)) && (location.get(0).y) ==  (location.get(2).y)){
                shipName = "destroyer";
            }
            else if ( (location.get(0).x) == ((location.get(1).x)) && (location.get(0).x) ==  (location.get(2).x)){
                shipName = "destroyer";
            }
            else if (location.get(0).equals(location.get(1).equals(location.get(2)))){
                shipName = "tower";
            }
            else {
                shipName = "l";
            }
        }
        else if (location.size() == 4){
            shipName = "battleship";
        }
        else {
            System.out.println("Hmm... That's a new ship. Go ahead and give it a name!");
            var newShipName = myInput.nextLine();
            shipName = newShipName;
        }
    }

    public String getShipName(){
        return shipName;
    }

    // Function 1:
    // Determines whether the player has sunken a ship or not

    public boolean isSunkenShip(){
        for(int i = 0; i < location.size(); i++ ){
            int x = location.get(i).getX();
            int y = location.get(i).getY();

            if(gb.attackMap[x][y] != 2){
                return false;
            }
        }
        return true;
    }

}
