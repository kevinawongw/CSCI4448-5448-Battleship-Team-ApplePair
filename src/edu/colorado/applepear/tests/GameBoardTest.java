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
        assertEquals(gb1.getShipMap()[m1.getY()][m1.getX()], 0,"Ship Map at the location should equal 1");
    }

    @Test
    @DisplayName("Test identifyShip")
    public void testIdentifyShip(){
        gb1.placeShip(myPoints);
        assertEquals(gb1.identifyShip(myPoints.get(0)).getShipName(), "minesweeper","minesweeper is at this location");
    }

}


