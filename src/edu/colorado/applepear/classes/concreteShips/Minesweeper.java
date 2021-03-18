package edu.colorado.applepear.classes.concreteShips;

import edu.colorado.applepear.classes.CaptainsQuarters;
import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Minesweeper implements Ship {

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
        shipName = "minesweeper";
    }

    @Override
    public void setShipHealth() {
        health = location.size();
    }

    @Override
    public void setCaptainsQuarters() {
        ct = new CaptainsQuarters(1,location.get(0));
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
    public List<Point> input(int[][] shipMap){

        Scanner myInput = new Scanner(System.in);
        String input = "";

        System.out.println("Place Minesweeper (2 blocks wide): ");
        System.out.println("Enter \"1\" or \"2\" \n 1. Horizontal \n 2. Vertical ");
        boolean temp = true;
        while (temp) {
            input = myInput.nextLine();
            if (input.equals("1") | input.equals("2")) {
                temp = false;
            } else {
                System.out.println("Input must be \"1\" or \"2\"! ");
            }
        }
        if (input.equals("1")) {
            System.out.println("Enter the X-coordinate of the right-most block of your ship: ");
            String inputValX = myInput.nextLine();
            System.out.println("Enter the Y-coordinate of the right-most block of your ship: ");
            String inputValY = myInput.nextLine();

            Point p1 = new Point(Integer.parseInt(inputValX), Integer.parseInt(inputValY));
            Point p2 = new Point(Integer.parseInt(inputValX) + 1, Integer.parseInt(inputValY));

            return Arrays.asList(p1, p2);


        } else if (input.equals("2")) {
            System.out.println("Enter the X-coordinate of the top-most block of your ship: ");
            String inputValX = myInput.nextLine();
            System.out.println("Enter the Y-coordinate of the top-most block of your ship: ");
            String inputValY = myInput.nextLine();

            Point p1 = new Point(Integer.parseInt(inputValX), Integer.parseInt(inputValY));
            Point p2 = new Point(Integer.parseInt(inputValX),Integer.parseInt(inputValY) + 1);

            return Arrays.asList(p1, p2);
        }
        return null;

    }
}
