package edu.colorado.applepear;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShipTest {
    private Ship ship;
    private GameBoard gb;
    private Player p;
    private Point p1, p2, p3, p4;

    @BeforeEach
    public void setShip() throws Exception{
        System.out.println("Before Each Test");
        p = new Player("yubin", 3,3,5);
        gb = new GameBoard(p);
    }

    //Testng minesweeper
    @Test
    @DisplayName("Displaying ship type")
    public void testGetMShip(){
        System.out.println("Testing GetMShip");
        ship = new Ship("minesweeper");
        p1 = new Point(1,2);
        p2 = new Point(1,1);
        gb.placeMinesweeper(p1,p2);
        assertEquals("minesweeper", gb.getMinesweeper().getShipType(),"GetMShip should display the minesweeper");
    }

    //Testng Destroyer
    @Test
    @DisplayName("Displaying ship type")
    public void testGetDShip(){
        System.out.println("Testing GetDShip");
        ship = new Ship("destroyer");
        p1 = new Point(2,2);
        p2 = new Point(1,5);
        p3 = new Point(2,3);
        gb.placeDestroyer(p1,p2,p3);
        assertEquals("destroyer", gb.getDestroyer().getShipType(),"GetDShip should display the destroyer");
    }

    //Testng Battleship
    @Test
    @DisplayName("Displaying ship type")
    public void testGetBShip(){
        System.out.println("Testing GetBShip");
        ship = new Ship("battleship");
        p1 = new Point(3,2);
        p2 = new Point(1,4);
        p3 = new Point(3,3);
        p4 = new Point(2,2);
        gb.placeBattleship(p1,p2,p3,p4);
        assertEquals("battleship", gb.getBattleship().getShipType(),"GetBShip should display the battleship");
    }
    //Testng Tower
    @Test
    @DisplayName("Displaying ship type")
    public void testGetTShip(){
        System.out.println("Testing GetTShip");
        ship = new Ship("tower");
        p1 = new Point(0,1);
        gb.placeTower(p1);
        assertEquals("tower", gb.getTower().getShipType(),"GetTShip should display the tower");
    }
    //Testng L-ship
    @Test
    @DisplayName("Displaying ship type")
    public void testGetLShip(){
        System.out.println("Testing GetLShip");
        ship = new Ship("l");
        p1 = new Point(1,3);
        p2 = new Point(0,1);
        p3 = new Point(2,1);
        gb.placeLShip(p1,p2,p3);
        assertEquals("l", gb.getL().getShipType(),"GetLShip should display the L-ship");
    }
}
