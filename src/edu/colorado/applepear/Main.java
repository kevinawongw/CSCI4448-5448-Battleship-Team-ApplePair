package edu.colorado.applepear;
import java.util.Scanner;
// Kevina was here doing menu things

public class Main {


    private static boolean run = true;

    public static void displayMenu() {
        System.out.println("\n\n ========== Welcome to Battleship ========== \n");
        System.out.println("Please pick a menu option");
        System.out.println("1. Choose Coordinates to attack");
        System.out.println("2. View Current Map");
        System.out.println("3. Check Player Inventory");
        System.out.println("4. Help & Instructions");
        System.out.println("5. Quit >:(");

    }

    public static void main(String[] args) {
        // write your code here
         Ship ship = new Ship();
         ship.show();

         GameBoard p1Map = new GameBoard();
         GameBoard p2Map = new GameBoard();

         GameBoard curGame = p1Map;
         GameBoard oppMap = p2Map;
         // Kevina was here
         // Menu Display & User Input
         // Refer to the displayMenu Print function for what each menu option will do

         displayMenu();
         while (run == true ){
             Scanner myInput = new Scanner(System.in);
             String myVal = myInput.nextLine();
             System.out.println(myVal);
             if (myVal.equals("1")){
                 System.out.println("What is the X coordinate for the space you want to attack?");
                 String myX = myInput.nextLine();
                 System.out.println("What is the Y coordinate for the space you want to attack?");
                 String myY = myInput.nextLine();
                 curGame.updateMap(myX,myY);
                 //... INCOMPLETE -
                 // Update Player map of reflected attack and new accessed space
                 // Update Missiles if specialty missile was used
                 // Update user of hit or miss
             }
             else if (myVal.equals("2")){
                 System.out.println("Player Map");
                 GameBoard.viewMap();
             }
             else if (myVal.equals("3")){

             }
             else if (myVal.equals("4")){

             }
             else if (myVal.equals("5")){
                run = false;
                return;
             }
             displayMenu();

             // Depending on the player's turn, their map will be different
             // Update maps and turns
             if (curGame.equals(p1Map)){
                 curGame = p2Map;
                 oppMap = p1Map;
             }
             else if (curGame.equals(p2Map)){
                 curGame = p1Map;
                 oppMap = p2Map;
             }
        }

    }





}
