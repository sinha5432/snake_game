package snakeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    private int score = 0;

    private Timer timer;
    private int delay = 4;

    private int tileSide = 16;
    private int windowSide = 640;
    private int tileNumbers = windowSide/tileSide;



    public void paint(Graphics g) {
        //background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, windowSide, windowSide);

        //border
        g.setColor(new Color(0, 255, 0));
        g.fillRect(0, 0, 5, 645);
        g.fillRect(0, 0, 645, 5);
        g.fillRect(0, 640, 645, 5);
        g.fillRect(640, 0, 5, 645);

        //snake head


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    


    
}
