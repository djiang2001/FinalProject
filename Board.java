import java.awt.*;
import javax.swing.*;
public class Board extends JFrame{

  public Board(){
    this.setTitle("Deblocked");
    this.setSize(600,600);
    this.setLocation(550,150);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }


  public static void main (String[] args )
  {
    Board frame  = new Board();

    frame.setVisible(true );

  }
}
