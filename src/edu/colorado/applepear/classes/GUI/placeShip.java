package edu.colorado.applepear.classes.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;


public class placeShip {
    private JPanel panel1;
    private JPanel grid;
    public placeShip(){
        initialize();
    }

    private final void initialize(){
        panel1 = new JPanel(new BorderLayout(0, 0));
        panel1.setBackground(Color.white);
        createMap(10,10);
        panel1.add(grid);

        /**
         * adding side bar on the right side of the screen
         */

        JPanel sideBar = new JPanel();
        panel1.add(sideBar, BorderLayout.EAST);
        sideBar.setBackground(Color.white);

        JPanel controls = new JPanel(new GridLayout(0, 2, 0, 0));
        sideBar.add(controls, BorderLayout.PAGE_START);
        controls.setBackground(Color.white);
        controls.setBorder(new EmptyBorder(30, 40, 40, 40));


        /**
         * input text fields below -- change to a better coord input system
         */
        controls.add(new JTextField());
        controls.add(new JTextField());
        controls.add(new JTextField());
        controls.add(new JTextField());
        controls.add(new JTextField());
        controls.add(new JTextField());
        controls.add(new JTextField());
        controls.add(new JTextField());
        controls.add(new JTextField());
        controls.add(new JTextField());
        controls.add(new JTextField());
        controls.add(new JButton("DONE"));

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
       int buttonCount = 0;
        final int[] clicked = {0};
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                JPanel panel = new JPanel();
                grid.add(panel);

                /**
                 * this commented out code is if the grid was made up of buttons
                 *
                 */
//                buttonCount +=1;
//                JButton button = new JButton(String.valueOf(buttonCount));
//                button.setForeground(Color.white);
//                button.setBackground(Color.white);
//                grid.add(button);
//
//                button.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        if (button.getBackground().equals(new Color(255, 205, 105))){
//                            button.setBackground(Color.white);
//                            button.setForeground(Color.white);
//                            clicked[0] -= 1;
//                            System.out.println(clicked[0]);
//
//                        }
//                        else{
//                            if (clicked[0] <10){
//                                button.setBackground(new Color(255, 205, 105));
//                                button.setForeground(new Color(255, 205, 105));
//                                clicked[0] += 1;
//                                System.out.println(clicked[0]);
//                            }
//                        }

                }
            }
        }





    public static void main(String[] args) {

        JFrame frame = new JFrame("Place Ships");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new placeShip().panel1);
        frame.setVisible(true);  // should be last.
        frame.setSize(800,500);
    }


}




