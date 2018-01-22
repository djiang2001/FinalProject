import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;
import java.lang.*;

public class End extends JFrame{
  private static Container pane;
  private JFrame end = new JFrame("Game Over");
  private static JButton enter = new JButton("Quit");
  private static JButton again = new JButton("Try Once More!");
  private static JButton more = new JButton("I Got Blocked Again :(");

  // Game over Screen Constructor
  public End(String s){
    pane = this.getContentPane();
    this.setTitle(s);
    this.setSize(600,300);
    end.setLocation(600,300);
    end.setLayout(new FlowLayout());

    //Button Functions
    enter.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          System.exit(0);
        }
      });

    again.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          end.dispose();
          Grid.main(null);
        }
      });
    more.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          end.dispose();
          Grid.main(null);
        }
      });

    //Failure or Success Paths
    if (s.equals("Failure")){
      end.add(new JLabel(new ImageIcon(System.getProperty("user.dir") + "/" + "blocked.png")));
      end.add(enter);
      end.add(again);
      end.pack();
      enter.setVisible(true);
      again.setVisible(true);
      end.setVisible(true);
    }

    else if (s.equals("Unblocked")){
      end.add(new JLabel(new ImageIcon(System.getProperty("user.dir") + "/" + "success.jpg")));
        end.add(enter);
        end.add(more);
        end.pack();
        enter.setVisible(true);
        more.setVisible(true);
        end.setVisible(true);
    }
    end.setResizable(false);
  }

  //Main
  public static void main(String[]args){
    End test = new End("Failure");
  }
}
