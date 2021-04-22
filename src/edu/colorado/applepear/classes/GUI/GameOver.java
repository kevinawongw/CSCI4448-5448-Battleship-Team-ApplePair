package edu.colorado.applepear.classes.GUI;

import edu.colorado.applepear.classes.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameOver extends JFrame {
    private JPanel overScreen;
    JButton playAgain;
    private JLabel imageLogo;
    Color navy = new Color(68, 88, 115);
    Color lightBlue = new Color(226, 233, 238);

    public GameOver(Player player1, Player player2, boolean next){
        overScreen = new JPanel(new BorderLayout(0,0));
        overScreen.setBackground(Color.white);
        JLabel titleLabel = new JLabel();
        String title =  "Winner is " +player1.getName() +". Congratulations!";
        titleLabel.setText(title);
        titleLabel.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 40));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 50));
        titleLabel.setForeground(navy);
        titleLabel.setBorder(new EmptyBorder(20,0,0,0));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout(10,10));
        bottomPanel.setBackground(Color.white);

        playAgain = new JButton("Play Again");
        playAgain.setBackground(navy);
        playAgain.setForeground(lightBlue);
        playAgain.setFont(new Font("tw cen mt condensed extra bold", Font.PLAIN, 18));
        playAgain.setPreferredSize(new Dimension(3,1));
        playAgain.setBorder(new EmptyBorder(20,30,30,30));
        playAgain.setVisible(true);
        bottomPanel.add(playAgain, BorderLayout.PAGE_START);


    }

    public JPanel getGameOver(){
        return overScreen;
    }

    private void createUIComponents() {
        imageLogo = new JLabel(new ImageIcon("src/edu/colorado/applepear/classes/GUI/boat (2).png"));
    }
}
