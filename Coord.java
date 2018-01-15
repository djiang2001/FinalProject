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

  public boolean equals(Coord position){
    return getX() == position.getX() && getY() == position.getY();
  }

}
