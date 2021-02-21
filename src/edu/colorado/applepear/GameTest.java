package edu.colorado.applepear;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Player player1;
    private Player player2;
    private Gameboard gb1;
    private Gameboard gb2;
    private Game game;

    @BeforeEach
    public void setUp() throws Exception {
        player1 = new Player("vienna", 3, 3, 5);
        player2 = new Player("kevina", 3, 3, 5);
        gb1 = new Gameboard(player1);
        gb2 = new Gameboard(player2);
        game = new Game(player1, player2, gb1, gb2);
    }

    @Test
    @DisplayName("if updateMap and hit a ship")
    public void testUpdateMap1() {
            assertEquals(true, , "updateMap should return true");
    }

    @Test
    @DisplayName("if updateMap and did not hit a ship")
    public void testUpdateMap2() {
            assertEquals(false, , "updateMap should return false");
    }

    @Test
    @DisplayName("if game is not over")
    public void testIsGameOver1() {
            p1.checkLose() = true;
            assertEquals(true, , "isGameOver should return true");
    }

    @Test
    @DisplayName("if game is over")
    public void testIsGameOver(2) {
            assertEquals(false, , "isGameOver should return false");
    }

}
