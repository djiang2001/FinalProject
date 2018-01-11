import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;

public class Deblocked extends JFrame implements MouseListener{

    private static Container pane;
    private Block[][] piece;
    private ArrayList<Block> blockPiece;
    JLabel score;
    
  
    public Deblocked(){
	
	this.setTitle("Deblocked");
	this.setSize(600,600);
	this.setLocation(550,150);
	score = new JLabel("0");
	add(score, BorderLayout.NORTH);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new GridLayout(8,8,0,0));

	boolean backgroundColor = false;
	squares = new Block[10][10];
	for(int i = 0; i < blocks.length;i++){
	    for (int j = 0; j < blocks[i].length;j++) {
		
		Block blocks = new Block(
					 Math.random i,j);

		

    
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
	Deblocked game = new Deblocked();
	game.setVisible(true);
	game.setResizable(false);
    }
    
}
