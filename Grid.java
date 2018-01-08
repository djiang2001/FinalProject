public class Grid{
  public static int len;
  public static int wid;
  public Block[][] content = new Block[5][5];

  public Grid(){
    makeGrid();
    fillGrid();
  }

  public static void makeGrid(){
    len = 5;
    wid = 5;
  }

  public void fillGrid(){
    for (int i = 0; i < len; i++){
      for (int j = 0; j < wid; j++){
        content[i][j] = new Block("red",i,j);
      }
    }
  }

}
