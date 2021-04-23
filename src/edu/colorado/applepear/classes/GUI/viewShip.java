package edu.colorado.applepear.classes.GUI;

import edu.colorado.applepear.classes.Player;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.Ship;
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
        menuPanel.setPreferredSize(new Dimension(350, 400));
        menuPanel.setBorder(new EmptyBorder(10,10,10,10));

        returnButton = new JButton("Return to Menu");
        returnButton.setBackground(navy);
        returnButton.setForeground(lightBlue);
        returnButton.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
        returnButton.setPreferredSize(new Dimension(3,1));
        returnButton.setVisible(true);
        menuPanel.add(returnButton, BorderLayout.PAGE_START);

        returnButton.addActionListener(e -> {
            JPanel card8 = new menu(currPlayer,oppPlayer,true).getMenuScreen();
            PlayerGUI.cards.add(card8, "currPView");
            CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
            if (!next){
                cl.show(PlayerGUI.cards, "currPView");
            }

            else{
                cl.show(PlayerGUI.cards, "menu");
            }
        });
    }

    public JPanel getViewScreen(){ return viewScreen;}


    public void createViewMap(int maxX, int maxY, @NotNull Player currPlayer){
        grid = new JPanel(new GridLayout(maxX,maxY,1,1));
        grid.setBorder(new EmptyBorder(30,40,40,40));
        grid.setBackground(Color.white);
        List<Point> bigList = new ArrayList<>();

        System.out.println(currPlayer.getGb().getShips() + "are my ships");

        for (Ship eachShip: currPlayer.getGb().getShips()){
            List<Point> eachShipPoint = eachShip.getLocation();
            for (Point eachPoint: eachShipPoint){
                System.out.println(eachPoint);
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
}
