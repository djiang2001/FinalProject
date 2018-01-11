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
  public static Border standard = new LineBorder(Color.black);
  JLabel score;
    JLabel moves;
  
  public Grid(){
	
    this.setTitle("Deblocked");
    this.setSize(600,600);
    this.setLocation(550,150);
    score = new JLabel("0");
    moves = new JLabel("20");
    add(score, BorderLayout.NORTH);
    add(moves, BorderLayout.NORTH);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new GridLayout(8,8,0,0));

    boolean backgroundColor = false;
    Random col = new Random();
    squares = new Block[10][10];
    for(int i = 0; i < squares.length;i++){
	    for (int j = 0; j < squares[i].length;j++) {	
		Block blocks = new Block(col.nextInt(5), i,j);

        squares[i][j] = blocks;
		
        blocks.addMouseListener(this);
        blocks.setBorder(standard);
        blocks.setOpaque(true);

        pane.add(blocks);
	    }
    }
  }

  public JLabel getScore(){
    return score;
  }

  public void mouseClicked(MouseEvent e){
	
  }
    
  public void mouseEntered(MouseEvent e) {
        
  }
    
  public void mouseExited(MouseEvent e) {
        
  }
    
  public void mousePressed(MouseEvent e) {
        
  }
    
  public void mouseReleased(MouseEvent e) {
        
  } 
    
  public static void main (String[] args )
  {
    Grid game = new Grid();
    game.setVisible(true);
    game.setResizable(false);
  }
}
