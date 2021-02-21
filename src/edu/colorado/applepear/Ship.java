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
    public ArrayList<Point> Mlocation; //minesweeper
    public ArrayList<Point> Dlocation; //Destroyer
    public ArrayList<Point> Blocation; //Battleship
    public ArrayList<Point> Tlocation; //Tower
    public ArrayList<Point> Llocation; //L-ship
    Player p;


    //Constructor
    public Ship(){
        Mlocation = new ArrayList<Point>();
        Dlocation = new ArrayList<Point>();
        Blocation = new ArrayList<Point>();
        Tlocation = new ArrayList<Point>();
        Llocation = new ArrayList<Point>();
    }

    /*function to determine which ship did the player hit and if the player sink the entire ship.
        if then, call each sunken functions by the location. */
    //calling it in main class
    public void determineShip(GameBoard attackMap, int posX, int posY){
        Point myPoint = new Point(posX, posY);

        if(Mlocation.contains(myPoint)){
            System.out.println("You have hit the minesweeper!");
            sunkenMinesweeper(attackMap);
        }
        else if(Dlocation.contains(myPoint)){
            System.out.println(Dlocation.contains(myPoint)+ " print!");
            System.out.println("You have hit the destroyer!");
            sunkenDestroyer(attackMap);
        }
        else if (Blocation.contains(myPoint)){
            System.out.println(Blocation.contains(myPoint)+ " print!");
            System.out.println("You have hit the battleship!");
            sunkenBattleship(attackMap);

        }
        else if (Tlocation.contains(myPoint)){
            System.out.println(Tlocation.contains(myPoint)+ " print!");
            System.out.println("You have hit the Tower!");
            sunkenTower(attackMap);

        }
        else{
//            System.out.println(Llocation.contains(myPoint.x)+ " print!");
//            System.out.println(Llocation.contains(myPoint.y)+ " print!");
            System.out.println("You have hit the L-ship!");
            sunkenLShip(attackMap);

        }

    }

    //Function to determine did the player have sunken the Minesweeper or not by getting the attackMap function from Gameboard class
    public void sunkenMinesweeper(GameBoard attackMap){
        int numShip = p.getNumShips();
        for(int i=0; i<Mlocation.size(); i++){
            int currX = Mlocation.get(i).x;
            int currY = Mlocation.get(i).y;
            /* From Gameboard class,
               attackMap = 0: unchecked
                         = 1: checked, but not found ship
                         = 2: checked and found ship
            */
            if(attackMap.attackMap[currX][currY] == 1 || attackMap.attackMap[currX][currY] == 0){ // check if attackMap is 1 or 0
                System.out.println("You have not sunken the Minesweeper.");
                p.decreaseNumShip(numShip);
                return;
            }
        }
        System.out.println("You have sunken the Destroyer!");

    }

    //Function to determine did the player have sunken the Destroyer or not by getting the attackMap function from Gameboard class
    public void sunkenDestroyer(GameBoard attackMap){
        int numShip = p.getNumShips();
        for(int i=0; i<Dlocation.size(); i++){
            int currX = Dlocation.get(i).x;
            int currY = Dlocation.get(i).y;

            /* From Gameboard class,
               attackMap = 0: unchecked
                         = 1: checked, but not found ship
                         = 2: checked and found ship
            */
            if(attackMap.attackMap[currX][currY] == 1 || attackMap.attackMap[currX][currY] == 0){ // check if attackMap is 1 or 0
                System.out.println("You have not sunken the Destroyer.");
                p.decreaseNumShip(numShip);
                return;
            }

        }
        System.out.println("You have sunken the Destroyer!");
    }

    //Function to determine did the player have sunken the Battleship or not by getting the attackMap function from Gameboard class
    public void sunkenBattleship(GameBoard attackMap){
        int numShip = p.getNumShips();
        for(int i=0; i<Blocation.size(); i++){
            int currX = Blocation.get(i).x;
            int currY = Blocation.get(i).y;
            /* From Gameboard class,
               attackMap = 0: unchecked
                         = 1: checked, but not found ship
                         = 2: checked and found ship
            */
            if(attackMap.attackMap[currX][currY] == 1 || attackMap.attackMap[currX][currY] == 0){// check if attackMap is 1 or 0
                System.out.println("You have not sunken the Battleship.");
                p.decreaseNumShip(numShip);
                return;
            }

        }
        System.out.println("You have sunken the Battleship!");

    }

    //Function to determine did the player have sunken the Tower or not by getting the attackMap function from Gameboard class
    public void sunkenTower(GameBoard attackMap){
        int numShip = p.getNumShips();
        for(int i=0; i<Tlocation.size(); i++){
            int currX = Tlocation.get(i).x;
            int currY = Tlocation.get(i).y;
            /* From Gameboard class,
               attackMap = 0: unchecked
                         = 1: checked, but not found ship
                         = 2: checked and found ship
            */
            if(attackMap.attackMap[currX][currY] == 1 || attackMap.attackMap[currX][currY] == 0){ // check if attackMap is 1 or 0
                System.out.println("You have not sunken the Tower.");
                p.decreaseNumShip(numShip);
                return;
            }

        }
        System.out.println("You have sunken the Tower!");
    }

    //Function to determine did the player have sunken the L-ship or not by getting the attackMap function from Gameboard class
    public void sunkenLShip(GameBoard attackMap){
        int numShip = p.getNumShips();
        for(int i=0; i<Blocation.size(); i++){
            int currX = Blocation.get(i).x;
            int currY = Blocation.get(i).y;
            /* From Gameboard class,
               attackMap = 0: unchecked
                         = 1: checked, but not found ship
                         = 2: checked and found ship
            */
            if(attackMap.attackMap[currX][currY] == 1 || attackMap.attackMap[currX][currY] == 0){ // check if attackMap is 1 or 0
                System.out.println("You have not sunken the L-ship.");
                p.decreaseNumShip(numShip);
                return;
            }

        }
        System.out.println("You have sunken the L-ship!");
    }



}
