import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;
import java.lang.*;

public class End extends JFrame{
  private static Container pane;
  private JFrame start = new JFrame("Introduction");
  private static JButton enter = new JButton("Continue");

  public End(String s){
    pane = this.getContentPane();
    this.setTitle(s);
  }
}
