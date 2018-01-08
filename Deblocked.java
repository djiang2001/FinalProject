import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Deblocked extends JFrame{

  JLabel score;
  
  public Deblocked(){
    this.setTitle("Deblocked");
    this.setSize(600,600);
    this.setLocation(550,150);

    score = new JLabel("0");
    add(score, BorderLayout.NORTH);
    Grid board= new Grid(3);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    System.out.println(board);
  }

  public JLabel getScore(){
    return score;
  }
  
  public static void main (String[] args )
  {
    Deblocked game = new Deblocked();
    game.setAlwaysOnTop(true);
    game.setVisible(true);
    game.setResizable(false);
  }
}
