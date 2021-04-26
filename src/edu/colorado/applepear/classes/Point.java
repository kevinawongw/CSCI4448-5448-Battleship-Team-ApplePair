package edu.colorado.applepear.classes;

/**
 * Point Class
 */

public class Point {

    /**
     * Variables
     */
    private final int x;
    private final int y;

    /**
     * Constructor
     * @param x
     * @param y
     */
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Getters
     */
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}

