package edu.colorado.applepear;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Vienna part: player class
public class Player{
    // player class will hold the following
    private String name;
    private int radarMissile, plusMissile, numShips;
    private GameBoard gb;

    //constructor
    public Player(String name, GameBoard gb){
        this.name = name;
        this.radarMissile = 3;
        this.plusMissile = 3;

    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPlusMissile(int plusMissile) {
        this.plusMissile = plusMissile;
    }

    public void setRadarMissile(int radarMissile) {
        this.radarMissile = radarMissile;
    }

    //getters
    public String getName(){ return name; }

    public int getRadarMissile() { return radarMissile; }

    public int getPlusMissile() { return plusMissile; }

    public GameBoard getGb() { return gb; }

    public boolean useRadarMissile( GameBoard opponentBoard, Point P){
        if (getRadarMissile() < 1){
            System.out.println( getName() + "has no more radar missiles remaining");
            return false;
        }
        else{
            //update number of radar missiles for this player
            setRadarMissile(getRadarMissile()-1);
            System.out.println("Using radar missile...");
            //points

            Point above = new Point(P.getX(),P.getY()+1);
            Point below = new Point(P.getX(),P.getY()-1);
            Point right = new Point(P.getX()+1,P.getY()+1);
            Point left = new Point(P.getX()-1,P.getY()+1);
            Point upRight = new Point(P.getX()+1,P.getY()+1);
            Point upLeft = new Point(P.getX()-1,P.getY()+1);
            Point downRight = new Point(P.getX()+1,P.getY()-1);
            Point downLeft = new Point(P.getX()-1,P.getY()-1);

            List<Point> radarRange = new ArrayList<>();

            radarRange.add(P);
            radarRange.add(above);
            radarRange.add(below);
            radarRange.add(right);
            radarRange.add(left);
            radarRange.add(upRight);
            radarRange.add(upLeft);
            radarRange.add(downRight);
            radarRange.add(downLeft);

            int[][] map =  opponentBoard.getShipMap();

            for ( Point i :radarRange){
                int thisX = i.getX();
                int thisY = i.getY();
                if (map[thisX][thisY] == 1){
                    System.out.println("Ship detected in this range!");
                    return true;
                }
            }
            System.out.println("No ship was found in this range");
            return false;

        }

    }


}

