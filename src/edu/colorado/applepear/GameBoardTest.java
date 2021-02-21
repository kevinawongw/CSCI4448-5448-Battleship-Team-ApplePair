package edu.colorado.applepear;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


// Kevina's Tests

public class GameBoardTest {

    private Player player1;
    private GameBoard gameBoard;
    private Point m1, m2, d1, d2, d3, b1, b2, b3, b4, t1, l1, l2, l3;


    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Before Each Test");
        player1 = new Player("kevina", 3, 3, 5);
        gameBoard = new GameBoard(player1);
    }

    // placeMinesweeper()
    @Test
    @DisplayName("Place Minesweeper")
    public void testPlaceMinesweeper() {
        m1 = new Point(0,0);
        m2 = new Point(1,0);
        gameBoard.placeMinesweeper(m1, m2);
        System.out.println("Testing Minesweeper Placement");
        assertEquals(1, gameBoard.getShipMap()[m1.y][m1.x] & gameBoard.getShipMap()[m2.y][m2.x], "Should correctly place minesweeper on map");
    }

    // placeDestroyer()
    @Test
    @DisplayName("Place Destroyer")
    public void testPlaceDestroyer() {
        d1 = new Point(0,1);
        d2 = new Point(1,1);
        d3 = new Point(2,1);
        gameBoard.placeDestroyer(d1, d2, d3);
        System.out.println("Testing Minesweeper Placement");
        assertEquals(1, gameBoard.getShipMap()[d1.y][d1.x] & gameBoard.getShipMap()[d2.y][d2.x] & gameBoard.getShipMap()[d3.y][d3.x], "Should correctly place minesweeper on map");
    }

    // placeBattleShip()
    @Test
    @DisplayName("Place Battleship")
    public void testPlaceBattleship() {
        b1 = new Point(9,9);
        b2 = new Point(8,9);
        b3 = new Point(7,9);
        b4 = new Point(6,9);
        gameBoard.placeBattleship(b1, b2, b3, b4);
        System.out.println("Testing Minesweeper Placement");
        assertEquals(1, gameBoard.getShipMap()[b1.y][b1.x] & gameBoard.getShipMap()[b2.y][b2.x] & gameBoard.getShipMap()[b3.y][b3.x] & gameBoard.getShipMap()[b4.y][b4.x], "Should correctly place minesweeper on map");
    }


    // placeTower()
    @Test
    @DisplayName("Place Tower")
    public void testTower(){
        t1 = new Point(3,3);
        gameBoard.placeTower(t1);
        System.out.println("Testing L-ship Placement");
        assertEquals(1, gameBoard.getShipMap()[t1.y][t1.x] , "Should correctly place minesweeper on map");
    }


    // placeL()
    @Test
    @DisplayName("Place L")
    public void testPlaceL(){
        l1 = new Point(5,5);
        l2 = new Point(5,6);
        l3 = new Point(6,7);
        gameBoard.placeLShip(l1, l2, l3);
        System.out.println("Testing L-ship Placement");
        assertEquals(1, gameBoard.getShipMap()[l1.y][l1.x] & gameBoard.getShipMap()[l2.y][l2.x] & gameBoard.getShipMap()[l3.y][l3.x], "Should correctly place minesweeper on map");
    }
}
