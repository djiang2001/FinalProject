import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class Start extends JFrame{
  private static Container pane;
  private JFrame start = new JFrame("Introduction");
  private static JButton enter = new JButton("Continue");
  private static JTextArea intro = new JTextArea();
  private static String words = "\n\nOh Dear!\n\nYou were talking to that one special person when your fingers fumbled. While trying to take back what you wrote, you have been blocked. Now it is your mission to be...";

  //Game Intro Constructor
  public Start(){
    pane = this.getContentPane();
    this.setTitle("Mission Page");
    this.setSize(600,300);
    this.setLocation(700 ,300);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    //Add properties
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    enter.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          new Main();
          intro.append("UNBLOCKED!");
          pane.remove(enter);
          pane.revalidate();
          setVisible(false);
        }
      }
      );
    intro.setFont(new Font("Segoe Script",Font.ITALIC, 20));
    intro.setLineWrap(true);
    intro.setWrapStyleWord(true);
    intro.setEditable(false);
    pane.add(intro);
    pane.add(enter);
    enter.setVisible(false);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  }

  //Animation Code
  public static void appendtext(){
    for (int i = 0; i < words.length(); i++){
      intro.append(words.charAt(i) + "");
      try {
        Thread.sleep(40);}catch(Exception e){}
    }
    enter.setVisible(true);
  }

  //Main
  public static void main(String[]args){
    Start intro = new Start();
    intro.setVisible(true);
    intro.setResizable(false);
    appendtext();
  }

}
