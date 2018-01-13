import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;
import java.util.*;

public class Grid extends JFrame implements MouseListener{

    
    private static Container pane;
    private Block[][] squares;
    private ArrayList<Block> blockPiece;
    private boolean selected = false;
    private Block selectedBlock;
    private int moves = 20;
  public static Border standard = new LineBorder(Color.black);
  
  public Grid(){
    
    this.setTitle("Deblocked");
    this.setSize(600,600);//Creates a JFrame size 600 by 600
    this.setLocation(550,150);//Sets the location at 550, 150
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    pane = this.getContentPane();
    pane.setLayout(new GridLayout(8,8));
    
    boolean backgroundColor = false;
    
    Random col = new Random();

    squares = new Block[8][8];
    
    for(int i = 0; i < squares.length;i++){
      for (int j = 0; j < squares[i].length;j++) {	
        Block blocks = new Block(col.nextInt(5), i,j);


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
  }
  
    private int getMoves(){
	return moves;
    }
    
  public void mouseClicked(MouseEvent e){
    Block a = (Block) e.getSource();
    
    System.out.println(a.getX());
    System.out.println(a.getY());
    System.out.println(a.getColor());
    System.out.println(this.getMoves());


  }
  
  public void mouseEntered(MouseEvent e) {
    
  }
  
  public void mouseExited(MouseEvent e) {
    
  }
  
  public void mousePressed(MouseEvent e) {
    
  }
  
  public void mouseReleased(MouseEvent e) {
    
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
