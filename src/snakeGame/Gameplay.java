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

    private Snake snake = new Snake();

    private Timer timer;
    private int delay = 64;

    private int tileSide = 16;
    private int windowSide = 640;
    private int tileNumbers = windowSide/tileSide;


    public int random(int max, int min) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }


    private int headPosX = random(41, 0);
    private int headPosY = random(41, 0);

    

    private int direction = random(4, 0);
    
    /*
     * Direction:
     *      0 = UP
     *      1 = LEFT
     *      2 = DOWN
     *      3 = RIGHT
     */


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
        // g.setColor(Color.red);
        // g.fillRect(headPosX*tileSide, headPosY*tileSide, tileSide, tileSide);

        snake.drawSnake(headPosX, headPosY, g);
       

        g.dispose();

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(play){

            if(direction == 0 && headPosY > 1) {
                moveUP();
            }
            else if(direction == 1 && headPosX > 1) {
                moveLEFT();
            }
            else if(direction == 2 && headPosY < tileNumbers - 1) {
                moveDOWN();
            }
            else if(direction == 3 && headPosX < tileNumbers - 1) {
                moveRIGHT();
            }

        }

        
        
        repaint();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_W) {
            play = true;
            direction = 0;
            
        }

        else if(e.getKeyCode() == KeyEvent.VK_A) {
            play = true;
            direction = 1;
            
        }
        else if(e.getKeyCode() == KeyEvent.VK_S) {
            play = true;
            direction = 2;
        }

        else if(e.getKeyCode() == KeyEvent.VK_D) {
            play = true;
            direction = 3;
        }
        
    }

    public void moveUP() {
        headPosY--;
    }

    public void moveDOWN() {
        headPosY++;
    }

    public void moveLEFT() {
        headPosX--;
    }

    public void moveRIGHT() {
        headPosX++;
    }

    
    

    
}
