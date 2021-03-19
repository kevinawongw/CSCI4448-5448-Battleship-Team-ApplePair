package edu.colorado.applepear.classes;
import java.io.Flushable;
import java.util.List;
import java.util.Scanner;

// Kevina was here doing menu things

public class Main {

    private static boolean run = true;

    public static void main(String[] args) {

         // -- BEGIN Initialization --

         // Takes User Inputs (Credit: GeeksForGeeks)
         Scanner myInput = new Scanner(System.in);

         // Initialize Objects for Game + Take User Inputs for Object Parameters - Kevina

         // Initialize Player Objects
         List<String> names = MainPrint.collectNames();
         GameBoard p1Map = new GameBoard();
         GameBoard p2Map = new GameBoard();
         Player p1 = new Player(p1Map);
         p1.setName(names.get(0));
         Player p2 = new Player(p2Map);
         p2.setName(names.get(1));

         // Initialize GameBoard Objects

         System.out.println("\n\n ========== " + p1.getName() + "'s Turn to Place Ships ========== \n");
         p1Map.populateShipMap();
         System.out.println("\n\n ========== " + p2.getName() + "'s Turn to Place Ships ========== \n");
         p2Map.populateShipMap();

         // Initialize Game Object
         Game myGame = new Game(p1,p2);

         // Variables to keep track of which player's turn
         Player curPlayer = p1;
         Player opponentPlayer = p2;

         // -- END Initialization--


         // -- BEGIN Game Menu Loop --

         // Menu Display & User Input
         // Refer to the displayMenu Print function for what each menu option will do
         System.out.println("\n\n+--- It is " + curPlayer.getName() + "'s turn ---+");
         MainPrint.displayMenu();

         while (run){
             String myVal = myInput.nextLine();
             System.out.println(myVal);
             switch (myVal) {
                 case "1":
                     Point attackPoint = MainPrint.collectAttackPoint();

                     System.out.println("What type of missile would you like to use?");
                     System.out.println("1. Regular Missile");
                     System.out.println("2. Sonar Pulse  Missile");
                     System.out.println("3. Plus Missile");
                     int choice = Integer.parseInt(myInput.nextLine());

                     switch (choice) {
                         // vienna: added switch case to determine what weapon to use
                         // kevina: added necessary functions (ie. updateHealth, check isSunken, updateAttackMap)
                         case 1:
                             Boolean attackHitOrMiss = myGame.hitOrMiss(attackPoint, curPlayer, opponentPlayer);
                             curPlayer.getGb().updateAttackMap(opponentPlayer.getGb(), attackPoint);
                             curPlayer.getGb().viewMap();

                             if (attackHitOrMiss) {

                                 int shipAttackedIndex = opponentPlayer.getGb().identifyShip(attackPoint);
                                 opponentPlayer.getGb().getShips().get(shipAttackedIndex).updateHealth(attackPoint);
                                 boolean sunken = opponentPlayer.getGb().getShips().get(shipAttackedIndex).isShipSunken();
                                 System.out.println("You Hit an Opponent's Ship! Nice Shot!");

                                 if (sunken){
                                     System.out.println("Nice! You sunk the opponent's " + opponentPlayer.getGb().getShips().get(shipAttackedIndex).getShipName());
                                     curPlayer.updateSunkShip(true);
                                 }
                             } else {
                                 System.out.println("You Missed...");
                             }

                             if (curPlayer.equals(p1)) {
                                 curPlayer = p2;
                                 opponentPlayer = p1;

                             } else if (curPlayer.equals(p2)) {
                                 curPlayer = p1;
                                 opponentPlayer = p2;
                             }
                             break;

                         case 2:
                             if (p1.getHasSunkenShip() == false) {
                                 curPlayer.useSonarPulse(p2Map, attackPoint);
                                 break;
                             }

                             curPlayer.useSonarPulse(p2Map, attackPoint);
                             if (curPlayer.equals(p1)) {
                                 curPlayer = p2;
                                 opponentPlayer = p1;

                             } else if (curPlayer.equals(p2)) {
                                 curPlayer = p1;
                                 opponentPlayer = p2;
                             }
                             break;

                         case 3:
                             List<Point> attackedLoc = curPlayer.usePlusMissile(p2Map, attackPoint);
                             for (Point loc : attackedLoc) {
                                 int index = opponentPlayer.getGb().identifyShip(loc);
                                 opponentPlayer.getGb().getShips().get(index).updateHealth(loc);
                                 Boolean sunken = opponentPlayer.getGb().getShips().get(index).isShipSunken();
                                 if (sunken) {
                                     System.out.println("Nice! You sunk the opponent's " + opponentPlayer.getGb().getShips().get(index).getShipName());
                                     curPlayer.updateSunkShip(true);
                                 }
                             }

                             if (curPlayer.equals(p1)) {
                                 curPlayer = p2;
                                 opponentPlayer = p1;

                             } else if (curPlayer.equals(p2)) {
                                 curPlayer = p1;
                                 opponentPlayer = p2;
                             }
                             break;
                     }
                     break;
                 case "2":
                     System.out.println("Would you like to move a fleet or a submarine?");


                 case "3":
                     System.out.println("Player Map");
                     curPlayer.getGb().viewMap();
                     break;
                 case "4":
                     System.out.println("\n\n +-----" + curPlayer.getName() + "'s Inventory -----+\n");
                     System.out.println("Number of Radar Missiles: " + curPlayer.getSonarPulse());
                     System.out.println("Number of Plus Missiles: " + curPlayer.getPlusMissile());
                     break;
                 case "5":
                     MainPrint.printInstructions();
                     break;
                 case "6":
                     curPlayer.getGb().viewShips();
                     break;
                 case "7":
                     run = false;
                     return;
                 default:
                     System.out.println("Please select a valid menu option...");
                     MainPrint.displayMenu();
             }
             boolean gameEnd = myGame.isGameOver();
             if(gameEnd){
                 System.exit(0);
             }
             if (myVal.equals("1")){
                 System.out.println("\n\n--- It is " + curPlayer.getName() + "'s turn ---");
                 MainPrint.displayMenu();
             }
             else{
                 MainPrint.displayMenu();
             }

        }
    }
    // -- END Game Menu Loop--
}
