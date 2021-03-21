package edu.colorado.applepear.tests.commandTests;

import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.commandClasses.MoveNorth;
import edu.colorado.applepear.classes.commandClasses.MoveSouth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveSouthTest {
    GameBoard gb;
    MoveSouth ms;

    @BeforeEach
    public void setUp() {
        gb = new GameBoard();

    }
    @Test
    @DisplayName("Testing Move Ship South")
    public void testMoveSouth1(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(0,0));
        centerPoint.add(new Point(1,0));

        gb.placeShip(centerPoint);
        ms = new MoveSouth(gb, gb.getShips().get(0) );
        ms.execute();
        assertEquals(gb.getShips().get(0).getLocation().get(0).getY(), 1, "The Y value should be 1.");
    }
    @Test
    @DisplayName("Testing Move Ship South2")
    public void testMoveSouth2(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(2,5));
        centerPoint.add(new Point(3,5));

        gb.placeShip(centerPoint);
        ms = new MoveSouth(gb, gb.getShips().get(0) );
        ms.execute();
        assertEquals(gb.getShips().get(0).getLocation().get(0).getY(), 6, "The Y value should be 6.");
    }

    @Test
    @DisplayName("Testing undo Ship South1")
    public void testUndoSouth(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(0,0));
        centerPoint.add(new Point(1,0));

        gb.placeShip(centerPoint);
        ms = new MoveSouth(gb, gb.getShips().get(0) );
        ms.execute();
        ms.undo();
        assertEquals(gb.getShips().get(0).getLocation().get(0).getY(), 0, "The Y value should be 0.");
    }
    @Test
    @DisplayName("Testing undo Ship South2")
    public void testUndoSouth2(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(2,5));
        centerPoint.add(new Point(3,5));

        gb.placeShip(centerPoint);
        ms = new MoveSouth(gb, gb.getShips().get(0) );
        ms.execute();
        ms.undo();
        assertEquals(gb.getShips().get(0).getLocation().get(0).getY(), 5, "The Y value should be 5.");
    }
}
