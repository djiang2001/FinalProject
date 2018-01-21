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
  public int numCombo;
  
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
  
  //--Methods--//
  public boolean anyCombo(){
    return (checkHorizontal() || checkVertical()); 
  }

  public boolean checkHorizontal(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length - 3; j++){
        Piece here = board[i][j];
        Piece next1 = board[i][j+1];
        Piece last = board[i][j+2];
        
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

  public void countCombo(){
    numCombo = 0;
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        if(board[i][j].isCombo()){
          numCombo += 1 ;
        }
      }
    }
  }
  
   public boolean anyMissing(){
    boolean result = false;
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        result = board[i][j].isCombo() || result;
      }
    }
    return result; 
  }

  public void findCombos(){
    rowCombo();
    colCombo();
  }

  public void rowCombo(){
    if (checkVertical()){
      for (int i = 0; i < board.length-3; i++){
        for (int j = 0; j < board[i].length; j++){
          Piece here = board[i][j];
          Piece twov = board[i+1][j];
          Piece threev = board[i+2][j];
          if( i + 2 < board.length ){
            if (here.equals(twov) &&
                here.equals(threev)){
              board[i][j].setCombo(true);
              board[i+1][j].setCombo(true);
              board[i+2][j].setCombo(true);
            }  
          }
          if( i + 4 < board.length ){
            Piece fourv = board[i+3][j];
            Piece fivev = board[i+4][j];
            if (here.equals(twov) &&
                here.equals(threev) &&
                here.equals(fourv) &&
                here.equals(fivev)){
              board[i][j].setCombo(true);
              board[i+1][j].setCombo(true);
              board[i+2][j].setCombo(true);
              board[i+3][j].setCombo(true);
              board[i+4][j].setCombo(true);
            }
          }
          if( i + 3 < board.length ){
            Piece fourv = board[i+3][j];
            if (here.equals(twov) &&
                here.equals(threev) &&
                here.equals(fourv)){
              board[i][j].setCombo(true);
              board[i+1][j].setCombo(true);
              board[i+2][j].setCombo(true);
              board[i+3][j].setCombo(true);
            }
          }   
        }
      }
    }
  }

  public void colCombo(){
    if (checkHorizontal()){
      for (int i = 0; i < board.length; i++){
        for (int j = 0; j < board[i].length-3; j++){
          Piece here = board[i][j];
          Piece twoh = board[i][j+1];
          Piece threeh = board[i][j+2];
          if (j + 2 < board[i].length){
            if (here.equals(twoh) &&
                here.equals(threeh)){
            board[i][j].setCombo(true);
            board[i][j+1].setCombo(true);
            board[i][j+2].setCombo(true);
            }
          }
          if (j + 4 < board[i].length){
            Piece fourh = board[i][j+3];
            Piece fiveh = board[i][j+4];
            if (here.equals(twoh) &&
                here.equals(threeh) &&
                here.equals(fourh) &&
                here.equals(fiveh)){
              board[i][j].setCombo(true);
              board[i][j+1].setCombo(true);
              board[i][j+2].setCombo(true);
              board[i][j+3].setCombo(true);
              board[i][j+4].setCombo(true);
            }
          }
          if (j + 3 < board[i].length){
            Piece fourh = board[i][j+3];
            if (here.equals(twoh) &&
                here.equals(threeh) &&
                here.equals(fourh)){
              board[i][j]. setCombo(true);
              board[i][j+1].setCombo(true);
              board[i][j+2].setCombo(true);
              board[i][j+3].setCombo(true);
            }
          }
        }
      }
    }
  }
    
   public void fallDown(){
     while(numCombo > 0){
      for (int i = 0; i < board.length-1; i++){
        for (int j = 0; j < board[i].length; j++){
          if(board[i][j].getRow() == 0 && board[i+1][j].isCombo()){
            board[i+1][j].setColor(board[i][j].getColor());
            board[i+1][j].setCombo(false);
            numCombo -= 1;
            board[i][j].setColor(PieceColor.randPick());
          }
          else{
            if(board[i+1][j].isCombo()){
              board[i][j].setCombo(true);
              numCombo += 1;
              board[i+1][j].setColor(board[i][j].getColor());
              board[i+1][j].setCombo(false);
              numCombo -= 1;
              System.out.println(numCombo);
            }
          }
        }
      }
     }
   }
  //--ActionListener--//
  
  @Override
  public void actionPerformed(ActionEvent e){
    Piece p = (Piece) e.getSource();
    countCombo();
    // System.out.println(p.getColor());
    // System.out.println(p.getRow());
    // System.out.println(p.isCombo());
    // System.out.println(numCombo);

    if(movesLeft > 0){
      if(!selected){
        notSelectedAction(p);
      } else{
        selectedAction(p);
        selected = false;
        findCombos();
        updateStatusPanel();
        fallDown();
      }
    }  
  }

  public void notSelectedAction(Piece n){
    selected = true;
    colorTemp = n.getColor();
    selX = n.getRow();
    selY = n.getCol();
    System.out.println(colorTemp);
  }

  public void selectedAction(Piece i){
    boolean bound = (Math.abs(selX-i.getRow()) <= 1 && Math.abs(selY-i.getCol()) <= 1);// || (Math.abs(selY-i.getCol()) <= 1 && Math.abs(selX-i.getRow()) == 0));
    System.out.println("Current:" + i.getColor());
    System.out.println(selX - i.getRow());
    if(this.anyCombo() && bound && !i.equals(board[selX][selY])) {
      board[selX][selY].setColor(i.getColor());
      i.setColor(colorTemp);
      movesLeft -= 1;
    }
  }
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
