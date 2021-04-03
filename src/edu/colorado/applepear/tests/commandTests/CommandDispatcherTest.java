package edu.colorado.applepear.tests.commandTests;

import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.commandClasses.Command;
import edu.colorado.applepear.classes.commandClasses.CommandDispatcher;
import edu.colorado.applepear.classes.commandClasses.MoveNorth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandDispatcherTest {
    List<Command> undocmd;
    List<Command> redocmd;
    CommandDispatcher cmd;
    GameBoard gb;
    MoveNorth mn;

    @BeforeEach
    public void setUp() throws Exception{
        undocmd = new ArrayList<>();
        redocmd = new ArrayList<>();
        gb = new GameBoard();
        cmd = new CommandDispatcher();

    }

    @Test
    @DisplayName("Testing Undo CommandDispatcher")
    public void testUndo1(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(0,9));
        centerPoint.add(new Point(1,9));
        gb.placeShip(centerPoint);
        mn = new MoveNorth(gb, gb.getShips().get(0));

        cmd.setCommands(mn);
        cmd.undo();

        assertEquals(undocmd.size(), 0, "Size of Undo List should be 0.");

    }
    @Test
    @DisplayName("Testing Redo CommandDispatcher")
    public void testRedo1(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(0,9));
        centerPoint.add(new Point(1,9));
        gb.placeShip(centerPoint);

        mn = new MoveNorth(gb, gb.getShips().get(0));
        cmd.setCommands(mn);
        cmd.undo();
        cmd.redo();
        assertEquals(redocmd.size(), 0, "Size of Undo List should be 1.");
    }

    @Test
    @DisplayName("Testing undoAll CommandDispatcher")
    public void testUndoAll1(){
        List<Point> centerPoint = new ArrayList<>();
        centerPoint.add(new Point(0,9));
        centerPoint.add(new Point(1,9));
        gb.placeShip(centerPoint);

        mn = new MoveNorth(gb, gb.getShips().get(0));
        cmd.setCommands(mn);
        cmd.undoAll();
        assertEquals(undocmd.size(), 0, "Size of Undo List should be 1.");

    }




}
