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

public class BankGUI extends JFrame {
  // Anfang Attribute
  private JButton jBAnmelden = new JButton();
  private JButton jBReg = new JButton();
  // Ende Attribute
  
  public BankGUI(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 361; 
    int frameHeight = 312;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jBAnmelden.setBounds(80, 40, 201, 81);
    jBAnmelden.setText("Anmelden");
    jBAnmelden.setMargin(new Insets(2, 2, 2, 2));
    jBAnmelden.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jBAnmelden_ActionPerformed(evt);
      }
    });
    cp.add(jBAnmelden);
    jBReg.setBounds(80, 144, 201, 81);
    jBReg.setText("Registrieren");
    jBReg.setMargin(new Insets(2, 2, 2, 2));
    jBReg.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jBReg_ActionPerformed(evt);
      }
    });
    cp.add(jBReg);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public BankGUI
  
  // Anfang Methoden
  public void jBAnmelden_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of jBAnmelden_ActionPerformed

  public void jBReg_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of jBReg_ActionPerformed

  // Ende Methoden
  
  public static void main(String[] args) {
    new BankGUI("BankGUI");
  } // end of main
  
} // end of class BankGUI
