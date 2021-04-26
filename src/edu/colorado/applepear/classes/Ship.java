package edu.colorado.applepear.classes;
import java.util.List;

/**
 * Interface Ship
 */

public interface Ship {

    /**
     * Getters
     */
    String getShipName();
    int getShipHealth();
    List<Point> getLocation();
    boolean getUnderwater();
    CaptainsQuarters getCaptainsQuarters();

    /**
     * Setters
     */
    void setShipName();
    void setShipHealth(int newHealth);
    void setCaptainsQuarters();
    void setLocation(List <Point> points);

    /**
     * Is Ship Sunken
     * @return Boolean
     * Returns whether or not the ship is Sunken
     */
    Boolean isShipSunken();

    /**
     * Update Health
     * @param location
     * Updates a ship's health
     */
    void updateHealth(Point location);

    /**
     * Input
     * @param shipMap
     * @return
     * Used for text-based version only
     */
    List<Point> input(int[][] shipMap);

}
