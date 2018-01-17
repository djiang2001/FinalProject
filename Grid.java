import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;
import java.util.*;

public class Grid extends JFrame implements MouseListener{
  
  
  private static Container pane;
  private Piece[][] squares;
  private JLabel[][] rectangles;
  private JPanel movePanel;
  private JPanel scorePanel;
  private JPanel goalPanel;
  private JLabel amove;
  private JLabel ascore;
  private JLabel agoal;
  private boolean selected = false;
  private String colorTemp;
  private int selectedX;
  private int selectedY;
  private int moves = 20;
  private int score = 0;
  private int goal = 500;
  private String[] colorHor;
  private String[] colorVert;
  public static Border standard = new LineBorder(Color.black);
  
  public Grid(){
    movePanel = new JPanel();
    scorePanel = new JPanel();
    goalPanel = new JPanel();
    amove = new JLabel("Moves:"+moves);
    ascore = new JLabel("Score:"+score);
    agoal = new JLabel("Goal:"+goal);
    movePanel.add(amove,BorderLayout.SOUTH);
    scorePanel.add(ascore,BorderLayout.SOUTH);
    goalPanel.add(agoal,BorderLayout.SOUTH);
    this.setTitle("Unblocked");
    this.setSize(800,900);//Creates a JFrame size 800 by 900
    this.setLocation(550,60);//Sets the location at 550, 60
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    pane = this.getContentPane();
    pane.setLayout(new GridLayout(11,10));
    
    Random col = new Random();
    
    squares = new Piece[10][10];
    rectangles = new JLabel[10][10];
    
    for(int i = 0; i < squares.length;i++){
      for (int j = 0; j < squares[i].length;j++) {	
        Piece blocks = new Piece(col.nextInt(5),j,i);
        ImageIcon ic = new ImageIcon(System.getProperty("user.dir") + "/blocks/" + blocks.getColor()+ ".png");
        
        JLabel icons = new JLabel(ic);
        
        squares[i][j] = blocks;
        rectangles[i][j] = icons;
        
        icons.addMouseListener(this);
        icons.setBorder(standard);
        
        pane.add(icons);
      }
    }

    pane.add(movePanel);
    pane.add(scorePanel);
    pane.add(goalPanel);
  }
  
  /*  public void swap(Piece a, Piece b){
      curBlock = b;
      b.setCor(a.getX(),a.getY());
      a.setCor(b.getX(),a.getY());
      
      pane.removeAll();
      
      Random col = new Random();
      
      for(int i = 0; i < squares.length;i++){
      for (int j = 0; j < squares[i].length;j++) {	
      Piece blocks = new Piece(col.nextInt(5),j,i);
      ImageIcon ic = new ImageIcon(System.getProperty("user.dir") + "/blocks/" + blocks.getColor()+ ".png");
      
      JLabel icons = new JLabel(ic);
      blocks.setCor(j,i);
      
      squares[i][j] = blocks;
      rectangles[i][j] = icons;
      
      icons.addMouseListener(this);
      icons.setBorder(standard);
      
      pane.add(icons);
      }
      }
      }*/
  
  public boolean hasMatch(Piece a, Piece b){
    boolean result = false;
    if(a.getColor().equals(b.getColor())){
      result = true;
    }
    return result;
  }
  
  public void fallDown(Piece a ){
    
  }
  //-Getters--//
  
  private int getMoves(){
    return moves;
  }
  
  private int getScore(){
    return score;
  }

  private int getGoal(){
    return goal;
  }
  
  private void setScore(int s){
    score = s;
  }
  
  private void setMoves(int m){
    moves = m;
  }
  
  private void setGoal(int g){
    goal = g;
  }
  
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
            //      System.out.println(getMoves());
            
            if(!selected){
              selected = true;
              colorTemp = squares[x][y].getColor();
              selectedX = x;
              selectedY = y;
              System.out.println(colorTemp);
            }
            
            else if(selected){
              System.out.println("Current:" + squares[x][y].getColor());
              //System.out.println("Past:" + selectedBlock2.getColor());
              squares[selectedX][selectedY].setColor(squares[x][y].getColor());
              //System.out.println("After" + squares[selectedBlock2.getX()][selectedBlock2.getY()].getColor());
              squares[x][y].setColor(colorTemp);
              
              if (!anyCombo()){
                squares[x][y].setColor(squares[selectedX][selectedY].getColor());
                squares[selectedX][selectedY].setColor(colorTemp);
              }
              
              colorTemp =  null;
              
              //selectedBlock2 = null;
              selected = false;

              pane.removeAll();
              makeGrid();

              pane.add(movePanel);
              pane.add(scorePanel);
              pane.add(goalPanel);
              
              /*selectedBlock2 = squares[y][x];
                int tempx = selectedBlock1.getCor().getX(); int tempy = selectedBlock1.getCor().getY();              
              */
              
              /* selectedBlock1.public int getField() {
                 return field;
                 getCor().setX(y);
                 selectedBlock1.getCor().setY(x);
                 selectedBlock2.public int getField() {
                 return field;
                 }etCor().setX(tempx);
                 selectedBlock2.getCor().setY(tempy);
                 
                 JLabel tempicon = rectangles[x][y];
                 rectangles[x][y] = rectangles[tempx][tempy];
                 rectangles[tempx][tempy] = tempicon;
                 
                 pane.removeAll();
                 moves = moves - 1;
                 for (int i = 0; i < squares.length; i++){
                 for (int j = 0; j < squares[i].length; j++){
                 pane.add(rectangles[i][j]);
                 }
                 }
                 
                 pane.add(movePanel);
                 pane.add(scorePanel);
                 pane.add(goalPanel);
                 System.out.println(selectedBlock1.getCor());
                 System.out.println(selectedBlock2.getCor());
                 selectedBlock1 = null;
                 selectedBlock2 = null;
                 //  System.out.println(hasMatch(selectedBlock,squares[x][y]));
              //change selected with second click and check chain
              selected = false;
              System.out.println(selected);
              */
            }
          }
        }
      }
    }
    System.out.println("_________________");
    pane.revalidate();
  }

  public boolean anyCombo(){
    return (checkHorizontal() || checkVertical()); 
  }

  public boolean checkHorizontal(){
    for (int i = 0; i < squares.length; i++){
      for (int j = 0; j < squares[i].length - 3; j++){
        Piece here = squares[i][j];
        Piece next = squares[i][j+1];
        Piece last = squares[i][j+2];
        if ((here.getColor()).equals(next.getColor()) &&
            (here.getColor()).equals(last.getColor())){
          return true;
        }
      }
    }
    return false;
  }

  public boolean checkVertical(){
    for (int i = 0; i < squares.length - 3; i++){
      for (int j = 0; j < squares[i].length; j++){
        Piece here = squares[i][j];
        Piece next = squares[i+1][j];
        Piece last = squares[i+2][j];
        if ((here.getColor()).equals(next.getColor()) &&
            (here.getColor()).equals(last.getColor())){
          return true;
        }
      }
    }
    return false;
  }
  
  public void makeGrid(){
    for (int i = 0; i <squares.length; i++){
      for (int j = 0; j < squares[i].length; j++){
        ImageIcon ic = new ImageIcon(System.getProperty("user.dir") + "/blocks/" +
                                     (squares[i][j]).getColor()+ ".png");
        
        JLabel icons = new JLabel(ic);

        icons.addMouseListener(this);
        icons.setBorder(standard);
        pane.add(icons);
      }
    }
  }
  
  //--MouseListener--//
  public void mouseEntered(MouseEvent e) {
    
  }
  
  public void mouseExited(MouseEvent e) {
    
  }
  
  public void mousePressed(MouseEvent e) {
    
  }
  
  public void mouseReleased(MouseEvent e) {
    
  }
  
  
  public static void main (String[] args){
    Grid game = new Grid();
    game.setVisible(true);
    game.setResizable(false);
  }
}
