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
  private Piece selectedBlock;
  private int moves = 20;
  private int score = 0;
  private int goal = 500;
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
    this.setSize(800,900);//Creates a JFrame size 600 by 600
    this.setLocation(550,150);//Sets the location at 550, 150
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    pane = this.getContentPane();
    pane.setLayout(new GridLayout(11,10));
    
    Random col = new Random();
    
    squares = new Piece[10][10];
    rectangles = new JLabel[10][10];
    
    for(int i = 0; i < squares.length;i++){
      for (int j = 0; j < squares[i].length;j++) {	
        Piece blocks = new Piece(col.nextInt(5), i,j);
        ImageIcon ic = new ImageIcon(System.getProperty("user.dir") + "/blocks/" + blocks.getColor()+ ".png");

        JLabel icons = new JLabel(ic);
        blocks.setY(i);
        blocks.setX(j);

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

  
  public boolean hasMatch(Piece a, Piece b){
    boolean result = false;
    if(a.getColor().equals(b.getColor())){
      result = true;
    }
    return result;
  }

  public void fallDown(Piece a, Piece b){
    
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
        
    }else{
      JLabel a = (JLabel) e.getSource();
      for (int y = 0; y < squares.length; y++){
        for (int x = 0; x < squares[y].length; x++){
          if (a == rectangles[x][y]){
            System.out.println(squares[x][y].getX());
            System.out.println(squares[x][y].getY());
            System.out.println(squares[x][y].getColor());
            System.out.println(getMoves());
            System.out.println("_________________");
          }
        }
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
