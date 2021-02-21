package edu.colorado.applepear;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameBoardTest {

    private Player player1;
    private GameBoard gameBoard;
    private Point p1;
    private Point p2;


    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Before Each Test");
        player1 = new Player("kevina", 3, 3, 5);
        gameBoard = new GameBoard(player1);
        p1 = new Point(0,0);
        p2 = new Point(0,1);
        gameBoard.placeMinesweeper(p1,p2);
    }

    @Test
    @DisplayName("Place Minesweeper")
    public void testPlaceMineSweeper() {
        System.out.println("Testing Minesweeper Placement");assertEquals(1, gameBoard.getShipMap()[p1.y][p1.x],
                "Should correctly place minesweeper on map");
        assertEquals(1, gameBoard.getShipMap()[p2.y][p2.x],
                "Should correctly place minesweeper on map");
    }

}
//    @Test
//    @DisplayName("Getting number of ships")
//    public void testGetNumShips() {
//        System.out.println("Testing GetNumShips");
//        assertEquals(5, player1.getNumShips(),
//                "GetNumShips should give the number of ships");
//    }
//    @Test
//    @DisplayName("Getting number of missiles")
//    public void testGetNumRadarMissiles() {
//        System.out.println("Testing GetRadarMissiles");
//        assertEquals(3, player1.getRadarMissile(),
//                "GetRadarMissile should give the player's number of radar missiles");
//
//    }
//    @Test
//    public void testGetNumPlusMissiles() {
//        System.out.println("Testing getPlusMissiles");
//        assertEquals(3, player1.getPlusMissile(),
//                "GetPlusMissile should give the player's number of Plus missiles");
//
//    }
//}