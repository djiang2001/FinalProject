public class Grid implements {
  public int len;
  public int wid;
  public Block[][] content = new Block[5][5];

  public Grid(){
    makeGrid();
    resetGrid();
  }

  public  void makeGrid(){
    len = 10;
    wid = 10;
  }

  public void resetGrid(){
    for (int i = 0; i < len; i++){
      for (int j = 0; j < wid; j++){
        content[i][j] = new Block("red",i,j);
      }
    }
  }



  public Block[][] getContent(){
    return content;
  }

  public void main(String[] args){
    System.out.println(getContent());
  }
}
