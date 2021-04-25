package edu.colorado.applepear.classes.GUI;

import edu.colorado.applepear.classes.Game;
import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Player;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.main.myNewMain;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
        createMap(10,10, currPlayer);
        menuScreen.add(grid);

        JPanel sideBar = new JPanel();
        sideBar.setLayout(new BoxLayout(sideBar,BoxLayout.Y_AXIS));
        menuScreen.add(sideBar, BorderLayout.EAST);
        sideBar.setBackground(lightBlue);

        JLabel titleLabel = new JLabel();
        String title = currPlayer.getName() + "'s Turn. Select an Option";
        titleLabel.setText(title);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        titleLabel.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
        titleLabel.setForeground(navy);
        titleLabel.setBorder(new EmptyBorder(20,0,0,0));
        sideBar.add(titleLabel,BorderLayout.WEST);

        JPanel menuPanel = new JPanel(new GridLayout(0,1));
        sideBar.add(menuPanel, BorderLayout.PAGE_END);
        menuPanel.setBackground(lightBlue);
        menuPanel.setPreferredSize(new Dimension(250, 300));
        menuPanel.setBorder(new EmptyBorder(70,50,30,50));

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
            cl.show(PlayerGUI.cards, "currView");

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

            GameBoard p1Map = new GameBoard();
            GameBoard p2Map = new GameBoard();

            myNewMain.resetPlayer(currPlayer,oppPlayer,p1Map,p2Map);

            JPanel card6 = new GameOver(currPlayer,oppPlayer,true).getGameOver();
            PlayerGUI.cards.add(card6, "oppPCMenu");
            CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
            cl.show(PlayerGUI.cards, "home");
        });


        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(3,2));
        statsPanel.setBackground(lightBlue);
        statsPanel.setBorder(new EmptyBorder(5,40,20,0));

        String inv = "Inventory ";
        JLabel invTitle = new JLabel(inv);
        invTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
        invTitle.setForeground(navy);
        invTitle.setVisible(true);
        statsPanel.add(invTitle);

        String stat = "Current Status";
        JLabel statTitle = new JLabel(stat);
        statTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
        statTitle.setForeground(navy);
        statTitle.setVisible(true);
        statsPanel.add(statTitle);

        String pm = "Plus Missiles: " + String.valueOf(currPlayer.getPlusMissile());
        JLabel pmTitle = new JLabel(pm);
        pmTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        pmTitle.setForeground(navy);
        pmTitle.setVisible(true);
        statsPanel.add(pmTitle);

        String nShip = "Ships Remaining: " + String.valueOf(currPlayer.getGb().getShips().size());
        JLabel nsTitle = new JLabel(nShip);
        nsTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        nsTitle.setForeground(navy);
        nsTitle.setVisible(true);
        statsPanel.add(nsTitle);

        String sp = "Sonar Pulses: " + String.valueOf(currPlayer.getSonarPulse());
        JLabel spTitle = new JLabel(sp);
        spTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        spTitle.setForeground(navy);
        spTitle.setVisible(true);
        statsPanel.add(spTitle);

        String sShip = "Sunken Ship: " + String.valueOf(currPlayer.getHasSunkenShip());
        JLabel ssTitle = new JLabel(sShip);
        ssTitle.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        ssTitle.setForeground(navy);
        ssTitle.setVisible(true);
        statsPanel.add(ssTitle);

        sideBar.add(statsPanel, BorderLayout.CENTER);

    }


    public JPanel getMenuScreen(){
        return menuScreen;
    }

    public void createMap(int maxX, int maxY, @NotNull Player currentPlayer){
        grid = new JPanel(new GridLayout(maxX,maxY,1,1));
        grid.setBorder(new EmptyBorder(30,40,40,40));
        grid.setBackground(Color.white);

        int[][] attackMap = currentPlayer.getGb().getAttackMap();
        java.util.List<edu.colorado.applepear.classes.Point> hitList = new ArrayList<>();
        List<edu.colorado.applepear.classes.Point> missList = new ArrayList<>();

        for (int row = 0; row < attackMap.length; row++) {
            for (int col = 0; col < attackMap[row].length; col++) {
                edu.colorado.applepear.classes.Point thisPoint = new edu.colorado.applepear.classes.Point(row,col);
                //miss
                if (attackMap[row][col] == 0){
                    continue;
                }
                //hit
                if (attackMap[row][col] == 1){
                    missList.add(thisPoint);
                }
                if (attackMap[row][col] == 2){
                    hitList.add(thisPoint);
                }
            }
        }

        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                JPanel panel = new JPanel();

                JLabel newLabel = new JLabel(i+","+j);
                newLabel.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 12));
                newLabel.setForeground(navy);
                panel.add(newLabel);

                for (edu.colorado.applepear.classes.Point each: hitList) {
                    if (each.getX() == j && each.getY() == i) {
                        panel.setBackground(new Color(204, 252, 187));
                        newLabel.setText(":)");
                    }
                }
                for (Point each2: missList){
                    if (each2.getX() == j && each2.getY()==i){
                        panel.setBackground(new Color(252, 187, 187));
                        newLabel.setText(":(");
                    }
                }

                String coordinate = i + "," + j;
                grid.add(coordinate, panel);

            }
        }
    }


}

