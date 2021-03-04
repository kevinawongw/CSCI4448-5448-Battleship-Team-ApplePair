package edu.colorado.applepear;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShipTest {
    Ship ship;
    GameBoard gb;
    Player p;
    Point p1, p2, p3, p4;

    @BeforeEach
    public void setShip() throws Exception{
        System.out.println("Before Each Test");
        p = new Player("yubin", 3,3,5);
        gb = new GameBoard(p);
    }

    //Testng Setter
    @Test
    @DisplayName("Displaying ship type")
    public void testSetShipName(){
        System.out.println("Testing SetShip");
        ship = new Ship("minesweeper");
        p1 = new Point(0,0);
        p2 = new Point(0,1);
        List<Point> myPoints = new ArrayList<Point>();
        myPoints.add(p1);
        myPoints.add(p2);
        gb.placeShip(myPoints);
        System.out.println(gb.getShips().get(0).getShipName());
        assertEquals("minesweeper", gb.getShips().get(0).getShipName(),"GetShip should display the minesweeper");
    }

}
