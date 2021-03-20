package edu.colorado.applepear.tests;

import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CaptainsQuartersTest {

    GameBoard gb1;
    Point m1, m2;
    List<Point> myPoints;

    @BeforeEach
    public void setCapQ() throws Exception{
        System.out.println("Before Each Test");
        gb1 = new GameBoard();
        myPoints = new ArrayList<Point>();
        m1 = new Point(0, 0);
        m2 = new Point(0,1 );
        myPoints.add(m1);
        myPoints.add(m2);
        gb1.placeShip(myPoints);
        gb1.getShips().get(0).setCaptainsQuarters();
    }

    @Test
    @DisplayName("Testing settingCaptainsQuarters")
    public void testCapQ() {
        assertAll("Should appropriately set the captain's quarters",
                () -> assertEquals(gb1.getShips().get(0).getCaptainsQuarters().getHealth(), 1,
                        "Should return 1 - the health of a minesweeper's captain's quarters"),
                () -> assertEquals(gb1.getShips().get(0).getCaptainsQuarters().getLocation().getX(), 0,
                        "Should return 0 - the location is (0,0)"),
                () -> assertEquals(gb1.getShips().get(0).getCaptainsQuarters().getLocation().getY(), 0,
                        "Should return 0 - the location is (0,0)"));
    }
}
