package edu.colorado.applepear.classes;
import java.util.List;

/**
 * Interface Ship
 */

public interface Ship {

    String getShipName();
    int getShipHealth();
    List<Point> getLocation();
    boolean getUnderwater();
    CaptainsQuarters getCaptainsQuarters();

    void setShipName();
    void setShipHealth(int newHealth);
    void setCaptainsQuarters();
    void setLocation(List <Point> points);

    Boolean isShipSunken();
    void updateHealth(Point location);
    List<Point> input(int[][] shipMap);
    List<Point> inputAsList(Point p);
}
