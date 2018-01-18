import java.util.*;
import javax.swing.*;
import java.awt.*
import java.swing.border.*

    enum PieceColor{
    BLUE(java.awt.Color.BLUE);
    GREEN(java.awt.Color.GREEN);
    YELLOW(java.awt.Color.YELLOW);
    RED(java.awt.Color.RED);
    public final java.awt.Color value;

    PieceColor(java.awt.Color value) {this.value = value;}

    private static
}
    
public class Piece extends JButton{
    private String color;
    private String[] colorColl = {"blue", "green", "yellow", "red", "orange"};
    private int x;
    private int y;
    private ImageIcon icon;
  
    public Piece(int col, int xcor, int ycor ){
	color = colorColl[col];
	x = xcor;
	y = ycor;
    }
  
    //-------------------Getters and Setters--------------------
  
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

    public String toString(){
	return "";
    }

  
    //------------------Icon Display------------------
  
}
