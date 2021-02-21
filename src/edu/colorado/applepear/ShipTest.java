package edu.colorado.applepear;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShipTest {
    private Ship ship;
    private GameBoard gb;
    private Player p;
    private Point p1;
    private Point p2;

    @BeforeEach
    public void setShip() throws Exception{
        System.out.println("Before Each Test");
        ship = new Ship("minesweeper");
        p = new Player("yubin", 3,3,5);
        gb = new GameBoard(p);
        p1 = new Point(1,2);
        p2 = new Point(1,1);
        gb.placeMinesweeper(p1,p2);
    }

    @Test
    @DisplayName("Displaying ship type")
    public void testGetShip(){
        System.out.println("Testing GetShip");
//        assertEquals("minesweeper",gb.minesweeper.getShipType(),"GetShip should display the minesweeper");
    }
}
