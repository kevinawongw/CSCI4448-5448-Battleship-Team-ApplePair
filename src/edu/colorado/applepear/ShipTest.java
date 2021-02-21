package edu.colorado.applepear;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShipTest {
    private Ship ship;

    @BeforeEach
    public void setShip() throws Exception{
        System.out.println("Before Each Test");
        ship = new Ship("minesweeper");
    }
}
