package edu.colorado.applepear;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    Player player1;
    Player player2;
    GameBoard g1;
    GameBoard g2;


    @BeforeEach
    public void setUp() {
//        System.out.println("Before Each

        g1 = new GameBoard();
        g2 = new GameBoard();
        player1 = new Player("vienna", g1);
        player2 = new Player("kevina", g2);


        Point point1 = new Point(1,1);
        Point point2 = new Point(1,2);

        List<Point> myPoints = new ArrayList<>();
        myPoints.add(point1);
        myPoints.add(point2);

        player2.setRadarMissile(0);

        g2.placeShip(myPoints);

    }

    @Test
    @DisplayName("Displaying player1 name")
    public void testGetName() {
        System.out.println("Testing GetName");assertEquals("vienna", player1.getName(),
                "GetName should display player name");
        assertEquals("kevina", player2.getName(),
                "GetName should display player name");
    }

    @Test
    @DisplayName("Getting number of missiles")
    public void testGetNumRadarMissiles() {
        System.out.println("Testing GetRadarMissiles");
        assertEquals(3, player1.getRadarMissile(),
                "GetRadarMissile should give the player's number of radar missiles");

    }
    @Test
    public void testGetNumPlusMissiles() {
        System.out.println("Testing getPlusMissiles");
        assertEquals(3, player1.getPlusMissile(),
                "GetPlusMissile should give the player's number of Plus missiles");

    }

    @Test
    public void testGetGB() {
        System.out.println("Testing getGb");
        assertEquals(g1 , player1.getGb(),
                "GetPlusMissile should give the player's number of Plus missiles");

    }

    @Test
    public void useRadarMissileTest(){
        System.out.println("Testing radarMissile");
        Point testPoint = new Point( 1,0);
        Point testPoint2 = new Point( 4,4);

        assertAll("Should return boolean for whether a ship was found using the radar missile",
                () -> assertTrue(player1.useRadarMissile(g2, testPoint),
                "should return true -- radar missile used and found"),
                () -> assertFalse(player2.useRadarMissile(g1, testPoint),
                        "should return false -- player owns no radar missiles"),
                () -> assertFalse(player1.useRadarMissile(g2, testPoint2),
                        "Should return false -- no ships found")

        );


    }

}
