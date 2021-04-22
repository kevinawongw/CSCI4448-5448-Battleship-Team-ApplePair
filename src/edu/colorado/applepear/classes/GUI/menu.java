package edu.colorado.applepear.classes.GUI;

import edu.colorado.applepear.classes.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class menu extends JFrame{
    private JPanel menuScreen;
    private JPanel grid;
    JButton b1;
    JButton b2;
    JButton b3;
    Color navy = new Color(68, 88, 115);
    Color lightBlue = new Color(226, 233, 238);


    public menu(Player currPlayer, Player oppPlayer, boolean next) {
        menuScreen = new JPanel(new BorderLayout(0,0));
        menuScreen.setBackground(Color.white);
        createMap(10,10);
        menuScreen.add(grid);

        JPanel sideBar = new JPanel();
        sideBar.setLayout(new BoxLayout(sideBar,BoxLayout.Y_AXIS));
        menuScreen.add(sideBar, BorderLayout.EAST);
        sideBar.setBackground(lightBlue);

        JLabel titleLabel = new JLabel();
        String title = currPlayer.getName() + "'s Turn";
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


        b1 = new JButton("Attack");
        b1.setBackground(navy);
        b1.setForeground(lightBlue);
        b1.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
//        b1.setSize(10,5);
        b1.setVisible(true);
        menuPanel.add(b1, BorderLayout.CENTER);

        b1.addActionListener(e -> {
            JPanel card5 = new attack(currPlayer,oppPlayer,true).getAttackScreen();
            PlayerGUI.cards.add(card5, "currAttack");
            CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
            if (!next){
                cl.show(PlayerGUI.cards, "currAttack");
            }

            else{
                cl.show(PlayerGUI.cards, "menu");
            }
        });

        b2 = new JButton("View Your Ship");
        b2.setBackground(navy);
        b2.setForeground(lightBlue);
        b2.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
        b2.setPreferredSize(new Dimension(3,1));
        b2.setVisible(true);
        menuPanel.add(b2, BorderLayout.CENTER);

        b2.addActionListener(e -> {
            JPanel card6 = new viewShip(currPlayer,oppPlayer,true).getViewScreen();
            PlayerGUI.cards.add(card6, "currView");
            CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
            if(!next)
                cl.show(PlayerGUI.cards, "currView");
            else
                cl.show(PlayerGUI.cards, "menu");
        });
        b3 = new JButton("Quit");
        b3.setBackground(navy);
        b3.setForeground(lightBlue);
        b3.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
        b3.setPreferredSize(new Dimension(3,1));
        b3.setVisible(true);
        menuPanel.add(b3, BorderLayout.CENTER);

        b3.addActionListener(e -> {
            JPanel card6 = new GameOver(currPlayer,oppPlayer,true).getGameOver();
            PlayerGUI.cards.add(card6, "oppPCMenu");
            CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
            if(!next)
                cl.show(PlayerGUI.cards, "oppPCMenu");
            else
                cl.show(PlayerGUI.cards, "home");
        });
    }



    public JPanel getMenuScreen(){
        return menuScreen;
    }

    public void createMap(int maxX, int maxY){
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
