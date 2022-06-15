package snakeGame;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame obj = new JFrame();
        obj.setBounds(0, 0, 640, 480);
        obj.setTitle("SNAKE");
        obj.setResizable(false);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
    }
    
}
