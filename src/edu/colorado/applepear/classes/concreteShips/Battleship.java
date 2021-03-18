package edu.colorado.applepear.classes.concreteShips;

import edu.colorado.applepear.classes.CaptainsQuarters;
import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Battleship implements Ship {

    public ArrayList<Point> location;
    private String shipName;
    private boolean isSunken;
    private int health;
    private CaptainsQuarters ct;

    public Battleship(){
        location = new ArrayList<Point>();
        shipName = "battleship";
        health = 4;
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
        shipName = "battleship";
    }

    @Override
    public void setShipHealth(int newHealth) {
        this.health = newHealth;
    }

    @Override
    public void setCaptainsQuarters() {
        ct = new CaptainsQuarters(2,location.get(2));
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
        String input3 = "";
        System.out.println("Place Battleship (3 blocks wide): ");
        System.out.println("Enter \"1\" or \"2\" \n 1. Horizontal \n 2. Vertical ");

        boolean temp = true;
        while (temp) {
            input3 = myInput.nextLine();
            if (input3.equals("1") | input3.equals("2")) {
                temp = false;
            } else {
                System.out.println("Input must be \"1\" or \"2\"! ");
            }
        }
        if (input3.equals("1")) {
            temp = true;
            while (temp) {
                System.out.println("Enter the X-coordinate of the right-most block of your ship: ");
                String inputValX = myInput.nextLine();
                System.out.println("Enter the Y-coordinate of the right-most block of your ship: ");
                String inputValY = myInput.nextLine();
                boolean criteriaA = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] == 0);
                boolean criteriaB = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 1] == 0);
                boolean criteriaC = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 2] == 0);
                boolean criteriaD = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 3] == 0);

                if (criteriaA && criteriaB && criteriaC && criteriaD) {
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
                    temp = false;
                    return Arrays.asList(p1, p2, p3, p4);


                } else {
                    System.out.println("You already placed another ship there! Try another location.");
                }

            }
        } else if (input3.equals("2")) {
            temp = true;

            while (temp) {
                System.out.println("Enter the X-coordinate of the top-most block of your ship: ");
                String inputValX = myInput.nextLine();
                System.out.println("Enter the Y-coordinate of the top-most block of your ship: ");
                String inputValY = myInput.nextLine();
                boolean criteriaA = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] == 0);
                boolean criteriaB = (shipMap[Integer.parseInt(inputValY) + 1][Integer.parseInt(inputValX)] == 0);
                boolean criteriaC = (shipMap[Integer.parseInt(inputValY) + 2][Integer.parseInt(inputValX)] == 0);
                boolean criteriaD = (shipMap[Integer.parseInt(inputValY) + 3][Integer.parseInt(inputValX)] == 0);

                if (criteriaA && criteriaB && criteriaC && criteriaD) {
                    int x1 = Integer.parseInt(inputValX);
                    int y1 = Integer.parseInt(inputValY);
                    Point p1 = new Point(x1, y1);

                    int x2 = Integer.parseInt(inputValX);
                    int y2 = Integer.parseInt(inputValY) + 1;
                    Point p2 = new Point(x2, y2);

                    int x3 = Integer.parseInt(inputValX);
                    int y3 = Integer.parseInt(inputValY) + 2;
                    Point p3 = new Point(x3, y3);

                    int x4 = Integer.parseInt(inputValX);
                    int y4 = Integer.parseInt(inputValY) + 3;
                    Point p4 = new Point(x4, y4);

                    temp = false;
                    return Arrays.asList(p1, p2, p3, p4);

                } else {
                    System.out.println("You already placed another ship there! Try another location.");
                }

            }

        }
        return null;
    }
}
