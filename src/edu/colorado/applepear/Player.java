package edu.colorado.applepear;
//Vienna part: player class
public class Player {
    // player class will hold the following
    private String name;
    private int radarMissile;
    private int plusMissile;

    //constructor
    public Player(String name, int radarMissile, int plusMissile){
        this.name = name;
        this.radarMissile = radarMissile;
        this.plusMissile = plusMissile;
    }
    //getters
    public String getName(){ return name; }

    public int getRadarMissile() { return radarMissile; }

    public int getPlusMissile() { return plusMissile; }

}

