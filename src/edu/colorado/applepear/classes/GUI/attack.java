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

public class attack extends JFrame {
    private JPanel attackScreen;
    private JPanel grid;

    JTextField x = new JTextField();
    JTextField y = new JTextField();
    JButton returnButton;
    Color navy = new Color(68, 88, 115);
    Color lightBlue = new Color(226, 233, 238);

    public attack(Player currPlayer, Player oppPlayer, boolean next){

        Game myGame = new Game(currPlayer,oppPlayer);
        attackScreen = new JPanel(new BorderLayout(0,0));
        attackScreen.setBackground(Color.white);
        createMap(10,10, currPlayer);
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

//        x.setEnabled(false);
//        y.setEnabled(false);
        coordPanel.add(x, BorderLayout.PAGE_START);
        coordPanel.add(y, BorderLayout.PAGE_START);



        /* Missile Button field */
        JButton missileButton = new JButton("Missile Attack");
        missileButton.setBackground(navy);
        missileButton.setForeground(lightBlue);
        missileButton.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
        missileButton.setVisible(true);
        missileButton.setEnabled(false);

        menuPanel.add(missileButton, BorderLayout.CENTER);
        menuPanel.add(new JLabel(" "),"span, grow");


        missileButton.addActionListener(e -> {
            /*missile attack part*/
            Integer xCoord = Integer.parseInt(x.getText());
            Integer yCoord = Integer.parseInt(y.getText());
            Point missilePoint = new Point(xCoord, yCoord);
            currPlayer.addAttackPoint(missilePoint);


            Boolean missile = myGame.hitOrMiss(missilePoint,currPlayer,oppPlayer);
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
        plusButton.setEnabled(false);
        menuPanel.add(plusButton, BorderLayout.CENTER);
        menuPanel.add(new JLabel(" "),"span, grow");

        plusButton.addActionListener(e -> {
            /*plus missile part*/
            Integer xCoord = Integer.parseInt(x.getText());
            Integer yCoord = Integer.parseInt(y.getText());
            edu.colorado.applepear.classes.Point missilePoint = new edu.colorado.applepear.classes.Point(xCoord, yCoord);
            Boolean missile = myGame.hitOrMiss(missilePoint,currPlayer,oppPlayer);
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

            /* No Remaining Plus Missile*/
            if(currPlayer.getPlusMissile() == -1) {
                plusButton.setEnabled(false);
                JLabel l = new JLabel("You don't have anymore Plus Missile.", SwingConstants.CENTER);
                l.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                missileD.setBackground(Color.white);
                missileD.add(l, BorderLayout.CENTER);
                l.setForeground(navy);
                missileD.setVisible(true);
                missileD.setSize(new Dimension(400,400));

                JPanel card6 = new attack(currPlayer,oppPlayer,true).getAttackScreen();
                PlayerGUI.cards.add(card6, "currAttack");
                CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
                cl.show(PlayerGUI.cards, "currAttack");
            }
            /* when there are remaining plus missile */
            else if(currPlayer.getPlusMissile() >= 0){
                for (Point loc : plusAttack) {
                    int i = oppPlayer.getGb().identifyShip(loc);
                    oppPlayer.getGb().getShips().get(i).updateHealth(loc);

                    if (missile) {
                        JLabel hit = new JLabel("Plus Missile landed " + plusAttack.size() + " hit(s)!", SwingConstants.CENTER);
                        hit.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                        missileD.add(hit, BorderLayout.CENTER);
                        hit.setForeground(navy);
//                            currPlayer.updateSunkShip(true);
                    } else {
                        JLabel miss = new JLabel("No attacks were made since there are no ships around.", SwingConstants.CENTER);
                        miss.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                        missileD.add(miss, BorderLayout.CENTER);
                        miss.setForeground(navy);
                    }
                }
                if(currPlayer.getPlusMissile() == 0){
                    currPlayer.setPlusMissile(currPlayer.getPlusMissile()-1);
                }


                /* Go back to Opponent's Menu */
                JPanel card6 = new menu(oppPlayer,currPlayer,false).getMenuScreen();
                PlayerGUI.cards.add(card6, "oppPCMenu");
                CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
                cl.show(PlayerGUI.cards, "oppPCMenu");
            }


        });


        JButton sonarButton = new JButton("Sonar Pulse");
        sonarButton.setBackground(navy);
        sonarButton.setForeground(lightBlue);
        sonarButton.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
        sonarButton.setPreferredSize(new Dimension(3,1));
        sonarButton.setVisible(true);
        sonarButton.setEnabled(false);
        menuPanel.add(sonarButton, BorderLayout.CENTER);
        menuPanel.add(new JLabel(" "),"span, grow");


        sonarButton.addActionListener(e -> {
            /* dialogue pop up -- sonar pulse not available */
            if (currPlayer.getHasSunkenShip() == false){
                JFrame fail = new JFrame("Not Available");
                JDialog d = new JDialog(fail, "dialog Box");
                JLabel l = new JLabel("Sonar Pulse is locked", SwingConstants.CENTER);
                l.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                d.setBackground(Color.white);
                d.add(l, BorderLayout.CENTER);
                l.setForeground(navy);
                d.setVisible(true);
                d.setSize(new Dimension(400,400));

                JPanel card6 = new attack(currPlayer,oppPlayer,true).getAttackScreen();
                PlayerGUI.cards.add(card6, "currAttack");
                CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
                cl.show(PlayerGUI.cards, "currAttack");
            }

            else{
                /*sonar pulse part*/
                Integer xCoord = Integer.parseInt(x.getText());
                Integer yCoord = Integer.parseInt(y.getText());
                Point missilePoint = new Point(xCoord, yCoord);
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


                if(currPlayer.getSonarPulse() >= 0){

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

                    if(currPlayer.getSonarPulse() == 0){
                        currPlayer.setSonarPulse(currPlayer.getSonarPulse()-1);
                    }

                    /* Go back to Opponent's Menu */
                    JPanel card6 = new menu(oppPlayer,currPlayer,false).getMenuScreen();
                    PlayerGUI.cards.add(card6, "oppPCMenu");
                    CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
                    cl.show(PlayerGUI.cards, "oppPCMenu");
                }

                /* No Remaining Sonar Pulse*/
                else if(currPlayer.getSonarPulse() == -1){
                    JLabel l = new JLabel("You don't have anymore Sonar Pulse. Enter Again.", SwingConstants.CENTER);
                    l.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                    missileD.setBackground(Color.white);
                    missileD.add(l, BorderLayout.CENTER);
                    l.setForeground(navy);
                    missileD.setVisible(true);
                    missileD.setSize(new Dimension(400,400));

                    JPanel card6 = new attack(currPlayer,oppPlayer,true).getAttackScreen();
                    PlayerGUI.cards.add(card6, "currAttack");
                    CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
                    cl.show(PlayerGUI.cards, "currAttack");
                }


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


        /* GAME OVER */
        boolean gameover = myGame.isGameOver();
        if(gameover){
            JPanel card9 = new GameOver(currPlayer,oppPlayer,true).getGameOver();
            PlayerGUI.cards.add(card9, "GameOver");
            CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
            cl.show(PlayerGUI.cards, "GameOver");
        }

        DocumentListener dl = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkForText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkForText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkForText();
            }

            /**
             * checkForText lets each subsequent text field to visible once players have inputted
             * an numerical coordinate within the bounds of the map for the previous text field.
             */
            private void checkForText(){

                String X = x.getText();
                String Y = y.getText();
                boolean point1 = placeShip.allowNext(X,Y);
                missileButton.setEnabled(point1);
                plusButton.setEnabled(point1);
                sonarButton.setEnabled(point1);

            }
        };

        /* adding document listeners to all of the text fields */

        x.getDocument().addDocumentListener(dl);
        y.getDocument().addDocumentListener(dl);


    }


    public JPanel getAttackScreen(){
        return attackScreen;
    }

    public void createMap(int maxX, int maxY, @NotNull Player currentPlayer){
        grid = new JPanel(new GridLayout(maxX,maxY,1,1));
        grid.setBorder(new EmptyBorder(30,40,40,40));
        grid.setBackground(Color.white);

        int[][] attackMap = currentPlayer.getGb().getAttackMap();
        List<Point> hitList = new ArrayList<>();
        List<Point> missList = new ArrayList<>();

        for (int row = 0; row < attackMap.length; row++) {
            for (int col = 0; col < attackMap[row].length; col++) {
                Point thisPoint = new Point(row,col);
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

                for (Point each: hitList) {
//                        System.out.println("Test: "+each);
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
