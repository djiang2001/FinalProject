import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main extends JFrame{
  private static Container pane;
  private JFrame main = new JFrame("UNBLOCKED");
  private static JButton enter = new JButton("Click Anywhere to Start Redemption Quest!");

  //Title Page Constructor
  public Main(){
    pane = this.getContentPane();
    this.setSize(600,300);
    main.setLocation(600,300);
    enter.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          main.dispose();
          Grid.main(null);
        }
      });

    //Add Image and Background
    ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "/" + "title.jpg");
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

  //Main
  public static void main(String[] args){
    Main start = new Main();
    start.setResizable(false);
  }
}
