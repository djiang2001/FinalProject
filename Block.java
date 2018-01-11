import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Block extends JLabel{
    private String color;
    private String[] colorColl = {"blue", "green", "yellow", "red", "orange"};
    private int ycor;
    private int xcor;
    private Icon icon;

  public Block(int color, int ycor, int xcor ){
    this.color = colorColl[color];
    this.ycor = ycor;
    this.xcor = xcor;
  }

  //-------------------Getters and Setters--------------------

  public int getY(){
    return ycor;
  }
  public int getX(){
    return xcor;
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
    public void setIcon(String c){
	icon = new ImageIcon(c+".png");
    }
    

    //------------------Icon Display-------------------
    
    
}
