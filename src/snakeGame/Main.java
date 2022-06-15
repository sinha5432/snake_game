package snakeGame;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame obj = new JFrame();
        Gameplay gamePlay = new Gameplay();
        obj.setTitle("SNAKE");
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gamePlay);

        // set windows size to desired dimensions
        Container c = obj.getContentPane();
        Dimension d = new Dimension(656,656);
        c.setPreferredSize(d);
        obj.pack();

        
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
        obj.setVisible(true);
    }
    
}
