package snakeGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;


public class Snake {

    private int tileSide = 16;
  
    private int points = 5;

    
    public void setPoints(int a) {
        this.points = a;
    }

    public int getPoints(int a) {
        return this.points;
    }


    // private ArrayList<Integer> posX = new ArrayList<Integer>();
    // private ArrayList<Integer> posY = new ArrayList<Integer>();
    
    private ArrayList<int[]> pos = new ArrayList<int[]>(); 
    
    

    public void drawSnakeSegment(Graphics2D g, int x, int y) {

        g.setColor(Color.red);
        g.fillRect(x*tileSide, y*tileSide, tileSide, tileSide);

        g.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);
        g.drawRect(x*tileSide, y*tileSide, tileSide, tileSide);

    }

    

    public void drawSnake(int x, int y, Graphics g) {


        while(pos.size() < points)
        {   
            int[] temp = {x,y};
            pos.add(temp);
        }

        if(pos.size() < points)
        {
            int[] temp = {x,y};
            pos.add(temp);
        }
        else
        {
            Collections.rotate(pos, pos.size()-1);
            int[] temp = {x,y};
            pos.set(pos.size()-1, temp);
            
        }

       
        for(int i=0; i<this.points; i++) {
            drawSnakeSegment((Graphics2D)g, this.pos.get(i)[0], this.pos.get(i)[1]);
        }
        
        
        
        
    }


    
    
}

