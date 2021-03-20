package edu.colorado.applepear.classes;

public class CaptainsQuarters {
    private int health;
    private Point location;

    public CaptainsQuarters(int health, Point location){
        this.health = health;
        this.location = location;
    }

    /**
     * Parameters: none
     * @return health (int)
     * This is the getter method for the attribute health.
     */
    public int getHealth(){
        return health;
    }

    /**
     * Parameters: none
     * @return location (point)
     * This is the getter method for the attribute location.
     */
    public Point getLocation(){
        return location;
    }

    /**
     * Parameters: new health to be set
     * This is the setter method for the attribute health.
     */
    public void setHealth(int health){
        this.health = health;
    }

    /**
     * Parameters: new location to be set
     * This is the setter method for the attribute location.
     */
    public void setLocation(Point location){
        this.location = location;
    }



}
