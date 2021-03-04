package edu.colorado.applepear;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        assertEquals(3, player1.getPlusMissile(),
                "GetPlusMissile should give the player's number of Plus missiles");

    }

    @Test
    public void useRadarMissileTest(){
        System.out.println("Testing radarMissile");
        Point testPoint = new Point( 1,0);
        assertTrue(player1.useRadarMissile(g2, testPoint),
                "radarMissile should return true");


    }

}
