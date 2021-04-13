package edu.colorado.applepear.classes.main;
import edu.colorado.applepear.classes.Game;
import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Player;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.commandClasses.*;

import java.util.List;
import java.util.Scanner;

// Kevina was here doing menu things

public class Main {

    private static boolean run = true;

    public static void main(String[] args) {

        /**
         * ---- Begin Initialization Section ----
         * Initialize Objects for Game + Take User Inputs for Object Parameters
         * Initialize GameBoard Objects
         */

         Scanner myInput = new Scanner(System.in);

         List<String> names = MainHelpers.collectNames();
         GameBoard p1Map = new GameBoard();
         GameBoard p2Map = new GameBoard();
         Player p1 = new Player(p1Map);
         p1.setName(names.get(0));
         Player p2 = new Player(p2Map);
         p2.setName(names.get(1));

         System.out.println("\n\n ========== " + p1.getName() + "'s Turn to Place Ships ========== \n");
         p1Map.populateShipMap();
         System.out.println("\n\n ========== " + p2.getName() + "'s Turn to Place Ships ========== \n");
         p2Map.populateShipMap();

         Game myGame = new Game(p1,p2);

         Player curPlayer = p1;
         Player opponentPlayer = p2;

        /**
         * ---- End Initialization Section ----
         */


        /**
         * Begin Main Game Loop
         */
        MainHelpers.displayPlayerTurn(curPlayer);
        MainHelpers.displayMenu();

         while (run){
             String myVal = myInput.nextLine();

             switch (myVal) {
                 case "1":
                     Point attackPoint = MainHelpers.collectAttackPoint();
                     int choice = MainHelpers.collectMissileInput();

                     switch (choice) {
                         case 1:
                             Boolean attackHitOrMiss = myGame.hitOrMiss(attackPoint, curPlayer, opponentPlayer);
                             curPlayer.getGb().updateAttackMap(opponentPlayer.getGb(), attackPoint);
                             curPlayer.getGb().viewAttackMap();

                             if (attackHitOrMiss) {

                                 int shipAttackedIndex = opponentPlayer.getGb().identifyShip(attackPoint);
                                 opponentPlayer.getGb().getShips().get(shipAttackedIndex).updateHealth(attackPoint);
                                 boolean sunken = opponentPlayer.getGb().getShips().get(shipAttackedIndex).isShipSunken();
                                 System.out.println("You Hit an Opponent's Ship! Nice Shot!");

                                 if (sunken){
                                     System.out.println("Nice! You sunk the opponent's " + opponentPlayer.getGb().getShips().get(shipAttackedIndex).getShipName());
                                     curPlayer.updateSunkShip(true);
                                     curPlayer.getGb().updateSunkenShip(shipAttackedIndex);
                                 }
                             }

                             else { System.out.println("You Missed..."); }

                             if (curPlayer.equals(p1)) {
                                 curPlayer = p2;
                                 opponentPlayer = p1;

                             } else if (curPlayer.equals(p2)) {
                                 curPlayer = p1;
                                 opponentPlayer = p2;
                             }
                             break;

                         case 2:
                             if (!curPlayer.getHasSunkenShip()) {
                                 curPlayer.useSonarPulse(opponentPlayer.getGb(), attackPoint);
                                 break;
                             }

                             curPlayer.useSonarPulse(opponentPlayer.getGb(), attackPoint);
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
                                     MainHelpers.printSinkMessage(opponentPlayer,index);
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
                         case 4:
                             if (curPlayer.getHasSunkenShip() == false) {
                                 curPlayer.useSpaceLaser(opponentPlayer.getGb(), attackPoint);
                                 break;
                             }

                             curPlayer.useSpaceLaser(opponentPlayer.getGb(), attackPoint);
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
                     int commandChoice = MainHelpers.collectMoveInput();
                     switch (commandChoice) {
                         case 1:
                             int indexOfMovingShip = MainHelpers.viewAllShipsAsList(curPlayer);
                             List<String> validMoves = curPlayer.getGb().getPossibleMoveLocations(curPlayer.getGb().getShips().get(indexOfMovingShip));
                             int moveIndex = MainHelpers.getMoves(validMoves);
                             String myMove = validMoves.get(moveIndex-1);
                             System.out.println("Test move 2: "+myMove);
                             Move move = new Move(curPlayer.getGb(), curPlayer.getGb().getShips().get(indexOfMovingShip),myMove);
                             curPlayer.getCommandDispatcher().setCommands(move);
                             break;

                         case 2:
                             curPlayer.getCommandDispatcher().redo();
                             curPlayer.getGb().viewShips();
                             break;
                         case 3:
                             curPlayer.getCommandDispatcher().undo();
                             curPlayer.getGb().viewShips();

                             break;
                         case 4:
                             curPlayer.getCommandDispatcher().undoAll();
                             break;
                     }

                     if (curPlayer.equals(p1)) {
                         curPlayer = p2;
                         opponentPlayer = p1;

                     } else if (curPlayer.equals(p2)) {
                         curPlayer = p1;
                         opponentPlayer = p2;
                     }

                     break;

                 case "3":
                     System.out.println("Player Map");
                     curPlayer.getGb().viewAttackMap();
                     break;
                 case "4":
                     MainHelpers.printInventory(curPlayer);
                     break;
                 case "5":
                     MainHelpers.printInstructions();
                     break;
                 case "6":
                     MainHelpers.viewAllShips(curPlayer);
                     break;
                 case "7":
                     run = false;
                     System.exit(0);
                 default:
                     System.out.println("Please select a valid menu option...");
                     MainHelpers.displayMenu();
                     break;
             }

             boolean gameEnd = myGame.isGameOver();

             if (gameEnd) {
                 MainHelpers.displayGameOver(curPlayer,opponentPlayer);
                 System.exit(0);
             }

             if (myVal.equals("1") || myVal.equals("2")){
                 MainHelpers.displayPlayerTurn(curPlayer);
                 MainHelpers.displayMenu();
             }
             else { MainHelpers.displayMenu(); }
        }
    }
}
