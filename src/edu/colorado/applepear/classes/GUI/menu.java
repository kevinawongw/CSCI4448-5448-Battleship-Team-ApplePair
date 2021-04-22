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
    JLabel plusMissile;
    JLabel sonarPulse;
    JLabel currShip;
    JLabel sunkShip;
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
        String title = currPlayer.getName() + "'s Turn. Select an Option";
        titleLabel.setText(title);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        titleLabel.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
        titleLabel.setForeground(navy);
        titleLabel.setBorder(new EmptyBorder(20,0,0,0));
        sideBar.add(titleLabel,BorderLayout.WEST);

        JPanel menuPanel = new JPanel(new GridLayout(0,1));
        sideBar.add(menuPanel, BorderLayout.PAGE_END);
        menuPanel.setBackground(lightBlue);
        menuPanel.setPreferredSize(new Dimension(250, 300));
        menuPanel.setBorder(new EmptyBorder(70,50,0,50));

        /* Bottom Panel for row*/
        JPanel bottomPanel = new JPanel(new GridLayout(2,0));
        bottomPanel.setLayout(new BoxLayout(bottomPanel,BoxLayout.X_AXIS));
        sideBar.add(bottomPanel, BorderLayout.PAGE_END);
        bottomPanel.setBackground(lightBlue);
        bottomPanel.setPreferredSize(new Dimension(350, 200));
        bottomPanel.setBorder(new EmptyBorder(20,15,10,15));

        /* Inventory Panel for column*/
        JPanel inventPanel = new JPanel(new GridLayout(0,3));
        bottomPanel.add(inventPanel, BorderLayout.CENTER);
        inventPanel.setLayout(new BoxLayout(inventPanel,BoxLayout.Y_AXIS));
        inventPanel.setBackground(lightBlue);
        inventPanel.setPreferredSize(new Dimension(175, 200));
        inventPanel.setBorder(new EmptyBorder(10,10,10,10));

        /* Status Panel for column*/
        JPanel statPanel = new JPanel(new GridLayout(0,3));
        bottomPanel.add(statPanel, BorderLayout.CENTER);
        statPanel.setLayout(new BoxLayout(statPanel,BoxLayout.Y_AXIS));
        statPanel.setBackground(lightBlue);
        statPanel.setPreferredSize(new Dimension(175, 200));
        statPanel.setBorder(new EmptyBorder(10,10,10,10));

        /* Menu Button field */
        b1 = new JButton("Attack");
        b1.setBackground(navy);
        b1.setForeground(lightBlue);
        b1.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
        b1.setVisible(true);

        menuPanel.add(b1, BorderLayout.CENTER);
        menuPanel.add(new JLabel(" "),"span, grow");


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
        menuPanel.add(new JLabel(" "),"span, grow");


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
//        menuPanel.add(new JLabel(" "),"span, grow");

        b3.addActionListener(e -> {
            JPanel card6 = new GameOver(currPlayer,oppPlayer,true).getGameOver();
            PlayerGUI.cards.add(card6, "oppPCMenu");
            CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
            cl.show(PlayerGUI.cards, "home");
        });

        /* Inventory field */
        JPanel IrowPanel = new JPanel();
        IrowPanel.setLayout(new BoxLayout(IrowPanel, BoxLayout.X_AXIS));
        IrowPanel.setBackground(lightBlue);
        IrowPanel.setBorder(new EmptyBorder(5,0,0,0));

        String inv = "Inventory ";
        JLabel invTitle = new JLabel(inv);
        invTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
        invTitle.setForeground(navy);
        invTitle.setVisible(true);
        inventPanel.add(invTitle, BorderLayout.WEST);

        String pm = "Plus Missiles: ";
        JLabel pmTitle = new JLabel(pm);
        pmTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        pmTitle.setForeground(navy);
        pmTitle.setVisible(true);
        IrowPanel.add(pmTitle, BorderLayout.WEST);

        String numPM = "3";
        plusMissile = new JLabel(numPM);
        plusMissile.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        plusMissile.setForeground(navy);
        plusMissile.setVisible(true);
        IrowPanel.add(plusMissile, BorderLayout.WEST);


        inventPanel.add(IrowPanel);

        JPanel IrowPanel2 = new JPanel();
        IrowPanel2.setLayout(new BoxLayout(IrowPanel2, BoxLayout.X_AXIS));
        IrowPanel2.setBackground(lightBlue);

        String sp = "Sonar Pulses: ";
        JLabel spTitle = new JLabel(sp);
        spTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        spTitle.setForeground(navy);
        spTitle.setVisible(true);
        IrowPanel2.add(spTitle, BorderLayout.WEST);

        String numSP = "2";
        sonarPulse = new JLabel(numSP);
        sonarPulse.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        sonarPulse.setForeground(navy);
        sonarPulse.setVisible(true);
        IrowPanel2.add(sonarPulse, BorderLayout.WEST);

        inventPanel.add(IrowPanel2);

        /* Status field */
        JPanel CSrowPanel = new JPanel();
        CSrowPanel.setLayout(new BoxLayout(CSrowPanel, BoxLayout.X_AXIS));
        CSrowPanel.setBackground(lightBlue);
        CSrowPanel.setBorder(new EmptyBorder(5,0,0,0));

        String stat = "Current Status";
        JLabel statTitle = new JLabel(stat);
        statTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
        statTitle.setForeground(navy);
        statTitle.setVisible(true);
        statPanel.add(statTitle, BorderLayout.WEST);

        String nShip = "Ships Remaining: ";
        JLabel nsTitle = new JLabel(nShip);
        nsTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        nsTitle.setForeground(navy);
        nsTitle.setVisible(true);
        CSrowPanel.add(nsTitle, BorderLayout.WEST);

        String numSR = "6";
        currShip = new JLabel(numSR);
        currShip.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        currShip.setForeground(navy);
        currShip.setVisible(true);
        CSrowPanel.add(currShip, BorderLayout.WEST);

        statPanel.add(CSrowPanel);

        JPanel CSrowPanel2 = new JPanel();
        CSrowPanel2.setLayout(new BoxLayout(CSrowPanel2, BoxLayout.X_AXIS));
        CSrowPanel2.setBackground(lightBlue);
        CSrowPanel2.setBorder(new EmptyBorder(5,0,0,0));

        String sShip = "Sunken Ship: ";
        JLabel ssTitle = new JLabel(sShip);
        ssTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        ssTitle.setForeground(navy);
        ssTitle.setVisible(true);
        CSrowPanel2.add(ssTitle, BorderLayout.WEST);

        String numSS = "0";
        sunkShip = new JLabel(numSS);
        sunkShip.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        sunkShip.setForeground(navy);
        sunkShip.setVisible(true);
        CSrowPanel2.add(sunkShip, BorderLayout.WEST);

        statPanel.add(CSrowPanel2);
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

