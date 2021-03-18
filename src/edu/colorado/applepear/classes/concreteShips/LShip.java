package edu.colorado.applepear.classes.concreteShips;

import edu.colorado.applepear.classes.CaptainsQuarters;
import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LShip implements Ship {

    public ArrayList<Point> location;
    private String shipName;
    private boolean isSunken;
    private int health;
    private CaptainsQuarters ct;

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
    public void setShipName() {
        shipName = "battleship";
    }

    @Override
    public void setShipHealth() {
        health = location.size();
    }

    @Override
    public void setCaptainsQuarters() {
        System.out.println("This type of ship cannot have a captain's quarters!");
        ct = null;
    }

    @Override
    public void setLocation(List<Point> points) {
        for (Point point : points) {
            location.add(point);
            int myX = point.getX();
            int myY = point.getY();
        }
    }

    @Override
    public Boolean isShipSunken() {
        if (location.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void updateHealth(Point p){
        // remove location attacked
        location.remove(p);
        // set new health to location length
        health = location.size();
    }


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
