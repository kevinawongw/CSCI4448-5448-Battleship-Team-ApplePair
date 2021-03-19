package edu.colorado.applepear.classes;
import edu.colorado.applepear.classes.concreteShips.*;

import java.util.*;

// Kevina did this section


public class GameBoard {

    // Helpful Variables
    public static final int numX = 10;
    public static final int numY = 10;
    private List<Ship> ships;

    // Initializing Maps:

    // Attack Map: Map reflects what coordinates have been attacked as well as the results of those attacks
    // Note from Kevina: For now, I'm going to make the map 0,1,2 for y/n ship. We can change to string if easier :)
    // 0 - unchecked
    // 1 - checked, no ship
    // 2 - checked, ship found
    private int[][] attackMap;


    // Ship Map: Reflects that player's own ships
    // 0 - Not Present
    // 1 - Present
    private int[][] shipMap;

    // Underwater Map: Reflects that player's own submarines
    // 0 - Not Present
    // 1 - Present
    private int[][] underwaterMap;

    // Constructor
    public GameBoard() {
        shipMap = new int[numY][numX];
        attackMap = new int[numY][numX];
        underwaterMap = new int[numY][numX];
        ships = new ArrayList<Ship>();
    }

    // Getters
    public int[][] getShipMap() {
        return shipMap;
    }

    public int[][] getAttackMap() {
        return attackMap;
    }

    public int[][] getUnderwaterMap() { return underwaterMap; }

    public List<Ship> getShips() {
        return ships;
    }

    // Setters
    public void setShipMap(Point p, int value){
        shipMap[p.getY()][p.getX()] = value;
    }

    public void setAttackMap(Point p, int value){
        attackMap[p.getY()][p.getX()] = value;
    }

    public void setUnderwaterMap(Point p, int value){
        underwaterMap[p.getY()][p.getX()] = value;
    }

    // Function 2: View Map
    // Param: None
    // Returns: None
    // Prints Map with 0s, Ms, and Hs - representing "Miss" and "Hit"
    public void viewMap() {
        System.out.print("----- Attack Map -----\n\n");

        for (int i = 0; i < numX; i++) {
            System.out.print("  ");

            for (int a = 0; a < 10; a++) {
                if (i == 0) {
                    System.out.print("+—" + a + "—");
                } else {
                    System.out.print("+———");
                }
            }
            System.out.print("+");
            System.out.print("\n");
            System.out.print(i + " | ");

            for (int j = 0; j < numY; j++) {
                if (attackMap[i][j] == 1) {
                    System.out.print("M" + " | ");

                } else if (attackMap[i][j] == 2) {
                    System.out.print("H" + " | ");

                } else if (attackMap[i][j] == 3) {
                    System.out.print("*" + " | ");

                } else if (attackMap[i][j] == 4) {
                    System.out.print(" " + " | ");

                } else {
                    System.out.print(attackMap[i][j] + " | ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("  ");
        for (int a = 0; a < 10; a++) {
            System.out.print("+———");
        }
        System.out.print("+\n\n");
    }


    // Function 3: View Ship Map
    // Param: None
    // Returns: None
    // Prints Map with 0s, 1s
    // Prints where that player's ships are located
    public void viewShips() {
        System.out.print("----- My Ship Map -----\n\n");

        for (int i = 0; i < numX; i++) {
            System.out.print("  ");

            for (int a = 0; a < 10; a++) {
                if (i == 0) {
                    System.out.print("+—" + a + "—");
                } else {
                    System.out.print("+———");
                }
            }
            System.out.print("+");
            System.out.print("\n");
            System.out.print(i + " | ");

            for (int j = 0; j < numY; j++) {
                System.out.print(shipMap[i][j] + " | ");
            }
            System.out.print("\n");
        }
        System.out.print("  ");
        for (int a = 0; a < 10; a++) {
            System.out.print("+———");
        }
        System.out.print("+\n\n");
    }

    // Function 3: View Ship Map
    // Param: None
    // Returns: None
    // Prints Map with 0s, 1s
    // Prints where that player's ships are located
    public void viewUnderwater() {
        System.out.print("----- My Underwater Map -----\n\n");

        for (int i = 0; i < numX; i++) {
            System.out.print("  ");

            for (int a = 0; a < 10; a++) {
                if (i == 0) {
                    System.out.print("+—" + a + "—");
                } else {
                    System.out.print("+———");
                }
            }
            System.out.print("+");
            System.out.print("\n");
            System.out.print(i + " | ");

            for (int j = 0; j < numY; j++) {
                System.out.print(underwaterMap[i][j] + " | ");
            }
            System.out.print("\n");
        }
        System.out.print("  ");
        for (int a = 0; a < 10; a++) {
            System.out.print("+———");
        }
        System.out.print("+\n\n");
    }

    public void updateShipMap() {
        for (Ship ship : ships) {
            if (ship.getUnderwater() == false) {
                for (Point point : ship.getLocation()) {
                    setShipMap(point, 1);
                }
            }
        }
    }

    public void updateUnderwaterMap() {
        for (Ship ship : ships) {
            if (ship.getUnderwater() == true) {
                for (Point point : ship.getLocation()) {
                    setUnderwaterMap(point, 1);
                }
            }
        }
    }

    public void populateShipMap() {
        Minesweeper minesweeper = new Minesweeper();
        List<Point> minesweeperCoords = minesweeper.input(shipMap);
        placeShip(minesweeperCoords);
        updateShipMap();
        viewShips();

        // Currently Minesweeper only - Kevina
    }

    public void placeShip(List<Point> loc){
        if (loc.size() == 2){
            Minesweeper minesweeper = new Minesweeper();
            minesweeper.setLocation(loc);
            minesweeper.setShipHealth(loc.size());
            ships.add(minesweeper);
        }
        else if (loc.size() == 3){
            Point p1 = loc.get(0);
            Point p2 = loc.get(1);
            Point p3 = loc.get(2);

            if (p1.equals(p2) && p1.equals(p3)){
                Tower tower = new Tower();
                tower.setLocation(loc);
                ships.add(tower);
            }
            else if((p1.getX() == p2.getX() && p1.getX() == p3.getX()) || (p1.getY() == p2.getY() && p1.getY() == p3.getY())){
                Destroyer destroyer = new Destroyer();
                destroyer.setLocation(loc);
                ships.add(destroyer);
            }
            else {
                LShip ls = new LShip();
                ls.setLocation(loc);
                ships.add(ls);
            }
        }
        else if (loc.size() == 4){
            Battleship battleship = new Battleship();
            battleship.setLocation(loc);
            ships.add(battleship);
        }
        else if (loc.size() == 5){
            Submarine sub = new Submarine();
            sub.setLocation(loc);
            ships.add(sub);
        }
        updateShipMap();
        updateUnderwaterMap();
    }


    public boolean updateAttackMap(GameBoard oppMap, Point p1) {
        if (oppMap.getShipMap()[p1.getY()][p1.getX()] == 1) {
            setAttackMap(p1,2);
            return true;
        } else if (oppMap.getShipMap()[p1.getY()][p1.getX()] == 0) {
            setAttackMap(p1,1);
            return false;
        } else {
            return false;
        }
    }

    public Ship identifyShip(Point point){
        for (Ship ship: ships){
            for (Point p : ship.getLocation()){
                if (p.equals(point)){
                    return ship;
                }
            }
        }
        return null;
    }

}


