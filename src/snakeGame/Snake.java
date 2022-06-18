package snakeGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;


public class Snake {

    private int tileSide = 16;
  
    private int points = 7;
    
    
    public void setPoints(int a) {
        this.points = a;
    }

    public int getPoints() {
        return this.points;
    }

    
    private ArrayList<int[]> pos = new ArrayList<int[]>();

    public ArrayList<int[]> getPos() {
        return this.pos;
    }
    
    

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


    public boolean isColliding(int x, int y, int dir) {

    //    TODO: Implement Self Collision

        
        if( (x == 1 && dir == 1) || (x == 39 && dir == 3) ||
            (y == 1 && dir== 0) || (y == 39 && dir == 2)
        ) {
            return true;
        }

        return false;
       
    }

  
    
    
}

