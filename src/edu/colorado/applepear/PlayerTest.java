package edu.colorado.applepear;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {


    private Player player1;
    private Player player2;

    @BeforeEach
    public void setUp() {
        System.out.println("Before Each Test");
        player1 = new Player("vienna", 3, 3, 0);
        player2 = new Player("kevina", 3, 3, 5);
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
    @DisplayName("Getting number of ships")
    public void testGetNumShips() {
        System.out.println("Testing GetNumShips");
        assertEquals(5, player2.getNumShips(),
                "GetNumShips should give the number of ships");
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
    public void checkLose() {
        System.out.println("Testing checkLose");
        assertTrue(player1.checkLose(), "checkLose should return true");

    }
}
