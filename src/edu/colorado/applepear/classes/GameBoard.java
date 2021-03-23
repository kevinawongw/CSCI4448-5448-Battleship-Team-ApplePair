package edu.colorado.applepear.classes;
import edu.colorado.applepear.classes.concreteShips.*;

import java.util.*;

// Kevina's Section
public class GameBoard {

    /**
     * Data Variables:
     * int numX = holds the width of the game board
     * int numY = holds the height of the game board
     */
    public static final int numX = 10;
    public static final int numY = 10;
    private List<Ship> ships;

    /**
     * Map Attributes:
     * Attack Map: Map reflects what coordinates have been attacked as well as the results of those attacks
     *     // 0 - unchecked
     *     // 1 - checked, no ship
     *     // 2 - checked, ship found
     * Ship Map: Reflects that player's own ships
     *     // 0 - Not Present
     *     // 1 - Present
     * Underwater Map: Reflects that player's own submarines
     *     // 0 - Not Present
     *     // 1 - Present
     */

    private final int[][] attackMap;
    private final int[][] shipMap;
    private final int[][] underwaterMap;
    private final int[][] underwaterAttackMap;


    /**
     * Constructor
     */
    public GameBoard() {
        shipMap = new int[numY][numX];
        attackMap = new int[numY][numX];
        underwaterMap = new int[numY][numX];
        underwaterAttackMap = new int[numY][numX];
        ships = new ArrayList<>();
    }

    /**
     * Getters
     */
    public int[][] getShipMap() { return shipMap; }
    public int[][] getAttackMap() { return attackMap; }
    public int[][] getUnderwaterMap() { return underwaterMap; }
    public int[][] getUnderwaterAttackMap () {return  underwaterAttackMap; }
    public List<Ship> getShips() { return ships; }

    /**
     * Setter - shipMap, attackMap, underwaterMap
     * @param point - Coordinate in which the new value is placed
     * @param newValue - New Value
     */
    public void setShipMap(Point point, int newValue){ shipMap[point.getY()][point.getX()] = newValue; }
    public void setAttackMap(Point point, int newValue){ attackMap[point.getY()][point.getX()] = newValue; }
    public void setUnderwaterMap(Point point, int newValue){ underwaterMap[point.getY()][point.getX()] = newValue; }
    public void setUnderwaterAttackMap(Point point, int newValue) { underwaterAttackMap[point.getY()][point.getX()] = newValue; }

    /**
     * View Underwater Attack Map
     * Prints Map with 0s, Ms, and Hs - representing "Miss" and "Hit"
     */
    public void viewUnderwaterAttackMap(){
        System.out.print("----- Underwater Attack Map -----\n\n");

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
                if (underwaterAttackMap[i][j] == 1) {
                    System.out.print("M" + " | ");
                } else if (underwaterAttackMap[i][j] == 2) {
                    System.out.print("H" + " | ");
                } else if (underwaterAttackMap[i][j] == 3) {
                    System.out.print("*" + " | ");
                } else if (underwaterAttackMap[i][j] == 4) {
                    System.out.print(" " + " | ");
                } else {
                    System.out.print(underwaterAttackMap[i][j] + " | ");
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

    /**
     * View Attack Map
     * Prints Map with 0s, Ms, and Hs - representing "Miss" and "Hit"
     */
    public void viewAttackMap() {
        System.out.print("----- Attack Map -----\n\n");

        for (int i = 0; i < numX; i++) {

            System.out.print("  ");

            for (int a = 0; a < 10; a++) {
                if (i == 0) { System.out.print("+—" + a + "—"); }
                else { System.out.print("+———"); }
            }

            System.out.print("+");
            System.out.print("\n");
            System.out.print(i + " | ");

            for (int j = 0; j < numY; j++) {
                if (attackMap[i][j] == 1) { System.out.print("M" + " | "); }
                else if (attackMap[i][j] == 2) { System.out.print("H" + " | "); }
                else if (attackMap[i][j] == 3) { System.out.print("*" + " | "); }
                else if (attackMap[i][j] == 4) { System.out.print(" " + " | "); }
                else { System.out.print(attackMap[i][j] + " | "); }
            }
            System.out.print("\n");
        }
        System.out.print("  ");
        for (int a = 0; a < 10; a++) { System.out.print("+———"); }
        System.out.print("+\n\n");
    }

    /**
     * View Ship Map
     * Prints Map with 0s, 1s
     * Prints where that player's ships are located
     */
    public void viewShips() {
        System.out.print("----- My Ship Map -----\n\n");

        for (int i = 0; i < numX; i++) {
            System.out.print("  ");

            for (int a = 0; a < 10; a++) {
                if (i == 0) { System.out.print("+—" + a + "—"); }
                else { System.out.print("+———"); }
            }

            System.out.print("+");
            System.out.print("\n");
            System.out.print(i + " | ");

            for (int j = 0; j < numY; j++) { System.out.print(shipMap[i][j] + " | "); }
            System.out.print("\n");
        }

        System.out.print("  ");
        for (int a = 0; a < 10; a++) { System.out.print("+———"); }
        System.out.print("+\n\n");
    }

    /**
     * View Underwater Map
     * Prints Map with 0s, 1s
     * Prints where that player's ships are located
     */

    public void viewUnderwater() {

        System.out.print("----- My Underwater Map -----\n\n");

        for (int i = 0; i < numX; i++) {
            System.out.print("  ");

            for (int a = 0; a < 10; a++) {
                if (i == 0) { System.out.print("+—" + a + "—"); }
                else { System.out.print("+———"); }
            }
            System.out.print("+");
            System.out.print("\n");
            System.out.print(i + " | ");

            for (int j = 0; j < numY; j++) { System.out.print(underwaterMap[i][j] + " | "); }
            System.out.print("\n");
        }

        System.out.print("  ");
        for (int a = 0; a < 10; a++) { System.out.print("+———"); }
        System.out.print("+\n\n");
    }


    /**
     * Update Ship Map
     * Updates the Ship Map when a ship is placed.
     */
    public void updateShipMap() {

        for (Ship ship : ships) {
            if (!ship.getUnderwater()) {
                for (Point point : ship.getLocation()) {
                    setShipMap(point, 1);
                }
            }
        }
    }

    /**
     * Update Underwater Map
     * Updates the Underwater Map when a submarine is placed.
     */
    public void updateUnderwaterMap() {
        for (Ship ship : ships) {
            if (ship.getUnderwater()) {
                for (Point point : ship.getLocation()) {
                    setUnderwaterMap(point, 1);
                }
            }
        }
    }

    /**
     * Populate Ship Map
     * Adds new ships to the map.
     */
    public void populateShipMap() {
        Minesweeper minesweeper = new Minesweeper();
        List<Point> minesweeperCoords = minesweeper.input(shipMap);
        placeShip(minesweeperCoords);
        updateShipMap();
        viewShips();

//        Submarine submarine = new Submarine();
//        List<Point> submarineCoords = submarine.input(shipMap);
//        placeShip(submarineCoords);
//        updateUnderwaterMap();
//        viewUnderwater();

    }

    /**
     * Place Ship
     * @param loc
     *      // Determine what type of ship it is
     *      // Instantiate concrete instance of the ship object
     *      // Add to the appropriate map (Ship or Underwater)
     */
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

    /**
     * Update Attack Map
     * @param oppMap - Opponent's Ship Map
     * @param p1 - Point Attacked
     *      // Checks if the attacked location hit a ship or not
     *      // Update map to a 2 if it attacked a ship
     *      // Update map to 1 otherwise
     */
    public boolean updateAttackMap(GameBoard oppMap, Point p1) {
        if (oppMap.getShipMap()[p1.getY()][p1.getX()] == 1) {
            setAttackMap(p1,2);
            return true;
        } else if (oppMap.getShipMap()[p1.getY()][p1.getX()] == 0) {
            setAttackMap(p1,1);
            return false;
        }
        return false;
    }

    /**
     * Update Underwater Attack Map
     * @param oppMap - Opponent's Underwater Ship Map
     * @param p1 - Point Attacked
     *      // Checks if the attacked location hit a ship or not
     *      // Update map to a 2 if it attacked a ship
     *      // Update map to 1 otherwise
     */
    public void updateUnderwaterAttackMap(GameBoard oppMap, Point p1) {
        if (oppMap.getUnderwaterMap()[p1.getY()][p1.getX()] == 1) {
            setAttackMap(p1,2);
        } else if (oppMap.getUnderwaterMap()[p1.getY()][p1.getX()] == 0) {
            setAttackMap(p1,1);
        }
    }

    /**
     * Identify Ship
     * @param point - Identify ship occupying this point
     * @return index
     *      // Iterate through each ship's location points until point is found
     *      // Return index of that ship
     */
    public Integer identifyShip(Point point){
        int index = 0;
        boolean found = false;
        for (Ship ship: ships){
            for (Point p : ship.getLocation()){
                if (p.getX() == point.getX() && p.getY() == point.getY() && !ship.getUnderwater()){
                    found = true;
                    return index;
                }
            }
            index++;
        }
        if (!found){
            index = -1;
        }
        return index;
    }

    /**
     * Update Sunken Ship
     * @param shipAttackedIndex
     *      // Removes ship from ships array when a ship is sunken.
     */
    public void updateSunkenShip(int shipAttackedIndex) {
        ships.remove(shipAttackedIndex);
    }

    /**
     * Get Possible Move Locations
     * @param ship - Ship that wants to move
     * @return String of Possible Directions
     *      // Check all points that a ship covers
     *      // Add possible move options
     */
    public List<String> getPossibleMoveLocations(Ship ship){

        List<String> possibleMoves = new ArrayList<String>();

        boolean North = true;
        boolean South = true;
        boolean West = true;
        boolean East = true;

        for (Point p : ship.getLocation()){
            if (p.getY() == 0){
                North = false;
            }
            if (p.getX() == numX - 1){
                East = false;
            }
            if (p.getX() == 0){
                West = false;
            }
            if (p.getY() == numY - 1){
                South = false;
            }
        }

        if (North) { possibleMoves.add("North"); }
        if (South) { possibleMoves.add("South"); }
        if (East) { possibleMoves.add("East"); }
        if (West) { possibleMoves.add("West"); }

        return possibleMoves;
    }

    /**
     * Move Ship
     * @param ship - Ship that is being Moved
     * @param direction - Direction that it will be moved
     */
//    public void moveShip(Ship ship, String direction){
//        List <String> valid = getPossibleMoveLocations(ship);
//        List <Point> newLocations = new ArrayList<Point>();
//        if (valid.contains(direction)){
//
//            if (!ship.getUnderwater()) {
//
//                if (direction.equals("North")) {
//                    for (Point p : ship.getLocation()) {
//                        newLocations.add(new Point(p.getX(), p.getY() - 1));
//                        setShipMap(p, 0);
//                    }
//                } else if (direction.equals("South")) {
//                    for (Point p : ship.getLocation()) {
//                        newLocations.add(new Point(p.getX(), p.getY() + 1));
//                        setShipMap(p, 0);
//
//                    }
//                } else if (direction.equals("East")) {
//                    for (Point p : ship.getLocation()) {
//                        newLocations.add(new Point(p.getX() + 1, p.getY()));
//                        setShipMap(p, 0);
//
//                    }
//                } else if (direction.equals("West")) {
//                    for (Point p : ship.getLocation()) {
//                        newLocations.add(new Point(p.getX() - 1, p.getY()));
//                        setShipMap(p, 0);
//
//                    }
//                }
//
//                ship.setLocation(newLocations);
//                updateShipMap();
//                viewShips();
//
//            }
//
//            else if (ship.getUnderwater()){
//                if (direction.equals("North")){
//                    for (Point p : ship.getLocation()){
//                        newLocations.add(new Point(p.getX(), p.getY()-1));
//                        setUnderwaterMap(p,0);
//                    }
//                }
//                else if (direction.equals("South")){
//                    for (Point p : ship.getLocation()){
//                        newLocations.add(new Point(p.getX(), p.getY() + 1));
//                        setUnderwaterMap(p,0);
//
//                    }
//                }
//                else if (direction.equals("East")){
//                    for (Point p : ship.getLocation()){
//                        newLocations.add(new Point(p.getX() + 1, p.getY()));
//                        setUnderwaterMap(p,0);
//
//                    }
//                }
//                else if (direction.equals("West")){
//                    for (Point p : ship.getLocation()){
//                        newLocations.add(new Point(p.getX() - 1, p.getY()));
//                        setUnderwaterMap(p,0);
//                    }
//                }
//                ship.setLocation(newLocations);
//                updateUnderwaterMap();
//                viewUnderwater();
//            }
//        }
//    }
}


