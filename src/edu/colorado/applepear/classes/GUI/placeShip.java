package edu.colorado.applepear.classes.GUI;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



public class placeShip {


    private final JPanel panel1;
    private JPanel grid;
    JTextField x1 = new JTextField();
    JTextField y1 = new JTextField();
    JTextField x2 = new JTextField();
    JTextField y2 = new JTextField();
    JTextField x3 = new JTextField();
    JTextField y3 = new JTextField();
    JTextField x4 = new JTextField();
    JTextField y4 = new JTextField();
    JTextField x5 = new JTextField();
    JTextField y5 = new JTextField();
    JButton Place1;


    public  placeShip(){


        panel1 = new JPanel(new BorderLayout(0, 0));
        panel1.setBackground(Color.white);
        createMap(10,10);
        panel1.add(grid);

        /*
          adding side bar on the right side of the screen
         */

        JPanel sideBar = new JPanel();
        panel1.add(sideBar, BorderLayout.EAST);
        sideBar.setBackground(new Color(226, 233, 238));

        JPanel controls = new JPanel(new GridLayout(0, 2, 0, 0));
        sideBar.add(controls, BorderLayout.PAGE_START);
        controls.setBackground(Color.white);
        controls.setBorder(new EmptyBorder(10, 10, 10, 10));


        /*
          input text fields below -- change to a better coordinate input system
         */
        String title = "Place Ship (x,y) Coords";
        JLabel myLabel = new JLabel();

        myLabel.setText(title);
        myLabel.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        myLabel.setForeground(new Color(68, 88, 115));
        controls.add(myLabel,BorderLayout.CENTER);
        controls.add(new JLabel(" "),"span, grow");


        x1.setVisible(true);
        y1.setVisible(true);
        controls.add(x1,  BorderLayout.PAGE_START);
        controls.add(y1,  BorderLayout.PAGE_START);
        controls.add(new JLabel(" "),"span, grow");
        controls.add(new JLabel(" "),"span, grow");


        x2.setVisible(false);
        y2.setVisible(false);
        controls.add(x2,  BorderLayout.PAGE_START);
        controls.add(y2,  BorderLayout.PAGE_START);
        controls.add(new JLabel(" "),"span, grow");
        controls.add(new JLabel(" "),"span, grow");

        x3.setVisible(false);
        y3.setVisible(false);
        controls.add(x3,  BorderLayout.PAGE_START);
        controls.add(y3,  BorderLayout.PAGE_START);

        controls.add(new JLabel(" "),"span, grow");
        controls.add(new JLabel(" "),"span, grow");

        x4.setVisible(false);
        y4.setVisible(false);
        controls.add(x4,  BorderLayout.PAGE_START);
        controls.add(y4,  BorderLayout.PAGE_START);

        controls.add(new JLabel(" "),"span, grow");
        controls.add(new JLabel(" "),"span, grow");

        x5.setVisible(false);
        y5.setVisible(false);
        controls.add(x5,  BorderLayout.PAGE_START);
        controls.add(y5,  BorderLayout.PAGE_START);


        controls.add(new JLabel(" "),"span, grow");
        controls.add(new JLabel(" "),"span, grow");
        Place1 = new JButton("Place");
        Place1.setBackground(	new Color(68, 88, 115));
        Place1.setForeground(new Color(		226, 233, 238));
        Place1.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        Place1.setVisible(false);
        controls.add(Place1 ,  BorderLayout.CENTER);


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

                String point1X = x1.getText();
                String point1Y = y1.getText();
                boolean point1 = allowNext(point1X,point1Y);
                x2.setVisible(point1);
                y2.setVisible(point1);

                String point2X = x2.getText();
                String point2Y = y2.getText();
                boolean point2 = allowNext(point2X,point2Y);
                x3.setVisible(point1 && point2);
                y3.setVisible(point1 && point2);

                String point3X = x3.getText();
                String point3Y = y3.getText();
                boolean point3 = allowNext(point3X,point3Y);
                x4.setVisible(point1 && point2 && point3);
                y4.setVisible(point1 && point2 && point3);

                String point4X = x4.getText();
                String point4Y = y4.getText();
                boolean point4 = allowNext(point4X,point4Y);
                x5.setVisible(point1 && point2 && point3 && point4);
                y5.setVisible(point1 && point2 && point3 && point4);
                String point5X = x5.getText();
                String point5Y = y5.getText();
                boolean doneButton = allowNext(point5X,point5Y);
                Place1.setVisible(doneButton);
            }
        };

        x1.getDocument().addDocumentListener(dl);
        y1.getDocument().addDocumentListener(dl);
        x2.getDocument().addDocumentListener(dl);
        y2.getDocument().addDocumentListener(dl);
        x3.getDocument().addDocumentListener(dl);
        y3.getDocument().addDocumentListener(dl);
        x4.getDocument().addDocumentListener(dl);
        y4.getDocument().addDocumentListener(dl);
        x5.getDocument().addDocumentListener(dl);
        y5.getDocument().addDocumentListener(dl);

    }
    public JPanel getPanel1(){
        return panel1;
    }


    /**
     *
     * @param maxX: num columns
     * @param maxY: num rows
     *
     * Creates the grid on the right side of the screen
     */
    public void createMap(int maxX, int maxY) {
       grid = new JPanel(new GridLayout(maxX, maxY, 1, 1));
       grid.setBorder(new EmptyBorder(30,40,40,40));
       grid.setBackground(Color.WHITE);


        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                JPanel panel = new JPanel();
//                if (i==1 && j==1){
//                    panel.setBackground(Color.PINK);
//                }
                String coordinate = i + "," + j;
                grid.add(coordinate, panel);



                }
            }


        }


    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch (NumberFormatException nfe) {
            return true;
        }
    }
    public static boolean allowNext(String str, String str2){
        if (str.isEmpty()) return false;
        if (str2.isEmpty()) return false;
        if (isInteger(str)) return false;
        if (isInteger(str2)) return false;
        int num1 =  Integer.parseInt(str);
        int num2 =  Integer.parseInt(str2);
        return num1 >= 1 && num1 <= 10 && num2 >= 1 && num2 <= 10;
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Place Ships");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new placeShip().panel1);
        frame.setVisible(true);  // should be last.
        frame.setSize(800,500);
    }


}




