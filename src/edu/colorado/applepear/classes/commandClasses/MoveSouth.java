package edu.colorado.applepear.classes.commandClasses;
import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;

import java.util.*;

public class MoveSouth implements Command{
    GameBoard gb;
    Ship ship;
    String direction;

    public MoveSouth(GameBoard gb, Ship ship){
        this.gb = gb;
        this.ship = ship;
        direction = "South";
    }

    public String getDirection(){
        return direction;
    }

    @Override
    public void execute() {
        List <Point> newLocations = new ArrayList<>();
        if(!ship.getUnderwater()){
            for (Point p : ship.getLocation()) {
                newLocations.add(new Point(p.getX(), p.getY() + 1));
                gb.setShipMap(p, 0);
            }
            ship.setLocation(newLocations);
            //System.out.println("Hiiiii");
            gb.updateShipMap();
            gb.viewShips();
        }
        else if(ship.getUnderwater()){
            for (Point p : ship.getLocation()) {
                newLocations.add(new Point(p.getX(), p.getY() + 1));
                gb.setShipMap(p, 0);
            }
            ship.setLocation(newLocations);
            gb.updateUnderwaterMap();
            gb.viewUnderwater();
        }
    }

}
