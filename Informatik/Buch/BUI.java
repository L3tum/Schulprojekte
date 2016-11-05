import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 02.09.2015
  * @author 
  */

public class BUI extends JFrame {
  // Anfang Attribute
  private JList jList1 = new JList();
    private DefaultListModel jList1Model = new DefaultListModel();
    private JScrollPane jList1ScrollPane = new JScrollPane(jList1);
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  // Ende Attribute
  
  public BUI(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1259; 
    int frameHeight = 579;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jList1.setModel(jList1Model);
    jList1ScrollPane.setBounds(896, 16, 321, 513);
    cp.add(jList1ScrollPane);
    jLabel1.setBounds(496, 16, 379, 49);
    jLabel1.setText("text");
    cp.add(jLabel1);
    jLabel2.setBounds(496, 80, 379, 49);
    jLabel2.setText("text");
    cp.add(jLabel2);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public BUI
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new BUI("BUI");
  } // end of main
  
  // Ende Methoden
} // end of class BUI
