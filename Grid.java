import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;
import java.lang.*;

public class Grid extends JFrame implements ActionListener{
  private final int Rows = 10, Cols = 10;
  private final Piece[][] board;
  private final JLabel status;
  private int movesLeft;
  private int goal;
  private int scores;
  private boolean selected = false;
  private int selX;
  private int selY;
  private PieceColor colorTemp;
  
  public Grid(){
    movesLeft = 20;
    scores = 0;
    board = new Piece [Rows][Cols];
    status = new JLabel();


    this.setTitle("Unblocked");
    this.setSize(800,800);
    this.setLayout(new BorderLayout());
    add(createPiecePanel(),BorderLayout.CENTER);
    add(createStatusPanel(),BorderLayout.SOUTH);
    updateStatusPanel();

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  
  private JPanel createStatusPanel(){
    JPanel p = new JPanel();
    p.add(status, BorderLayout.SOUTH);
    return p;
  }

  private JPanel createPiecePanel(){
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(Rows,Cols));
    for(int row = 0; row < Rows; row++){
	    for(int col = 0; col < Cols; col++){
        Piece piece = new Piece(row,col,PieceColor.randPick());
        piece.addActionListener(this);
        board[row][col] = piece;
        p.add(piece);
	    }
    }
    return p;
  }
  
  //-Getters and Setters--//
  
  private int getMoves(){
    return movesLeft;
  }
  
  private int getScore(){
    return scores;
  }

  private int getGoal(){
    return goal;
  }
  
  private void setScore(int s){
    scores = s;
  }
  
  private void setMoves(int m){
    movesLeft = m;
  }
  
  private void setGoal(int g){
    goal = g;
  }

  public boolean anyCombo(){
    return (checkHorizontal() || checkVertical()); 
  }

  public boolean checkHorizontal(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length - 3; j++){
        Piece here = board[i][j];
        Piece next1 = board[i][j+1];
        Piece last = board[i][j+2];

        //String colStat = here.getColor();
        if (here.equals(next1) &&
            here.equals(last)){
          return true;
        }
      }
    }
    return false;
  }

  public boolean checkVertical(){
    for (int i = 0; i < board.length - 3; i++){
      for (int j = 0; j < board[i].length; j++){
        Piece here = board[i][j];
        Piece next = board[i+1][j];
        Piece last = board[i+2][j];
        if (here.equals(next) &&
            here.equals(last)){
          return true;
        }
      }
    }
    return false;
  }

  /*  public boolean anyMissing(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j].getColor() == BLACK){
          return true;
        }
      }
    }
    return false; 
  }
  */
  
  /*  public void fallDown(){
    while (anyMissing()){
      for (int i = 0; i < board.length-1; i++){
        for (int j = 0; j < board[i].length; j++){
          if (i == 0 && board[i][j].getColor() == PieceColor(BLACK)){
            board[i][j].setColor(PieceColor.randPick());
          }
          if (board[i+1][j].getColor() == BLACK){
            board[i+1][j].setColor(board[i][j].getColor());
            board[i][j].setColor(BLACK);
          }
        }
      }
    }
  }
  */

  /*  public void destroy(){
    if (anyCombo()){
      for (int i = 0; i < board.length; i++){
        for (int j = 0; j < board[i].length; j++){
          if (board[i][j].equals(board[i][j+1]) &&
              board[i][j].equals(board[i][j+2]) &&
              j + 3 < board[i].length){
            board[i][j].setColor(null);
            board[i][j+1].setColor(null);
            board[i][j+1].setColor(null);
          }
        }
      }
    }
    }*/
  
  //--ActionListener--//
  
  @Override
  public void actionPerformed(ActionEvent e){

    Piece p = (Piece) e.getSource();
    System.out.println(p.getColor());
    System.out.println(p.getRow());
    // fallDown();
    if(movesLeft > 0){
      if(!selected){
        selected = true;
        colorTemp = p.getColor();
        selX = p.getRow();
        selY = p.getCol();
        System.out.println(colorTemp);
      } else{
        boolean bound = ((Math.abs(selX-p.getRow()) == 1 && Math.abs(selY-p.getCol()) == 0) || (Math.abs(selY-p.getCol()) == 1 && Math.abs(selX-p.getRow()) == 0));
        System.out.println("Current:" + p.getColor());
        System.out.println(selX - p.getRow());
        if(this.anyCombo() && bound) {
        board[selX][selY].setColor(p.getColor());
        p.setColor(colorTemp);
        movesLeft -= 1;
        }
        selected = false;
        updateStatusPanel();
      }
    }  
  }

    /*
   public void mouseClicked(MouseEvent e){
     if(moves == 0){
       amove.setText("Game Over");
     }else{
       JLabel a = (JLabel) e.getSource();
       for (int y = 0; y < squares.length; y++){
         for (int x = 0; x < squares[y].length; x++){
           if (a == rectangles[x][y]){
             System.out.println(squares[x][y].getX());
             System.out.println(squares[x][y].getColor());
            
             if(!selected){
               selected = true;
               colorTemp = squares[x][y].getColor();
               selX = x;
               selY = y;
               System.out.println(colorTemp);
             }
            
             else{
               System.out.println("Current:" + squares[x][y].getColor());
		
               squares[selX][selY].setColor(squares[x][y].getColor());
               squares[x][y].setColor(colorTemp);

               ImageIcon currentIcon = new ImageIcon(System.getProperty("user.dir") + "/blocks/" + (squares[x][y]).getColor()+ ".png");
		
               ImageIcon prevIcon = new ImageIcon(System.getProperty("user.dir") + "/blocks/" + (squares[selX][selY]).getColor()+ ".png");
		
               rectangles[x][y].setIcon(currentIcon);
               rectangles[selX][selY].setIcon(prevIcon);
              
               if (!anyCombo()){
                 squares[x][y].setColor(squares[selX][selY].getColor());
                 squares[selX][selY].setColor(colorTemp);
               }

		currentIcon = new ImageIcon(System.getProperty("user.dir") + "/blocks/" + (squares[x][y]).getColor()+ ".png");

		prevIcon = new ImageIcon(System.getProperty("user.dir") + "/blocks/" + (squares[selX][selY]).getColor()+ ".png");
	      
		rectangles[x][y].setIcon(currentIcon);
		rectangles[selX][selY].setIcon(prevIcon);
		
		colorTemp =  null;
		selected = false;

    findChains();
    // destroyChains();
    System.out.println(countCombos());

    setMoves(moves - 1);
    amove.setText("Moves:"+moves);
            }
          }
        }
      }
    }
    System.out.println("_________________");
    pane.revalidate();
  }

  public void findChainVertical(){
    ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "/blocks/" + "black"+ ".png");
    if (checkVertical()){
      for (int i = 0; i < squares.length-3; i++){
        for (int j = 0; j < squares[i].length; j++){
          Piece here = squares[i][j];
          Piece twov = squares[i+1][j];
          Piece threev = squares[i+2][j];
          if( i + 4 < squares.length ){
            Piece fourv = squares[i+3][j];
            Piece fivev = squares[i+4][j];
            if ((here.getColor()).equals(twov.getColor()) &&
                (here.getColor()).equals(threev.getColor()) &&
                (here.getColor()).equals(fourv.getColor()) &&
                (here.getColor()).equals(fivev.getColor())){
              squares[i][j].setColor("black");
              squares[i+1][j].setColor("black");
              squares[i+2][j].setColor("black");
              squares[i+3][j].setColor("black");
              squares[i+4][j].setColor("black");

              rectangles[i][j].setIcon(icon);
              rectangles[i+1][j].setIcon(icon);
              rectangles[i+2][j].setIcon(icon);
              rectangles[i+3][j].setIcon(icon);
              rectangles[i+4][j].setIcon(icon);
            }
          }
	  if( i + 3 < squares.length ){
            Piece fourv = squares[i+3][j];
            if ((here.getColor()).equals(twov.getColor()) &&
                (here.getColor()).equals(threev.getColor()) &&
                (here.getColor()).equals(fourv.getColor())){
                            squares[i][j].setColor("black");
              squares[i][j].setColor("black");
              squares[i+1][j].setColor("black");
              squares[i+2][j].setColor("black");
              squares[i+3][j].setColor("black");

              rectangles[i][j].setIcon(icon);
              rectangles[i+1][j].setIcon(icon);
              rectangles[i+2][j].setIcon(icon);
              rectangles[i+3][j].setIcon(icon);
            }
          }
          else{
             if ((here.getColor()).equals(twov.getColor()) &&
                 (here.getColor()).equals(threev.getColor())){
                   squares[i][j].setColor("black");
              squares[i+1][j].setColor("black");
              squares[i+2][j].setColor("black");
              squares[i+3][j].setColor("black");

              rectangles[i][j].setIcon(icon);
              rectangles[i+1][j].setIcon(icon);
              rectangles[i+2][j].setIcon(icon);
              rectangles[i+3][j].setIcon(icon);
             }
          }
        }
      }
    }
  }


  public void findChainHorizontal(){
    ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "/blocks/" + "black"+ ".png");
    if (checkHorizontal()){
      for (int i = 0; i < squares.length; i++){
        for (int j = 0; j < squares[i].length-3; j++){
          Piece here = squares[i][j];
          Piece twoh = squares[i][j+1];
          Piece threeh = squares[i][j+2];
          if (j + 4 < squares[i].length){
            Piece fourh = squares[i][j+3];
            Piece fiveh = squares[i][j+4];
            if ((here.getColor()).equals(twoh.getColor()) &&
                (here.getColor()).equals(threeh.getColor()) &&
                (here.getColor()).equals(fourh.getColor()) &&
                (here.getColor()).equals(fiveh.getColor())){
              squares[i][j].setColor("black");
              squares[i][j+1].setColor("black");
              squares[i][j+2].setColor("black");
              squares[i][j+3].setColor("black");
              squares[i][j+4].setColor("black");

              rectangles[i][j].setIcon(icon);
              rectangles[i][j+1].setIcon(icon);
              rectangles[i][j+2].setIcon(icon);
              rectangles[i][j+3].setIcon(icon);
              rectangles[i][j+4].setIcon(icon);
            }
          } 
          if (j + 3 < squares[i].length){
            Piece fourh = squares[i][j+3];
            if ((here.getColor()).equals(twoh.getColor()) &&
                (here.getColor()).equals(threeh.getColor()) &&
                (here.getColor()).equals(fourh.getColor())){
              squares[i][j].setColor("black");
              squares[i][j+1].setColor("black");
              squares[i][j+2].setColor("black");
              squares[i][j+3].setColor("black");

              rectangles[i][j].setIcon(icon);
              rectangles[i][j+1].setIcon(icon);
              rectangles[i][j+2].setIcon(icon);
              rectangles[i][j+3].setIcon(icon);
            }
          }
          else {
              squares[i][j].setColor("black");
              squares[i][j+1].setColor("black");
              squares[i][j+2].setColor("black");

              rectangles[i][j].setIcon(icon);
              rectangles[i][j+1].setIcon(icon);
              rectangles[i][j+2].setIcon(icon);
          }
        }
      }
    }
  }

  public void findChains(){
    findChainVertical();
    findChainHorizontal();
  }

   public int countCombos(){
    int result = 0;
    for(int i = 0; i < squares.length;i++){
      for(int j = 0; j < squares[i].length;j++){
        if(squares[i][j].getColor().equals("black")){
          result++;
        }
      }
    }
    return result;
  }
  

   public void destroyChains(){
    Random colors = new Random();
    int a = 0;
      while(a < countCombos()){
        for(int i = 0; i < squares.length; i++){
          for(int j = 0; j < squares[i].length; j++){
            if(i == 0){
              if(squares[i+1][j].getColor().equals("black")){
                comboColor = squares[i][j].getColor();
                squares[i][j].setColor(colors.nextInt(5));
                squares[i+1][j].setColor(comboColor);

               ImageIcon comboNow = new ImageIcon(System.getProperty("user.dir") + "/blocks/" + (squares[i][j]).getColor()+ ".png");

                ImageIcon comboThen = new ImageIcon(System.getProperty("user.dir") + "/blocks/" + (squares[i + 1][j]).getColor()+ ".png");

                rectangles[i][j].setIcon(comboNow);
                rectangles[i+1][j].setIcon(comboThen);
                
              }else{
                comboColor = squares[i][j].getColor();
                squares[i+1][j].setColor(comboColor);
                ImageIcon comboNow = new ImageIcon(System.getProperty("user.dir") + "/blocks/" + (squares[i][j]).getColor()+ ".png");

                ImageIcon comboThen = new ImageIcon(System.getProperty("user.dir") + "/blocks/" + (squares[i + 1][j]).getColor()+ ".png");

                rectangles[i][j].setIcon(comboNow);
                rectangles[i+1][j].setIcon(comboThen);
              }
            }
          }
        }
      }
  }
  
  

  
  public void mouseEntered(MouseEvent e) {
    
  }
  
  public void mouseExited(MouseEvent e) {
    
  }
  
  public void mousePressed(MouseEvent e) {
    
  }
  
  public void mouseReleased(MouseEvent e) {
    
  }
  
    */
      private void updateStatusPanel() {
	        if (movesLeft==0) {
            status.setText("Game Over   Score: " + this.getScore() + "   Goal: " + this.getGoal());
	        } else {
            status.setText("Moves:" + movesLeft + "  Score: " + this.getScore() + "   Goal: " + this.getGoal());
	        }
      }
  
  public static void main (String[] args){
    Grid game = new Grid();
    game.setVisible(true);
    game.setResizable(false);
  }
}
