import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 30.04.2015
  * @author 
  */

public class SockenEditorFrame extends JFrame {
  // Anfang Attribute
  private JLabel jLabelTitle = new JLabel();
  private JLabel jLabelFarbe = new JLabel();
  private JTextField jTextFieldFarbe = new JTextField();
  private JLabel jLabelGr = new JLabel();
  private JNumberField jNumberFieldGr = new JNumberField();
  private JLabel jLabelArt = new JLabel();
  private JTextField jTextFieldArt = new JTextField();
  private JButton jButtonAbschicken = new JButton();
  private String farbe;
  private int gr;
  private String art;
  private String mat;
  private JLabel jLabelMat = new JLabel();
  private JTextField jTextFieldMat = new JTextField();
  // Ende Attribute
  
  public SockenEditorFrame(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 445;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jLabelTitle.setBounds(48, 24, 199, 49);
    jLabelTitle.setText("Meine Traumsocke");
    jLabelTitle.setFont(new Font("Cambria", Font.BOLD, 22));
    cp.add(jLabelTitle);
    jLabelFarbe.setBounds(48, 96, 51, 33);
    jLabelFarbe.setText("Farbe");
    cp.add(jLabelFarbe);
    jTextFieldFarbe.setBounds(104, 96, 145, 33);
    cp.add(jTextFieldFarbe);
    jLabelGr.setBounds(48, 144, 52, 36);
    jLabelGr.setText("Groesse");
    cp.add(jLabelGr);
    jNumberFieldGr.setBounds(104, 144, 145, 33);
    jNumberFieldGr.setText("");
    cp.add(jNumberFieldGr);
    jLabelArt.setBounds(48, 192, 51, 33);
    jLabelArt.setText("Art");
    cp.add(jLabelArt);
    jTextFieldArt.setBounds(104, 192, 145, 33);
    cp.add(jTextFieldArt);
    jButtonAbschicken.setBounds(64, 336, 169, 49);
    jButtonAbschicken.setText("Erstellen");
    jButtonAbschicken.setMargin(new Insets(2, 2, 2, 2));
    jButtonAbschicken.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonAbschicken_ActionPerformed(evt);
      }
    });
    cp.add(jButtonAbschicken);
    jLabelMat.setBounds(48, 240, 59, 33);
    jLabelMat.setText("Material");
    cp.add(jLabelMat);
    jTextFieldMat.setBounds(104, 240, 145, 33);
    cp.add(jTextFieldMat);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public SockenEditorFrame
  
  // Anfang Methoden
  public void jButtonAbschicken_ActionPerformed(ActionEvent evt) {
    this.farbe = jTextFieldFarbe.getText();
    this.gr = jNumberFieldGr.getInt();
    this.art = jTextFieldArt.getText();
    this.mat = jTextFieldMat.getText();
  } // end of jButtonAbschicken_ActionPerformed
  
  public String getFarbe(){
    return this.farbe;
  }
  public int getGr(){
    return this.gr;
  }
  public String getArt(){
    return this.art;
  }
  
  public String getMat(){
    return this.mat;
  }
  // Ende Methoden
} // end of class SockenEditorFrame
