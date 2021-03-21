package edu.colorado.applepear.tests.commandTests;

import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Player;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;
import edu.colorado.applepear.classes.commandClasses.MoveNorth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveNorthTest {
    GameBoard gb;
    MoveNorth mn;

    @BeforeEach
    public void setUp() {
        gb = new GameBoard();

    }
    @Test
    @DisplayName("Testing Move Ship North")
    public void testMoveNorth1(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(0,9));
        centerPoint.add(new Point(1,9));

        gb.placeShip(centerPoint);
        mn = new MoveNorth(gb, gb.getShips().get(0));
        mn.execute();
        assertEquals(gb.getShips().get(0).getLocation().get(0).getY(), 8, "The Y value should be 8.");
    }
    @Test
    @DisplayName("Testing Move Ship North2")
    public void testMoveNorth2(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(1,1));
        centerPoint.add(new Point(2,1));

        gb.placeShip(centerPoint);
        mn = new MoveNorth(gb, gb.getShips().get(0) );
        mn.execute();
        assertEquals(gb.getShips().get(0).getLocation().get(0).getY(), 0, "The Y value should be 0.");
    }

    @Test
    @DisplayName("Testing undo Ship North1")
    public void testUndoNorth(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(1,1));
        centerPoint.add(new Point(2,1));

        gb.placeShip(centerPoint);
        mn = new MoveNorth(gb, gb.getShips().get(0) );
        mn.execute();
        mn.undo();
        assertEquals(gb.getShips().get(0).getLocation().get(0).getY(), 1, "The Y value should be 1.");
    }
    @Test
    @DisplayName("Testing undo Ship North2")
    public void testUndoNorth2(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(2,5));
        centerPoint.add(new Point(3,5));

        gb.placeShip(centerPoint);
        mn = new MoveNorth(gb, gb.getShips().get(0) );
        mn.execute();
        mn.undo();
        assertEquals(gb.getShips().get(0).getLocation().get(0).getY(), 5, "The Y value should be 5.");
    }

}
