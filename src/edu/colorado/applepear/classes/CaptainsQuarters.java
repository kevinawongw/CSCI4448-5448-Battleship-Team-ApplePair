package edu.colorado.applepear.classes;

public class CaptainsQuarters {
    private int health;
    private Point location;
    private String shipName;

    //Constructor
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
     * Parameters: none
     * @return shipName (string)
     * This is the getter method for the attribute shipName.
     */
    public String getShipName(){
        return shipName;
    }

    /**
     * Parameters: new health to be set
     * @return none
     * This is the setter method for the attribute health.
     */
    public void setHealth(int health){
        this.health = health;
    }

    /**
     * Parameters: new location to be set
     * @return none
     * This is the setter method for the attribute location.
     */
    public void setLocation(Point location){
        this.location = location;
    }

    /**
     * Parameters: new ship type to be set
     * @return none
     * This is the setter method for the attribute shipType.
     */
    public void setShipType(String shipName){
        this.shipName = shipName;
    }




}
