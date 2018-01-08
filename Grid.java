import javax.swing.JPanel;
import javax.swing.JLabel;

public class Grid extends JPanel{
  private int len;
  private int wid;
  private Block[][] content = new Block[10][10];
  private int moves;
  JLabel Score;

  public Grid(int difficulty){
    setFocusable(true);
    makeGrid(difficulty);
    resetGrid();
  }

  public void makeGrid(int difficulty){
    len = 10;
    wid = 10;
    if(difficulty == 1){
      moves = 30;
        } else if(difficulty == 2){
      moves = 25;
        } else {
      moves = 20;
    }

  }

  public void resetGrid(){
    for (int i = 0; i < len; i++){
      for (int j = 0; j < wid; j++){
        content[i][j] = new Block("red",i,j);
      }
    }
  }

  public void setMoves(int amount){
    moves = amount;
  }
  public int getMoves(){
    return moves;
  }


  public Block[][] getContent(){
    return content;
  }

  public void main(String[] args){
    System.out.println(getContent());
  }
}
