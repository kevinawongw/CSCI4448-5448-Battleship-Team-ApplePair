package edu.colorado.applepear.classes.GUI;
import edu.colorado.applepear.classes.GameBoard;
import edu.colorado.applepear.classes.Player;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;


public class PlayerGUI {
    private Player p1;
    private Player p2;
    private JPanel ScreenMain;
    private JTextField p2Name;
    private JTextField p1Name;
    private JButton STARTButton;
    private JLabel imageLogo;
    private static JPanel cards;


    public JPanel getScreenMain(){
        return ScreenMain;
    }
    public JPanel getCards(){
        return cards;
    }


    public PlayerGUI(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;

        /**
         * initializing cards. This will pet us transition to different pages
         */
        cards = new JPanel(new CardLayout());
        JPanel card1 =  getScreenMain();
        JPanel card2 = new placeShip().getPanel1();
        cards.add(card1, "home");
        cards.add(card2, "pc");


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

                p1.setName(getName1());
                p2.setName(getName2());
                System.out.println(" These are our players: " + p1.getName() + " and " + p2.getName());
                CardLayout cl = (CardLayout)(getCards().getLayout());
                cl.show(getCards(), "pc");

            }
        });


    }

    /**
     * create UI components creates custom component. This is a custom JLabel that holds the boat icon.
     */
    private void createUIComponents() {
        imageLogo = new JLabel(new ImageIcon("src/edu/colorado/applepear/classes/GUI/boat (2).png"));
    }

    public String getName1() {
        return p1Name.getText();
    }
    public String getName2() {
        return p2Name.getText();
    }



}