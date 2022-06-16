package snakeGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Snake {

    private int tileSide = 16;
  
    private int points = 3;

    
    public void setPoints(int a) {
        this.points = a;
    }

    public int getPoints(int a) {
        return this.points;
    }


    private ArrayList<Integer> posX = new ArrayList<Integer>();
    private ArrayList<Integer> posY = new ArrayList<Integer>();

    
    

    public void drawSnakeSegment(Graphics2D g, int x, int y) {

        g.setColor(Color.red);
        g.fillRect(x*tileSide, y*tileSide, tileSide, tileSide);

        g.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);
        g.drawRect(x*tileSide, y*tileSide, tileSide, tileSide);

    }

    private boolean ready1 = false;
    private boolean ready2 = false;

    public void drawSnake(int x, int y, Graphics g) {


        if(this.posX.size() < this.points) {
            this.posX.add(x);
        }
        else if(this.posX.get(posX.size()-1) != x) {
            this.posX.add(x);
        }
        else{
            ready1 = true;
        }

        if(this.posY.size() < this.points) {
            this.posY.add(y);
        }
        else if(this.posY.get(this.posY.size()-1) != y) {
            this.posY.add(y);
        }
        else{
            ready2 = true;
        }
        
        

       
        if(ready1 && ready2) {

            for(int i=1; i<=this.points; i++) {
                drawSnakeSegment((Graphics2D)g, this.posX.get(this.posX.size() - i), this.posY.get(this.posY.size() - i));

                System.out.println("posY = " + posY);
                
            }

        }
        
        
        
    }


    
    
}

