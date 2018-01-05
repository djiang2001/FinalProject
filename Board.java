import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Board extends JFrame{
    private Container pane;

    public Board(){
	this.setTitle("Deblocked");
	this.setSize(600,600);
	this.setLocation(550,150);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	

	addMouseListener(new MouseAdapter() {
		public void mousePressed(MouseEvent demo){
		    System.out.println("hello");
		}
	    });

	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));

	
	pane.add(Box.createHorizontalGlue());
	pane.add(Box.createRigidArea(new Dimension(10, 0)));
    }


    public static void main (String[] args )
    {
	Board game = new Board();
	game.setAlwaysOnTop(true);
	game.setVisible(true);
	game.setResizable(false);
    }
}
