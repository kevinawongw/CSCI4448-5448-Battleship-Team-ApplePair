package edu.colorado.applepear.tests.GUI;

import edu.colorado.applepear.classes.Player;
import edu.colorado.applepear.classes.main.myNewMain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerGUITest {

    Player p1;
    Player p2;

    @BeforeEach
    public void setUp() {
        p1 = myNewMain.getPlayer1();
        p2 = myNewMain.getPlayer2();
    }

    @Test
    @DisplayName("Displaying player1 name")
    public void testGetName() {
        p1.setName("vienna");
        p2.setName("kevina");
        System.out.println("Testing GetName");assertEquals("vienna", p1.getName(),
                "GetName should display player name");
        assertEquals("kevina", p2.getName(),
                "GetName should display player name");
    }
    @Test
    public void testSetName() {
        p1.setName("sally");
        assertEquals("sally", p1.getName(), "setName should set player 1 name");
    }

}
