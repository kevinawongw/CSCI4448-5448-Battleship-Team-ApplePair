package edu.colorado.applepear;

// Kevina did this section

public class GameBoard {

    // Helpful Variables
    public static int numX = 10;
    public static int numY = 10;


    // Note from Kevina: For now, I'm going to make the map 0,1,2 for y/n ship. We can change to string if easier :)
    // 0 - unchecked
    // 1 - checked, no ship
    // 2 - checked, ship found
    public static int[][] map = new int [numX][numY];




    // Function 1: Check specific Coordinate
    // Param: X and Y coordinates
    // Returns: Int
    // Checks X and Y coordinates against Map
    // if [X][Y] is 0, print "unchecked"
    // Return 0
    // if [X][Y] is 1, print "checked, ship found"
    // Return 1
    // if [X][Y] is 2, print "checked, no ship found"
    // Return 2

    //Function 2: View Map
    // Prints Map with 0s, 1s, and 2s
    public static void viewMap() {

    }






}
