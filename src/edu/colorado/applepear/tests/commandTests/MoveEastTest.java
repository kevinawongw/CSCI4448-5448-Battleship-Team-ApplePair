package edu.colorado.applepear.tests.commandTests;

import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.commandClasses.MoveEast;
import edu.colorado.applepear.classes.commandClasses.MoveWest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveEastTest {
    GameBoard gb;
    MoveEast me;

    @BeforeEach
    public void setUp() {
        gb = new GameBoard();

    }
    @Test
    @DisplayName("Testing Move Ship East")
    public void testMoveEast1(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(0,0));
        centerPoint.add(new Point(0,1));

        gb.placeShip(centerPoint);
        me = new MoveEast(gb, gb.getShips().get(0) );
        me.execute();
        assertEquals(gb.getShips().get(0).getLocation().get(0).getX(), 1, "The X value should be 1.");
    }
    @Test
    @DisplayName("Testing Move Ship East2")
    public void testMoveEast2(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(2,2));
        centerPoint.add(new Point(2,3));

        gb.placeShip(centerPoint);
        me = new MoveEast(gb, gb.getShips().get(0) );
        me.execute();
        assertEquals(gb.getShips().get(0).getLocation().get(0).getX(), 3, "The X value should be 3.");
    }

    @Test
    @DisplayName("Testing undo Ship East1")
    public void testUndoEast(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(8,0));
        centerPoint.add(new Point(8,1));

        gb.placeShip(centerPoint);
        me = new MoveEast(gb, gb.getShips().get(0) );
        me.execute();
        me.undo();
        assertEquals(gb.getShips().get(0).getLocation().get(0).getX(), 8, "The Y value should be 8.");
    }
    @Test
    @DisplayName("Testing undo Ship East2")
    public void testUndoEast2(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(7,4));
        centerPoint.add(new Point(7,5));

        gb.placeShip(centerPoint);
        me = new MoveEast(gb, gb.getShips().get(0) );
        me.execute();
        me.undo();
        assertEquals(gb.getShips().get(0).getLocation().get(0).getX(), 7, "The Y value should be 7.");
    }

}
