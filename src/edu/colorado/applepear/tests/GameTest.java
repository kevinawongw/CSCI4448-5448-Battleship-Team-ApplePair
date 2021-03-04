package edu.colorado.applepear.test;

import edu.colorado.applepear.methods.Game;
import edu.colorado.applepear.methods.GameBoard;
import edu.colorado.applepear.methods.Player;
import edu.colorado.applepear.methods.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    Player player1, player2;
    Game game;
    @BeforeEach
    public void setUp() throws Exception {
        GameBoard gb1 = new GameBoard(), gb2 = new GameBoard();
        player1 = new Player(gb1);
        player2 = new Player(gb2);
        game = new Game(player1, player2);
    }


//    Kevina is working on this

    @Test
    @DisplayName("if game is over (P1")

    public void testIsGameOver1() {
        List<Point> coordLoc = new ArrayList<Point>();
        coordLoc.add(new Point(0,0));
        coordLoc.add(new Point(0,1));
        player2.getGb().placeShip(coordLoc);
        assertTrue(game.isGameOver(), "isGameOver should return true");
    }

    @Test
    @DisplayName("if game is not over")
      public void testIsGameOverNo() {
        List<Point> coordLoc = new ArrayList<Point>();
        coordLoc.add(new Point(0,0));
        coordLoc.add(new Point(0,1));
        player2.getGb().placeShip(coordLoc);
        player1.getGb().placeShip(coordLoc);
        assertFalse(game.isGameOver(), "isGameOver should return false");
    }

    @Test
    @DisplayName("if game is over (p2")
    public void testIsGameOver2() {
        List<Point> coordLoc = new ArrayList<Point>();
        coordLoc.add(new Point(0,0));
        coordLoc.add(new Point(0,1));
        player1.getGb().placeShip(coordLoc);
        assertTrue(game.isGameOver(), "isGameOver should return True");
    }

}
