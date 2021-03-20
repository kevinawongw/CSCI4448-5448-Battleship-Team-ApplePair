package edu.colorado.applepear.classes.commandClasses;
import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;

import java.util.*;

public class MoveWest implements Command{
    GameBoard gb;
    Ship ship;

    public MoveWest(GameBoard gb, Ship ship){
        this.gb = gb;
        this.ship = ship;
    }
    @Override
    public void execute() {
        List <String> valid = gb.getPossibleMoveLocations(ship);
        List <Point> newLocations = new ArrayList<>();
        if(valid.contains("West")){
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
                    newLocations.add(new Point(p.getX(), p.getY()-1));
                    gb.setUnderwaterMap(p,0);
                }
                ship.setLocation(newLocations);
                gb.updateUnderwaterMap();
                gb.viewUnderwater();
            }
        }
    }
}
