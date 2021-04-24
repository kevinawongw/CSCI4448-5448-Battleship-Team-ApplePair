package edu.colorado.applepear.classes.GUI;

import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Player;
import edu.colorado.applepear.classes.main.myNewMain;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class attack extends JFrame {
    private JPanel attackScreen;
    private JPanel grid;
    JButton returnButton;
    Color navy = new Color(68, 88, 115);
    Color lightBlue = new Color(226, 233, 238);

    public attack(Player currPlayer, Player oppPlayer, boolean next){

        attackScreen = new JPanel(new BorderLayout(0,0));
        attackScreen.setBackground(Color.white);
        createMap(10,10);
        attackScreen.add(grid);

        JPanel sideBar = new JPanel();
        sideBar.setLayout(new BoxLayout(sideBar,BoxLayout.Y_AXIS));
        attackScreen.add(sideBar, BorderLayout.EAST);
        sideBar.setBackground(lightBlue);

        JLabel titleLabel = new JLabel();
        String title = currPlayer.getName() + "'s Turn to Attack";
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
        menuPanel.setBorder(new EmptyBorder(70,50,70,50));

        /* Menu Button field */
        JButton missileButton = new JButton("Missile Attack");
        missileButton.setBackground(navy);
        missileButton.setForeground(lightBlue);
        missileButton.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
        missileButton.setVisible(true);

        menuPanel.add(missileButton, BorderLayout.CENTER);
        menuPanel.add(new JLabel(" "),"span, grow");


        missileButton.addActionListener(e -> {
//            JPanel card5 = new attack(currPlayer,oppPlayer,true).getAttackScreen();
//            PlayerGUI.cards.add(card5, "currAttack");
//            CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
//            if (!next){
//                cl.show(PlayerGUI.cards, "currAttack");
//            }
//
//            else{
//                cl.show(PlayerGUI.cards, "menu");
//            }
        });

        JButton plusButton = new JButton("Plus Missile");
        plusButton.setBackground(navy);
        plusButton.setForeground(lightBlue);
        plusButton.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
        plusButton.setPreferredSize(new Dimension(3,1));
        plusButton.setVisible(true);
        menuPanel.add(plusButton, BorderLayout.CENTER);
        menuPanel.add(new JLabel(" "),"span, grow");

        plusButton.addActionListener(e -> {

//            GameBoard p1Map = new GameBoard();
//            GameBoard p2Map = new GameBoard();
//
//            myNewMain.resetPlayer(currPlayer,oppPlayer,p1Map,p2Map);
//
//            JPanel card6 = new GameOver(currPlayer,oppPlayer,true).getGameOver();
//            PlayerGUI.cards.add(card6, "oppPCMenu");
//            CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
//            cl.show(PlayerGUI.cards, "home");
        });


        JButton sonarButton = new JButton("Sonar Pulse");
        sonarButton.setBackground(navy);
        sonarButton.setForeground(lightBlue);
        sonarButton.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
        sonarButton.setPreferredSize(new Dimension(3,1));
        sonarButton.setVisible(true);
        menuPanel.add(sonarButton, BorderLayout.CENTER);
        menuPanel.add(new JLabel(" "),"span, grow");


        sonarButton.addActionListener(e -> {
//            JPanel card6 = new viewShip(currPlayer,oppPlayer,true).getViewScreen();
//            PlayerGUI.cards.add(card6, "currView");
//            CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
//            cl.show(PlayerGUI.cards, "currView");

        });

        returnButton = new JButton("Return to Menu");
        returnButton.setBackground(navy);
        returnButton.setForeground(lightBlue);
        returnButton.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
        returnButton.setPreferredSize(new Dimension(3,1));
        returnButton.setVisible(true);
        menuPanel.add(returnButton, BorderLayout.CENTER);
//        menuPanel.add(new JLabel(" "),"span, grow");

        returnButton.addActionListener(e -> {

            JPanel card8 = new menu(currPlayer,oppPlayer,true).getMenuScreen();
            PlayerGUI.cards.add(card8, "currPView");
            CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
            cl.show(PlayerGUI.cards, "currPView");

        });



    }


    public JPanel getAttackScreen(){
        return attackScreen;
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



    // for testing this screen, use this main function. Note that buttons will not work.
    private static void createAndShowGui() {
        JFrame frame = new JFrame();

        GameBoard p1Map = new GameBoard();
        GameBoard p2Map = new GameBoard();
        Player p1 = new Player(p1Map);
        Player p2 = new Player(p2Map);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new attack(p1,p2,true).getUi());
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

    public JPanel getUi() {
        return attackScreen;
    }
}
