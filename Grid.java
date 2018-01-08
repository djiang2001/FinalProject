public class Grid{
  public static int len;
  public static int wid;
  public String[][] conten = new String[5][5];

  public Grid(){
    makeGrid();
    fillGrid();
  }

  public static void makeGrid(){
    len = 5;
    wid = 5;
  }

  public void fillGrid(){
  }
}
