import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Board extends JFrame{
  JFrame window;
  JLabel board[][];
  int colorNum[][];
  Random colorer;

  public Board(){
    window = new JFrame("Deblocked");
    window.setSize(800,900);
    window.setLayout(null);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);

    board = new JLabel[10][10];
    colorNum = new int[10][10];
    colorer = new Random();

    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board.length; j++){
        board[i][j] = new JLabel();
        board[i][j].setBounds(0 + i * 50,0 + j * 50,50,50);
        colorNum[i][j] = colorer.nextInt(4) + 1;
        board[i][j].setIcon(new ImageIcon("user.dir" + "/blocks/" + colorNum[i][j] + ".png" ));
        board[i][j].setVisible(true);
        window.add(board[i][j]);

      }
    }


  }

  public static void main(String[] args){
    Board game = new Board();
    game.setVisible(true);
    game.setResizable(false);
  }
}
