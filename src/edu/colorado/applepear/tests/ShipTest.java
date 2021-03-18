package edu.colorado.applepear.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Player;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.concreteShips.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShipTest {
    Minesweeper m;
    Destroyer d;
    LShip ls;
    Tower t;
    Battleship b;

    GameBoard gb;


    @BeforeEach
    public void setShip() throws Exception{
        System.out.println("Before Each Test");
        p = new Player(gb);
        gb = new GameBoard();
    }

    //Testng Setter
    @Test
    @DisplayName("Displaying ship type")
    public void testSetShipName(){
        System.out.println("Testing SetShip");
        ship = new ShipRem();
        p1 = new Point(0,0);
        p2 = new Point(0,1);
        List<Point> myPoints = new ArrayList<Point>();
        myPoints.add(p1);
        myPoints.add(p2);
        gb.placeShip(myPoints);
        System.out.println(gb.getShips().get(0).getShipName());
        assertEquals("minesweeper", gb.getShips().get(0).getShipName(),"setShip should display the minesweeper");
    }

    @Test
    @DisplayName("Displaying ship type")
    public void testGetShipName(){
        System.out.println("Testing getShip");
        ship = new ShipRem();
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
