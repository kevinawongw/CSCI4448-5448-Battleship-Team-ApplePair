package edu.colorado.applepear;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Player player1;
    private Player player2;

    @BeforeEach
    public void setUp() throws Exception {
        player1 = new Player("vienna", 3, 3, 5);
        player2 = new Player("kevina", 3, 3, 5);
    }

    @Test
    @DisplayName("Displaying player1 name")
    public void testGetName() {
        assertEquals("vienna", player1.getName(),
                "GetName should display player name");
    }

    @DisplayName("Displaying player2 name")
    public void testGetName2() {
        assertEquals("kevina", player2.getName(),
                "GetName should display player name");
    }

    @DisplayName("Getting number of ships")
    public void testGetNumShips() {
        assertEquals(5, player1.getNumShips(),
                "GetNumShips should give the number of ships");
    }
}
