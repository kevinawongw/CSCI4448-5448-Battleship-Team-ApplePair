package edu.colorado.applepear.classes.concreteShips;

import edu.colorado.applepear.classes.CaptainsQuarters;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Destroyer implements Ship {

    /**
     * Class Attributes
     */
    public ArrayList<Point> location;
    private String shipName;
    private int health;
    private CaptainsQuarters ct;

    /**
     * Constructor
     */
    public Destroyer(){
        location = new ArrayList<>();
        shipName = "destroyer";
        health = 3;
        boolean isSunken = false;
        boolean underwater = false;
    }

    /**
     * Getters
     * @return attributes
     */
    @Override
    public String getShipName() { return shipName; }
    @Override
    public int getShipHealth() { return health; }
    @Override
    public List<Point> getLocation() { return location; }
    @Override
    public boolean getUnderwater() { return false; }
    @Override
    public CaptainsQuarters getCaptainsQuarters() { return ct; }

    /**
     * Setters
     */
    @Override
    public void setShipName() { shipName = "destroyer"; }
    @Override
    public void setShipHealth(int newHealth) { this.health = newHealth; }
    @Override
    public void setCaptainsQuarters() { ct = new CaptainsQuarters(2,location.get(1));}
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
     *      // Prompt user to enter left-most or top-most coordinates of the new destroyer.
     */
    @Override
    public List<Point> input(int[][] shipMap) {
        Scanner myInput = new Scanner(System.in);
        String input2 = "";
        System.out.println("Enter \"1\" or \"2\" \n 1. Horizontal \n 2. Vertical ");
        System.out.println("Place Destroyer (3 blocks wide): ");
        boolean temp = true;
        while (temp) {
            input2 = myInput.nextLine();
            if (input2.equals("1") | input2.equals("2")) {
                temp = false;
            } else {
                System.out.println("Input must be \"1\" or \"2\"! ");
            }
        }
        if (input2.equals("1")) {
            temp = true;
            while (temp) {
                System.out.println("Enter the X-coordinate of the right-most block of your ship: ");
                String inputValX = myInput.nextLine();
                System.out.println("Enter the Y-coordinate of the right-most block of your ship: ");
                String inputValY = myInput.nextLine();
                boolean criteriaA = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] == 0);
                boolean criteriaB = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 1] == 0);
                boolean criteriaC = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 2] == 0);

                if (criteriaA && criteriaB && criteriaC) {
                    Point p1 = new Point(Integer.parseInt(inputValX), Integer.parseInt(inputValY));
                    Point p2 = new Point(Integer.parseInt(inputValX) + 1, Integer.parseInt(inputValY));
                    Point p3 = new Point(Integer.parseInt(inputValX) + 2, Integer.parseInt(inputValY));
                    temp = false;
                    return Arrays.asList(p1, p2, p3);
                }
                else {
                    System.out.println("You already placed another ship there! Try another location.");
                    temp = true;
                }
            }

        }
        else if (input2.equals("2")) {
            temp = true;
            while (temp) {
                System.out.println("Enter the X-coordinate of the top-most block of your ship: ");
                String inputValX = myInput.nextLine();
                System.out.println("Enter the Y-coordinate of the top-most block of your ship: ");
                String inputValY = myInput.nextLine();
                boolean criteriaA = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] == 0);
                boolean criteriaB = (shipMap[Integer.parseInt(inputValY) + 1][Integer.parseInt(inputValX)] == 0);
                boolean criteriaC = (shipMap[Integer.parseInt(inputValY) + 2][Integer.parseInt(inputValX)] == 0);

                if (criteriaA && criteriaB && criteriaC) {
                    Point p1 = new Point (Integer.parseInt(inputValX), Integer.parseInt(inputValY));
                    Point p2 = new Point (Integer.parseInt(inputValX), Integer.parseInt(inputValY) + 1);
                    Point p3 = new Point (Integer.parseInt(inputValX), Integer.parseInt(inputValY) + 2);
                    temp = false;
                    return Arrays.asList(p1, p2, p3);
                }
                else {
                    System.out.println("You already placed another ship there! Try another location.");
                    temp = true;
                }
            }
        }
        return null;

    }
}
