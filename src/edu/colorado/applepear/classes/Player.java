package edu.colorado.applepear.classes;

import java.util.ArrayList;
import java.util.List;


//Vienna part: player class
public class Player{
    // player class will hold the following
    private String name;
    private int sonarPulse, plusMissile;
    private final GameBoard gb;
    private Boolean hasSunkenShip;


    //constructor
    public Player(GameBoard gb){
        this.sonarPulse = 2;
        this.plusMissile = 3;
        this.gb = gb;
        this.hasSunkenShip = false ;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPlusMissile(int plusMissile) {
        this.plusMissile = plusMissile;
    }

    public void setSonarPulse(int sonarPulse) {
        this.sonarPulse = sonarPulse;
    }

    //getters
    public String getName(){ return name; }

    public int getSonarPulse() { return sonarPulse; }

    public int getPlusMissile() { return plusMissile; }

    public GameBoard getGb() { return gb; }

    public boolean getHasSunkenShip(){return hasSunkenShip;}
    public void updateSunkShip(Boolean trueOrFalse){
        this.hasSunkenShip = trueOrFalse;
    }

/**
Parameters: the opponent's board as GameBoard type, the point to check as Point type
Returns: whether there are ships nearby as a boolean
This function scans the 8 blocks around a point for the presence of a ship. 
**/

    public boolean useSonarPulse( GameBoard opponentBoard, Point P){
        //checks if this player has any radar missiles left

        if (getSonarPulse() < 1){
            System.out.println( getName() + " has no more radar missiles remaining \n");
            return false;
        }
        else if(!getHasSunkenShip()){
            System.out.println("Sonar Pulse is not unlocked \n");
            return false;
        }
        else{
            //update number of radar missiles for this player
            setSonarPulse(getSonarPulse()-1);
            System.out.println("Using radar missile... \n");
            boolean myReturn = false;
            int count = 0;
            //points

            Point above = new Point(P.getX(),P.getY()+1);
            Point below = new Point(P.getX(),P.getY()-1);
            Point right = new Point(P.getX()+1,P.getY());
            Point left = new Point(P.getX()-1,P.getY());
            Point upRight = new Point(P.getX()+1,P.getY()+1);
            Point upLeft = new Point(P.getX()-1,P.getY()+1);
            Point downRight = new Point(P.getX()+1,P.getY()-1);
            Point downLeft = new Point(P.getX()-1,P.getY()-1);
            Point farUp = new Point(P.getX(),P.getY()+2);
            Point farDown = new Point(P.getX(),P.getY()-2);
            Point farRight = new Point(P.getX()+2, P.getY());
            Point farLeft = new Point(P.getX()-2, P.getY());

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
            radarRange.add(farDown);
            radarRange.add(farLeft);
            radarRange.add(farRight);
            radarRange.add(farUp);

            //making are the points are in the grid
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
                if (map[thisY][thisX] == 1){
                    getGb().getAttackMap()[thisY][thisX] = 3;
                    count +=1;
                    myReturn = true;
                }
                else{
                    getGb().getAttackMap()[thisY][thisX] = 4;
                }
            }
            if (!myReturn){
                System.out.println("No ship was found in this range \n");
            }
            else{
                System.out.println(count +" spot(s) detected something... \n");
            }
            getGb().viewAttackMap();
            return myReturn;

        }

    }

/**
Parameters: the opponent's board as GameBoard type, the point to check as Point type
Returns: whether an attack was performed as a boolean
This function attacks the coordinates above, below, left, right of the coordinate entered .
**/
    public ArrayList<Point> usePlusMissile(GameBoard oppBoard, Point point){
        //checks if this player has any plus missiles left
        ArrayList<Point> attacked = new ArrayList<>();
        if (getPlusMissile() < 1){
            System.out.println(getName() + " has no more plus missiles remaining.");
            return attacked;
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

        for (Point p : plusRange){
            int currX = p.getX();
            int currY = p.getY();

            if (currX<0 ||currY<0){
                break;
            }
            getGb().updateAttackMap(oppBoard, p);

            if (map[currX][currY] == 1){
                attacked.add(p);
            }

        }
        if(attacked.size()> 0) {
            System.out.println("Plus Missile landed " + attacked.size() + " hit(s)!");

        }
        else{
            System.out.println("No attacks were made since there are no ships around.");
        }
        return attacked;

    }

}

