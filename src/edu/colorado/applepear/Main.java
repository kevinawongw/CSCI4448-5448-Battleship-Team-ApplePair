package edu.colorado.applepear;
import java.util.Scanner;

// Kevina was here doing menu things

public class Main {

    // Variable to keep game running
    private static boolean run = true;

    // Helper Function - Display Menu - Kevina
    public static void displayMenu() {
        System.out.println("\n\n ========== Battleship Menu ========== \n");
        System.out.println("Please pick a menu option");
        System.out.println("1. Choose Coordinates to attack");
        System.out.println("2. View Current Map");
        System.out.println("3. Check Player Inventory");
        System.out.println("4. Help & Instructions");
        System.out.println("5. View My Ships");
        System.out.println("6. Quit >:(");

    }

    // Main - Kevina
    public static void main(String[] args) {
         // -- BEGIN Initialization --

         // Takes User Inputs (Credit: GeeksForGeeks)
         Scanner myInput = new Scanner(System.in);

         // Initialize Objects for Game + Take User Inputs for Object Parameters - Kevina

         // Initialize Player Objects
         System.out.println("\n\n ========== Welcome to Battleship ========== \n");
         System.out.println("\n Enter Player 1's Name: \n");
         String name1 = myInput.nextLine();
         System.out.println("\n Enter Player 2's Name: \n");
         String name2 = myInput.nextLine();
         Player p1 = new Player(name1,2,2,5);
         Player p2 = new Player(name2,2,2,5);

         // Initialize GameBoard Objects
         GameBoard p1Map = new GameBoard(p1);
         GameBoard p2Map = new GameBoard(p2);
         System.out.println("\n\n ========== " + p1Map.getPlayer().getName() + "'s Turn to Place Ships ========== \n");
         p1Map.populateShips();
         System.out.println("\n\n ========== " + p2Map.getPlayer().getName() + "'s Turn to Place Ships ========== \n");
         p2Map.populateShips();

         // Initialize Game Object
         Game myGame = new Game (p1,p2,p1Map, p2Map);

         // Variables to keep track of which player's turn
         GameBoard curMap = p1Map;
         GameBoard oppMap = p2Map;

         // -- END Initialization--

         // -- BEGIN Game Menu Loop --

         // Menu Display & User Input
         // Refer to the displayMenu Print function for what each menu option will do
         displayMenu();

         while (run){
             String myVal = myInput.nextLine();
             System.out.println(myVal);
             if (myVal.equals("1")){
                 System.out.println("What is the X coordinate for the space you want to attack?");
                 String myX = myInput.nextLine();
                 System.out.println("What is the Y coordinate for the space you want to attack?");
                 String myY = myInput.nextLine();
                 boolean hitOrMiss = Game.updateMap(curMap,oppMap, myX,myY);
                 if (hitOrMiss){
                     System.out.println("You Hit an Opponent's Ship! Nice Shot!");
                 }
                 else{
                     System.out.println("You Missed...");
                 }
                 curMap.viewMap();
                 // Depending on the player's turn, their map will be different
                 // Update maps and turns
                 if (curMap.equals(p1Map)){
                     p1Map = curMap;
                     curMap = p2Map;
                     oppMap = p1Map;

                 }
                 else if (curMap.equals(p2Map)){
                     p2Map = curMap;
                     curMap = p1Map;
                     oppMap = p2Map;
                 }
             }
             else if (myVal.equals("2")){
                 System.out.println("Player Map");
                 curMap.viewMap();
             }
             else if (myVal.equals("3")){

             }
             else if (myVal.equals("4")){

             }
             else if (myVal.equals("5")){
                 curMap.viewShips();
             }
             else if (myVal.equals("6")){
                run = false;
                return;
             }
             displayMenu();
        }
    }
    // -- END Game Menu Loop--





}
