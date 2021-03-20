package edu.colorado.applepear.tests;

import edu.colorado.applepear.classes.Game;
import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Player;
import edu.colorado.applepear.classes.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    Player player1, player2;
    Game game;
    List<Point> coordLoc;

    @BeforeEach
    public void setUp() throws Exception {
        GameBoard gb1 = new GameBoard(), gb2 = new GameBoard();
        player1 = new Player(gb1);
        player2 = new Player(gb2);
        game = new Game(player1, player2);
        coordLoc = new ArrayList<Point>();
        coordLoc.add(new Point(0,0));
        coordLoc.add(new Point(0,1));
    }


//    Kevina is working on this

    @Test
    @DisplayName("if game is over (P1)")

    public void testIsGameOver1() {
        player2.getGb().placeShip(coordLoc);
        assertTrue(game.isGameOver(), "isGameOver should return true");
    }

    @Test
    @DisplayName("if game is not over")
      public void testIsGameOverNo() {
        player2.getGb().placeShip(coordLoc);
        player1.getGb().placeShip(coordLoc);
        assertFalse(game.isGameOver(), "isGameOver should return false");
    }

    @Test
    @DisplayName("if game is over (p2")
    public void testIsGameOver2() {
        player1.getGb().placeShip(coordLoc);
        assertTrue(game.isGameOver(), "isGameOver should return True");
    }

    @Test
    @DisplayName("Test HitOrMiss (Hit)")
    public void testHitOrMiss(){
        player1.getGb().placeShip(coordLoc);
        assertTrue(game.hitOrMiss(coordLoc.get(0),player2,player1), "HitOrMiss should return True");
    }

    @Test
    @DisplayName("Test HitOrMiss (Miss)")
    public void testHitOrMiss2(){
        assertFalse(game.hitOrMiss(coordLoc.get(0),player2,player1), "HitOrMiss should return True");
    }

}
