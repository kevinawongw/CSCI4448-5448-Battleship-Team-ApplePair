package edu.colorado.applepear.classes.main;
import edu.colorado.applepear.classes.GUI.PlayerGUI;
import edu.colorado.applepear.classes.Game;
import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Player;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.commandClasses.*;
import javax.swing.*;

class Main2{
    public static void main(String[] args) {

        GameBoard p1Map = new GameBoard();
        GameBoard p2Map = new GameBoard();
        Player p1 = new Player(p1Map);
        Player p2 = new Player(p2Map);
        Game myGame = new Game(p1,p2);
        PlayerGUI myUI = new PlayerGUI(p1,p2);
        p1.setName(myUI.getName1());
        p2.setName(myUI.getName2());


        JFrame mainframe = new JFrame("Battleship");
        mainframe.setContentPane(myUI.getCards());
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(800, 500);
        mainframe.setVisible(true);


        Player curPlayer = p1;
        Player opponentPlayer = p2;
    }

}