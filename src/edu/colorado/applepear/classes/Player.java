package edu.colorado.applepear.classes;
import edu.colorado.applepear.classes.commandClasses.CommandDispatcher;

import java.util.ArrayList;
import java.util.List;


public class Player{

    /**
     * Class Attributes
     */
    private String name;
    private int sonarPulse, plusMissile;
    private final GameBoard gb;
    private Boolean hasSunkenShip;
    private final CommandDispatcher commandDispatcher;
    private String nameString;
    private List<Point> attacked= new ArrayList<>();


    /**
     * Constructor
     * @param gb - GameBoard
     */
    public Player(GameBoard gb){
        this.sonarPulse = 2;
        this.plusMissile = 3;
        this.gb = gb;
        this.hasSunkenShip = false ;
        this.commandDispatcher = new CommandDispatcher();
    }

    /**
     * Setters
     */
    public void setName(String name) { this.name = name; }
    public void setPlusMissile(int plusMissile) { this.plusMissile = plusMissile; }
    public void setSonarPulse(int sonarPulse) { this.sonarPulse = sonarPulse; }

    /**
     * Getters
     */
    public String getName(){ return name; }
    public int getSonarPulse() { return sonarPulse; }
    public int getPlusMissile() { return plusMissile; }
    public GameBoard getGb() { return gb; }
    public boolean getHasSunkenShip(){return hasSunkenShip;}
    public CommandDispatcher getCommandDispatcher(){ return commandDispatcher; }

    /**
     * Update Sunken Ship
     * @param trueOrFalse
     * Updates to see if a player has sunken a ship or not.
     */
    public void updateSunkShip(Boolean trueOrFalse){
        this.hasSunkenShip = trueOrFalse;
    }

    /**
     *
     * @param opponentBoard - Opponent's Board
     * @param P - Point
     * @return boolean for whether or not a ship was detected in the sonar pulse.
     *      // Scan the 8 blocks around a point for the presence of a ship
     *      // If yes, True
     *      // If no, False
     */
    public boolean useSonarPulse( GameBoard opponentBoard, Point P){

        if (getSonarPulse() < 1){
            System.out.println( getName() + " has no more radar missiles remaining \n");
            return false;
        }
        else if(!getHasSunkenShip()){
            System.out.println("Sonar Pulse is not unlocked \n");
            return false;
        }
        else{
            setSonarPulse(getSonarPulse()-1);
            System.out.println("Using radar missile... \n");
            boolean myReturn = false;
            int count = 0;

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

            List<Point> scannedCells = new ArrayList<>();
            for (Point thisPoint: radarRange){
                if ( (thisPoint.getX() >= 0) && (thisPoint.getX() <= 9) && (thisPoint.getY() <= 9) && (thisPoint.getY() >= 0)){
                    scannedCells.add(thisPoint);

                }
            }

            int[][] map =  opponentBoard.getShipMap();

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
     *
     * @param oppBoard - Opponent's Board
     * @param point - Center of Plus Missile
     * @return attacked - list of attacked points
     *      // Attacks the coordinates above, below, to the left, and to the right of entered coordinates.
     */
    public ArrayList<Point> usePlusMissile(GameBoard oppBoard, Point point){

        ArrayList<Point> attacked = new ArrayList<>();
        if (getPlusMissile() < 1){
            System.out.println(getName() + " has no more plus missiles remaining.");
            return attacked;
        }

        setPlusMissile(getPlusMissile() - 1);
        System.out.println("Using plus missile...");

        List<Point> plusRange = new ArrayList<>();

        Point above = new Point(point.getX(), point.getY()+1);
        Point below = new Point(point.getX(), point.getY()-1);
        Point right = new Point(point.getX()+1,point.getY());
        Point left = new Point(point.getX()-1, point.getY());

        if(above.getX() >=0 && above.getY()<=9)
            plusRange.add(above);
        if(below.getX() >=0 && below.getY()<=9)
            plusRange.add(below);
        if(right.getX() >=0 && right.getY()<=9)
            plusRange.add(right);
        if(left.getX() >=0 && left.getY()<=9)
            plusRange.add(left);

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

    /**
     *
     * @param oppBoard - Opponent's Board
     * @param point - Center of Plus Missile
     * @return attacked - list of attacked points
     *      // Attacks the coordinate on the surface attack map and the underwater attack map
     */

    public ArrayList<Point> useSpaceLaser(GameBoard oppBoard, Point point){
        ArrayList<Point> attacked = new ArrayList<>();
        if(!getHasSunkenShip()){

            System.out.println("Space Missile is not unlocked \n");
        }

        else{
            int[][] map =  oppBoard.getShipMap();
            int[][] underMap = oppBoard.getUnderwaterMap();
            if (map[point.getY()][point.getX()]==1){
                attacked.add(point);
                System.out.println("surface ship hit! \n");
            }
            if (underMap[point.getY()][point.getX()]==1){
                attacked.add(point);
                System.out.println("underwater ship hit! \n");
            }
            getGb().updateAttackMap(oppBoard, point);
            getGb().updateUnderwaterAttackMap(oppBoard,point);
            if (attacked.size() == 0){
                System.out.println("no ship hit...\n");
            }

        }
        return attacked;

    }


}

