package edu.colorado.applepear.classes;

import java.util.ArrayList;
import java.util.List;

public interface Ship {

    String getShipName();
    int getShipHealth();
    List<Point> getLocation();

    void setShipName();
    void setShipHealth();
    void setCaptainsQuarters();
    void setLocation(List <Point> points);

    Boolean isShipSunken();
    void updateHealth(Point location);
    List<Point> input(int[][] shipMap);

}
