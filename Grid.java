import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;
import java.util.*;

public class Grid extends JFrame implements MouseListener{

    
  private static Container pane;
  private JLabel[][] squares;
  private Piece[][] rectangles;
  private boolean selected = false;
  private Piece selectedBlock;
  private int moves = 20;
  private int goal = 100;
  public static Border standard = new LineBorder(Color.black);
  
  public Grid(){
    
    this.setTitle("Unblocked");
    this.setSize(600,600);//Creates a JFrame size 600 by 600
    this.setLocation(550,150);//Sets the location at 550, 150
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    pane = this.getContentPane();
    pane.setLayout(new GridLayout(10,10));
    
    boolean backgroundColor = false;
    
    Random col = new Random();

    squares = new JLabel[10][10];
    rectangles = new Piece[10][10];
    
    for(int i = 0; i < squares.length;i++){
      for (int j = 0; j < squares[i].length;j++) {
        JLabel blocks = new JLabel();
        //Piece blocks = new Piece(col.nextInt(5), i,j);


        squares[i][j] = blocks;
	
        blocks.addMouseListener(this);
        blocks.setBorder(standard);
        blocks.setOpaque(true);

        if (j == 0) { 
          backgroundColor = !backgroundColor;
        }
        if (backgroundColor) {
          blocks.setBackground(Color.pink);
          backgroundColor = false;
        } else {
          blocks.setBackground(Color.blue);
          backgroundColor = true;
        }
	
        pane.add(blocks);
      }
      
    }

    for(int i = 0; i < squares.length;i++){
      for (int j = 0; j < squares[i].length;j++) {
        Piece pieces = new Piece(col.nextInt(5), i,j);

        rectangles[i][j] = pieces;

      }
    }
  }
  
  private int getMoves(){
    return moves;
  }
    
  public void mouseClicked(MouseEvent e){
    JLabel a = (JLabel) e.getSource();
    
    System.out.println("1");


  }
  
  public void mouseEntered(MouseEvent e) {
    
  }
  
  public void mouseExited(MouseEvent e) {
    
  }
  
  public void mousePressed(MouseEvent e) {
    
  }
  
  public void mouseReleased(MouseEvent e) {
    
  }

  public boolean hasChain(Piece a, Piece b, Piece c){
    boolean result = false;
    if(a.getColor().equals(b.getColor().equals(c.getColor()))){
      result = true;
    }
    return result;
  }

  public String toString() {
    return "";
  }

  
  public static void main (String[] args )
  {
    Grid game = new Grid();
    game.setVisible(true);
    game.setResizable(false);
    
  }
}
