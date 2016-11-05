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

public class SockenFrame extends JFrame {
  // Anfang Attribute
  private JLabel jLabelTitle = new JLabel();
  private JLabel jLabelGr = new JLabel();
  private JLabel jLabelFarbe = new JLabel();
  private JLabel jLabelMaterial = new JLabel();
  private JButton jButtonBenutzen = new JButton();
  private JButton jButtonWaschen = new JButton();
  private JButton jButtonTrocknen = new JButton();
  private JLabel jLabelStatus = new JLabel();
  private JLabel jLabelSauber = new JLabel();
  private JLabel jLabelBenutzt = new JLabel();
  private JLabel jLabelNass = new JLabel();
  private JLabel jLabelTrocken = new JLabel();
  private JLabel jLabelArt = new JLabel();
  private JLabel jLabelSauberJa = new JLabel();
  private JLabel jLabelNassJa = new JLabel();
  private JLabel jLabelBenutztJa = new JLabel();
  private JLabel jLabelTrockenJa = new JLabel();
  // Ende Attribute
  
  public SockenFrame(String title, String farbe, int groesse, String material, String art) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 357; 
    int frameHeight = 544;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jLabelTitle.setBounds(72, 16, 199, 65);
    jLabelTitle.setText("Meine Traumsocke");
    jLabelTitle.setFont(new Font("Cambria", Font.BOLD, 22));
    cp.add(jLabelTitle);
    jLabelGr.setBounds(32, 104, 131, 33);
    jLabelGr.setText(groesse);
    cp.add(jLabelGr);
    jLabelFarbe.setBounds(176, 104, 139, 33);
    jLabelFarbe.setText(farbe);
    cp.add(jLabelFarbe);
    jLabelMaterial.setBounds(104, 160, 131, 33);
    jLabelMaterial.setText(material);
    cp.add(jLabelMaterial);
    jButtonBenutzen.setBounds(24, 288, 89, 41);
    jButtonBenutzen.setText("Benutzen");
    jButtonBenutzen.setMargin(new Insets(2, 2, 2, 2));
    jButtonBenutzen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonBenutzen_ActionPerformed(evt);
      }
    });
    cp.add(jButtonBenutzen);
    jButtonWaschen.setBounds(128, 288, 97, 41);
    jButtonWaschen.setText("Waschen");
    jButtonWaschen.setMargin(new Insets(2, 2, 2, 2));
    jButtonWaschen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonWaschen_ActionPerformed(evt);
      }
    });
    cp.add(jButtonWaschen);
    jButtonTrocknen.setBounds(240, 288, 89, 41);
    jButtonTrocknen.setText("Trocknen");
    jButtonTrocknen.setMargin(new Insets(2, 2, 2, 2));
    jButtonTrocknen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonTrocknen_ActionPerformed(evt);
      }
    });
    cp.add(jButtonTrocknen);
    jLabelStatus.setBounds(104, 352, 155, 41);
    jLabelStatus.setText("Status der Socke");
    cp.add(jLabelStatus);
    jLabelSauber.setBounds(32, 408, 51, 25);
    jLabelSauber.setText("Sauber");
    cp.add(jLabelSauber);
    jLabelBenutzt.setBounds(200, 408, 59, 25);
    jLabelBenutzt.setText("Benutzt");
    cp.add(jLabelBenutzt);
    jLabelNass.setBounds(32, 448, 54, 28);
    jLabelNass.setText("Nass");
    cp.add(jLabelNass);
    jLabelTrocken.setBounds(200, 448, 51, 25);
    jLabelTrocken.setText("Trocken");
    cp.add(jLabelTrocken);
    jLabelArt.setBounds(104, 216, 139, 33);
    jLabelArt.setText(art);
    cp.add(jLabelArt);
    jLabelSauberJa.setBounds(96, 408, 59, 25);
    jLabelSauberJa.setText("Ja");
    cp.add(jLabelSauberJa);
    jLabelNassJa.setBounds(96, 448, 70, 28);
    jLabelNassJa.setText("Nein");
    cp.add(jLabelNassJa);
    jLabelBenutztJa.setBounds(272, 408, 59, 25);
    jLabelBenutztJa.setText("Nein");
    cp.add(jLabelBenutztJa);
    jLabelTrockenJa.setBounds(272, 448, 67, 25);
    jLabelTrockenJa.setText("Ja");
    cp.add(jLabelTrockenJa);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public SockenFrame
  
  // Anfang Methoden
  public void jButtonBenutzen_ActionPerformed(ActionEvent evt) {
    this.jLabelSauberJa.setText("Nein");
    this.jLabelBenutztJa.setText("Ja");
  } // end of jButtonBenutzen_ActionPerformed
  
  public void jButtonWaschen_ActionPerformed(ActionEvent evt) {
    this.jLabelNassJa.setText("Ja");
    this.jLabelBenutztJa("Nein");
    this.jLabelSauberJa("Ja");
    this.jLabelTrockenJa("Nein");
  } // end of jButtonWaschen_ActionPerformed
  
  public void jButtonTrocknen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of jButtonTrocknen_ActionPerformed
  
  // Ende Methoden
  
  public static void main(String[] args) {
  } // end of main
  
} // end of class SockenFrame
