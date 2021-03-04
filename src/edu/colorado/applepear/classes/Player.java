package edu.colorado.applepear.classes;

import java.util.ArrayList;
import java.util.List;


//Vienna part: player class
public class Player{
    // player class will hold the following
    private String name;
    private int radarMissile, plusMissile, numShips;
    private final GameBoard gb;

    //constructor
    public Player(GameBoard gb){
        this.radarMissile = 3;
        this.plusMissile = 3;
        this.gb = gb;
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

/**
Parameters: the opponent's board as GameBoard type, the point to check as Point type
Returns: whether there are ships nearby as a boolean
This function scans the 8 blocks around a point for the presence of a ship. 
**/
    public boolean useRadarMissile( GameBoard opponentBoard, Point P){
        //checks if this player has any radar missiles left

        if (getRadarMissile() < 1){
            System.out.println( getName() + " has no more radar missiles remaining");
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

            //adding points to check into array list
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

            //making sre the points are in the grid
            List<Point> scannedCells = new ArrayList<>();
            for (Point thisPoint: radarRange){
                if ( (thisPoint.getX() >= 0) && (thisPoint.getX() <= 9) && (thisPoint.getY() <= 9) && (thisPoint.getY() >= 0)){
                    scannedCells.add(thisPoint);
                }
            }

            //saving the opponent's ship map into a new map
            int[][] map =  opponentBoard.getShipMap();

            //trying to find ships by checking the points in the array list
            for ( Point i :scannedCells){
                int thisX = i.getX();
                int thisY = i.getY();
                if (map[thisX][thisY] == 1){
                    System.out.println("Ship detected in this range!");
                    return true;
                }
            }
            System.out.println("point2: ");
            System.out.println("No ship was found in this range");
            return false;

        }

    }

/**
Parameters: the opponent's board as GameBoard type, the point to check as Point type
Returns: whether an attack was performed as a boolean
This function attacks the coordinates above, below, left, right of the coordinate entered .
**/
    public boolean usePlusMissile(GameBoard oppBoard, Point point){
        //checks if this player has any plus missiles left
        if (getPlusMissile() < 1){
            System.out.println(getName() + " has no more plus missiles remaining.");
            return false;
        }
        setPlusMissile(getPlusMissile() - 1);
        System.out.println("Using plus missile...");

        //new arrayList to save the points
        List<Point> plusRange = new ArrayList<>();

        //points
        Point above = new Point(point.getX(), point.getY()+1);
        Point below = new Point(point.getX(), point.getY()-1);
        Point right = new Point(point.getX()+1,point.getY());
        Point left = new Point(point.getX()-1, point.getY());

        //checks if the point is on the grid and not out of bounds then appends if on grid
        if(above.getX() >=0 && above.getY()<=9)
            plusRange.add(above);
        if(below.getX() >=0 && below.getY()<=9)
            plusRange.add(below);
        if(right.getX() >=0 && right.getY()<=9)
            plusRange.add(right);
        if(left.getX() >=0 && left.getY()<=9)
            plusRange.add(left);

        //saves the opponent map
        int[][] map =  oppBoard.getShipMap();

        boolean attack = false;
        for (Point p : plusRange){
            int currX = p.getX();
            int currY = p.getY();

            if (map[currX][currY] == 1){
//                playerMap.getAttackMap()[thisX][thisY] = 2;
                attack = true;
            }

        }
        if(attack)
            return attack;
        else{
            System.out.println("No attacks were made since there are no ships around.");
            return false;
        }

    }

}

