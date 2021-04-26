package edu.colorado.applepear.classes.GUI;

import edu.colorado.applepear.classes.Game;
import edu.colorado.applepear.classes.Player;
import edu.colorado.applepear.classes.Point;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class attack extends JFrame {

    /**
     * Attributes
     */
    private JPanel attackScreen;
    private JPanel grid;

    JTextField x = new JTextField();
    JTextField y = new JTextField();
    JButton returnButton;
    Color navy = new Color(68, 88, 115);
    Color lightBlue = new Color(226, 233, 238);

    /**
     * Attack
     * @param currPlayer
     * @param oppPlayer
     * @param next
     */
    public attack(Player currPlayer, Player oppPlayer, boolean next) {

        Game myGame = new Game(currPlayer, oppPlayer);
        attackScreen = new JPanel(new BorderLayout(0, 0));
        attackScreen.setBackground(Color.white);
        createMap(10, 10, currPlayer);
        attackScreen.add(grid);


        JPanel sideBar = new JPanel();
        sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
        attackScreen.add(sideBar, BorderLayout.EAST);
        sideBar.setBackground(lightBlue);

        JLabel titleLabel = new JLabel();
        String title = currPlayer.getName() + "'s Turn to Attack";
        titleLabel.setText(title);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        titleLabel.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
        titleLabel.setForeground(navy);
        titleLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
        sideBar.add(titleLabel, BorderLayout.WEST);

        JPanel coordPanel = new JPanel(new GridLayout(2, 0));
        sideBar.add(coordPanel, BorderLayout.PAGE_START);
        coordPanel.setBackground(lightBlue);
        coordPanel.setPreferredSize(new Dimension(250, 300));
        coordPanel.setBorder(new EmptyBorder(30, 20, 20, 20));

        JPanel menuPanel = new JPanel(new GridLayout(0, 1));
        sideBar.add(menuPanel, BorderLayout.PAGE_START);
        menuPanel.setBackground(lightBlue);
        menuPanel.setPreferredSize(new Dimension(250, 300));
        menuPanel.setBorder(new EmptyBorder(20, 50, 70, 50));

        String coord = "Enter the x and y!";
        JLabel c = new JLabel(coord);
        c.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
        c.setForeground(navy);
        c.setVisible(true);
        coordPanel.add(c, BorderLayout.PAGE_START);
        coordPanel.add(new JLabel(" "), "span, grow");

        coordPanel.add(x, BorderLayout.PAGE_START);
        coordPanel.add(y, BorderLayout.PAGE_START);


        JButton missileButton = new JButton("Missile Attack");
        missileButton.setBackground(navy);
        missileButton.setForeground(lightBlue);
        missileButton.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
        missileButton.setVisible(true);
        missileButton.setEnabled(false);

        menuPanel.add(missileButton, BorderLayout.CENTER);
        menuPanel.add(new JLabel(" "), "span, grow");


        missileButton.addActionListener(e -> {
            Integer xCoord = Integer.parseInt(x.getText());
            Integer yCoord = Integer.parseInt(y.getText());
            Point missilePoint = new Point(xCoord, yCoord);

            Boolean missile = myGame.hitOrMiss(missilePoint, currPlayer, oppPlayer);
            currPlayer.getGb().updateAttackMap(oppPlayer.getGb(), missilePoint);
            JFrame missileF = new JFrame("Missile Attack Frame");
            JDialog missileD = new JDialog(missileF, "Missile Attack Dialog");
            JPanel missileP = new JPanel();
            missileP.setLayout(new BoxLayout(missileP, BoxLayout.Y_AXIS));
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
            closeB.setPreferredSize(new Dimension(3, 1));
            closeB.setVisible(true);
            missileP.add(closeB, BorderLayout.CENTER);

            missileP.setBackground(Color.white);
            missileD.setVisible(true);
            missileD.setSize(new Dimension(400, 400));

            if (missile) {
                int attackIndex = oppPlayer.getGb().identifyShip(missilePoint);
                oppPlayer.getGb().getShips().get(attackIndex).updateHealth(missilePoint);
                boolean sunken = oppPlayer.getGb().getShips().get(attackIndex).isShipSunken();

                JLabel hit = new JLabel("You Hit an Opponent's Ship! Nice Shot!", SwingConstants.CENTER);
                hit.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                missileD.add(hit, BorderLayout.CENTER);
                hit.setForeground(navy);
                if (sunken) {
                    JLabel sunk = new JLabel("Nice! You sunk the opponent's " + oppPlayer.getGb().getShips().get(attackIndex).getShipName(), SwingConstants.CENTER);
                    sunk.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                    missileD.add(sunk, BorderLayout.CENTER);
                    sunk.setForeground(navy);
                    currPlayer.updateSunkShip(true);
                    oppPlayer.getGb().updateSunkenShip(attackIndex);


                }
            }
            else {
                JLabel miss = new JLabel("You missed...", SwingConstants.CENTER);
                miss.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                missileD.add(miss, BorderLayout.CENTER);
                miss.setForeground(navy);

            }

            JPanel card6 = new menu(oppPlayer, currPlayer).getMenuScreen();
            PlayerGUI.cards.add(card6, "oppPCMenu");
            CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
            cl.show(PlayerGUI.cards, "oppPCMenu");

        });

        JButton plusButton = new JButton("Plus Missile");
        plusButton.setBackground(navy);
        plusButton.setForeground(lightBlue);
        plusButton.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
        plusButton.setPreferredSize(new Dimension(3, 1));
        plusButton.setVisible(true);
        plusButton.setEnabled(false);
        menuPanel.add(plusButton, BorderLayout.CENTER);
        menuPanel.add(new JLabel(" "), "span, grow");

        plusButton.addActionListener(e -> {

            /**
             * Plus Missile
             */

            Integer xCoord = Integer.parseInt(x.getText());
            Integer yCoord = Integer.parseInt(y.getText());
            Point missilePoint = new Point(xCoord, yCoord);

            Boolean missile = myGame.hitOrMiss(missilePoint, currPlayer, oppPlayer);

            JFrame missileF = new JFrame("Plus Missile Frame");
            JDialog missileD = new JDialog(missileF, "Plus Missile Dialog");
            JLabel plusMissileDialogue = new JLabel("Plus Missile has been used!");
            plusMissileDialogue.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
            plusMissileDialogue.setHorizontalAlignment(SwingConstants.CENTER);
            plusMissileDialogue.setForeground(navy);
            missileD.add(plusMissileDialogue, BorderLayout.CENTER);

            JPanel missileP = new JPanel();
            missileP.setLayout(new BoxLayout(missileP, BoxLayout.Y_AXIS));
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
            closeB.setPreferredSize(new Dimension(3, 1));
            closeB.setVisible(true);
            missileP.add(closeB, BorderLayout.CENTER);

            missileP.setBackground(Color.white);
            missileD.setVisible(true);
            missileD.setSize(new Dimension(400, 400));

            if (currPlayer.getPlusMissile() == 0) {
                plusButton.setEnabled(false);
                JLabel l = new JLabel("You don't have anymore Plus Missile.", SwingConstants.CENTER);
                l.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                missileD.setBackground(Color.white);
                missileD.add(l, BorderLayout.CENTER);
                l.setForeground(navy);
                missileD.setVisible(true);
                missileD.setSize(new Dimension(400, 400));

                JPanel card6 = new attack(currPlayer, oppPlayer, true).getAttackScreen();
                PlayerGUI.cards.add(card6, "currAttack");
                CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
                cl.show(PlayerGUI.cards, "currAttack");
            }

            else if (currPlayer.getPlusMissile() > 0) {
                ArrayList<Point> plusAttack = currPlayer.usePlusMissile(oppPlayer.getGb(), missilePoint);

                for (Point loc : plusAttack) {
                    int i = oppPlayer.getGb().identifyShip(loc);
                    oppPlayer.getGb().getShips().get(i).updateHealth(loc);

                    if (missile) {
                        JLabel hit = new JLabel("Plus Missile landed " + plusAttack.size() + " hit(s)!", SwingConstants.CENTER);
                        hit.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                        missileD.add(hit, BorderLayout.CENTER);
                        hit.setForeground(navy);
                    }

                }

                JPanel card6 = new menu(oppPlayer, currPlayer).getMenuScreen();
                PlayerGUI.cards.add(card6, "oppPCMenu");
                CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
                cl.show(PlayerGUI.cards, "oppPCMenu");
            }


        });

        JButton sonarButton = new JButton("Sonar Pulse");
        sonarButton.setBackground(navy);
        sonarButton.setForeground(lightBlue);
        sonarButton.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
        sonarButton.setPreferredSize(new Dimension(3, 1));
        sonarButton.setVisible(true);
        sonarButton.setEnabled(false);
        menuPanel.add(sonarButton, BorderLayout.CENTER);
        menuPanel.add(new JLabel(" "), "span, grow");


        sonarButton.addActionListener(e -> {

            if (currPlayer.getHasSunkenShip() == false) {
                JFrame fail = new JFrame("Not Available");
                JDialog d = new JDialog(fail, "dialog Box");
                JLabel l = new JLabel("Sonar Pulse is locked", SwingConstants.CENTER);
                l.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                d.setBackground(Color.white);
                d.add(l, BorderLayout.CENTER);
                l.setForeground(navy);
                d.setVisible(true);
                d.setSize(new Dimension(400, 400));

                JPanel card6 = new attack(currPlayer, oppPlayer, true).getAttackScreen();
                PlayerGUI.cards.add(card6, "currAttack");
                CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
                cl.show(PlayerGUI.cards, "currAttack");
            } else {

                /**
                 * Sonar Pulse
                 */

                Integer xCoord = Integer.parseInt(x.getText());
                Integer yCoord = Integer.parseInt(y.getText());
                Point missilePoint = new Point(xCoord, yCoord);
                JFrame missileF = new JFrame("Plus Missile Frame");
                JDialog missileD = new JDialog(missileF, "Plus Missile Dialog");
                JPanel missileP = new JPanel();

                missileP.setLayout(new BoxLayout(missileP, BoxLayout.Y_AXIS));
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
                closeB.setPreferredSize(new Dimension(3, 1));
                closeB.setVisible(true);
                missileP.add(closeB, BorderLayout.CENTER);

                missileP.setBackground(Color.white);
                missileD.setVisible(true);
                missileD.setSize(new Dimension(400, 400));



                if (currPlayer.getSonarPulse() > 0) {
                    Boolean sonarPulseAttack = currPlayer.useSonarPulse(oppPlayer.getGb(), missilePoint);
                    if (sonarPulseAttack) {
                        JLabel hit = new JLabel("Few spot(s) detected something... \n", SwingConstants.CENTER);
                        hit.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                        missileD.add(hit, BorderLayout.CENTER);
                        hit.setForeground(navy);
                    } else {
                        JLabel miss = new JLabel("No ship was found in this range \n", SwingConstants.CENTER);
                        miss.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                        missileD.add(miss, BorderLayout.CENTER);
                        miss.setForeground(navy);
                    }


                    JPanel card6 = new menu(oppPlayer, currPlayer).getMenuScreen();
                    PlayerGUI.cards.add(card6, "oppPCMenu");
                    CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
                    cl.show(PlayerGUI.cards, "oppPCMenu");
                }

                else if (currPlayer.getSonarPulse() == 0) {
                    JLabel l = new JLabel("You don't have anymore Sonar Pulse. Enter Again.", SwingConstants.CENTER);
                    l.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
                    missileD.setBackground(Color.white);
                    missileD.add(l, BorderLayout.CENTER);
                    l.setForeground(navy);
                    missileD.setVisible(true);
                    missileD.setSize(new Dimension(400, 400));

                    JPanel card6 = new attack(currPlayer, oppPlayer, true).getAttackScreen();
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
        returnButton.setPreferredSize(new Dimension(3, 1));
        returnButton.setVisible(true);
        menuPanel.add(returnButton, BorderLayout.CENTER);

        returnButton.addActionListener(e -> {

            JPanel card8 = new menu(currPlayer, oppPlayer).getMenuScreen();
            PlayerGUI.cards.add(card8, "currPView");
            CardLayout cl = (CardLayout) (PlayerGUI.cards.getLayout());
            cl.show(PlayerGUI.cards, "currPView");

        });


        /**
         * Game Over
         */
        boolean gameover = myGame.isGameOver();
        if (gameover) {
            JPanel card9 = new GameOver(currPlayer, oppPlayer, true).getGameOver();
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
            private void checkForText() {

                String X = x.getText();
                String Y = y.getText();
                boolean point1 = placeShip.allowNext(X, Y);
                missileButton.setEnabled(point1);
                if (currPlayer.getPlusMissile() >0){
                    plusButton.setEnabled(point1);
                }
                if (currPlayer.getSonarPulse() > 0){
                    sonarButton.setEnabled(point1);
                }


            }
        };

        x.getDocument().addDocumentListener(dl);
        y.getDocument().addDocumentListener(dl);


    }

    /**
     * Get Attack Screen
     * @return
     */
    public JPanel getAttackScreen() {
        return attackScreen;
    }

    /**
     * Create Map
     * @param maxX
     * @param maxY
     * @param currentPlayer
     */
    public void createMap(int maxX, int maxY, @NotNull Player currentPlayer) {
        grid = new JPanel(new GridLayout(maxX, maxY, 1, 1));
        grid.setBorder(new EmptyBorder(30, 40, 40, 40));
        grid.setBackground(Color.white);

        int[][] attackMap = currentPlayer.getGb().getAttackMap();
        List<Point> hitList = new ArrayList<>();
        List<Point> missList = new ArrayList<>();

        for (int row = 0; row < attackMap.length; row++) {
            for (int col = 0; col < attackMap[row].length; col++) {
                Point thisPoint = new Point(row, col);
                if (attackMap[row][col] == 0) {
                    continue;
                }
                if (attackMap[row][col] == 1) {
                    missList.add(thisPoint);
                }
                if (attackMap[row][col] == 2) {
                    hitList.add(thisPoint);
                }
            }
        }

        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                JPanel panel = new JPanel();

                JLabel newLabel = new JLabel(i + "," + j);
                newLabel.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 12));
                newLabel.setForeground(navy);
                panel.add(newLabel);

                for (Point each : hitList) {
                    if (each.getX() == j && each.getY() == i) {
                        panel.setBackground(new Color(204, 252, 187));
                        newLabel.setText(":)");
                    }
                }
                for (Point each2 : missList) {
                    if (each2.getX() == j && each2.getY() == i) {
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