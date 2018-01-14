import java.util.ArrayList;
import javax.swing.*;

public class Piece extends JLabel{
  private String color;
  private String[] colorColl = {"blue", "green", "yellow", "red", "orange"};
  private int ycor;
  private int xcor;
  private ImageIcon icon;
  
  public Piece(int col, int ycor, int xcor ){
    color = colorColl[col];
    this.ycor = ycor;
    this.xcor = xcor;
     icon = new ImageIcon("~/blocks/"+col+".png");
    setIcon(icon);
    setVisible(true);
  }
  
  //-------------------Getters and Setters--------------------
  
  public int getX(){
    return xcor;
  }
  
  public int getY(){
    return ycor;
  }
 
  public String getColor(){
    return color;
  }
  public Icon getIcon(){
    return icon;
  }
  
  public void setY(int y){
    ycor = y;
  }
  public void setX(int x){
    xcor = x;
  }
  public void setColor(String c){
    color = c;
  }

  public String toString(){
    return "";
  }
  //public void setIcon(String c){
  //icon = new ImageIcon("~/blocks/"+c+".png");
  // }
  
  //------------------Icon Display------------------
  
}
