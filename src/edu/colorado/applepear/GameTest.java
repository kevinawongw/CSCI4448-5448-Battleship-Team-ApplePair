package edu.colorado.applepear;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    Player player1, player2;
    GameBoard gb1, gb2;
    Game game;

    @BeforeEach
    public void setUp() throws Exception {
        player1 = new Player("vienna", 3, 3, 5);
        player2 = new Player("kevina", 3, 3, 5);
        gb1 = new GameBoard(player1);
        gb2 = new GameBoard(player2);
        game = new Game(player1, player2, gb1, gb2);
    }

    @Test
    @DisplayName("if updateMap and hit a ship")
    public void testUpdateMap1() {
        List<Point> myPoint= null;
        myPoint.add(new Point(0,0));
        gb1.placeShip(myPoint);
        assertTrue(game.updateMap(gb2,gb1,new Point(0,0)), "updateMap should return true");
    }

    @Test
    @DisplayName("if updateMap and did not hit a ship")
    public void testUpdateMap2() {
            assertFalse(game.updateMap(gb2,gb1,new Point(0,1)), "updateMap should return false");
    }

    @Test
    @DisplayName("if game is not over")
    public void testIsGameOver1() {
            player1.setNumShips(0);
            assertFalse(game.isGameOver(), "isGameOver should return true");
    }

    @Test
    @DisplayName("if game is over")
      public void testIsGameOver() {
            player2.setNumShips(3);
            assertFalse(game.isGameOver(), "isGameOver should return false");
    }

}
