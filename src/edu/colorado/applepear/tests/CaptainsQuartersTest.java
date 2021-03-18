package edu.colorado.applepear.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.colorado.applepear.classes.CaptainsQuarters;
import edu.colorado.applepear.classes.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CaptainsQuartersTest {
    CaptainsQuarters capQ;
    Point newPoint;

    @BeforeEach
    public void setCapQ() throws Exception{
        System.out.println("Before Each Test");
        newPoint = new Point(0, 0);
        capQ = new CaptainsQuarters(1, newPoint);
    }

    @Test
    @DisplayName("Setting the Captain's Quarters")
    public void testCapQ(){
        System.out.println("Testing setting the Captain's Quarters for the minesweeper ship");
        assertEquals(1, capQ.getHealth(), "GetHealth should return the valid health");
        assertEquals(0, capQ.getLocation().getX(), "GetLocation for the x-coordinate should return the valid x-coordinate");
        assertEquals(0, capQ.getLocation().getY(), "GetLocation for the y-coordinate should return the valid y-coordinate");
        assertEquals("minesweeper", capQ.getShipName(), "GetShipName should return the valid ship name");

    }
}
