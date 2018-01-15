import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;
import java.util.*;

public class Grid extends JFrame implements MouseListener{
  
  
  private static Container pane;
  private Piece[][] squares;
  private JLabel[][] rectangles;
  private boolean selected = false;
  private Piece selectedBlock;
  private int moves = 20;
  public static Border standard = new LineBorder(Color.black);
  
  public Grid(){
    
    this.setTitle("Unblocked");
    this.setSize(600,600);//Creates a JFrame size 600 by 600
    this.setLocation(550,150);//Sets the location at 550, 150
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    pane = this.getContentPane();
    pane.setLayout(new GridLayout(10,10));
    
    Random col = new Random();
    
    squares = new Piece[10][10];
    rectangles = new JLabel[10][10];
    
    for(int i = 0; i < squares.length;i++){
      for (int j = 0; j < squares[i].length;j++) {	
        Piece blocks = new Piece(col.nextInt(5), i,j);
        ImageIcon ic = new ImageIcon("/home/ahmed/FinalProject/blocks/" + blocks.getColor()+ ".png");

        JLabel icons = new JLabel(ic);
        blocks.setY(i);
        blocks.setX(j);
        squares[i][j] = blocks;
        rectangles[i][j] = icons;
        icons.addMouseListener(this);
        icons.setBorder(standard);
        
        
        pane.add(icons);
        
      }
    }
  }

  
  public boolean hasChain(Piece a, Piece b, Piece c){
    boolean result = false;
    if(a.getColor().equals(b.getColor().equals(c.getColor()))){
      result = true;
    }
    return result;
  }
  
  //-Getters--//
  
  private int getMoves(){
    return moves;
  }
  
    public void mouseClicked(MouseEvent e){
      JLabel a = (JLabel) e.getSource();
      for (int y = 0; y < squares.length; y++){
        for (int x = 0; x < squares[y].length; x++){
          if (a == rectangles[x][y]){
            System.out.println(squares[x][y].getX());
            System.out.println(squares[x][y].getY());
            System.out.println(squares[x][y].getColor());
            System.out.println(getMoves());
          }
        }
      }
    }
  
  //--MouseListener--//
  public void mouseEntered(MouseEvent e) {
    
  }
  
  public void mouseExited(MouseEvent e) {
    
  }
  
  public void mousePressed(MouseEvent e) {
    
  }
  
  public void mouseReleased(MouseEvent e) {
    
  }
  
  
  public static void main (String[] args){
    Grid game = new Grid();
    game.setVisible(true);
    game.setResizable(false);
  }
}
