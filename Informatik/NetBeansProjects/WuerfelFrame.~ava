import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 30.04.2015
  * @author 
  */

public class WuerfelFrame extends JFrame {
  // Anfang Attribute
  private JLabel jLabelTitle = new JLabel();
  private JNumberField jNumberFieldTip = new JNumberField();
  private JLabel jLabelTip = new JLabel();
  private JButton jButtonWuerfeln = new JButton();
  private JLabel jLabelImage = new JLabel();
  private JLabel jLabelErg = new JLabel();
  private Wuerfel w = new Wuerfel();
  private int gaben = 0;

  private JTable jTableStat = new JTable(3, 6);
    private DefaultTableModel jTableStatModel = (DefaultTableModel) jTableStat.getModel();
    private JScrollPane jTableStatScrollPane = new JScrollPane(jTableStat);
  // Ende Attribute
  
  public WuerfelFrame(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 312; 
    int frameHeight = 595;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jLabelTitle.setBounds(56, 24, 195, 65);
    jLabelTitle.setText("Würfelspiel!");
    jLabelTitle.setFont(new Font("Cambria", Font.BOLD, 22));
    jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
    
    jLabelTitle.setBackground(new Color(0xFFC800));
    jLabelTitle.setOpaque(true);
    cp.add(jLabelTitle);
    jNumberFieldTip.setBounds(120, 104, 129, 41);
    jNumberFieldTip.setText("");
    jNumberFieldTip.setBackground(Color.WHITE);
    cp.add(jNumberFieldTip);
    jLabelTip.setBounds(56, 104, 67, 41);
    jLabelTip.setText("Tipp");
    jLabelTip.setHorizontalAlignment(SwingConstants.CENTER);
    jLabelTip.setBackground(Color.CYAN);
    jLabelTip.setOpaque(true);
    cp.add(jLabelTip);
    jButtonWuerfeln.setBounds(56, 168, 193, 49);
    jButtonWuerfeln.setText("Würfeln!");
    jButtonWuerfeln.setMargin(new Insets(2, 2, 2, 2));
    jButtonWuerfeln.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonWuerfeln_ActionPerformed(evt);
      }
    });
    cp.add(jButtonWuerfeln);
    jLabelImage.setBounds(128, 248, 50, 50);
    jLabelImage.setText("");
    cp.add(jLabelImage);
    jLabelErg.setBounds(104, 320, 107, 65);
    jLabelErg.setText("Ergebnis");
    jLabelErg.setFont(new Font("Cambria", Font.BOLD, 22));
    jLabelErg.setBackground(Color.RED);
    jLabelErg.setOpaque(true);
    jLabelErg.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jLabelErg);
    cp.setBackground(Color.YELLOW);
    jTableStatScrollPane.setBounds(16, 408, 273, 57);
    jTableStatScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jTableStatScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    jTableStat.getColumnModel().getColumn(0).setHeaderValue("1");
    jTableStat.getColumnModel().getColumn(1).setHeaderValue("2");
    jTableStat.getColumnModel().getColumn(2).setHeaderValue("3");
    jTableStat.getColumnModel().getColumn(3).setHeaderValue("4");
    jTableStat.getColumnModel().getColumn(4).setHeaderValue("5");
    jTableStat.getColumnModel().getColumn(5).setHeaderValue("6");
    jTableStat.setRowHeight(18);
    cp.add(jTableStatScrollPane);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public WuerfelFrame
  
  // Anfang Methoden
  public void jButtonWuerfeln_ActionPerformed(ActionEvent evt) {
    w.wuerfeln();
    jLabelImage.setIcon(new ImageIcon("wuerfel" + w.getZahl() + ".gif"));
    
    if (jNumberFieldTip.getInt() == w.getZahl()) {
      jLabelErg.setText("Treffer!");
      gaben++;
      if (gaben == 3) {
        jLabelImage.setIcon(new ImageIcon("Gaben.saviour.jpg"));
      } // end of if
    } // end of if
    else{
      jLabelErg.setText("Schlecht!");
    }
    jNumberFieldTip.clear();
  } // end of jButtonWuerfeln_ActionPerformed
  
  // Ende Methoden
  
  public static void main(String[] args) {
    new WuerfelFrame("WuerfelFrame");
  } // end of main
  
} // end of class WuerfelFrame
