package edu.colorado.applepear;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


// Kevina's Tests

public class GameBoardTest {

    GameBoard gameBoard;
    Point m1, m2, d1, d2, d3, b1, b2, b3, b4, t1, l1, l2, l3;

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Before Each Test");
        Player player1 = new Player("kevina", gameBoard);
        gameBoard = new GameBoard();
    }

    // placeMinesweeper()
    @Test
    @DisplayName("Place Ship")
    public void testPlaceShip() {
        m1 = new Point(0, 0);
        m2 = new Point(1, 0);
        List<Point> myPoints = new ArrayList<Point>();
        myPoints.add(m1);
        myPoints.add(m2);
        gameBoard.placeShip(myPoints);
        System.out.println("Testing Minesweeper Placement");
//        assertEquals((1, gameBoard.getShipMap()[m1.y][m1.x] & gameBoard.getShipMap()[m2.y][m2.x], "Should correctly place minesweeper on map")
//        && (1,gameBoard.getShips().size(), "There should be one ship on the map."));
    }
}


