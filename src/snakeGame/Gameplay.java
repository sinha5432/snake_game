package snakeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

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


    public int random(int max, int min) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }


    private int headPosX = 20; // random(41, 0);
    private int headPosY = 20; //random(41, 0);


    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();  

    }




    public void paint(Graphics g) {
        //background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 645, 645);

        //border
        
        g.setColor(new Color(0, 128, 0));
        g.fillRect(0, 0, 16, 656);
        g.fillRect(0, 0, 656, 16);
        g.fillRect(0, 640, 656, 16);
        g.fillRect(640, 0, 16, 656);

        //snake head
        g.setColor(Color.red);
        g.fillRect(headPosX*tileSide, headPosY*tileSide, tileSide, tileSide);


        g.dispose();

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        
        repaint();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_W) {
            // System.out.println("W detected");
            if(headPosY <= 1) {
                headPosY = 1;
            }
            else {
                moveUP();
            }
        }

        else if(e.getKeyCode() == KeyEvent.VK_A) {
            if(headPosX <= 1) {
                headPosX = 1;
            }
            else {
                moveLEFT();
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_S) {
            if(headPosY >= tileNumbers - 1) {
                headPosY = tileNumbers - 1;
            }
            else {
                moveDOWN();
            }
        }

        else if(e.getKeyCode() == KeyEvent.VK_D) {
            if(headPosX >= tileNumbers - 1) {
                headPosX = tileNumbers - 1;
            }
            else {
                moveRIGHT();
            }
        }
        
    }

    public void moveUP() {
        play = true;
        headPosY--;
    }

    public void moveDOWN() {
        play = true;
        headPosY++;
    }

    public void moveLEFT() {
        play = true;
        headPosX--;
    }

    public void moveRIGHT() {
        play = true;
        headPosX++;
    }

    
    

    
}
