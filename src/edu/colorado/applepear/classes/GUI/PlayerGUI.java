package edu.colorado.applepear.classes.GUI;

import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Player;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayerGUI {
    private JPanel ScreenMain;
    private JTextField p2Name;
    private JTextField p1Name;
    private JButton STARTButton;
    private JLabel imageLogo;

    GameBoard p1Map = new GameBoard();
    GameBoard p2Map = new GameBoard();
    Player p1 = new Player(p1Map);
    Player p2 = new Player(p2Map);



    public PlayerGUI() {

        /**
         * DocumentLister dl reports any changes in JTextFields p1Name and p2Name
         * checkForText() makes sure that the player names are different and that they are not empty
         */
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
            private void checkForText(){
                String name1 = p1Name.getText().trim();
                String name2 = p2Name.getText().trim();
                boolean textOK = !name1.isEmpty() && !name2.isEmpty() && !name1.toLowerCase().equals(name2.toLowerCase());
                STARTButton.setEnabled(textOK);
            }
        };

        p1Name.getDocument().addDocumentListener(dl);
        p2Name.getDocument().addDocumentListener(dl);

        /**
         * this action listener tell the program what to do if START is clicked
         * if clicked: it will update the names for players and hide the home screen
         */
        STARTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                getData(p1);
                getData2(p2);
                System.out.println(" These are our players: " + p1.getName() + " and " + p2.getName());
                ScreenMain.setVisible(false);
                //put next panel to true to view next panel

            }
        });

    }

    /**
     * create UI components creates custom component. This is a custom JLabel that holds the boat icon.
     */
    private void createUIComponents() {
        imageLogo = new JLabel(new ImageIcon("src/edu/colorado/applepear/classes/GUI/boat (2).png"));
    }

    public static void main(String[] args) {
        JFrame mainframe = new JFrame("PlayerGUI");
        mainframe.setContentPane(new PlayerGUI().ScreenMain);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(800, 500);
        mainframe.setTitle("Battleship Home Screen");
        mainframe.setVisible(true);
        }

    /**
     *
     * @param data is the player passed in. getData will set the player names to the text in the textField
     */
    public void getData(Player data) {
        data.setName(p1Name.getText());
    }
    public void getData2(Player data) {
        data.setName(p2Name.getText());
    }



}