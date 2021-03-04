package edu.colorado.applepear;
import java.util.Scanner;

// Kevina was here doing menu things

public class Main {

    // Variable to keep game running
    private static boolean run = true;

    // Helper Function - Display Menu - Kevina
    // Param: None
    // Return: None
    // Prints Menu
    private static void displayMenu() {
        System.out.println("\n\n ========== Battleship Menu ========== \n");
        System.out.println("Please pick a menu option");
        System.out.println("1. Choose Coordinates to attack");
        System.out.println("2. View Current Map");
        System.out.println("3. Check Player Inventory");
        System.out.println("4. Help & Instructions");
        System.out.println("5. View My Ships");
        System.out.println("6. Quit >:(");

    }

    // Helper Function - Display Instruction - Kevina
    // Param: None
    // Return: None
    // Prints Instructions
    private static void printInstructions() {
        System.out.println("\n\n ========== Battleship Instructions ========== \n");
        System.out.println("[Goal] : Select Coordinates to take out your opponent's ships!");
        System.out.println("[Missiles] : All Players have unlimited uses of the standard missile that attacks one coordinate! Each player gets 2 \"+\" Missiles and 2 radar missiles.");
        System.out.println("[\"+\" Missile] : Attacks an area in the shape of a \"+\". The coordinate entered will attack that coordinate and the coordinates to the right, left, above, and below it. The player needs a rest turn after using this");
        System.out.println("[Radar Missile] : Scans the coordinate the player selected along with the eight spaces around it. Tells player if a ship is present, but not where.");
        System.out.println("Winner takes down all of their opponents ships! Good Luck!");
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
         GameBoard p1Map = new GameBoard();
         GameBoard p2Map = new GameBoard();
         Player p1 = new Player(name1,p1Map);
         Player p2 = new Player(name2,p2Map);

         // Initialize GameBoard Objects

         System.out.println("\n\n ========== " + p1.getName() + "'s Turn to Place Ships ========== \n");
         p1Map.populateShipMap();
         System.out.println("\n\n ========== " + p2.getName() + "'s Turn to Place Ships ========== \n");
         p2Map.populateShipMap();

         // Initialize Game Object
         Game myGame = new Game (p1,p2,p1Map, p2Map);

         // Variables to keep track of which player's turn
         Player curPlayer = p1;
         Player opponentPlayer = p2;


         // -- END Initialization--


         // -- BEGIN Game Menu Loop --

         // Menu Display & User Input
         // Refer to the displayMenu Print function for what each menu option will do
         System.out.println("\n\n+--- It is " + curPlayer.getName() + "'s turn ---+");
         displayMenu();

         while (run){
             String myVal = myInput.nextLine();
             System.out.println(myVal);
             switch (myVal) {
                 case "1":
                     System.out.println("\n\n+--- Let's Attack! ---+");
                     System.out.println("What is the X coordinate for the space you want to attack?");
                     String myX = myInput.nextLine();
                     System.out.println("What is the Y coordinate for the space you want to attack?");
                     String myY = myInput.nextLine();
                     Point attackPoint = new Point(Integer.parseInt(myX),Integer.parseInt(myY));
                     curPlayer.getGb().updateAttackMap(opponentPlayer.getGb(), attackPoint);
                     curPlayer.getGb().viewMap();
//                     if (hitOrMiss) {
//                         System.out.println("You Hit an Opponent's Ship! Nice Shot!");
//
//                     } else {
//                         System.out.println("You Missed...");
//                     }
                     // Depending on the player's turn, their map will be different
                     // Update maps and turns
                     if (curPlayer.equals(p1)) {
                         curPlayer = p2;
                         opponentPlayer = p1;

                     }
                     else if (curPlayer.equals(p2)) {
                         curPlayer = p1;
                         opponentPlayer = p2;
                     }
//                 case "2":
//                     System.out.println("Player Map");
//                     curPlayer.getGb().viewMap();
//                     break;
//                 case "3":
//                     System.out.println("\n\n +-----" + curPlayer.getName() + "'s Inventory -----+\n");
//                     System.out.println("Number of Radar Missiles: " + curPlayer.getRadarMissile());
//                     System.out.println("Number of Plus Missiles: " + curPlayer.getPlusMissile());
//                     break;
//                 case "4":
//                     printInstructions();
//                     break;
//                 case "5":
//                     curPlayer.getGb().viewShips();
//                     break;
//                 case "6":
//                     run = false;
//                     return;
//                 default:
//                     System.out.println("Please select a valid menu option...");
//                     displayMenu();
//
//
//                 boolean gameEnd = myGame.isGameOver();
//                 if(gameEnd){
//                     System.exit(0);
//                 }
//                 System.out.println("\n\n--- It is " + curPlayer.getName() + "'s turn ---");
//                 displayMenu();
             }
             //end the game
        }
    }
    // -- END Game Menu Loop--
}
