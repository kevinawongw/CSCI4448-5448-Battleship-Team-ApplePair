package edu.colorado.applepear.classes.concreteShips;

import edu.colorado.applepear.classes.CaptainsQuarters;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;

import java.util.ArrayList;

public class Minesweeper implements Ship {

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
        shipName = "minesweeper";
    }

    @Override
    public void setShipHealth() {
        health = location.size();
    }

    @Override
    public void setCaptainsQuarters() {
        // For Yvonne :)
        ct = new CaptainsQuarters(1,location.get(0));
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
