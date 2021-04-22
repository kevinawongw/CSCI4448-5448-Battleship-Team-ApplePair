package edu.colorado.applepear.classes.main;
import edu.colorado.applepear.classes.GUI.PlayerGUI;
import edu.colorado.applepear.classes.Game;
import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Player;
import javax.swing.*;

/**
 * Main for GUI
 */

public class myNewMain {

        static GameBoard p1Map = new GameBoard();
        static GameBoard p2Map = new GameBoard();
        static Player p1 = new Player(p1Map);
        static Player p2 = new Player(p2Map);
        Game myGame = new Game(p1,p2);

    /**
     * Getters
     */
    public static Player getPlayer1(){ return p1; }
    public static Player getPlayer2(){ return p2; }

    /**
     * Main for GUI
     * @param args
     */
    public static void main(String[] args) {

        PlayerGUI myUI = new PlayerGUI();

        JFrame mainframe = new JFrame("Battleship");
        mainframe.setContentPane(myUI.getCards());
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(850, 500);
        mainframe.setVisible(true);
    }

}