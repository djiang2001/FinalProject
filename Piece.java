import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

  enum PieceColor{
    BLUE(java.awt.Color.BLUE),
    GREEN(java.awt.Color.GREEN),
    YELLOW(java.awt.Color.YELLOW),
    RED(java.awt.Color.RED),
    ORANGE(java.awt.Color.ORANGE);
  
  public final java.awt.Color value;
    
  PieceColor(java.awt.Color value) { this.value = value; }
  
  private static Random rand = new Random();//helper method for random selection
  public static PieceColor randPick() {
    return PieceColor.values()[rand.nextInt(PieceColor.values().length)];
  }
}
    
public class Piece extends JButton{
  public static final Border standard = new LineBorder(Color.black);
  private PieceColor color;
  public final int row, col;
  /*private String color;
    private String[] colorColl = {"blue", "green", "yellow", "red", "orange"};
    private int x;
    private int y;
    private ImageIcon icon;*/
  
    public Piece(int row, int col, PieceColor color ){
      this.row = row;
      this.col = col;
      setBorder(standard);
      setColor(color);
    }
  
 //-------------------Getters and Setters--------------------

  public PieceColor getColor(){
    return color;
  }
  
  public void setColor(PieceColor color){
    this.color = color;
    this.setBackground(this.color.value);
  }

  public boolean equals(Piece other){
    return this.getColor().value == other.getColor().value;
  }
  /*
    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }
    
    public String getColor(){
	return color;
    }
    public Icon getIcon(){
	return icon;
    }

    public void setX(int xcor){
	x = xcor;
    }

    public void setY(int ycor){
	y = ycor;
    }
  
    public void setColor(String c){
	color = c;
    }

  public void setColor(int i){
    color = colorColl[i];
  }
  */

    public String toString(){
	return ""+color + "Block (" + row + "," + col;
    }

  
    //------------------Icon Display------------------
  
}
