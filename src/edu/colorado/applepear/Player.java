package edu.colorado.applepear;

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

}

