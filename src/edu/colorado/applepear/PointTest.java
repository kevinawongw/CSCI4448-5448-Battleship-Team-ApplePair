package edu.colorado.applepear;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class PointTest {
    private Point point;

    @BeforeEach
    public void setPoint() throws Exception{
        System.out.println("Before Each Test");
        point= new Point(1,2);
    }

    @Test
    @DisplayName("Displaying the point")
    public void testGetPoint(){
        System.out.println("Testing GetPoint");
        assertEquals(1, point.getX(), "GetX should display the valid point X");
        assertEquals(2, point.getY(), "GetY should display the valid point Y");
    }
}