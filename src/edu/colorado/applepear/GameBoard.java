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


    // Function 1: Update Map:
    // Param:
    public void updateMap(String myX, String myY) {
    }
    

    
    // Function 2: View Map
    // Param: None
    // Returns: None
    // Prints Map with 0s, 1s, and 2s
    public static void viewMap() {
        for (int i = 0; i < numX; i++){
            for (int a = 0 ; a < 10 ; a++){
                System.out.print("+———");
            }
            System.out.print("+");
            System.out.print("\n");
            System.out.print("| ");

            for (int j = 0; j < numY; j++){
                System.out.print(map[i][j] + " | ");
            }
            System.out.print("\n");
        }
        for (int a = 0 ; a < 10 ; a++){
            System.out.print("+———");
        }
        System.out.print("+");
    }


}
