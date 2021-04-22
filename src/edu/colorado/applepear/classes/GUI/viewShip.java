package edu.colorado.applepear.classes.GUI;

import edu.colorado.applepear.classes.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class viewShip {
    private JPanel viewScreen;
    private JPanel grid;
    JButton returnButton;
    Color navy = new Color(68, 88, 115);
    Color lightBlue = new Color(226, 233, 238);

    public viewShip(Player currPlayer, Player oppPlayer, boolean next){
        viewScreen = new JPanel(new BorderLayout(0,0));
        viewScreen.setBackground(Color.white);
        createViewMap(10,10);
        viewScreen.add(grid);

        JPanel sideBar = new JPanel();
        sideBar.setLayout(new BoxLayout(sideBar,BoxLayout.Y_AXIS));
        viewScreen.add(sideBar, BorderLayout.EAST);
        sideBar.setBackground(lightBlue);

        JLabel titleLabel = new JLabel();
        String title = currPlayer.getName() + "'s Turn to Attack";
        titleLabel.setText(title);
        titleLabel.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        titleLabel.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
        titleLabel.setForeground(navy);
        titleLabel.setBorder(new EmptyBorder(20,0,0,0));
        sideBar.add(titleLabel,BorderLayout.WEST);

        JPanel menuPanel = new JPanel(new GridLayout(0,1));
        sideBar.add(menuPanel, BorderLayout.PAGE_END);
        menuPanel.setBackground(lightBlue);
        menuPanel.setPreferredSize(new Dimension(250, 400));
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


    public void createViewMap(int maxX, int maxY){
        grid = new JPanel(new GridLayout(maxX,maxY,1,1));
        grid.setBorder(new EmptyBorder(30,40,40,40));
        grid.setBackground(Color.white);

        for(int i=0; i< maxX; i++){
            for(int j=0; j< maxY; j++){
                JPanel newP = new JPanel();
                String coord = i + ","+j;
                grid.add(coord, newP);
            }
        }
    }
}
