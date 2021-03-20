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
    Point m1, m2;

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
    @DisplayName("Testing Possible Moves - Top Left")
    public void testPossibleMoves(){
        gb1.placeShip(myPoints);
        System.out.println(gb1.getPossibleMoveLocations(gb1.getShips().get(0)));
        assertEquals(gb1.getPossibleMoveLocations(gb1.getShips().get(0)).size(), 2, "There are two possible moves at (0,0)");
    }

    @Test
    @DisplayName("Testing Possible Moves - All")
    public void testPossibleMoves2(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(3,3));
        centerPoint.add(new Point(3,4));

        gb1.placeShip(centerPoint);
        System.out.println(gb1.getPossibleMoveLocations(gb1.getShips().get(0)));
        assertEquals(gb1.getPossibleMoveLocations(gb1.getShips().get(0)).size(), 4, "There are two possible moves at (3,3)");
    }

    @Test
    @DisplayName("Testing Possible Moves - Left")
    public void testPossibleMoves3(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(0,1));
        centerPoint.add(new Point(0,2));

        gb1.placeShip(centerPoint);
        System.out.println(gb1.getPossibleMoveLocations(gb1.getShips().get(0)));
        assertEquals(gb1.getPossibleMoveLocations(gb1.getShips().get(0)).size(), 3, "There are two possible moves at (0,1)");
    }

    @Test
    @DisplayName("Testing Possible Moves - BottomRight")
    public void testPossibleMoves4(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(8,9));
        centerPoint.add(new Point(9,9));

        gb1.placeShip(centerPoint);
        System.out.println(gb1.getPossibleMoveLocations(gb1.getShips().get(0)));
        assertEquals(gb1.getPossibleMoveLocations(gb1.getShips().get(0)).size(), 2, "There are two possible moves at (9,9)");
    }

    @Test
    @DisplayName("Testing Move Ship South")
    public void testMoveShip1(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(0,0));
        centerPoint.add(new Point(1,0));

        gb1.placeShip(centerPoint);
        gb1.getPossibleMoveLocations(gb1.getShips().get(0));
        gb1.moveShip(gb1.getShips().get(0), "South");
        gb1.viewShips();
        assertEquals(gb1.getShips().get(0).getLocation().get(0).getY(), 1, "The Y value should be 1.");
    }

    @Test
    @DisplayName("Testing Move Ship East")
    public void testMoveShip2(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(0,0));
        centerPoint.add(new Point(0,1));

        gb1.placeShip(centerPoint);
        gb1.getPossibleMoveLocations(gb1.getShips().get(0));
        gb1.moveShip(gb1.getShips().get(0), "East");
        gb1.viewShips();
        assertEquals(gb1.getShips().get(0).getLocation().get(0).getX(), 1, "The Y value should be 8.");
    }

    @Test
    @DisplayName("Testing Move Ship West")
    public void testMoveShip3(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(9,0));
        centerPoint.add(new Point(9,1));

        gb1.placeShip(centerPoint);
        System.out.println(gb1.getPossibleMoveLocations(gb1.getShips().get(0)));
        gb1.moveShip(gb1.getShips().get(0), "West");
        gb1.viewShips();

        assertEquals(gb1.getShips().get(0).getLocation().get(0).getX(), 8, "The Y value should be 1.");
    }

    @Test
    @DisplayName("Testing Move Ship North")
    public void testMoveShip4(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(0,9));
        centerPoint.add(new Point(1,9));

        gb1.placeShip(centerPoint);
        System.out.println(gb1.getPossibleMoveLocations(gb1.getShips().get(0)));
        gb1.moveShip(gb1.getShips().get(0), "North");
        gb1.viewShips();

        assertEquals(gb1.getShips().get(0).getLocation().get(0).getY(), 8, "The Y value should be 1.");
    }
}
