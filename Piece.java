import java.util.ArrayList;
import javax.swing.*;

public class Piece extends JLabel{
  private String color;
  private String[] colorColl = {"blue", "green", "yellow", "red", "orange"};
  private Coord location;
  private ImageIcon icon;
  
  public Piece(int col, int xcor, int ycor ){
    color = colorColl[col];
    location = new Coord(xcor,ycor);
  }
  
  //-------------------Getters and Setters--------------------
  
  public Coord getCor(){
    return location;
  }
  
  public String getColor(){
    return color;
  }
  public Icon getIcon(){
    return icon;
  }
  
  public void setCor(int xcor, int ycor){
    location.setX(xcor);
    location.setY(ycor);
  }
  
  public void setColor(String c){
    color = c;
  }

  public String toString(){
    return "";
  }

  
  //------------------Icon Display------------------
  
}
