package edu.colorado.applepear.classes.commandClasses;
import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;

import java.util.*;

public class MoveSouth implements Command{

    /**
     * Class Attributes
     */
    GameBoard gb;
    Ship ship;

    /**
     * Move South
     * @param gb - Game Board
     * @param ship - Ship Moved
     */
    public MoveSouth(GameBoard gb, Ship ship){
        this.gb = gb;
        this.ship = ship;
    }

    /**
     * Execute
     */
    @Override
    public void execute() {
        List <Point> newLocations = new ArrayList<>();
        if(!ship.getUnderwater()){
            for (Point p : ship.getLocation()) {
                newLocations.add(new Point(p.getX(), p.getY() + 1));
                gb.setShipMap(p, 0);
            }
            ship.setLocation(newLocations);
            gb.updateShipMap();
            gb.viewShips();
        }
        else if(ship.getUnderwater()){
            for (Point p : ship.getLocation()){
                newLocations.add(new Point(p.getX(), p.getY() + 1));
                gb.setUnderwaterMap(p,0);
            }
            ship.setLocation(newLocations);
            gb.updateUnderwaterMap();
            gb.viewUnderwater();
        }
    }

    /**
     * Undo
     */
    @Override
    public void undo(){
        List <Point> newLocations = new ArrayList<>();
        if(!ship.getUnderwater()){
            for(Point p : ship.getLocation()){
                newLocations.add(new Point(p.getX(), p.getY() - 1));
                gb.setShipMap(p, 0);
            }
            ship.setLocation(newLocations);
            gb.updateShipMap();
            gb.viewShips();
        }
        else if(ship.getUnderwater()){
            for (Point p : ship.getLocation()){
                newLocations.add(new Point(p.getX(), p.getY() - 1));
                gb.setUnderwaterMap(p,0);
            }
            ship.setLocation(newLocations);
            gb.updateUnderwaterMap();
            gb.viewUnderwater();
        }
    }


}
