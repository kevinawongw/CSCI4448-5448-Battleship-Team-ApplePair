package edu.colorado.applepear.classes.main;
import edu.colorado.applepear.classes.Player;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainHelpers {

    /**
     * Helper Function - displayMenu - Kevina
     * Prints Menu for Main
     */
    public static void displayMenu() {
        System.out.println("\n\n ========== Battleship Menu ========== \n");
        System.out.println("Please pick a menu option");
        System.out.println("1. Choose Coordinates to attack");
        System.out.println("2. Move a Ship");
        System.out.println("3. View Current Map");
        System.out.println("4. Check Player Inventory");
        System.out.println("5. Help & Instructions");
        System.out.println("6. View My Ships");
        System.out.println("7. Quit >:(");
    }

    /**
     * Helper Function - printInstructions - Kevina
     * Prints Instructions for View
     */
    public static void printInstructions() {
        System.out.println("\n\n ========== Battleship Instructions ========== \n");
        System.out.println("[Goal] : Select Coordinates to take out your opponent's ships!");
        System.out.println("[Missiles] : All Players have unlimited uses of the standard missile that attacks one coordinate! Each player gets 2 \"+\" Missiles and 2 radar missiles.");
        System.out.println("[\"+\" Missile] : Attacks an area in the shape of a \"+\". The coordinate entered will attack that coordinate and the coordinates to the right, left, above, and below it. The player needs a rest turn after using this");
        System.out.println("[Radar Missile] : Scans the coordinate the player selected along with the eight spaces around it. Tells player if a ship is present, but not where.");
        System.out.println("Winner takes down all of their opponents ships! Good Luck!");
    }

    /**
     // Helper Function - collectNames - Kevina
     // @Param: None
     // @Return: List<String> names
     // Prints prompts for name inputs
     // Takes in user input
     // Make list of names.
     */

    /**
     * Helper Function - collectNames - Kevina
     * @return names
     *      // Prints prompts for name inputs
     *      // Takes in user input
     *      // Make and return list of names
     */
    public static List<String> collectNames() {
        List<String> names = new ArrayList<>();
        Scanner myInput = new Scanner(System.in);
        System.out.println("\n\n ========== Welcome to Battleship ========== \n");
        System.out.println("\n Enter Player 1's Name: \n");
        String name1 = myInput.nextLine();
        names.add(name1);
        System.out.println("\n Enter Player 2's Name: \n");
        String name2 = myInput.nextLine();
        names.add(name2);
        return names;
    }

    /**
     * Helper Function - collectAttackPoint - Kevina
     * @return attackPoint
     *      // Prints prompt statements for inputting attack points
     *      // Takes in user input for x-coord and y-coord
     *      // Makes and returns Point
     */
    public static Point collectAttackPoint(){
        Scanner myInput = new Scanner(System.in);

        System.out.println("\n\n+--- Let's Attack! ---+");
        System.out.println("What is the X coordinate for the space you want to attack?");
        int myX = Integer.parseInt(myInput.nextLine());
        System.out.println("What is the Y coordinate for the space you want to attack?");
        int myY = Integer.parseInt(myInput.nextLine());

        return new Point(myX, myY);
    }

    /**
     * Helper Function - collectMissileInput - Kevina
     * Vienna added new missile features
     * @return choice
     *      // Prints prompt statements for missile picks
     *      // Takes in user input item pick
     *      // Makes Int
     */
    public static int collectMissileInput(){
        Scanner myInput = new Scanner(System.in);


        System.out.println("What type of missile would you like to use?");
        System.out.println("1. Regular Missile");
        System.out.println("2. Sonar Pulse  Missile");
        System.out.println("3. Plus Missile");
        System.out.println("4. Space Laser Missile");


        return Integer.parseInt(myInput.nextLine());
    }

    /**
     * Helper Function - collectAttackPoint - Kevina
     * @param curPlayer
     * Print Player's Turn
     */
    public static void displayPlayerTurn(Player curPlayer) {
        System.out.println("\n\n+--- It is " + curPlayer.getName() + "'s turn ---+");
    }

    /**
     * Helper Function - collectAttackPoint - Kevina
     * @param curPlayer
     * Prints Player's inventory
     */
    public static void printInventory(Player curPlayer) {
        System.out.println("\n\n +-----" + curPlayer.getName() + "'s Inventory -----+\n");
        System.out.println("Number of Radar Missiles: " + curPlayer.getSonarPulse());
        System.out.println("Number of Plus Missiles: " + curPlayer.getPlusMissile());
        if (curPlayer.getHasSunkenShip()){
            System.out.println("Sonar Missile Eligible? : Yes");
        }
        else{
            System.out.println("Sonar Missile Eligible? : No, Sink an opponent's ship first!");
        }
    }

    /**
     * Helper Function - collectAttackPoint - Kevina
     * @param opponentPlayer
     * @param index
     * Prints Sunken Ship Message
     */
    public static void printSinkMessage(Player opponentPlayer, int index){
        System.out.println("Nice! You sunk the opponent's " + opponentPlayer.getGb().getShips().get(index).getShipName());
    }

    /**
     * Display Game Over
     * @param curPlayer - Current Player
     * @param opponentPlayer - Opponent Player
     * Displays Winner
     */
    public static void displayGameOver(Player curPlayer, Player opponentPlayer) {
        System.out.println("=== GAME OVER ===");
        System.out.println(curPlayer.getName() + " has no ships remaining!");
        System.out.println("Congratulations " + opponentPlayer.getName() + "!");
    }

    public static void viewAllShips(Player curPlayer) {
        curPlayer.getGb().viewShips();
        curPlayer.getGb().viewUnderwater();
    }

    /**
     * View All Ships As List
     * @param curPlayer - Current Player
     * @return Index of Ship Moved
     */
    public static int viewAllShipsAsList(Player curPlayer){
        Scanner myInput = new Scanner(System.in);
        System.out.println("Which fleet do you want to move? (Input Number) \n");
        int i = 1;
        for (Ship s : curPlayer.getGb().getShips()){
            System.out.println(i + ". " + s.getShipName());
            System.out.println("Coordinates: ");
            for (Point p : s.getLocation()){
                System.out.println("   (" + p.getX() + "," + p.getY() + ")");
            }
        i++;
        }
        return Integer.parseInt(myInput.nextLine()) - 1;
    }


    public static int getMoves(List<String> validMoves) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Which direction do you want to move? (Input Number)");
        int i = 1;
        for (String move : validMoves){
            System.out.println(i + ". " + move);
            i++;
        }

        return Integer.parseInt(myInput.nextLine()) - 1;
    }
}
