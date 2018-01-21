import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main extends JFrame{
  private static Container pane;
  private JFrame main = new JFrame("Introduction");
  private static JButton enter = new JButton("Click Anywhere to Start Redemption Quest!");

  public Main(){
    pane = this.getContentPane();
    this.setSize(600,300);

    enter.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          new Grid();
          main.dispose();
        }
      });

    ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "/" + "title.jpg");
    System.out.println(System.getProperty("user.dir") +"/" + "title.jpg");
    enter.setIcon(icon);
    enter.setHorizontalTextPosition(JButton.CENTER);
    enter.setVerticalTextPosition(JButton.BOTTOM);
    enter.setBorder(BorderFactory.createEmptyBorder());
    enter.setBackground(Color.BLACK);
    enter.setForeground(Color.WHITE);
    main.add(enter);
    main.pack();


    enter.setVisible(true);
    // main.add(enter);
    main.setVisible(true);
  }

  public static void main(String[] args){
    Main start = new Main();
  }
}
