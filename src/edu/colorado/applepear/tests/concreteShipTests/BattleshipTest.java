package edu.colorado.applepear.tests.concreteShipTests;

import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Player;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.concreteShips.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BattleshipTest {

    Battleship b;
    Point point1, point2, point3, point4;

    @BeforeEach
    public void setUp() {

        b = new Battleship();

        point1 = new Point(0,0);
        point2 = new Point(0,1);
        point3 = new Point(0,2);
        point4 = new Point(0,3);

        List<Point> myPoints = new ArrayList<>();

        myPoints.add(point1);
        myPoints.add(point2);
        myPoints.add(point3);
        myPoints.add(point4);

        b.setLocation(myPoints);

    }

    @Test
    @DisplayName("Get Name")
    public void testGetName() {
        b.setShipName();
        System.out.println("Testing GetName");assertEquals("battleship", b.getShipName(),
                "GetName should display ship name");
    }

    @Test
    @DisplayName("Set Name")
    public void testSetName() {
        b.setShipName();
        assertEquals("battleship", b.getShipName(), "setName should set name to minesweeper");
    }


    @Test
    @DisplayName("Get health")
    public void testGetHealth() {

        b.setShipHealth(b.location.size());

        System.out.println("Testing GetShipHealth");
        assertEquals(4, b.getShipHealth(),
                "GetHealth should return the ship's health");

    }

    @Test
    @DisplayName("Set health")
    public void testSetHealth() {

        b.setShipHealth(b.location.size());
        System.out.println("Testing GetShipHealth");
        assertEquals(4, b.getShipHealth(),
                "GetHealth should return the ship's health");
    }

    @Test
    @DisplayName("Update health")
    public void testUpdateHealth() {
        System.out.println("Testing updateHealth");

        b.updateHealth(point1);
        assertEquals(3, b.getShipHealth(),
                "updateHealth should update the missiles health.");

    }

    @Test
    @DisplayName("Ship Not Sunken")
    public void TestIsShipSunken() {

        System.out.println("Testing IsShipSunken False");
        assertFalse(b.isShipSunken(),
                "Ship should not be sunken at this point");
    }

    @Test
    @DisplayName("Ship Sunken")
    public void TestShipSunken() {
        System.out.println("Testing IsShipSunken True");

        b.updateHealth(point1);
        b.updateHealth(point2);
        b.updateHealth(point3);
        b.updateHealth(point4);


        assertTrue(b.isShipSunken(),
                "Ship should be sunken at this point");
    }


}
