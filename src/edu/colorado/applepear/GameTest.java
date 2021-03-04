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
        player1 = new Player("vienna", gb1);
        player2 = new Player("kevina", gb2);
        gb1 = new GameBoard();
        gb2 = new GameBoard();
        game = new Game(player1, player2, gb1, gb2);
    }


//    Kevina is working on this

    @Test
    @DisplayName("if game is not over")
    public void testIsGameOver1() {
        assertFalse(game.isGameOver(), "isGameOver should return true");
    }

    @Test
    @DisplayName("if game is over")
      public void testIsGameOver() {
        List<Point> coordLoc = new ArrayList<>();
        coordLoc.add(new Point(0,0));
        coordLoc.add(new Point(0,1));
        player2.getGb().placeShip(coordLoc);
        assertFalse(game.isGameOver(), "isGameOver should return false");
    }

}
