package edu.colorado.applepear.classes.GUI;
import edu.colorado.applepear.classes.Player;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;


public class placeShip extends JFrame{

    /* Initializing GUI components*/
    
    private JPanel placeShipScreen;
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
    Color navy = new Color(68, 88, 115);
    Color lightBlue = new Color(226, 233, 238);

    JButton doneButton;



    public  placeShip(Player currPlayer, Player oppPlayer, boolean next){
        
        placeShipScreen = new JPanel(new BorderLayout(0, 0));
        placeShipScreen.setBackground(Color.white);
        createMap(10,10);
        placeShipScreen.add(grid);

        /*
          adding side bar on the right side of the screen w/ a box layout
         */
        JPanel sideBar = new JPanel();
        sideBar.setLayout(new BoxLayout(sideBar,BoxLayout.Y_AXIS));
        placeShipScreen.add(sideBar, BorderLayout.EAST);
        sideBar.setBackground(lightBlue);

        /* first component on box layout it the title panel */

        JLabel titleLabel = new JLabel();
        String title2 =  currPlayer.getName() + "'s Turn to Place Ships";
        titleLabel.setText(title2);
        titleLabel.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        titleLabel.setForeground(Color.black);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        titleLabel.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 16));
        titleLabel.setForeground(navy);
        titleLabel.setBorder(new EmptyBorder(20,0,0,10));
        sideBar.add(titleLabel,BorderLayout.WEST);

        /* second component on box layout is the controls panel */

        JPanel controls = new JPanel(new GridLayout(0, 3));
        sideBar.add(controls, BorderLayout.PAGE_END);
        controls.setBackground(lightBlue);
        controls.setPreferredSize(new Dimension(250,400));
        controls.setBorder(new EmptyBorder(10, 10, 10, 10));


        /*
          input text fields below -- change to a better coordinate input system
         */

        controls.add(new JLabel(" "),"span, grow");
        controls.add(new JLabel(" "),"span, grow");

        /* battleship field */

        String B = "Battleship: ";
        String blank = " ";
        JLabel l1 = new JLabel(B);
        JLabel b = new JLabel(blank);
        l1.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        l1.setForeground(navy);
        l1.setVisible(true);
        x1.setVisible(true);
        y1.setVisible(true);

        controls.add(b, BorderLayout.PAGE_START);
        controls.add(l1,  BorderLayout.PAGE_START);
        controls.add(x1,  BorderLayout.PAGE_START);
        controls.add(y1,  BorderLayout.PAGE_START);
        controls.add(new JLabel(" "),"span, grow");
        controls.add(new JLabel(" "),"span, grow");
        controls.add(new JLabel(" "),"span, grow");


        /* destroyer field */

        String D = "Destroyer: ";
        JLabel l2 = new JLabel(D);
        l2.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        l2.setForeground(navy);
        l2.setVisible(false);
        x2.setVisible(false);
        y2.setVisible(false);
        controls.add(l2,BorderLayout.PAGE_START);
        controls.add(x2,  BorderLayout.PAGE_START);
        controls.add(y2,  BorderLayout.PAGE_START);
        controls.add(new JLabel(" "),"span, grow");
        controls.add(new JLabel(" "),"span, grow");
        controls.add(new JLabel(" "),"span, grow");


        /* L-ship field */

        String L = "LShip: ";
        JLabel l3 = new JLabel(L);
        l3.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        l3.setForeground(navy);
        l3.setVisible(false);
        x3.setVisible(false);
        y3.setVisible(false);
        controls.add(l3,BorderLayout.PAGE_START);
        controls.add(x3,  BorderLayout.PAGE_START);
        controls.add(y3,  BorderLayout.PAGE_START);
        controls.add(new JLabel(" "),"span, grow");
        controls.add(new JLabel(" "),"span, grow");
        controls.add(new JLabel(" "),"span, grow");

        /* minesweeper field */

        String M = "Minesweeper: ";
        JLabel l4 = new JLabel(M);
        l4.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        l4.setForeground(navy);
        l4.setVisible(false);
        x4.setVisible(false);
        y4.setVisible(false);
        controls.add(l4,BorderLayout.PAGE_START);
        controls.add(x4,  BorderLayout.PAGE_START);
        controls.add(y4,  BorderLayout.PAGE_START);
        controls.add(new JLabel(" "),"span, grow");
        controls.add(new JLabel(" "),"span, grow");
        controls.add(new JLabel(" "),"span, grow");

        /* tower field */

        String S = "Tower";
        JLabel l5 = new JLabel(S);
        l5.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        l5.setForeground(navy);
        l5.setVisible(false);
        x5.setVisible(false);
        y5.setVisible(false);
        controls.add(l5,BorderLayout.PAGE_START);
        controls.add(x5,  BorderLayout.PAGE_START);
        controls.add(y5,  BorderLayout.PAGE_START);
        controls.add(new JLabel(" "),"span, grow");
        controls.add(new JLabel(" "),"span, grow");
        controls.add(new JLabel(" "),"span, grow");

        doneButton = new JButton("Place");
        doneButton.setBackground(	navy);
        doneButton.setForeground(lightBlue);
        doneButton.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 14));
        doneButton.setVisible(false);
        controls.add(doneButton ,  BorderLayout.CENTER);

        doneButton.addActionListener(e -> {

            /* how i think we can add ships to ship map -- will comment out temporarily

            Integer x1coordinate = Integer.parseInt(x1.getText());
            Integer y1coordinate = Integer.parseInt(y1.getText());

            */

            /*adding cards*/
            JPanel card3 = new placeShip(oppPlayer,currPlayer, true).getPlaceShipScreen();
            JPanel card4 = new menu(oppPlayer,currPlayer,false).getMenuScreen();
            PlayerGUI.cards.add(card3,"oppPC");
            PlayerGUI.cards.add(card4, "menu");
            //add main menu screen to cards.
            CardLayout cl = (CardLayout)(PlayerGUI.cards.getLayout());

            if (!next){
                cl.show(PlayerGUI.cards, "oppPC");
            }
            //This should actually take us to the menu options screen -- not home. Change when menu option screen is done
            else{
                cl.show(PlayerGUI.cards, "menu");
            }



        });

        /*  Document listener will see when there are changes to the text fields */
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

                String point1X = x1.getText();
                String point1Y = y1.getText();
                boolean point1 = allowNext(point1X,point1Y);
                x2.setVisible(point1);
                y2.setVisible(point1);
                if(point1)
                    l2.setVisible(true);

                String point2X = x2.getText();
                String point2Y = y2.getText();
                boolean point2 = allowNext(point2X,point2Y);
                x3.setVisible(point1 && point2);
                y3.setVisible(point1 && point2);
                if(point2)
                    l3.setVisible(true);

                String point3X = x3.getText();
                String point3Y = y3.getText();
                boolean point3 = allowNext(point3X,point3Y);
                x4.setVisible(point1 && point2 && point3);
                y4.setVisible(point1 && point2 && point3);
                if(point3)
                    l4.setVisible(true);

                String point4X = x4.getText();
                String point4Y = y4.getText();
                boolean point4 = allowNext(point4X,point4Y);
                x5.setVisible(point1 && point2 && point3 && point4);
                y5.setVisible(point1 && point2 && point3 && point4);
                if(point4)
                    l5.setVisible(true);

                String point5X = x5.getText();
                String point5Y = y5.getText();
                boolean isDone = allowNext(point5X,point5Y);
                doneButton.setVisible(point1 && point2 && point3 && point4 && isDone );

            }
        };

        /* adding document listeners to all of the text fields */

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
    public JPanel getPlaceShipScreen(){
        return placeShipScreen;
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

    /**
     *
     * @param str checks if inputted string str is an integer
     * @return true or false
     */
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch (NumberFormatException nfe) {
            return true;
        }
    }

    /**
     *
     * @param str the x coordinate that the user inputted
     * @param str2 the y coordinate that the user inputted
     * @return helper function to determine if the x and y inputs were appropriate
     */
    public static boolean allowNext(String str, String str2){
        if (str.isEmpty()) return false;
        if (str2.isEmpty()) return false;
        if (isInteger(str)) return false;
        if (isInteger(str2)) return false;
        int num1 =  Integer.parseInt(str);
        int num2 =  Integer.parseInt(str2);
        return num1 >= 1 && num1 <= 10 && num2 >= 1 && num2 <= 10;
    }




}




