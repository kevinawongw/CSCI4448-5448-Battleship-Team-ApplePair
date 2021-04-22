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
    JLabel plusMissile;
    JLabel sonarPulse;
    JLabel currShip;
    JLabel sunkShip;
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
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
        titleLabel.setForeground(navy);
        titleLabel.setBorder(new EmptyBorder(20,0,0,0));
        sideBar.add(titleLabel,BorderLayout.CENTER);

        /* Menu button Panel */
        JPanel menuPanel = new JPanel(new GridLayout(0,1));
        sideBar.add(menuPanel, BorderLayout.PAGE_END);
        menuPanel.setBackground(lightBlue);
        menuPanel.setPreferredSize(new Dimension(350, 300));
        menuPanel.setBorder(new EmptyBorder(10,10,10,10));

        /* Bottom Panel for row*/
        JPanel bottomPanel = new JPanel(new GridLayout(2,0));
        bottomPanel.setLayout(new BoxLayout(bottomPanel,BoxLayout.X_AXIS));
        sideBar.add(bottomPanel, BorderLayout.PAGE_END);
        bottomPanel.setBackground(lightBlue);
        bottomPanel.setPreferredSize(new Dimension(350, 200));
        bottomPanel.setBorder(new EmptyBorder(20,10,10,10));

        /* Inventory Panel for column*/
        JPanel inventPanel = new JPanel(new GridLayout(0,3));
        bottomPanel.add(inventPanel, BorderLayout.WEST);
        inventPanel.setLayout(new BoxLayout(inventPanel,BoxLayout.Y_AXIS));
        inventPanel.setBackground(lightBlue);
        inventPanel.setPreferredSize(new Dimension(175, 200));
        inventPanel.setBorder(new EmptyBorder(10,10,10,10));



        /* Status Panel for column*/
        JPanel statPanel = new JPanel(new GridLayout(0,3));
        bottomPanel.add(statPanel, BorderLayout.EAST);
        statPanel.setLayout(new BoxLayout(statPanel,BoxLayout.Y_AXIS));
        statPanel.setBackground(lightBlue);
        statPanel.setPreferredSize(new Dimension(175, 200));
        statPanel.setBorder(new EmptyBorder(10,10,10,10));

        /* Menu Button field */
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

        /* Inventory field */

        String inv = "Inventory: ";
        JLabel invTitle = new JLabel(inv);
        invTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
        invTitle.setForeground(navy);
        invTitle.setVisible(true);
        inventPanel.add(invTitle, BorderLayout.PAGE_START);

//        String numPM = "3";
//        plusMissile = new JLabel(numPM);
//        plusMissile.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
//        plusMissile.setForeground(navy);
//        plusMissile.setVisible(true);
//        inventPanel.add(plusMissile, BorderLayout.LINE_START);

        String pm = "Plus Missiles";
        JLabel pmTitle = new JLabel(pm);
        pmTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        pmTitle.setForeground(navy);
        pmTitle.setVisible(true);
        inventPanel.add(pmTitle, BorderLayout.LINE_END);

//        String numSP = "2";
//        sonarPulse = new JLabel(numSP);
//        sonarPulse.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
//        sonarPulse.setForeground(navy);
//        sonarPulse.setVisible(true);
//        inventPanel.add(sonarPulse, BorderLayout.LINE_START);

        String B = "";
        JLabel blank = new JLabel(B);
        blank.setVisible(true);
        inventPanel.add(blank, BorderLayout.CENTER);

        String sp = "Sonar Pulses";
        JLabel spTitle = new JLabel(sp);
        spTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        spTitle.setForeground(navy);
        spTitle.setVisible(true);
        inventPanel.add(spTitle, BorderLayout.LINE_END);



        /* Status field */

        String stat = "Current Status: ";
        JLabel statTitle = new JLabel(stat);
        statTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
        statTitle.setForeground(navy);
        statTitle.setVisible(true);
        statPanel.add(statTitle, BorderLayout.PAGE_START);

        String nShip = "Ships Remaining";
        JLabel nsTitle = new JLabel(nShip);
        nsTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        nsTitle.setForeground(navy);
        nsTitle.setVisible(true);
        statPanel.add(nsTitle, BorderLayout.PAGE_START);

        String sShip = "Sunken Ship";
        JLabel ssTitle = new JLabel(sShip);
        ssTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        ssTitle.setForeground(navy);
        ssTitle.setVisible(true);
        statPanel.add(ssTitle, BorderLayout.PAGE_START);

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
