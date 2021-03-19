package edu.colorado.applepear.classes;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPrint {
    // Helper Function - Display Menu - Kevina
    // Param: None
    // Return: None
    // Prints Menu
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

    // Helper Function - Display Instruction - Kevina
    // Param: None
    // Return: None
    // Prints Instructions
    public static void printInstructions() {
        System.out.println("\n\n ========== Battleship Instructions ========== \n");
        System.out.println("[Goal] : Select Coordinates to take out your opponent's ships!");
        System.out.println("[Missiles] : All Players have unlimited uses of the standard missile that attacks one coordinate! Each player gets 2 \"+\" Missiles and 2 radar missiles.");
        System.out.println("[\"+\" Missile] : Attacks an area in the shape of a \"+\". The coordinate entered will attack that coordinate and the coordinates to the right, left, above, and below it. The player needs a rest turn after using this");
        System.out.println("[Radar Missile] : Scans the coordinate the player selected along with the eight spaces around it. Tells player if a ship is present, but not where.");
        System.out.println("Winner takes down all of their opponents ships! Good Luck!");
    }

    // Helper Function - Get Inputs and Names
    // Param: None
    // Return Names
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

    public static Point collectAttackPoint(){
        Scanner myInput = new Scanner(System.in);

        System.out.println("\n\n+--- Let's Attack! ---+");
        System.out.println("What is the X coordinate for the space you want to attack?");
        int myX = Integer.parseInt(myInput.nextLine());
        System.out.println("What is the Y coordinate for the space you want to attack?");
        int myY = Integer.parseInt(myInput.nextLine());
        Point attackPoint = new Point(myX, myY);

        return attackPoint;
    }

}
