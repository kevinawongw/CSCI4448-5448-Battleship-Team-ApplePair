package edu.colorado.applepear.classes.commandClasses;
import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;

import java.util.*;

public class Move implements Command{
    GameBoard gb;
    Ship ship;
    String direction;

    public Move(GameBoard gb, Ship ship, String direction){
        this.gb = gb;
        this.ship = ship;
        this.direction = direction;
    }
    @Override
    public void execute() {
        List <Point> newLocations = new ArrayList<>();
        switch (direction) {
            case "North":
                if (!ship.getUnderwater()) {
                    for (Point p : ship.getLocation()) {
                        newLocations.add(new Point(p.getX(), p.getY() - 1));
                        gb.setShipMap(p, 0);
                    }
                    ship.setLocation(newLocations);
                    gb.updateShipMap();
                    gb.viewShips();
                } else if (ship.getUnderwater()) {
                    for (Point p : ship.getLocation()) {
                        newLocations.add(new Point(p.getX(), p.getY() - 1));
                        gb.setUnderwaterMap(p, 0);
                    }
                    ship.setLocation(newLocations);
                    gb.updateUnderwaterMap();
                    gb.viewUnderwater();
                }
                break;
            case "South":
                if (!ship.getUnderwater()) {
                    for (Point p : ship.getLocation()) {
                        newLocations.add(new Point(p.getX(), p.getY() + 1));
                        gb.setShipMap(p, 0);
                    }
                    ship.setLocation(newLocations);
                    gb.updateShipMap();
                    gb.viewShips();
                } else if (ship.getUnderwater()) {
                    for (Point p : ship.getLocation()) {
                        newLocations.add(new Point(p.getX(), p.getY() + 1));
                        gb.setUnderwaterMap(p, 0);
                    }
                    ship.setLocation(newLocations);
                    gb.updateUnderwaterMap();
                    gb.viewUnderwater();
                }
                break;
            case "East":
                if (!ship.getUnderwater()) {
                    for (Point p : ship.getLocation()) {
                        newLocations.add(new Point(p.getX() + 1, p.getY()));
                        gb.setShipMap(p, 0);
                    }
                    ship.setLocation(newLocations);
                    gb.updateShipMap();
                    gb.viewShips();
                } else if (ship.getUnderwater()) {
                    for (Point p : ship.getLocation()) {
                        newLocations.add(new Point(p.getX() + 1, p.getY()));
                        gb.setShipMap(p, 0);
                    }
                    ship.setLocation(newLocations);
                    gb.updateUnderwaterMap();
                    gb.viewUnderwater();
                }
                break;
            case "West":
                if (!ship.getUnderwater()) {
                    for (Point p : ship.getLocation()) {
                        newLocations.add(new Point(p.getX() - 1, p.getY()));
                        gb.setShipMap(p, 0);
                    }
                    ship.setLocation(newLocations);
                    gb.updateShipMap();
                    gb.viewShips();
                } else if (ship.getUnderwater()) {
                    for (Point p : ship.getLocation()) {
                        newLocations.add(new Point(p.getX() - 1, p.getY()));
                        gb.setShipMap(p, 0);
                    }
                    ship.setLocation(newLocations);
                    gb.updateUnderwaterMap();
                    gb.viewUnderwater();
                }
                break;
        }

    }

    @Override
    public void undo(){
        List <Point> newLocations = new ArrayList<>();
        switch (direction) {
            case "North":
                if (!ship.getUnderwater()) {
                    for (Point p : ship.getLocation()) {
                        newLocations.add(new Point(p.getX(), p.getY() + 1));
                        gb.setShipMap(p, 0);
                    }
                    ship.setLocation(newLocations);
                    gb.updateShipMap();
                    gb.viewShips();
                } else if (ship.getUnderwater()) {
                    for (Point p : ship.getLocation()) {
                        newLocations.add(new Point(p.getX(), p.getY() + 1));
                        gb.setUnderwaterMap(p, 0);
                    }
                    ship.setLocation(newLocations);
                    gb.updateUnderwaterMap();
                    gb.viewUnderwater();
                }
                break;
            case "South":
                if (!ship.getUnderwater()) {
                    for (Point p : ship.getLocation()) {
                        newLocations.add(new Point(p.getX(), p.getY() - 1));
                        gb.setShipMap(p, 0);
                    }
                    ship.setLocation(newLocations);
                    gb.updateShipMap();
                    gb.viewShips();
                } else if (ship.getUnderwater()) {
                    for (Point p : ship.getLocation()) {
                        newLocations.add(new Point(p.getX(), p.getY() - 1));
                        gb.setUnderwaterMap(p, 0);
                    }
                    ship.setLocation(newLocations);
                    gb.updateUnderwaterMap();
                    gb.viewUnderwater();
                }
                break;
            case "East":
                if (!ship.getUnderwater()) {
                    for (Point p : ship.getLocation()) {
                        newLocations.add(new Point(p.getX() - 1, p.getY()));
                        gb.setShipMap(p, 0);
                    }
                    ship.setLocation(newLocations);
                    gb.updateShipMap();
                    gb.viewShips();
                } else if (ship.getUnderwater()) {
                    for (Point p : ship.getLocation()) {
                        newLocations.add(new Point(p.getX() - 1, p.getY()));
                        gb.setShipMap(p, 0);
                    }
                    ship.setLocation(newLocations);
                    gb.updateUnderwaterMap();
                    gb.viewUnderwater();
                }
                break;
            case "West":
                if (!ship.getUnderwater()) {
                    for (Point p : ship.getLocation()) {
                        newLocations.add(new Point(p.getX() + 1, p.getY()));
                        gb.setShipMap(p, 0);
                    }
                    ship.setLocation(newLocations);
                    gb.updateShipMap();
                    gb.viewShips();
                } else if (ship.getUnderwater()) {
                    for (Point p : ship.getLocation()) {
                        newLocations.add(new Point(p.getX() + 1, p.getY()));
                        gb.setShipMap(p, 0);
                    }
                    ship.setLocation(newLocations);
                    gb.updateUnderwaterMap();
                    gb.viewUnderwater();
                }
                break;
        }

    }

}
