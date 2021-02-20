package edu.colorado.applepear;
import java.util.Arrays;
import java.util.Scanner;

// Kevina did this section

import java.util.Scanner;

public class GameBoard {

    // Helpful Variables
    public static final int numX = 10;
    public static final int numY = 10;
    private Player p;
//    private Ship minesweeper = new Ship();
//    private Ship destroyer = new Ship();
//    private Ship battleship = new Ship();
//    private Ship tower = new Ship();
//    private Ship L = new Ship();

    // Initializing Maps:

    // Attack Map: Map reflects what coordinates have been attacked as well as the results of those attacks
    // Note from Kevina: For now, I'm going to make the map 0,1,2 for y/n ship. We can change to string if easier :)
    // 0 - unchecked
    // 1 - checked, no ship
    // 2 - checked, ship found
    public int[][] attackMap;

    // Ship Map: Reflects that player's own ships
    // 0 - Not Present
    // 1 - Present
    private int[][] shipMap;

    // Constructor
    public GameBoard(Player p) {
        this.p = p;
        shipMap = new int[numX][numY];
        attackMap = new int[numX][numY];
//        this.minesweeper = minesweeper;
//        this.destroyer = destroyer;
//        this.battleship = battleship;
//        this.tower = tower;
//        this.L = L;
    }

    // Getters
    public Player getPlayer() {
        return p;
    }

    public int[][] getShipMap() {
        return this.shipMap;
    }


    // Function 2: View Map
    // Param: None
    // Returns: None
    // Prints Map with 0s, Ms, and Hs - representing "Miss" and "Hit"
    public void viewMap() {
        System.out.print("----- " + getPlayer().getName() + "'s Map -----\n\n");

        for (int i = 0; i < numX; i++) {
            System.out.print("  ");

            for (int a = 0; a < 10; a++) {
                if (i == 0) {
                    System.out.print("+—" + a + "—");
                } else {
                    System.out.print("+———");
                }
            }
            System.out.print("+");
            System.out.print("\n");
            System.out.print(i + " | ");

            for (int j = 0; j < numY; j++) {
                if (attackMap[i][j] == 1) {
                    System.out.print("M" + " | ");

                } else if (attackMap[i][j] == 2) {
                    System.out.print("H" + " | ");

                } else {
                    System.out.print(attackMap[i][j] + " | ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("  ");
        for (int a = 0; a < 10; a++) {
            System.out.print("+———");
        }
        System.out.print("+\n\n");
    }


    // Function 3: View Ship Map
    // Param: None
    // Returns: None
    // Prints Map with 0s, 1s
    // Prints where that player's ships are located
    public void viewShips() {
        System.out.print("----- " + getPlayer().getName() + "'s Ships -----\n\n");

        for (int i = 0; i < numX; i++) {
            System.out.print("  ");

            for (int a = 0; a < 10; a++) {
                if (i == 0) {
                    System.out.print("+—" + a + "—");
                } else {
                    System.out.print("+———");
                }
            }
            System.out.print("+");
            System.out.print("\n");
            System.out.print(i + " | ");

            for (int j = 0; j < numY; j++) {
                System.out.print(shipMap[i][j] + " | ");
            }
            System.out.print("\n");
        }
        System.out.print("  ");
        for (int a = 0; a < 10; a++) {
            System.out.print("+———");
        }
        System.out.print("+\n\n");
    }

    // Function 4,5,6,7,8,9: Populate Ships - ShipMap Setter
    // Param: None - takes in terminal input
    // Returns: None - Directly modifies shipMap
    // Pseudocode:
    // For i in numShips (5)
    // Ask user for rotation preference (except for "Tower" and "L")
    // Ask user for top-most/right-most block for ship placement (depending on rotation preference)
    // Check to make sure user input coordinates are unfilled
    // If unfilled (if 0)
    // Fill coordinates in shipMap with 1 to indicate ship presence
    // Repeat with all 5 ships
    // Print Ships

    // --Ships--:
    // Minesweeper (2 blocks)
    // Destroyer (3 blocks)
    // Battleship (4 Blocks)
    // Tower (1 block x 3 hits)
    // L - Ship (3 blocks shaped like "L")

    public void placeMinesweeper() {
        Scanner myInput = new Scanner(System.in);
        String input = null;

        System.out.println("Place Minesweeper (2 blocks wide): ");
        System.out.println("Enter \"1\" or \"2\" \n 1. Horizontal \n 2. Vertical ");
        boolean temp = true;
        while (temp) {
            input = myInput.nextLine();
            if (input.equals("1") | input.equals("2")) {
                temp = false;
            } else {
                System.out.println("Input must be \"1\" or \"2\"! ");
            }
        }
        if (input.equals("1")) {
            System.out.println("Enter the X-coordinate of the right-most block of your ship: ");
            String inputValX = myInput.nextLine();
            System.out.println("Enter the Y-coordinate of the right-most block of your ship: ");
            String inputValY = myInput.nextLine();

            shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] = 1;
            shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 1] = 1;
            //Getting location for Ship class
//            minesweeper.location.add(new Point(Integer.parseInt(inputValY), Integer.parseInt(inputValX)));
//            minesweeper.location.add(new Point(Integer.parseInt(inputValY),Integer.parseInt(inputValX) + 1));
////               System.out.println("Test Code: "+minesweeper.location.size());

            viewShips();


        } else if (input.equals("2")) {
            System.out.println("Enter the X-coordinate of the top-most block of your ship: ");
            String inputValX = myInput.nextLine();
            System.out.println("Enter the Y-coordinate of the top-most block of your ship: ");
            String inputValY = myInput.nextLine();

            shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] = 1;
            shipMap[Integer.parseInt(inputValY) + 1][Integer.parseInt(inputValX)] = 1;
            //Getting location for Ship class

//            minesweeper.location.add(new Point(Integer.parseInt(inputValY), Integer.parseInt(inputValX)));
//            minesweeper.location.add(new Point(Integer.parseInt(inputValY)+1,Integer.parseInt(inputValX)));

            viewShips();

        }
    }

    public void placeDestroyer() {
        Scanner myInput = new Scanner(System.in);
        String input2 = null;
        System.out.println("Enter \"1\" or \"2\" \n 1. Horizontal \n 2. Vertical ");
        System.out.println("Place Destroyer (3 blocks wide): ");
        boolean temp = true;
        while (temp) {
            input2 = myInput.nextLine();
            if (input2.equals("1") | input2.equals("2")) {
                temp = false;
            } else {
                System.out.println("Input must be \"1\" or \"2\"! ");
            }
        }
        if (input2.equals("1")) {
            temp = true;
            while (temp) {
                System.out.println("Enter the X-coordinate of the right-most block of your ship: ");
                String inputValX = myInput.nextLine();
                System.out.println("Enter the Y-coordinate of the right-most block of your ship: ");
                String inputValY = myInput.nextLine();
                boolean criteriaA = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] == 0);
                boolean criteriaB = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 1] == 0);
                boolean criteriaC = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 2] == 0);

                if (criteriaA && criteriaB && criteriaC) {
                    shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] = 1;
                    shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 1] = 1;
                    shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 2] = 1;
                    //Getting location for Ship class
//                    destroyer.location.add(new Point(Integer.parseInt(inputValY),Integer.parseInt(inputValX)));
//                    destroyer.location.add(new Point(Integer.parseInt(inputValY),Integer.parseInt(inputValX) + 1));
//                    destroyer.location.add(new Point(Integer.parseInt(inputValY),Integer.parseInt(inputValX) + 2));
                    temp = false;
                    viewShips();

                } else {
                    System.out.println("You already placed another ship there! Try another location.");
                }

            }
        } else if (input2.equals("2")) {
            temp = true;
            while (temp) {
                System.out.println("Enter the X-coordinate of the top-most block of your ship: ");
                String inputValX = myInput.nextLine();
                System.out.println("Enter the Y-coordinate of the top-most block of your ship: ");
                String inputValY = myInput.nextLine();
                boolean criteriaA = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] == 0);
                boolean criteriaB = (shipMap[Integer.parseInt(inputValY) + 1][Integer.parseInt(inputValX)] == 0);
                boolean criteriaC = (shipMap[Integer.parseInt(inputValY) + 2][Integer.parseInt(inputValX)] == 0);

                if (criteriaA && criteriaB && criteriaC) {
                    shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] = 1;
                    shipMap[Integer.parseInt(inputValY) + 1][Integer.parseInt(inputValX)] = 1;
                    shipMap[Integer.parseInt(inputValY) + 2][Integer.parseInt(inputValX)] = 1;
                    //Getting location for Ship class
//                    destroyer.location.add(new Point(Integer.parseInt(inputValY),Integer.parseInt(inputValX)));
//                    destroyer.location.add(new Point(Integer.parseInt(inputValY) + 1,Integer.parseInt(inputValX) ));
//                    destroyer.location.add(new Point(Integer.parseInt(inputValY) + 2,Integer.parseInt(inputValX)));
                    temp = false;
                    viewShips();

                } else {
                    System.out.println("You already placed another ship there! Try another location.");
                }

            }
        }
    }

    public void placeBattleship() {
        Scanner myInput = new Scanner(System.in);
        String input3 = null;
        System.out.println("Place Battleship (3 blocks wide): ");
        System.out.println("Enter \"1\" or \"2\" \n 1. Horizontal \n 2. Vertical ");

        boolean temp = true;
        while (temp) {
            input3 = myInput.nextLine();
            if (input3.equals("1") | input3.equals("2")) {
                temp = false;
            } else {
                System.out.println("Input must be \"1\" or \"2\"! ");
            }
        }
        if (input3.equals("1")) {
            temp = true;
            while (temp) {
                System.out.println("Enter the X-coordinate of the right-most block of your ship: ");
                String inputValX = myInput.nextLine();
                System.out.println("Enter the Y-coordinate of the right-most block of your ship: ");
                String inputValY = myInput.nextLine();
                boolean criteriaA = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] == 0);
                boolean criteriaB = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 1] == 0);
                boolean criteriaC = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 2] == 0);
                boolean criteriaD = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 3] == 0);

                if (criteriaA && criteriaB && criteriaC && criteriaD) {
                    shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] = 1;
                    shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 1] = 1;
                    shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 2] = 1;
                    shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX) + 3] = 1;

                    //Getting location for Ship class
//                    battleship.location.add(new Point(Integer.parseInt(inputValY),Integer.parseInt(inputValX)));
//                    battleship.location.add(new Point(Integer.parseInt(inputValY),Integer.parseInt(inputValX) + 1));
//                    battleship.location.add(new Point(Integer.parseInt(inputValY),Integer.parseInt(inputValX) + 2));
//                    battleship.location.add(new Point(Integer.parseInt(inputValY),Integer.parseInt(inputValX) + 3));
                    temp = false;
                    viewShips();


                } else {
                    System.out.println("You already placed another ship there! Try another location.");
                }

            }
        } else if (input3.equals("2")) {
            temp = true;

            while (temp) {
                System.out.println("Enter the X-coordinate of the top-most block of your ship: ");
                String inputValX = myInput.nextLine();
                System.out.println("Enter the Y-coordinate of the top-most block of your ship: ");
                String inputValY = myInput.nextLine();
                boolean criteriaA = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] == 0);
                boolean criteriaB = (shipMap[Integer.parseInt(inputValY) + 1][Integer.parseInt(inputValX)] == 0);
                boolean criteriaC = (shipMap[Integer.parseInt(inputValY) + 2][Integer.parseInt(inputValX)] == 0);
                boolean criteriaD = (shipMap[Integer.parseInt(inputValY) + 3][Integer.parseInt(inputValX)] == 0);

                if (criteriaA && criteriaB && criteriaC && criteriaD) {
                    shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] = 1;
                    shipMap[Integer.parseInt(inputValY) + 1][Integer.parseInt(inputValX)] = 1;
                    shipMap[Integer.parseInt(inputValY) + 2][Integer.parseInt(inputValX)] = 1;
                    shipMap[Integer.parseInt(inputValY) + 3][Integer.parseInt(inputValX)] = 1;

                    //Getting location for Ship class
//                    battleship.location.add(new Point(Integer.parseInt(inputValY),Integer.parseInt(inputValX)));
//                    battleship.location.add(new Point(Integer.parseInt(inputValY) + 1,Integer.parseInt(inputValX) ));
//                    battleship.location.add(new Point(Integer.parseInt(inputValY) + 2,Integer.parseInt(inputValX)));
//                    battleship.location.add(new Point(Integer.parseInt(inputValY) + 3,Integer.parseInt(inputValX)));
                    viewShips();
                    temp = false;
                } else {
                    System.out.println("You already placed another ship there! Try another location.");
                }

            }

        }

    }

    public void placeTower() {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Place Tower (1): ");
        boolean temp = true;
        while (temp) {
            System.out.println("Enter the X-coordinate of the ship: ");
            String inputValX = myInput.nextLine();
            System.out.println("Enter the Y-coordinate of the ship: ");
            String inputValY = myInput.nextLine();
            boolean criteriaA = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] == 0);

            if (criteriaA) {
                shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] = 1;
                //Getting location for Ship class
//                tower.location.add(new Point(Integer.parseInt(inputValY),Integer.parseInt(inputValX)));
                temp = false;
                viewShips();

            } else {
                System.out.println("You already placed another ship there! Try another location.");
            }
        }
    }

    public void placeLShip() {
        Scanner myInput = new Scanner(System.in);

        System.out.println("Place L-Ship (3 blocks is L shape): ");
        boolean temp = true;
        while (temp) {
            System.out.println("Enter the X-coordinate of the top left-most block of your ship: ");
            String inputValX = myInput.nextLine();
            System.out.println("Enter the Y-coordinate of the top left-most block of your ship: ");
            String inputValY = myInput.nextLine();
            boolean criteriaA = (shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] == 0);
            boolean criteriaB = (shipMap[Integer.parseInt(inputValY) + 1][Integer.parseInt(inputValX)] == 0);
            boolean criteriaC = (shipMap[Integer.parseInt(inputValY) + 1][Integer.parseInt(inputValX) + 1] == 0);

            if (criteriaA && criteriaB && criteriaC) {
                shipMap[Integer.parseInt(inputValY)][Integer.parseInt(inputValX)] = 1;
                shipMap[Integer.parseInt(inputValY) + 1][Integer.parseInt(inputValX)] = 1;
                shipMap[Integer.parseInt(inputValY) + 1][Integer.parseInt(inputValX) + 1] = 1;
                //Getting location for Ship class
//                L.location.add(new Point(Integer.parseInt(inputValY),Integer.parseInt(inputValX)));
//                L.location.add(new Point(Integer.parseInt(inputValY+1),Integer.parseInt(inputValX)));
//                L.location.add(new Point(Integer.parseInt(inputValY+1),Integer.parseInt(inputValX) + 1));
                temp = false;
                viewShips();

            } else {
                System.out.println("You already placed another ship there! Try another location.");
            }
        }
    }

    public void populateShipMap() {
        placeMinesweeper();
//        placeDestroyer();
//        placeBattleship();
//        placeTower();
//        placeLShip();
        viewShips();
    }
}


