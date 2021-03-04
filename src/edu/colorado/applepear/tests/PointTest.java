package edu.colorado.applepear.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.colorado.applepear.classes.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {
    Point point;

    @BeforeEach
    public void setPoint() throws Exception{
        System.out.println("Before Each Test");
        point= new Point(1,2);
    }

    @Test
    @DisplayName("Setting the point")
    public void testGetPoint(){
        System.out.println("Testing GetPoint");
        assertEquals(1, point.getX(), "GetX should return the valid point X");
        assertEquals(2, point.getY(), "GetY should return the valid point Y");
    }
}
