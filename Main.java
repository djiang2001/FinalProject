import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main extends JFrame{
  private static Container pane;
  private JFrame main = new JFrame("Introduction");
  private static JButton enter = new JButton("Start Redemption Quest");
  private JLabel background = new JLabel();


  public Main(){
    pane = this.getContentPane();
    this.setSize(600,300);

    enter.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          main.dispose();
          new Grid();
        }
      });

    background.setIcon(new ImageIcon(System.getProperty("user.dir") + "title.jpg"));
    background.setVisible(true);
    main.add(background);
    main.pack();
  }

  public static void main(String[] args){
    Main start = new Main();
    start.setResizable(false);
    start.setVisible(true);
  }
}
