package edu.colorado.applepear.classes.GUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerGUI {
    private JPanel ScreenMain;
    private JTextField p2Name;
    private JTextField p1Name;
    private JButton STARTButton;
    private JLabel imageLogo;
    private Boolean name1OK;
    private Boolean name2OK;


    public PlayerGUI() {


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
        STARTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(" The Text in boxes are " + p1Name.getText() + " and " + p2Name.getText());
            }
        });

    }

    private void createUIComponents() {
        imageLogo = new JLabel(new ImageIcon("../boat (2).png"));
    }

    public static void main(String[] args) {
        JFrame mainframe = new JFrame("PlayerGUI");
        mainframe.setContentPane(new PlayerGUI().ScreenMain);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(800, 500);
        mainframe.setVisible(true);
        }


}