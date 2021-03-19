package edu.colorado.applepear.classes.concreteShips;

import edu.colorado.applepear.classes.CaptainsQuarters;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Submarine implements Ship {

    public ArrayList<Point> location;
    private String shipName;
    private boolean isSunken;
    private int health;
    private CaptainsQuarters ct;
    private boolean underwater;

    public Submarine(){
        location = new ArrayList<Point>();
        shipName = "submarine";
        health = 5;
        isSunken = false;
        underwater = true;
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
    public boolean getUnderwater() { return underwater; }

    @Override
    public CaptainsQuarters getCaptainsQuarters() {
        return null;
    }

    @Override
    public void setShipName() {
        shipName = "submarine";
    }

    @Override
    public void setShipHealth(int newHealth) {
        this.health = newHealth;
    }

    @Override
    public void setCaptainsQuarters() {
        ct = new CaptainsQuarters(2,location.get(4));
    }

    @Override
    public void setLocation(List<Point> points) {
        location = new ArrayList<Point>();
        for (Point point : points) {
            location.add(point);
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

        int index = location.indexOf(p);
        Point t = location.remove(index);

        setLocation(location);
        setShipHealth(location.size());
    }

    @Override
    public List<Point> input(int[][] underwaterMap) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Place Submarine: ");


        boolean temp = true;
        while (temp) {
            System.out.println("Enter the X-coordinate of the left-most block of your ship: ");
            String inputValX = myInput.nextLine();
            System.out.println("Enter the Y-coordinate of the left-most block of your ship: ");
            String inputValY = myInput.nextLine();
            boolean criteriaA = (underwaterMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] == 0);
            boolean criteriaB = (underwaterMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 1] == 0);
            boolean criteriaC = (underwaterMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 2] == 0);
            boolean criteriaD = (underwaterMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 3] == 0);
            boolean criteriaE = (underwaterMap[Integer.parseInt(inputValY)-1][Integer.parseInt(inputValX) + 2] == 0);

            if (criteriaA && criteriaB && criteriaC && criteriaD && criteriaE) {
                int x1 = Integer.parseInt(inputValX);
                int y1 = Integer.parseInt(inputValY);
                Point p1 = new Point(x1, y1);
                int x2 = Integer.parseInt(inputValX) + 1;
                int y2 = Integer.parseInt(inputValY);
                Point p2 = new Point(x2, y2);
                int x3 = Integer.parseInt(inputValX) + 2;
                int y3 = Integer.parseInt(inputValY);
                Point p3 = new Point(x3, y3);
                int x4 = Integer.parseInt(inputValX) + 3;
                int y4 = Integer.parseInt(inputValY);
                Point p4 = new Point(x4, y4);
                int x5 = Integer.parseInt(inputValX) + 2;
                int y5 = Integer.parseInt(inputValY) + 1;
                Point p5 = new Point(x5, y5);
                temp = false;
                return Arrays.asList(p1, p2, p3, p4, p5);

            }
            else {
                System.out.println("You already placed another ship there! Try another location.");
            }
        }
        return null;
    }
}
