public class Coord{
  private int x;
  private int y;

  public Coord(int xcor, int ycor){
    x = xcor;
    y = ycor;
  }

  public int getX(){
    return x;
  }

  public int getY(){
    return y;
  }

  public void setX(int xcor){
    x = xcor;
  }

  public void setY(int ycor){
    y = ycor;
  }

  public boolean equals(Coord position){
    return getX() == position.getX() && getY() == position.getY();
  }

  public String toString(){
    return "(" + getX() + "," + getY() + ")";
  }
}
