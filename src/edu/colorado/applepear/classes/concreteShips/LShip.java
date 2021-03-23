package edu.colorado.applepear.classes.concreteShips;

import edu.colorado.applepear.classes.CaptainsQuarters;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LShip implements Ship {

    /**
     * Class Attributes
     */
    public ArrayList<Point> location;
    private String shipName;
    private int health;

    /**
     * Constructor
     */
    public LShip(){
        location = new ArrayList<>();
        shipName = "lship";
        health = 3;
        boolean isSunken = false;
        boolean underwater = false;
    }

    /**
     * Getters
     * @return attributes
     */
    @Override
    public String getShipName() {
        return shipName;
    }
    @Override
    public int getShipHealth() {
        return health;
    }
    @Override
    public List<Point> getLocation() {
        return location;
    }
    @Override
    public boolean getUnderwater() {
        return false;
    }
    @Override
    public CaptainsQuarters getCaptainsQuarters() {
        return null;
    }

    /**
     * Setters
     */
    @Override
    public void setShipName() {
        shipName = "lship";
    }
    @Override
    public void setShipHealth(int newHealth) {
        this.health = newHealth;
    }
    @Override
    public void setCaptainsQuarters() {
        System.out.println("This type of ship cannot have a captain's quarters!");
    }
    @Override
    public void setLocation(List<Point> points) {
        location = new ArrayList<>();
        location.addAll(points);
    }

    /**
     * is Ship Sunken
     * @return boolean
     *      // Checks length of ship's location
     *      // If 0, True
     *      // Else, False
     */
    @Override
    public Boolean isShipSunken() {
        return location.size() == 0;
    }

    /**
     * Update Health
     * @param p - Point that was attacked
     *      // Find Point in ship's location list
     *      // Remove that Point from the location list
     *      // Update Health
     */
    @Override
    public void updateHealth(Point p){

        int index = 0;
        for (Point point : location){
            if (p.getX() == point.getX() && p.getY() == point.getY()){
                break;
            }
            index++;
        }

        location.remove(index);

        setLocation(location);
        setShipHealth(location.size());
    }


    /**
     * Input
     * @param shipMap - Opponent's Ship Map
     * @return list of points for the new ship
     *      // Prompt user to enter left-most or top-most coordinates of the new l-ship.
     */
    @Override
    public List<Point> input(int[][] shipMap) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Place L-Ship (3 blocks is L shape): ");
        boolean temp = true;
        while (temp) {
            System.out.println("Enter the X-coordinate of the top left-most block of your ship: ");
            String inputValX = myInput.nextLine();
            System.out.println("Enter the Y-coordinate of the top left-most block of your ship: ");
            String inputValY = myInput.nextLine();
            boolean criteriaA = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] == 0);
            boolean criteriaB = (shipMap[Integer.parseInt(inputValY) + 1][Integer.parseInt(inputValX)] == 0);
            boolean criteriaC = (shipMap[Integer.parseInt(inputValY) + 1][Integer.parseInt(inputValX) + 1] == 0);

            if (criteriaA && criteriaB && criteriaC) {
                int x1 = Integer.parseInt(inputValX);
                int y1 = Integer.parseInt(inputValY);
                Point p1 = new Point(x1, y1);
                int x2 = Integer.parseInt(inputValX);
                int y2 = Integer.parseInt(inputValY) + 1;
                Point p2 = new Point(x2, y2);
                int x3 =Integer.parseInt(inputValX) + 1;
                int y3 = Integer.parseInt(inputValY) + 1;
                Point p3 = new Point(x3, y3);
                temp = false;
                return Arrays.asList(p1, p2, p3);
            }
            else {
                System.out.println("You already placed another ship there! Try another location.");
            }
        }
        return null;
    }
}
