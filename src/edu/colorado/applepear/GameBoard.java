package edu.colorado.applepear;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

// Kevina did this section


public class GameBoard {

    // Helpful Variables
    public static final int numX = 10;
    public static final int numY = 10;
    private Player p;
    private Ship minesweeper = new Ship("minesweeper");
    private Ship destroyer = new Ship("destroyer");
    private Ship battleship = new Ship("battleship");
    private Ship tower = new Ship("tower");
    private Ship L = new Ship("l");

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

    public int[][] getAttackMap() {
        return this.attackMap;
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

    private void placeMinesweeper(Point p1, Point p2) {
        shipMap[p1.y][p1.x] = 1;
        shipMap[p2.y][p2.x] = 1;
        //Getting location for Ship class
        minesweeper.location.add(p1);
        minesweeper.location.add(p2);
    }

    private List<Point> minesweeperInput(){
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

            Point p1 = new Point(Integer.parseInt(inputValX),Integer.parseInt(inputValY));
            Point p2 = new Point(Integer.parseInt(inputValX) + 1,Integer.parseInt(inputValY));

            return Arrays.asList(p1,p2);


        } else if (input.equals("2")) {
            System.out.println("Enter the X-coordinate of the top-most block of your ship: ");
            String inputValX = myInput.nextLine();
            System.out.println("Enter the Y-coordinate of the top-most block of your ship: ");
            String inputValY = myInput.nextLine();

            Point p1 = new Point(Integer.parseInt(inputValX),Integer.parseInt(inputValY));
            Point p2 = new Point(Integer.parseInt(inputValX),Integer.parseInt(inputValY) + 1);

            return Arrays.asList(p1,p2);
        }
        return null;
    }

    public void placeDestroyer(Point p1, Point p2, Point p3){
        shipMap[p1.y][p1.x] = 1;
        shipMap[p2.y][p2.x] = 1;
        shipMap[p3.y][p3.x] = 1;

        destroyer.location.add(p1);
        destroyer.location.add(p2);
        destroyer.location.add(p3);

    }

    private List<Point> destroyerInput(){
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
                    Point p1 = new Point(Integer.parseInt(inputValX),Integer.parseInt(inputValY));
                    Point p2 = new Point(Integer.parseInt(inputValX) + 1,Integer.parseInt(inputValY));
                    Point p3 = new Point(Integer.parseInt(inputValX) + 2, Integer.parseInt(inputValY));
                    temp = false;
                    return Arrays.asList(p1,p2,p3);
                }
                else {
                    System.out.println("You already placed another ship there! Try another location.");
                    temp = true;
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
                    Point p1 = new Point (Integer.parseInt(inputValX), Integer.parseInt(inputValY));
                    Point p2 = new Point (Integer.parseInt(inputValX), Integer.parseInt(inputValY) + 1);
                    Point p3 = new Point (Integer.parseInt(inputValX), Integer.parseInt(inputValY) + 2);
                    temp = false;
                    return Arrays.asList(p1,p2,p3);
                }
                else {
                    System.out.println("You already placed another ship there! Try another location.");
                    temp = true;
                }
            }
        }
        return null;
    }


    private void placeBattleship(Point p1, Point p2, Point p3, Point p4) {
        shipMap[p1.y][p1.x] = 1;
        shipMap[p2.y][p2.x] = 1;
        shipMap[p3.y][p3.x] = 1;
        shipMap[p4.y][p4.x] = 1;

        battleship.location.add(new Point(p1.x ,p1.y));
        battleship.location.add(new Point(p2.x ,p2.y));
        battleship.location.add(new Point(p3.x ,p3.y));
        battleship.location.add(new Point(p4.x ,p4.y));
    }

    private List<Point> battleshipInput(){
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
                    int x1 = Integer.parseInt(inputValX);
                    int y1 = Integer.parseInt(inputValY);
                    Point p1 = new Point (x1,y1);
                    int x2 = Integer.parseInt(inputValX) + 1;
                    int y2 = Integer.parseInt(inputValY);
                    Point p2 = new Point (x2,y2);
                    int x3 = Integer.parseInt(inputValX) + 2;
                    int y3 = Integer.parseInt(inputValY);
                    Point p3 = new Point (x3,y3);
                    int x4 = Integer.parseInt(inputValX) + 3;
                    int y4 = Integer.parseInt(inputValY);
                    Point p4 = new Point (x4,y4);
                    temp = false;
                    return Arrays.asList(p1,p2,p3,p4);


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
                    int x1 = Integer.parseInt(inputValX);
                    int y1 = Integer.parseInt(inputValY);
                    Point p1 = new Point (x1,y1);

                    int x2 = Integer.parseInt(inputValX);
                    int y2 = Integer.parseInt(inputValY) + 1;
                    Point p2 = new Point (x2,y2);

                    int x3 = Integer.parseInt(inputValX);
                    int y3 = Integer.parseInt(inputValY) + 2;
                    Point p3 = new Point (x3,y3);

                    int x4 = Integer.parseInt(inputValX);
                    int y4 = Integer.parseInt(inputValY) + 3;
                    Point p4 = new Point (x4,y4);

                    temp = false;
                    return Arrays.asList(p1,p2,p3,p4);

                } else {
                    System.out.println("You already placed another ship there! Try another location.");
                }

            }

        }
        return null;
    }



    private void placeTower(Point p1) {
        shipMap[p1.y][p1.x] = 1;

        tower.location.add(p1);
    }

    private List<Point> towerInput() {
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
                int x1 = Integer.parseInt(inputValX);
                int y1 = Integer.parseInt(inputValY);
                Point p1 = new Point(x1,y1);
                temp = false;
                return Arrays.asList(p1);

            }

            else {
                System.out.println("You already placed another ship there! Try another location.");
            }
        }
        return null;
    }

    private void placeLShip(Point p1, Point p2, Point p3) {

        shipMap[p1.y][p1.x] = 1;
        shipMap[p2.y][p2.x] = 1;
        shipMap[p3.y][p3.x] = 1;
        L.location.add(p1);
        L.location.add(p2);
        L.location.add(p3);

    }

    public List<Point> lInput() {
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
                int x1 = Integer.parseInt(inputValX);
                int y1 = Integer.parseInt(inputValY);
                Point p1 = new Point(x1,y1);
                int x2 = Integer.parseInt(inputValX);
                int y2 = Integer.parseInt(inputValY) + 1;
                Point p2 = new Point(x2,y2);
                int x3 =Integer.parseInt(inputValX) + 1;
                int y3 = Integer.parseInt(inputValY) + 1;
                Point p3 = new Point(x3,y3);

                temp = false;
                return Arrays.asList(p1,p2,p3);
            }
            else {
                System.out.println("You already placed another ship there! Try another location.");
            }
        }
        return null;
    }

    public void populateShipMap(){
        List<Point> minesweeperCoords = minesweeperInput();
        placeMinesweeper(minesweeperCoords.get(0), minesweeperCoords.get(1));
        viewShips();

        List<Point> destroyerCoords = destroyerInput();
        placeDestroyer(destroyerCoords.get(0), destroyerCoords.get(1), destroyerCoords.get(2));
        viewShips();

        List<Point> battleshipCoords = battleshipInput();
        placeBattleship(battleshipCoords.get(0), battleshipCoords.get(1), battleshipCoords.get(2), battleshipCoords.get(3));
        viewShips();

        List<Point> towerCoords = towerInput();
        placeTower(towerCoords.get(0));
        viewShips();

        List<Point> lCoords = lInput();
        placeDestroyer(lCoords.get(0), lCoords.get(1), lCoords.get(2));
        viewShips();
    }
}


