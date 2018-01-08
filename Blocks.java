import java.util.Random;

public class Block{
    private String color;
    private String[] colorColl = {"blue", "green", "yellow", "red", "orange"};
    private int ycor;
    private int xcor;

  public Blocks(String color, int ycor, int xcor ){
    this.color = color;
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

  public void setY(int y){
    ycor = y;
  }
  public void setX(int x){
    xcor = x;
  }
  public void setColor(String c){
    color = c;
  }

}
