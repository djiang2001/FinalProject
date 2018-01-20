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
    return PieceColor.values()[rand.nextInt(PieceColor.values().length-1)];
  }
}
    
public class Piece extends JButton{
  public static final Border standard = new LineBorder(Color.black);
  private PieceColor color;
  public final int row, col;
  private boolean isCombo;
  private ImageIcon icon;
  
    public Piece(int row, int col, PieceColor color ){
      this.row = row;
      this.col = col;
      setBorder(standard);
      setColor(color);
      icon =  new ImageIcon(System.getProperty("user.dir") + "/blocks/" + this.color + ".png");
      this.setIcon(icon);
      this.setCombo(false);
    }
  
 //-------------------Getters and Setters--------------------

  public PieceColor getColor(){
    return color;
  }
  
  public void setColor(PieceColor color){
    this.color = color;
    icon = new ImageIcon(System.getProperty("user.dir") + "/blocks/" + color  + ".png");
    this.setIcon(icon);
  }

  public int getRow(){
    return row;
  }

  public int getCol(){
    return col;
  }

  public void setCombo(boolean b){
    isCombo = b;
  }

  public boolean isCombo(){
    return isCombo;
  }
  
  public boolean equals(Piece other){
    return this.getColor().value == other.getColor().value;
  }

    public String toString(){
	return ""+color + "Block (" + row + "," + col;
    }

  
    //------------------Icon Display------------------
  
}
