package edu.colorado.applepear.classes.concreteShips;

import edu.colorado.applepear.classes.CaptainsQuarters;
import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Tower implements Ship {

    public ArrayList<Point> location;
    private String shipName;
    private boolean isSunken;
    private int health;
    private CaptainsQuarters ct;

    public Tower(){
        location = new ArrayList<Point>();
        shipName = "tower";
        health = 3;
        ct = null;
        isSunken = false;
    }

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
        shipName = "tower";
    }

    @Override
    public void setShipHealth(int newHealth) {
        this.health = newHealth;
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
        location.remove(location.size()-1);
        // set new health to location length
        health = location.size();
    }

    @Override
    public List<Point> input(int[][] shipMap) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Place Tower (1): ");
        boolean temp = true;
        while (temp) {
            System.out.println("Enter the X-coordinate of the ship: ");
            String inputValX = myInput.nextLine();
            System.out.println("Enter the Y-coordinate of the ship: ");
            String inputValY = myInput.nextLine();
            boolean criteriaA = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] == 0);

            if (criteriaA) {
                int x1 = Integer.parseInt(inputValX);
                int y1 = Integer.parseInt(inputValY);
                Point p1 = new Point(x1, y1);
                temp = false;
                return Arrays.asList(p1);

            }

            else {
                System.out.println("You already placed another ship there! Try another location.");
            }
        }
        return null;
    }
}
