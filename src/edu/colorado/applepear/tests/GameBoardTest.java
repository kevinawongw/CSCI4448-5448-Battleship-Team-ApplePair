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

    GameBoard gb1;
    GameBoard gb2;
    Point m1, m2;
    List<Point> myPoints;

    @BeforeEach
    public void setUp() throws Exception {

        System.out.println("Before Each Test");
        gb1 = new GameBoard();
        gb2 = new GameBoard();
        m1 = new Point(0, 0);
        m2 = new Point(1, 0);
        myPoints = new ArrayList<Point>();
        myPoints.add(m1);
        myPoints.add(m2);
    }

    // Place Ship
    @Test
    @DisplayName("Place Ship")
    public void testPlaceShip() {
        gb1.placeShip(myPoints);
        System.out.println("Testing Minesweeper Placement");
        assertEquals(1, gb1.getShipMap()[m1.getY()][m1.getX()] & gb1.getShipMap()[m2.getY()][m2.getX()], "Should correctly place minesweeper on map");
    }


    @Test
    @DisplayName("if updateMap and hit a ship")
    public void testUpdateAttackMap1() {
        gb2.placeShip(myPoints);
        gb1.updateAttackMap(gb2,m1);
        assertEquals(gb1.getAttackMap()[m1.getY()][m1.getX()], 2, "Attack Map at the location should equal 2");
    }

    @Test
    @DisplayName("if updateMap and did not hit a ship")
    public void testUpdateAttackMap2() {
        gb1.updateAttackMap(gb2,m1);
        assertEquals(gb1.getAttackMap()[m1.getY()][m1.getX()], 1,"Attack Map at the location should equal 1");
    }

    @Test
    @DisplayName("Test placeShip")
    public void testUpdateShipMap(){
        gb1.placeShip(myPoints);
        gb1.updateShipMap();
        assertEquals(gb1.getShipMap()[m1.getY()][m1.getX()], 1,"Ship Map at the location should equal 1");
    }

    @Test
    @DisplayName("Test placeShip")
    public void testUpdateShipMap2(){
        gb1.updateShipMap();
        assertEquals(gb1.getShipMap()[m1.getY()][m1.getX()], 0,"Ship Map at the location should equal 0");
    }

    @Test
    @DisplayName("Test placeSubMarine")
    public void testUpdateShipMap3(){
        Point s1 = new Point(2,0);
        Point s2 = new Point(0,1);
        Point s3 = new Point(1,1);
        Point s4 = new Point(2,1);
        Point s5 = new Point(3,1);
        List<Point> subPoints = new ArrayList<>();
        subPoints.add(s1);
        subPoints.add(s2);
        subPoints.add(s3);
        subPoints.add(s4);
        subPoints.add(s5);
        gb1.placeShip(subPoints);
        System.out.println(gb1.identifyShip(s1));
        gb1.updateUnderwaterMap();
        assertEquals(gb1.getUnderwaterMap()[s1.getY()][s1.getX()], 1,"Underwater Map at the location should equal 1");
    }

    @Test
    @DisplayName("Test identifyShip")
    public void testIdentifyShip(){
        gb1.placeShip(myPoints);
        assertEquals((gb1.identifyShip(myPoints.get(0))), 0,"minesweeper is at this location");
    }

    @Test
    @DisplayName("Test identifyShip (Not Found)")
    public void testIdentifyShip2(){
        gb1.placeShip(myPoints);
        assertEquals(gb1.identifyShip(new Point(5,5)), -1,"there is no ship there");
    }

    @Test
    @DisplayName("Testing Removing Ship")
    public void testUpdateSunkenShp(){
        gb1.placeShip(myPoints);
        int index = gb1.identifyShip(m1);
        gb1.updateSunkenShip(index);
        assertEquals(gb1.getShips().size(), 0 , "There should be no more ships in the ships list.");
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
