import javax.swing.JPanel;
import javax.swing.JLabel;

public class Grid extends JPanel{
  private int len;
  private int wid;
  private String[][] content = new String[10][10];
  private int moves;
  JLabel Score;
  
  //--Constructor--//
  public Grid(int difficulty){
    setFocusable(true);
    makeGrid(difficulty);
    resetGrid();
    return content;
  }

  //--Grid Making Methods--//
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
        Block b = new Block("red",i,j);
        content[i][j] = b;
      }
    }
  }

  private void addBlock(Graphics g, int x, int y){
    Color colorSet[] {
      new Color(255,0,0),
        new Color(0,0,255),
        new Color(255,255,0),
        }
    Color color = colorSet[];
    g.setColor(color);
  }
    
  public void paint(Graphics g){
    super.paint(g);


    /*   int top = 
    for (int i = 0; i < len; i++){
	    for (int j = 0; j < wid; j++){
        addBlock(g,0 + j * wid, top + i * len) 
	    }
      } */
  }
    


  public void setMoves(int amount){
    moves = amount;
  }
  
  public int getMoves(){
    return moves;
  }


  public String[][] getContent(){
    return content;
  }

  public void main(String[] args){
    System.out.println(getContent());
  }
}
