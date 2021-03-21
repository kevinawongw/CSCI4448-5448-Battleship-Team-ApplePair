package edu.colorado.applepear.tests.commandTests;

import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.commandClasses.MoveNorth;
import edu.colorado.applepear.classes.commandClasses.MoveWest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveWestTest {
    GameBoard gb;
    MoveWest mw;

    @BeforeEach
    public void setUp() {
        gb = new GameBoard();

    }
    @Test
    @DisplayName("Testing Move Ship West")
    public void testMoveWest1(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(9,0));
        centerPoint.add(new Point(9,1));

        gb.placeShip(centerPoint);
        mw = new MoveWest(gb, gb.getShips().get(0) );
        mw.execute();
        assertEquals(gb.getShips().get(0).getLocation().get(0).getX(), 8, "The X value should be 8.");
    }
    @Test
    @DisplayName("Testing Move Ship West2")
    public void testMoveWest2(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(7,2));
        centerPoint.add(new Point(7,3));

        gb.placeShip(centerPoint);
        mw = new MoveWest(gb, gb.getShips().get(0) );
        mw.execute();
        assertEquals(gb.getShips().get(0).getLocation().get(0).getX(), 6, "The X value should be 6.");
    }

    @Test
    @DisplayName("Testing undo Ship West1")
    public void testUndoWest(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(9,0));
        centerPoint.add(new Point(9,1));

        gb.placeShip(centerPoint);
        mw = new MoveWest(gb, gb.getShips().get(0) );
        mw.execute();
        mw.undo();
        assertEquals(gb.getShips().get(0).getLocation().get(0).getX(), 9, "The Y value should be 9.");
    }
    @Test
    @DisplayName("Testing undo Ship West2")
    public void testUndoWest2(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(7,4));
        centerPoint.add(new Point(7,5));

        gb.placeShip(centerPoint);
        mw = new MoveWest(gb, gb.getShips().get(0) );
        mw.execute();
        mw.undo();
        assertEquals(gb.getShips().get(0).getLocation().get(0).getX(), 7, "The Y value should be 7.");
    }

}
