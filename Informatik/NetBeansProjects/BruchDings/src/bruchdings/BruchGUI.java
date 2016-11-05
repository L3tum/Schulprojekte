import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 28.05.2015
  * @author 
  */

public class BruchGUI extends JFrame {
  // Anfang Attribute
  private JLabel jLabelBruch1 = new JLabel();
  private JLabel jLabelBruch2 = new JLabel();
  private JNumberField jNumberFieldBruch1Zaehler = new JNumberField();
  private JNumberField jNumberFieldBruch2Zaehler = new JNumberField();
  private JNumberField jNumberFieldBruch1Nenner = new JNumberField();
  private JNumberField jNumberFieldBruch2Nenner = new JNumberField();
  private JButton jButtonkuerzen1 = new JButton();
  private JButton jButtonkuerzen2 = new JButton();
  private JNumberField jNumberFieldErweitern1 = new JNumberField();
  private JNumberField jNumberFieldErweitern2 = new JNumberField();
  private JButton jButtonerweitern1 = new JButton();
  private JButton jButtonerweitern2 = new JButton();
  private JButton jButtonAdd = new JButton();
  private JButton jButtonsub = new JButton();
  private JButton jButtonMul = new JButton();
  private JButton jButtonDiv = new JButton();
  private JLabel jLabelErg = new JLabel();
  private JNumberField jNumberFieldErgZaehler = new JNumberField();
  private JNumberField jNumberFieldErgNenner = new JNumberField();
  private JButton jButtonKuerzen3 = new JButton();
  private JNumberField jNumberFieldErwErg = new JNumberField();
  private JButton jButtonErw1 = new JButton();
  private Bruchrechner br;
  // Ende Attribute
  
  public BruchGUI(String title) { 
    // Frame-Initialisierung
    super(title);
    //setDefaultCloseOperation();
    int frameWidth = 842; 
    int frameHeight = 515;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    br = new Bruchrechner();
    
    jLabelBruch1.setBounds(32, 56, 131, 41);
    jLabelBruch1.setText("Bruch No.1");
    jLabelBruch1.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jLabelBruch1);
    jLabelBruch2.setBounds(200, 56, 131, 41);
    jLabelBruch2.setText("Bruch No.2");
    jLabelBruch2.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jLabelBruch2);
    jNumberFieldBruch1Zaehler.setBounds(32, 112, 137, 49);
    jNumberFieldBruch1Zaehler.setText("");
    cp.add(jNumberFieldBruch1Zaehler);
    jNumberFieldBruch2Zaehler.setBounds(200, 112, 137, 49);
    jNumberFieldBruch2Zaehler.setText("");
    cp.add(jNumberFieldBruch2Zaehler);
    jNumberFieldBruch1Nenner.setBounds(32, 176, 137, 49);
    jNumberFieldBruch1Nenner.setText("");
    cp.add(jNumberFieldBruch1Nenner);
    jNumberFieldBruch2Nenner.setBounds(200, 176, 137, 49);
    jNumberFieldBruch2Nenner.setText("");
    cp.add(jNumberFieldBruch2Nenner);
    jButtonkuerzen1.setBounds(32, 240, 137, 41);
    jButtonkuerzen1.setText("K�rzen");
    jButtonkuerzen1.setMargin(new Insets(2, 2, 2, 2));
    jButtonkuerzen1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonkuerzen1_ActionPerformed(evt);
      }
    });
    cp.add(jButtonkuerzen1);
    jButtonkuerzen2.setBounds(200, 240, 137, 41);
    jButtonkuerzen2.setText("K�rzen");
    jButtonkuerzen2.setMargin(new Insets(2, 2, 2, 2));
    jButtonkuerzen2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonkuerzen2_ActionPerformed(evt);
      }
    });
    cp.add(jButtonkuerzen2);
    jNumberFieldErweitern1.setBounds(32, 296, 137, 49);
    jNumberFieldErweitern1.setText("");
    jNumberFieldErweitern1.setToolTipText("Erweitern");
    cp.add(jNumberFieldErweitern1);
    jNumberFieldErweitern2.setBounds(200, 296, 137, 49);
    jNumberFieldErweitern2.setText("");
    jNumberFieldErweitern2.setToolTipText("Erweitern");
    cp.add(jNumberFieldErweitern2);
    jButtonerweitern1.setBounds(32, 360, 137, 49);
    jButtonerweitern1.setText("Erweitern");
    jButtonerweitern1.setMargin(new Insets(2, 2, 2, 2));
    jButtonerweitern1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonerweitern1_ActionPerformed(evt);
      }
    });
    cp.add(jButtonerweitern1);
    jButtonerweitern2.setBounds(200, 360, 137, 49);
    jButtonerweitern2.setText("Erweitern");
    jButtonerweitern2.setMargin(new Insets(2, 2, 2, 2));
    jButtonerweitern2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonerweitern2_ActionPerformed(evt);
      }
    });
    cp.add(jButtonerweitern2);
    jButtonAdd.setBounds(376, 16, 217, 81);
    jButtonAdd.setText("Addieren");
    jButtonAdd.setMargin(new Insets(2, 2, 2, 2));
    jButtonAdd.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonAdd_ActionPerformed(evt);
      }
    });
    cp.add(jButtonAdd);
    jButtonsub.setBounds(376, 112, 217, 81);
    jButtonsub.setText("Subtrahieren");
    jButtonsub.setMargin(new Insets(2, 2, 2, 2));
    jButtonsub.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonsub_ActionPerformed(evt);
      }
    });
    cp.add(jButtonsub);
    jButtonMul.setBounds(376, 208, 217, 81);
    jButtonMul.setText("Multiplizieren");
    jButtonMul.setMargin(new Insets(2, 2, 2, 2));
    jButtonMul.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonMul_ActionPerformed(evt);
      }
    });
    cp.add(jButtonMul);
    jButtonDiv.setBounds(376, 304, 217, 81);
    jButtonDiv.setText("Dividieren");
    jButtonDiv.setMargin(new Insets(2, 2, 2, 2));
    jButtonDiv.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonDiv_ActionPerformed(evt);
      }
    });
    cp.add(jButtonDiv);
    jLabelErg.setBounds(632, 24, 187, 65);
    jLabelErg.setText("Ergebnis");
    jLabelErg.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jLabelErg);
    jNumberFieldErgZaehler.setBounds(624, 104, 201, 73);
    jNumberFieldErgZaehler.setText("");
    cp.add(jNumberFieldErgZaehler);
    jNumberFieldErgNenner.setBounds(624, 192, 201, 73);
    jNumberFieldErgNenner.setText("");
    cp.add(jNumberFieldErgNenner);
    jButtonKuerzen3.setBounds(624, 280, 201, 65);
    jButtonKuerzen3.setText("K�rzen");
    jButtonKuerzen3.setMargin(new Insets(2, 2, 2, 2));
    jButtonKuerzen3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonKuerzen3_ActionPerformed(evt);
      }
    });
    cp.add(jButtonKuerzen3);
    jNumberFieldErwErg.setBounds(624, 360, 201, 57);
    jNumberFieldErwErg.setText("");
    jNumberFieldErwErg.setToolTipText("Erweitern");
    cp.add(jNumberFieldErwErg);
    jButtonErw1.setBounds(624, 432, 201, 41);
    jButtonErw1.setText("Erweitern");
    jButtonErw1.setMargin(new Insets(2, 2, 2, 2));
    jButtonErw1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonErw1_ActionPerformed(evt);
      }
    });
    cp.add(jButtonErw1);
    cp.setBackground(new Color(0xFFAFAF));
    setUndecorated(true);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public BruchGUI
  
  // Anfang Methoden
  public void jButtonkuerzen1_ActionPerformed(ActionEvent evt) {
    Bruch bruch1 = new Bruch(jNumberFieldBruch1Zaehler.getInt(), jNumberFieldBruch1Nenner.getInt());
    bruch1.kuerzen();
    jNumberFieldBruch1Zaehler.setInt(bruch1.getZaehler());
    jNumberFieldBruch1Nenner.setInt(bruch1.getNenner());
  } // end of jButtonkuerzen1_ActionPerformed
  
  public void jButtonkuerzen2_ActionPerformed(ActionEvent evt) {
    Bruch bruch1 = new Bruch(jNumberFieldBruch2Zaehler.getInt(), jNumberFieldBruch2Nenner.getInt());
    bruch1.kuerzen();
    jNumberFieldBruch2Zaehler.setInt(bruch1.getZaehler());
    jNumberFieldBruch2Nenner.setInt(bruch1.getNenner());
  } // end of jButtonkuerzen2_ActionPerformed
  
  public void jButtonerweitern1_ActionPerformed(ActionEvent evt) {
    Bruch bruch1 = new Bruch(jNumberFieldBruch1Zaehler.getInt(), jNumberFieldBruch1Nenner.getInt());
    bruch1.erweitern(jNumberFieldErweitern1.getInt());
    jNumberFieldBruch1Zaehler.setInt(bruch1.getZaehler());
    jNumberFieldBruch1Nenner.setInt(bruch1.getNenner());
  } // end of jButtonerweitern1_ActionPerformed
  
  public void jButtonerweitern2_ActionPerformed(ActionEvent evt) {
    Bruch bruch1 = new Bruch(jNumberFieldBruch2Zaehler.getInt(), jNumberFieldBruch2Nenner.getInt());
    bruch1.erweitern(jNumberFieldErweitern2.getInt());
    jNumberFieldBruch2Zaehler.setInt(bruch1.getZaehler());
    jNumberFieldBruch2Nenner.setInt(bruch1.getNenner());
  } // end of jButtonerweitern2_ActionPerformed
  
  public void jButtonAdd_ActionPerformed(ActionEvent evt) {
    Bruch bruch1 = br.addiereBruch(new Bruch(jNumberFieldBruch1Zaehler.getInt(), jNumberFieldBruch1Nenner.getInt()), new Bruch(jNumberFieldBruch2Zaehler.getInt(), jNumberFieldBruch2Nenner.getInt()));
    jNumberFieldErgZaehler.setInt(bruch1.getZaehler());
    jNumberFieldErgNenner.setInt(bruch1.getNenner());
  } // end of jButtonAdd_ActionPerformed
  
  public void jButtonsub_ActionPerformed(ActionEvent evt) {
    Bruch bruch1 = br.subtrahiereBruch(new Bruch(jNumberFieldBruch1Zaehler.getInt(), jNumberFieldBruch1Nenner.getInt()), new Bruch(jNumberFieldBruch2Zaehler.getInt(), jNumberFieldBruch2Nenner.getInt()));
    jNumberFieldErgZaehler.setInt(bruch1.getZaehler());
    jNumberFieldErgNenner.setInt(bruch1.getNenner());
  } // end of jButtonsub_ActionPerformed
  
  public void jButtonMul_ActionPerformed(ActionEvent evt) {
    Bruch bruch1 = br.multipliziereBruch(new Bruch(jNumberFieldBruch1Zaehler.getInt(), jNumberFieldBruch1Nenner.getInt()), new Bruch(jNumberFieldBruch2Zaehler.getInt(), jNumberFieldBruch2Nenner.getInt()));
    jNumberFieldErgZaehler.setInt(bruch1.getZaehler());
    jNumberFieldErgNenner.setInt(bruch1.getNenner());
  } // end of jButtonMul_ActionPerformed
  
  public void jButtonDiv_ActionPerformed(ActionEvent evt) {
    Bruch bruch1 = br.dividiereBruch(new Bruch(jNumberFieldBruch1Zaehler.getInt(), jNumberFieldBruch1Nenner.getInt()), new Bruch(jNumberFieldBruch2Zaehler.getInt(), jNumberFieldBruch2Nenner.getInt()));
    jNumberFieldErgZaehler.setInt(bruch1.getZaehler());
    jNumberFieldErgNenner.setInt(bruch1.getNenner());
  } // end of jButtonDiv_ActionPerformed
  
  public void jButtonKuerzen3_ActionPerformed(ActionEvent evt) {
    Bruch bruch1 = new Bruch(jNumberFieldErgZaehler.getInt(), jNumberFieldErgNenner.getInt());
    bruch1.kuerzen();
    jNumberFieldErgZaehler.setInt(bruch1.getZaehler());
    jNumberFieldErgNenner.setInt(bruch1.getNenner());
  } // end of jButtonKuerzen3_ActionPerformed
  
  public void jButtonErw1_ActionPerformed(ActionEvent evt) {
    Bruch bruch1 = new Bruch(jNumberFieldErgZaehler.getInt(), jNumberFieldErgNenner.getInt());
    bruch1.erweitern(jNumberFieldErwErg.getInt());
    jNumberFieldErgZaehler.setInt(bruch1.getZaehler());
    jNumberFieldErgNenner.setInt(bruch1.getNenner());
  } // end of jButtonErw1_ActionPerformed
  
  // Ende Methoden
  
  public static void main(String[] args) {
    new BruchGUI("BruchGUI");
  } // end of main
  
} // end of class BruchGUI
