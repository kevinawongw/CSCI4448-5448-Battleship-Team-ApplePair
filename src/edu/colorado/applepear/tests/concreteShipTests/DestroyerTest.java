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

public class DestroyerTest {

    Destroyer d;
    Point point1,point2,point3;

    @BeforeEach
    public void setUp() {

        d = new Destroyer();

        point1 = new Point(0,0);
        point2 = new Point(0,1);
        point3 = new Point(0,2);

        List<Point> myPoints = new ArrayList<>();

        myPoints.add(point1);
        myPoints.add(point2);
        myPoints.add(point3);

        d.setLocation(myPoints);

    }

    @Test
    @DisplayName("Get Name")
    public void testGetName() {
        d.setShipName();
        System.out.println("Testing GetName");assertEquals("destroyer", d.getShipName(),
                "GetName should display ship name");
    }

    @Test
    @DisplayName("Set Name")
    public void testSetName() {
        d.setShipName();
        assertEquals("destroyer", d.getShipName(), "setName should set name to minesweeper");
    }


    @Test
    @DisplayName("Get health")
    public void testGetHealth() {

        d.setShipHealth(d.location.size());

        System.out.println("Testing GetShipHealth");
        assertEquals(3, d.getShipHealth(),
                "GetHealth should return the ship's health");

    }

    @Test
    @DisplayName("Set health")
    public void testSetHealth() {

        d.setShipHealth(d.location.size());
        System.out.println("Testing GetShipHealth");
        assertEquals(3, d.getShipHealth(),
                "GetHealth should return the ship's health");
    }

    @Test
    @DisplayName("Update health")
    public void testUpdateHealth() {
        System.out.println("Testing updateHealth");

        d.updateHealth(point1);
        assertEquals(2, d.getShipHealth(),
                "updateHealth should update the missiles health.");

    }

    @Test
    @DisplayName("Ship Not Sunken")
    public void TestIsShipSunken() {

        System.out.println("Testing IsShipSunken False");
        assertFalse(d.isShipSunken(),
                "Ship should not be sunken at this point");
    }

    @Test
    @DisplayName("Ship Sunken")
    public void TestShipSunken() {
        System.out.println("Testing IsShipSunken True");

        d.updateHealth(point1);
        d.updateHealth(point2);
        d.updateHealth(point3);

        assertTrue(d.isShipSunken(),
                "Ship should be sunken at this point");
    }


}
