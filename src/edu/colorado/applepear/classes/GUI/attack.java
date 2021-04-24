package edu.colorado.applepear.classes.GUI;

import edu.colorado.applepear.classes.Game;
import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Player;
import edu.colorado.applepear.classes.Point;
import edu.colorado.applepear.classes.main.myNewMain;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class attack extends JFrame {
    private JPanel attackScreen;
    private JPanel grid;
    JTextField x = new JTextField();
    JTextField y = new JTextField();
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

        JPanel coordPanel = new JPanel(new GridLayout(2,0));
        sideBar.add(coordPanel, BorderLayout.PAGE_START);
        coordPanel.setBackground(lightBlue);
        coordPanel.setPreferredSize(new Dimension(250, 300));
        coordPanel.setBorder(new EmptyBorder(30,20,20,20));

        JPanel menuPanel = new JPanel(new GridLayout(0,1));
        sideBar.add(menuPanel, BorderLayout.PAGE_START);
        menuPanel.setBackground(lightBlue);
        menuPanel.setPreferredSize(new Dimension(250, 300));
        menuPanel.setBorder(new EmptyBorder(20,50,70,50));

        /*Coordinate field */
        String coord = "Enter the x and y coordinates for attack!";
        JLabel c = new JLabel(coord);
        c.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
        c.setForeground(navy);
        c.setVisible(true);
        coordPanel.add(c,BorderLayout.PAGE_START);
        coordPanel.add(new JLabel(" "),"span, grow");

        x.setVisible(true);
        y.setVisible(true);
        coordPanel.add(x, BorderLayout.PAGE_START);
        coordPanel.add(y, BorderLayout.PAGE_START);

        /* Missile Button field */
        JButton missileButton = new JButton("Missile Attack");
        missileButton.setBackground(navy);
        missileButton.setForeground(lightBlue);
        missileButton.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
        missileButton.setVisible(true);

        menuPanel.add(missileButton, BorderLayout.CENTER);
        menuPanel.add(new JLabel(" "),"span, grow");


        missileButton.addActionListener(e -> {
            /*missile attack part*/
            Integer xCoord = Integer.parseInt(x.getText());
            Integer yCoord = Integer.parseInt(y.getText());
            Game game = new Game(currPlayer,oppPlayer);
            edu.colorado.applepear.classes.Point missilePoint = new edu.colorado.applepear.classes.Point(xCoord, yCoord);

            Boolean missile = game.hitOrMiss(missilePoint,currPlayer,oppPlayer);
            currPlayer.getGb().updateAttackMap(oppPlayer.getGb(),missilePoint);
            JFrame missileF= new JFrame("Missile Attack Frame");
            JDialog missileD = new JDialog(missileF, "Missile Attack Dialog");
            JPanel missileP = new JPanel();
            missileP.setLayout(new BoxLayout(missileP,BoxLayout.Y_AXIS));
            missileF.add(missileP, BorderLayout.EAST);
            missileP.setBackground(lightBlue);

            missileP.setBackground(navy);
            missileP.setForeground(lightBlue);
            missileD.setBackground(navy);
            missileD.setForeground(lightBlue);
            JButton closeB = new JButton("Back to Game");
            closeB.setBackground(navy);
            closeB.setForeground(lightBlue);
            closeB.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
            closeB.setPreferredSize(new Dimension(3,1));
            closeB.setVisible(true);
            missileP.add(closeB, BorderLayout.CENTER);

            missileP.setBackground(Color.white);
            missileD.setVisible(true);
            missileD.setSize(new Dimension(400,400));

            if(missile){
                int attackIndex = oppPlayer.getGb().identifyShip(missilePoint);
                oppPlayer.getGb().getShips().get(attackIndex).updateHealth(missilePoint);
                boolean sunken = oppPlayer.getGb().getShips().get(attackIndex).isShipSunken();
                JLabel hit = new JLabel("You Hit an Opponent's Ship! Nice Shot!", SwingConstants.CENTER);
                hit.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                missileD.add(hit, BorderLayout.CENTER);
                hit.setForeground(navy);
                if(sunken){
                    JLabel sunk = new JLabel("Nice! You sunk the opponent's " + oppPlayer.getGb().getShips().get(attackIndex).getShipName(), SwingConstants.CENTER);
                    sunk.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                    missileD.add(sunk, BorderLayout.CENTER);
                    sunk.setForeground(navy);
                    currPlayer.updateSunkShip(true);
                    currPlayer.getGb().updateSunkenShip(attackIndex);
                }
            }
            else{
                JLabel miss = new JLabel("You missed...", SwingConstants.CENTER);
                miss.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                missileD.add(miss, BorderLayout.CENTER);
                miss.setForeground(navy);

            }

            JPanel card6 = new menu(oppPlayer,currPlayer,false).getMenuScreen();
            PlayerGUI.cards.add(card6, "oppPCMenu");
            CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
            cl.show(PlayerGUI.cards, "oppPCMenu");

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
            /*plus missile part*/
            Integer xCoord = Integer.parseInt(x.getText());
            Integer yCoord = Integer.parseInt(y.getText());
            edu.colorado.applepear.classes.Point missilePoint = new edu.colorado.applepear.classes.Point(xCoord, yCoord);

            ArrayList<Point> plusAttack = currPlayer.usePlusMissile(oppPlayer.getGb(),missilePoint);
            JFrame missileF= new JFrame("Plus Missile Frame");
            JDialog missileD = new JDialog(missileF, "Plus Missile Dialog");
            JPanel missileP = new JPanel();
            missileP.setLayout(new BoxLayout(missileP,BoxLayout.Y_AXIS));
            missileF.add(missileP, BorderLayout.EAST);
            missileP.setBackground(lightBlue);

            missileP.setBackground(navy);
            missileP.setForeground(lightBlue);
            missileD.setBackground(navy);
            missileD.setForeground(lightBlue);
            JButton closeB = new JButton("Back to Game");
            closeB.setBackground(navy);
            closeB.setForeground(lightBlue);
            closeB.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
            closeB.setPreferredSize(new Dimension(3,1));
            closeB.setVisible(true);
            missileP.add(closeB, BorderLayout.CENTER);

            missileP.setBackground(Color.white);
            missileD.setVisible(true);
            missileD.setSize(new Dimension(400,400));

            /*print out if there's no remaining plus missiles (haven't finish it yet)*/
//            if(currPlayer.getPlusMissile()==0){
//                String enterAgain = String.valueOf(currPlayer.getName()) + " has no more plus missiles remaining.";
//                JLabel noMissile = new JLabel(enterAgain);
//                noMissile.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
//                noMissile.setForeground(navy);
//                noMissile.setVisible(true);
//                missileP.add(noMissile);
//            }
            for(Point loc : plusAttack){
                int i = oppPlayer.getGb().identifyShip(loc);
                oppPlayer.getGb().getShips().get(i).updateHealth(loc);
                Boolean sunken = oppPlayer.getGb().getShips().get(i).isShipSunken();
                System.out.println("Test : "+sunken);
                if(!sunken){ //not sure why the !sunken works here but opposite in Main class but ya
                    JLabel sunk = new JLabel("Plus Missile landed " + plusAttack.size() + " hit(s)!", SwingConstants.CENTER);
                    sunk.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                    missileD.add(sunk, BorderLayout.CENTER);
                    sunk.setForeground(navy);
                    currPlayer.updateSunkShip(true);
                }
                else{ //doesn't show the message hmm..
                    JLabel miss = new JLabel("No attacks were made since there are no ships around.", SwingConstants.CENTER);
                    miss.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                    missileD.add(miss, BorderLayout.CENTER);
                    miss.setForeground(navy);
                }
            }

            /* Go back to Opponent's Menu */
            JPanel card6 = new menu(oppPlayer,currPlayer,false).getMenuScreen();
            PlayerGUI.cards.add(card6, "oppPCMenu");
            CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
            cl.show(PlayerGUI.cards, "oppPCMenu");


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
            /* dialogue pop up -- sonar pulse not available */
            if (currPlayer.getHasSunkenShip() == false){
                JFrame fail = new JFrame("Not Available");
                JDialog d = new JDialog(fail, "dialog Box");
                JLabel l = new JLabel("Sonar Pulse is unlocked", SwingConstants.CENTER);
                l.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                d.setBackground(Color.white);
                d.add(l, BorderLayout.CENTER);
                l.setForeground(navy);
                d.setVisible(true);
                d.setSize(new Dimension(230,100));

                JPanel card6 = new attack(currPlayer,oppPlayer,true).getAttackScreen();
                PlayerGUI.cards.add(card6, "currAttack");
                CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
                cl.show(PlayerGUI.cards, "currAttack");
            }
            //else choose coords
            else{
                /*sonar pulse part*/
                Integer xCoord = Integer.parseInt(x.getText());
                Integer yCoord = Integer.parseInt(y.getText());
                edu.colorado.applepear.classes.Point missilePoint = new edu.colorado.applepear.classes.Point(xCoord, yCoord);
                JFrame missileF= new JFrame("Plus Missile Frame");
                JDialog missileD = new JDialog(missileF, "Plus Missile Dialog");
                JPanel missileP = new JPanel();

                missileP.setLayout(new BoxLayout(missileP,BoxLayout.Y_AXIS));
                missileF.add(missileP, BorderLayout.EAST);
                missileP.setBackground(lightBlue);
                missileP.setBackground(navy);
                missileP.setForeground(lightBlue);
                missileD.setBackground(navy);
                missileD.setForeground(lightBlue);
                JButton closeB = new JButton("Back to Game");
                closeB.setBackground(navy);
                closeB.setForeground(lightBlue);
                closeB.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
                closeB.setPreferredSize(new Dimension(3,1));
                closeB.setVisible(true);
                missileP.add(closeB, BorderLayout.CENTER);

                missileP.setBackground(Color.white);
                missileD.setVisible(true);
                missileD.setSize(new Dimension(400,400));

                Boolean sonarPulseAttack = currPlayer.useSonarPulse(oppPlayer.getGb(),missilePoint);

                if(sonarPulseAttack){
                    JLabel hit = new JLabel("Few spot(s) detected something... \n", SwingConstants.CENTER);
                    hit.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                    missileD.add(hit, BorderLayout.CENTER);
                    hit.setForeground(navy);
                    currPlayer.updateSunkShip(true);
                }
                else{
                    JLabel miss = new JLabel("No ship was found in this range \n", SwingConstants.CENTER);
                    miss.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                    missileD.add(miss, BorderLayout.CENTER);
                    miss.setForeground(navy);
                }

                /* Go back to Opponent's Menu */
                JPanel card6 = new menu(oppPlayer,currPlayer,false).getMenuScreen();
                PlayerGUI.cards.add(card6, "oppPCMenu");
                CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
                cl.show(PlayerGUI.cards, "oppPCMenu");

            }


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

        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                JPanel panel = new JPanel();
                JLabel newLabel = new JLabel(i+","+j);
                newLabel.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 12));
                newLabel.setForeground(navy);
                panel.add(newLabel);
                String coordinate = i + "," + j;
                grid.add(coordinate, panel);

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
