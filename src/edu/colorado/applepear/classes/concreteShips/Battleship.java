package edu.colorado.applepear.classes.concreteShips;

import edu.colorado.applepear.classes.CaptainsQuarters;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;

import java.util.ArrayList;

public class Battleship implements Ship {

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
    public void setShipName() {
        shipName = "battleship";
    }

    @Override
    public void setShipHealth() {
        health = location.size();
    }

    @Override
    public void setCaptainsQuarters() {
        ct = new CaptainsQuarters(2,location.get(2));
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
    public void updateHealth(Point location){
        // pop location attacked
        // set new health to location length
    }
}
