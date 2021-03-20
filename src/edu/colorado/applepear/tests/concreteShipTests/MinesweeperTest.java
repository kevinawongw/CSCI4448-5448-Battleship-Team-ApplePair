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

public class MinesweeperTest {

    Minesweeper m;
    Point point1,point2;

    @BeforeEach
    public void setUp() {

        m = new Minesweeper();

        point1 = new Point(0,0);
        point2 = new Point(0,1);

        List<Point> myPoints = new ArrayList<>();

        myPoints.add(point1);
        myPoints.add(point2);

        m.setLocation(myPoints);

    }

    @Test
    @DisplayName("Get Name")
    public void testGetName() {
        m.setShipName();
        System.out.println("Testing GetName");assertEquals("minesweeper", m.getShipName(),
                "GetName should display ship name");
    }

    @Test
    @DisplayName("Set Name")
    public void testSetName() {

        m.setShipName();
        assertEquals("minesweeper", m.getShipName(), "setName should set name to minesweeper");
    }


    @Test
    @DisplayName("Get health")
    public void testGetHealth() {

        m.setShipHealth(m.location.size());

        System.out.println("Testing GetShipHealth");
        assertEquals(2, m.getShipHealth(),
                "GetHealth should return the ship's health");

    }

    @Test
    @DisplayName("Set health")
    public void testSetHealth() {

        m.setShipHealth(m.location.size());
        System.out.println("Testing GetShipHealth");
        assertEquals(2, m.getShipHealth(),
                "GetHealth should return the ship's health");
    }

    @Test
    @DisplayName("Update health")
    public void testUpdateHealth() {
        System.out.println("Testing updateHealth");

        m.updateHealth(point1);
        assertEquals(1, m.getShipHealth(),
                "updateHealth should update the missiles health.");

    }

    @Test
    @DisplayName("Ship Not Sunken")
    public void TestIsShipSunken() {
        System.out.println("Testing IsShipSunken False");

        assertFalse(m.isShipSunken(),
                "Ship should not be sunken at this point");
    }

    @Test
    @DisplayName("Ship Sunken")
    public void TestShipSunken() {
        System.out.println("Testing IsShipSunken True");

        m.updateHealth(point1);
        m.updateHealth(point2);

        assertTrue(m.isShipSunken(),
                "Ship should be sunken at this point");
    }


}
