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

public class TowerTest {

    Tower t;
    Point point1;

    @BeforeEach
    public void setUp() {

        t = new Tower();

        point1 = new Point(0,0);

        List<Point> myPoints = new ArrayList<>();

        myPoints.add(point1);
        myPoints.add(point1);
        myPoints.add(point1);

        t.setLocation(myPoints);

    }

    @Test
    @DisplayName("Get Name")
    public void testGetName() {
        t.setShipName();
        System.out.println("Testing GetName");assertEquals("tower", t.getShipName(),
                "GetName should display ship name");
    }

    @Test
    @DisplayName("Set Name")
    public void testSetName() {

        t.setShipName();
        assertEquals("tower", t.getShipName(), "setName should set name to minesweeper");
    }


    @Test
    @DisplayName("Get health")
    public void testGetHealth() {

        t.setShipHealth(t.location.size());

        System.out.println("Testing GetShipHealth");
        assertEquals(3, t.getShipHealth(),
                "GetHealth should return the ship's health");

    }

    @Test
    @DisplayName("Set health")
    public void testSetHealth() {

        t.setShipHealth(t.location.size());
        System.out.println("Testing GetShipHealth");
        assertEquals(3, t.getShipHealth(),
                "GetHealth should return the ship's health");
    }

    @Test
    @DisplayName("Update health")
    public void testUpdateHealth() {
        System.out.println("Testing updateHealth");

        t.updateHealth(point1);
        assertEquals(2, t.getShipHealth(),
                "updateHealth should update the missiles health.");

    }

    @Test
    @DisplayName("Ship Not Sunken")
    public void TestIsShipSunken() {
        System.out.println("Testing IsShipSunken False");

        assertFalse(t.isShipSunken(),
                "Ship should not be sunken at this point");
    }

    @Test
    @DisplayName("Ship Sunken")
    public void TestShipSunken() {
        System.out.println("Testing IsShipSunken True");

        t.updateHealth(point1);
        t.updateHealth(point1);
        t.updateHealth(point1);

        assertTrue(t.isShipSunken(),
                "Ship should be sunken at this point");
    }


}
