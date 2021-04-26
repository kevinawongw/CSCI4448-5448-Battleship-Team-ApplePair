package edu.colorado.applepear.classes.GUI;

import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Player;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;
import edu.colorado.applepear.classes.concreteShips.Battleship;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

public class viewShip {
    private JPanel viewScreen;
    private JPanel grid;
    JButton returnButton;
    Color navy = new Color(68, 88, 115);
    Color lightBlue = new Color(226, 233, 238);
    Color yellow = new Color(255,205,105);
    Color red = new Color(168,50,50);

    public viewShip(Player currPlayer, Player oppPlayer, boolean next){
        viewScreen = new JPanel(new BorderLayout(0,0));
        viewScreen.setBackground(Color.white);
//        List<Ship> allShips = currPlayer.getGb().getShips();
        createViewMap(10,10, currPlayer);
        viewScreen.add(grid);

        JPanel sideBar = new JPanel();
        sideBar.setLayout(new BoxLayout(sideBar,BoxLayout.Y_AXIS));
        viewScreen.add(sideBar, BorderLayout.EAST);
        sideBar.setBackground(lightBlue);

        JLabel titleLabel = new JLabel();
        String title = currPlayer.getName() + "'s Ship";
        titleLabel.setText(title);
        titleLabel.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
        titleLabel.setForeground(navy);
        titleLabel.setBorder(new EmptyBorder(20,0,0,0));
        sideBar.add(titleLabel,BorderLayout.CENTER);

        JPanel menuPanel = new JPanel(new GridLayout(0,1));
        sideBar.add(menuPanel, BorderLayout.PAGE_END);
        menuPanel.setBackground(lightBlue);
        menuPanel.setPreferredSize(new Dimension(250, 300));
        menuPanel.setBorder(new EmptyBorder(70,50,70,50));

//        /* View Ship Button Field */
//        JButton battleship = new JButton("Battleship");
//        battleship.setBackground(navy);
//        battleship.setForeground(lightBlue);
//        battleship.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
//        battleship.setVisible(true);
//        menuPanel.add(battleship, BorderLayout.CENTER);
//        menuPanel.add(new JLabel(" "),"span, grow");
//
//        JButton destroyer = new JButton("Destroyer");
//        destroyer.setBackground(navy);
//        destroyer.setForeground(lightBlue);
//        destroyer.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
//        destroyer.setPreferredSize(new Dimension(3,1));
//        destroyer.setVisible(true);
//        menuPanel.add(destroyer, BorderLayout.CENTER);
//        menuPanel.add(new JLabel(" "),"span, grow");
//
//        JButton Lship = new JButton("L-Ship");
//        Lship.setBackground(navy);
//        Lship.setForeground(lightBlue);
//        Lship.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
//        Lship.setPreferredSize(new Dimension(3,1));
//        Lship.setVisible(true);
//        menuPanel.add(Lship, BorderLayout.CENTER);
//        menuPanel.add(new JLabel(" "),"span, grow");
//
//        JButton minesweeper = new JButton("Minesweeper");
//        minesweeper.setBackground(navy);
//        minesweeper.setForeground(lightBlue);
//        minesweeper.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
//        minesweeper.setPreferredSize(new Dimension(3,1));
//        minesweeper.setVisible(true);
//        menuPanel.add(minesweeper, BorderLayout.CENTER);
//        menuPanel.add(new JLabel(" "),"span, grow");
//
//        JButton tower = new JButton("Tower");
//        tower.setBackground(navy);
//        tower.setForeground(lightBlue);
//        tower.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
//        tower.setPreferredSize(new Dimension(3,1));
//        tower.setVisible(true);
//        menuPanel.add(tower, BorderLayout.CENTER);
//        menuPanel.add(new JLabel(" "),"span, grow");

        returnButton = new JButton("Return to Menu");
        returnButton.setBackground(navy);
        returnButton.setForeground(lightBlue);
        returnButton.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        returnButton.setPreferredSize(new Dimension(3,1));
        returnButton.setVisible(true);
        menuPanel.add(returnButton, BorderLayout.PAGE_START);

        returnButton.addActionListener(e -> {
            JPanel card8 = new menu(currPlayer,oppPlayer).getMenuScreen();
            PlayerGUI.cards.add(card8, "currPView");
            CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
            cl.show(PlayerGUI.cards, "currPView");

        });
    }

    public JPanel getViewScreen(){ return viewScreen;}


    public void createViewMap(int maxX, int maxY, @NotNull Player currPlayer){
        grid = new JPanel(new GridLayout(maxX,maxY,1,1));
        grid.setBorder(new EmptyBorder(30,40,40,40));
        grid.setBackground(Color.white);
        List<Point> bigList = new ArrayList<>();


        for (Ship eachShip: currPlayer.getGb().getShips()){
            List<Point> eachShipPoint = eachShip.getLocation();

            for (Point eachPoint: eachShipPoint){
                bigList.add(eachPoint);
            }
        }

        for(int i=0; i< maxX; i++){
            for(int j=0; j< maxY; j++){
                JPanel newP = new JPanel();
                    for (Point each: bigList){
                        if (each.getX() == i && each.getY()==j){
                            newP.setBackground(yellow);
                        }
                    }
                String coord = i + ","+j;
                grid.add(coord, newP);
            }
        }
    }

    public JPanel getViewUi() {
        return viewScreen;
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame();

        GameBoard p1Map = new GameBoard();
        GameBoard p2Map = new GameBoard();
        Player p1 = new Player(p1Map);
        Player p2 = new Player(p2Map);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new viewShip(p1,p2,true).getViewUi());
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);  // should be last.
        frame.setSize(800,500);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }


}
