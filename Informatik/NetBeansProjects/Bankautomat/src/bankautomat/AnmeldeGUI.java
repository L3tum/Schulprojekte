import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 18.06.2015
  * @author 
  */

public class AnmeldeGUI extends JFrame {
  // Anfang Attribute
  // Ende Attribute
  
  public AnmeldeGUI(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 501; 
    int frameHeight = 336;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    // Ende Komponenten
    
    setVisible(true);
  } // end of public AnmeldeGUI
  
  // Anfang Methoden
  // Ende Methoden
  
  public static void main(String[] args) {
    new AnmeldeGUI("AnmeldeGUI");
  } // end of main
  
} // end of class AnmeldeGUI
