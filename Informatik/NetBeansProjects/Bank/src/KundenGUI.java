import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 18.06.2015
  * @author 
  */

public class KundenGUI extends JFrame {
  // Anfang Attribute
  private JLabel jLName = new JLabel();
  private JLabel jLStart = new JLabel();
  private JTextField jTName = new JTextField();
  private JTextField jNStart = new JTextField();
  private JButton jBAnlegen = new JButton();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabelKundenAuswahl = new JLabel();
  private JLabel jLNameA = new JLabel();
  private JTextField jTNameA = new JTextField();
  private JTextField jNBetrag = new JTextField();
  private JButton jBEinzahlen = new JButton();
  private JButton jBAuszahlen = new JButton();
  private JLabel jLSometing = new JLabel();
  private JLabel jLHinweis = new JLabel();
  private JLabel jLSomething = new JLabel();
  private JLabel jLKontostand = new JLabel();
  private Map<String, Kunde> kunden = new HashMap<>();
  // Ende Attribute
  
  public KundenGUI(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 808; 
    int frameHeight = 592;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jLName.setBounds(24, 16, 155, 41);
    jLName.setText("Name:");
    jLName.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jLName);
    jLStart.setBounds(24, 72, 155, 49);
    jLStart.setText("Startguthaben:");
    jLStart.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jLStart);
    jTName.setBounds(200, 16, 233, 49);
    cp.add(jTName);
    jNStart.setBounds(200, 72, 113, 49);
    jNStart.setText("");
    cp.add(jNStart);
    jBAnlegen.setBounds(120, 144, 153, 49);
    jBAnlegen.setText("Anlegen");
    jBAnlegen.setMargin(new Insets(2, 2, 2, 2));
    jBAnlegen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jBAnlegen_ActionPerformed(evt);
      }
    });
    cp.add(jBAnlegen);
    jLabel1.setBounds(320, 72, 43, 49);
    jLabel1.setText("€");
    jLabel1.setBackground(Color.WHITE);
    jLabel1.setOpaque(true);
    cp.add(jLabel1);
    jLabelKundenAuswahl.setBounds(496, 160, 219, 73);
    jLabelKundenAuswahl.setText("Kunde auswählen:");
    jLabelKundenAuswahl.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jLabelKundenAuswahl);
    jLNameA.setBounds(464, 256, 115, 49);
    jLNameA.setText("Name:");
    jLNameA.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jLNameA);
    jTNameA.setBounds(600, 256, 169, 49);
    cp.add(jTNameA);
    jNBetrag.setBounds(552, 320, 121, 57);
    cp.add(jNBetrag);
    jBEinzahlen.setBounds(456, 320, 81, 57);
    jBEinzahlen.setText("Einzahlen");
    jBEinzahlen.setMargin(new Insets(2, 2, 2, 2));
    jBEinzahlen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jBEinzahlen_ActionPerformed(evt);
      }
    });
    cp.add(jBEinzahlen);
    jBAuszahlen.setBounds(688, 320, 81, 57);
    jBAuszahlen.setText("Auszahlen");
    jBAuszahlen.setMargin(new Insets(2, 2, 2, 2));
    jBAuszahlen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jBAuszahlen_ActionPerformed(evt);
      }
    });
    cp.add(jBAuszahlen);
    jLSometing.setBounds(456, 392, 99, 41);
    jLSometing.setText("Hinweis:");
    jLSometing.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jLSometing);
    jLHinweis.setBounds(576, 392, 195, 41);
    jLHinweis.setText("");
    jLHinweis.setHorizontalAlignment(SwingConstants.CENTER);
    jLHinweis.setBackground(Color.WHITE);
    jLHinweis.setOpaque(true);
    cp.add(jLHinweis);
    jLSomething.setBounds(456, 456, 107, 49);
    jLSomething.setText("Kontostand:");
    jLSomething.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jLSomething);
    jLKontostand.setBounds(576, 456, 195, 41);
    jLKontostand.setText("");
    jLKontostand.setBackground(Color.WHITE);
    jLKontostand.setOpaque(true);
    cp.add(jLKontostand);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public KundenGUI
  
  // Anfang Methoden
  public void jBAnlegen_ActionPerformed(ActionEvent evt) {
      System.out.println(Integer.parseInt(this.jNBetrag.getText()));
    //kunden.put(jTName.getText(), new Kunde(jTName.getText(), Integer.getInteger(jNStart.getText())));
  } // end of jBAnlegen_ActionPerformed

  public void jBEinzahlen_ActionPerformed(ActionEvent evt) {
     kunden.get(jTNameA.getText()).einzahlen(Integer.getInteger(jNBetrag.getText())); 
  } // end of jBEinzahlen_ActionPerformed

  public void jBAuszahlen_ActionPerformed(ActionEvent evt) {
    if(!kunden.get(jTNameA.getText()).auszahlen(Integer.getInteger(jNBetrag.getText()))){
        jLHinweis.setText("Sie haben nicht so viel Geld!");
    }
    else{
        kunden.get(jTNameA.getText()).auszahlen(Integer.getInteger(jNBetrag.getText()));
    }
  } // end of jBAuszahlen_ActionPerformed

  // Ende Methoden
  
  public static void main(String[] args) {
    new KundenGUI("KundenGUI");
  } // end of main
  
} // end of class KundenGUI