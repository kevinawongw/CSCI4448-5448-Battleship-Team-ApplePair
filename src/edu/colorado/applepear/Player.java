package edu.colorado.applepear;
//Vienna part: player
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
    //getters
    public String getName(){ return name; }

    public int getRadarMissile() { return radarMissile; }

    public int getPlusMissile() { return plusMissile; }

    public int getNumShips() { return numShips; }

}

