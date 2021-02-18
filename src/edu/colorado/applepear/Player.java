package edu.colorado.applepear;

//Vienna part: player class
public class Player {
    // player class will hold the following
    private String name;
    private int radarMissile;
    private int plusMissile;
    private int numShips;

    //constructor
    public Player(String name, int radarMissile, int plusMissile, int numShips){
        this.name = name;
        this.radarMissile = radarMissile;
        this.plusMissile = plusMissile;
        this.numShips = numShips;
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

    public void setNumShips(int numShips) {
        this.numShips = numShips;
    }

    //getters
    public String getName(){ return name; }

    public int getRadarMissile() { return radarMissile; }

    public int getPlusMissile() { return plusMissile; }

    public int getNumShips() { return numShips; }

    //check for losing state 

    public boolean checkLose(){
        int myShips = getNumShips();
        if (myShips == 0) {
            return true;
        }
        else {
            return false;
        }
    }

}

