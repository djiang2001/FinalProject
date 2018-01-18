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
  private int selX;
  private int selY;
  private int moves = 20;
  private int score = 0;
  private int goal = 500;
  private ArrayList<Integer> toDestroy = new ArrayList<Integer>();
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
  
  
  public boolean hasMatch(Piece a, Piece b){
    boolean result = false;
    if(a.getColor().equals(b.getColor())){
      result = true;
    }
    return result;
  }
  
  public void fallDown(Piece a ){
    
  }
  //-Getters and Setters--//
  
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

    
    
  public boolean anyCombo(){
    return (checkHorizontal() || checkVertical()); 
  }

  public boolean checkHorizontal(){
    for (int i = 0; i < squares.length; i++){
      for (int j = 0; j < squares[i].length - 3; j++){
        Piece here = squares[i][j];
        Piece next1 = squares[i][j+1];
        Piece last = squares[i][j+2];

	//String colStat = here.getColor();
        if ((here.getColor()).equals(next1.getColor()) &&
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
  
  //--MouseListener--//
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
            }
          }
        }
      }
    }
    System.out.println("_________________");
    pane.revalidate();
  }

  public void findChainVertical(){
    if (checkVertical()){
      for (int i = 0; i < squares.length; i++){
        for (int j = 0; j < squares[i].length; j++){
          Piece here = squares[i][j];
          Piece twov = squares[i+1][j];
          Piece threev = squares[i+2][j];
          Piece fourv = squares[i+3][j];
          Piece fivev = squares[i+4][j];
          if ((here.getColor()).equals(twov.getColor()) &&
              (here.getColor()).equals(threev.getColor()) &&
              (here.getColor()).equals(fourv.getColor()) &&
              (here.getColor()).equals(fivev.getColor())){
            toDestroy.add(new Integer(i));
            toDestroy.add(new Integer(j));
            toDestroy.add(new Integer(i+1));
            toDestroy.add(new Integer(j));
            toDestroy.add(new Integer(i+2));
            toDestroy.add(new Integer(j));
            toDestroy.add(new Integer(i+3));
            toDestroy.add(new Integer(j));
            toDestroy.add(new Integer(i+4));
            toDestroy.add(new Integer(j));
          }
          else if ((here.getColor()).equals(twov.getColor()) &&
                   (here.getColor()).equals(threev.getColor()) &&
                   (here.getColor()).equals(fourv.getColor())){
            toDestroy.add(new Integer(i));
            toDestroy.add(new Integer(j));
            toDestroy.add(new Integer(i+1));
            toDestroy.add(new Integer(j));
            toDestroy.add(new Integer(i+2));
            toDestroy.add(new Integer(j));
            toDestroy.add(new Integer(i+3));
            toDestroy.add(new Integer(j));
          }
          else{
            toDestroy.add(new Integer(i));
            toDestroy.add(new Integer(j));
            toDestroy.add(new Integer(i+1));
            toDestroy.add(new Integer(j));
            toDestroy.add(new Integer(i+2));
            toDestroy.add(new Integer(j));
          }
        }
      }
    }
  }

  public void findChainHorizontal(){
    if (checkHorizontal()){
      for (int i = 0; i < squares.length; i++){
        for (int j = 0; j < squares[i].length; j++){
          Piece here = squares[i][j];
          Piece twoh = squares[i][j+1];
          Piece threeh = squares[i][j+2];
          Piece fourh = squares[i][j+1];
          Piece fiveh = squares[i][j+2];
          if ((here.getColor()).equals(twoh.getColor()) &&
              (here.getColor()).equals(threeh.getColor()) &&
              (here.getColor()).equals(fourh.getColor()) &&
              (here.getColor()).equals(fiveh.getColor())){
            toDestroy.add(new Integer(i));
            toDestroy.add(new Integer(j));
            toDestroy.add(new Integer(i));
            toDestroy.add(new Integer(j+1));
            toDestroy.add(new Integer(i));
            toDestroy.add(new Integer(j+2));
            toDestroy.add(new Integer(i));
            toDestroy.add(new Integer(j+3));
            toDestroy.add(new Integer(i));
            toDestroy.add(new Integer(j+4));
          }
          else if ((here.getColor()).equals(twoh.getColor()) &&
                   (here.getColor()).equals(threeh.getColor()) &&
                   (here.getColor()).equals(fourh.getColor())){
            toDestroy.add(new Integer(i));
            toDestroy.add(new Integer(j));
            toDestroy.add(new Integer(i));
            toDestroy.add(new Integer(j+1));
            toDestroy.add(new Integer(i));
            toDestroy.add(new Integer(j+2));
            toDestroy.add(new Integer(i));
            toDestroy.add(new Integer(j+3));
          }
          else {
            toDestroy.add(new Integer(i));
            toDestroy.add(new Integer(j));
            toDestroy.add(new Integer(i));
            toDestroy.add(new Integer(j+1));
            toDestroy.add(new Integer(i));
            toDestroy.add(new Integer(j+2));
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
  
  
  public static void main (String[] args){
    Grid game = new Grid();
    game.setVisible(true);
    game.setResizable(false);
  }
}
