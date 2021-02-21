package edu.colorado.applepear;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Player player1;
    private Player player2;
    private GameBoard gb1;
    private GameBoard gb2;
    private Game game;
    private Point point;

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
        System.out.println("Testing testUpdateMap1");

            assertEquals(true, game.updateMap(gb1,gb2,"1","2"), "updateMap should return true");
    }

//    @Test
//    @DisplayName("if updateMap and did not hit a ship")
//    public void testUpdateMap2() {
//            assertEquals(false, game.updateMap(), "updateMap should return false");
//    }
//
//    @Test
//    @DisplayName("if game is not over")
//    public void testIsGameOver1() {
//            p1.checkLose() = true;
//            assertEquals(true, game.isGameOver(), "isGameOver should return true");
//    }
//
//    @Test
//    @DisplayName("if game is over")
//    public void testIsGameOver(2) {
//            assertEquals(false, game.isGameOver(), "isGameOver should return false");
//    }

}
