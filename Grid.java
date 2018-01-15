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
  private Piece selectedBlock1;
  private Piece selectedBlock2;
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

  public Grid(Piece[][] previous, JLabel[][] previousr){
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

    squares = previous;
    rectangles = previousr;

    for (int i=0; i <squares.length; i++){
      for (int j=0; j <squares[i].length; j++){
        rectangles[j][i].addMouseListener(this);
        rectangles[j][i].setBorder(standard);
        pane.add(rectangles[j][i]);
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
            System.out.println(squares[x][y].getY());
            System.out.println(squares[x][y].getColor());
            System.out.println(getMoves());
            System.out.println("_________________");
            
            if (selected){
              selectedBlock2 = squares[x][y];
              Piece[][] temp = squares;
              int newx1 = selectedBlock1.getX();
              int newy1 = selectedBlock1.getY();
              int newx2 = selectedBlock2.getX();
              int newy2 = selectedBlock2.getY();
              temp[newx1][newy1] = squares[newx2][newy2];
              squares[newx2][newy2] = squares[newx1][newy1];
              squares[newx1][newy1] = temp[newx1][newx2];
              
              ImageIcon ic1 = new ImageIcon(System.getProperty("user.dir") + "/blocks/" + squares[newx1][newy1].getColor()+ ".png");
              ImageIcon ic2 = new ImageIcon(System.getProperty("user.dir") + "/blocks/" + squares[newx2][newy2].getColor()+ ".png");
              
              rectangles[newx1][newy1] = new JLabel(ic1);
              rectangles[newx2][newy2] = new JLabel(ic2);
              this.dispose();
              
              Grid game = new Grid(squares,rectangles);
              game.setVisible(true);
              game.setResizable(false);
    
            }
            
            else if(!selected){
              selected = true;
              selectedBlock1 = squares[x][y];
              System.out.println(selectedBlock1.getX());
            }
            // else if(selected){
            //   System.out.println(hasMatch(selectedBlock1,squares[x][y]));
            //   //change selected with second click and check chain
            // }
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
