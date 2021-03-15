package edu.colorado.applepear.tests;

import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


// Kevina's Tests

public class GameBoardTest {

    GameBoard gb1 = new GameBoard();
    GameBoard gb2 = new GameBoard();
    Point m1, m2, testPoint, testPoint2;

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Before Each Test");
        GameBoard gb1 = new GameBoard();
        GameBoard gb2 = new GameBoard();
    }

    // Place Ship
    @Test
    @DisplayName("Place Ship")
    public void testPlaceShip() {
        m1 = new Point(0, 0);
        m2 = new Point(1, 0);
        List<Point> myPoints = new ArrayList<Point>();
        myPoints.add(m1);
        myPoints.add(m2);
        gb1.placeShip(myPoints);
        System.out.println("Testing Minesweeper Placement");
        assertEquals(1, gb1.getShipMap()[m1.y][m1.x] & gb1.getShipMap()[m2.y][m2.x], "Should correctly place minesweeper on map");
    }

    @Test
    @DisplayName("if updateMap and hit a ship")
    public void testUpdateMap1() {
        List<Point> myPoint = new ArrayList<>();
        myPoint.add(new Point(0,0));
        myPoint.add(new Point(0,1));
        gb2.placeShip(myPoint);
        assertTrue(gb1.updateAttackMap(gb2,new Point(0,0)), "updateMap should return true");
    }

    @Test
    @DisplayName("if updateMap and did not hit a ship")
    public void testUpdateMap2() {
        assertFalse(gb1.updateAttackMap(gb2,new Point(0,1)), "updateMap should return false");
    }
    @Test
    @DisplayName("Finding a ship")
    public void testFindShip() {
        m1 = new Point(0, 0);
        m2 = new Point(1, 0);
        List<Point> myPoints = new ArrayList<Point>();
        myPoints.add(m1);
        myPoints.add(m2);
        gb1.placeShip(myPoints);
        testPoint = new Point(0,0);
        testPoint2 = new Point(6,6);

        assertAll("return a ship if parameter is the location of a ship",
                () -> assertEquals("minesweeper", gb1.findShip(testPoint).getShipName(),
                        "Should return the ship name at that point" ),
                ()-> assertNull(gb1.findShip(testPoint2),
                        "Should return null because no ship is at that point"));
    }

}


