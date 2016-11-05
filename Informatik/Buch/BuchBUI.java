import java.awt.*;
import java.awt.event.*;

public class BuchBUI extends Frame {
  // Anfang Attribute
  
  private int anz = 20;
  private int anz_buch = 0;
  private Buch [] buch = new Buch [anz];

  // die Komponenten

  private TextField tFTitel = new TextField();
  private TextField tFAutor = new TextField();
  private TextField tFISBN = new TextField();
  private TextField tFPreis = new TextField();
  private TextField tFAnzahl = new TextField();
  private Label label1 = new Label();
  private Button tbBuch = new Button();
  private TextArea textArea1 = new TextArea("", 1, 1, TextArea.SCROLLBARS_NONE);
  private Checkbox radioButton1 = new Checkbox();
  private Checkbox radioButton2 = new Checkbox();
  private Checkbox adioButton3 = new Checkbox();
  private TextField tFKategorie = new TextField();
  private TextField tFGattung = new TextField();
  private Label label2 = new Label();
  private Button btFiktional = new Button();
  private Label label3 = new Label();
  private Button btFachbuch = new Button();
  private Label label4 = new Label();
  private Label label5 = new Label();
  private Label label6 = new Label();
  private Label label7 = new Label();
  private Label label8 = new Label();
  private Label label9 = new Label();
  private Label label10 = new Label();
  private TextField tFDauer = new TextField();
  private TextField tFMedium = new TextField();
  private TextField tFSprecher = new TextField();
  private Label label11 = new Label();
  private Label label12 = new Label();
  private Label label13 = new Label();
  private Button btHoerbuch = new Button();
  private Label label14 = new Label();
  private Label label15 = new Label();
  // Ende Attribute

  // der Konstruktor der GUI

  public BuchBUI(String title) {
    // Frame-Initialisierung
    super(title);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 934; 
    int frameHeight = 516;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    Panel cp = new Panel(null);
    add(cp);
    // Anfang Komponenten

    tFTitel.setBounds(8, 64, 121, 24);
    tFTitel.setText("Titel");
    tFTitel.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(tFTitel);
    tFAutor.setBounds(8, 112, 121, 24);
    tFAutor.setText("Autor");
    tFAutor.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(tFAutor);
    tFISBN.setBounds(8, 168, 121, 24);
    tFISBN.setText("ISBN");
    tFISBN.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(tFISBN);
    tFPreis.setBounds(8, 216, 121, 24);
    tFPreis.setText("1");
    tFPreis.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(tFPreis);
    tFAnzahl.setBounds(8, 264, 121, 24);
    tFAnzahl.setText("1");
    tFAnzahl.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(tFAnzahl);
    label1.setBounds(8, 16, 38, 20);
    label1.setText("Buch");
    label1.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(label1);
    tbBuch.setBounds(8, 312, 123, 33);
    tbBuch.setLabel("Buch einfügen");
    tbBuch.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        tbBuch_ActionPerformed(evt);
      }
    });
    tbBuch.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(tbBuch);
    textArea1.setBounds(528, 64, 361, 377);
    textArea1.setText("Bücherliste (Autor)" +"\n");
    textArea1.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(textArea1);
    tFKategorie.setBounds(136, 64, 121, 24);
    tFKategorie.setText("Kategorie");
    tFKategorie.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(tFKategorie);
    tFGattung.setBounds(264, 64, 113, 24);
    tFGattung.setText("Gattung");
    tFGattung.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(tFGattung);
    label2.setBounds(136, 16, 38, 20);
    label2.setText("Fachbuch");
    label2.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(label2);
    btFiktional.setBounds(256, 312, 115, 33);
    btFiktional.setLabel("Fiktionales Buch");
    btFiktional.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        btFiktional_ActionPerformed(evt);
      }
    });
    btFiktional.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(btFiktional);
    label3.setBounds(264, 16, 38, 20);
    label3.setText("Fiktionales Buch");
    label3.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(label3);
    btFachbuch.setBounds(136, 312, 115, 33);
    btFachbuch.setLabel("Fachbuch");
    btFachbuch.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        btFachbuch_ActionPerformed(evt);
      }
    });
    btFachbuch.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(btFachbuch);
    label4.setBounds(144, 56, 38, 20);
    label4.setText("Anzahl");
    label4.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(label4);
    label5.setBounds(8, 248, 38, 20);
    label5.setText("Anzahl");
    label5.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(label5);
    label6.setBounds(8, 200, 38, 20);
    label6.setText("Preis");
    label6.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(label6);
    label7.setBounds(8, 48, 38, 20);
    label7.setText("Titel");
    label7.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(label7);
    label8.setBounds(8, 96, 38, 20);
    label8.setText("Autor");
    label8.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(label8);
    label9.setBounds(8, 152, 38, 20);
    label9.setText("ISBN");
    label9.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(label9);
    label10.setBounds(384, 16, 45, 20);
    label10.setText("Hörbuch");
    label10.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(label10);
    tFDauer.setBounds(384, 64, 121, 24);
    tFDauer.setText("Dauer");
    tFDauer.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(tFDauer);
    tFMedium.setBounds(384, 112, 121, 24);
    tFMedium.setText("Medium");
    tFMedium.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(tFMedium);
    tFSprecher.setBounds(384, 168, 121, 24);
    tFSprecher.setText("Sprecher");
    tFSprecher.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(tFSprecher);
    label11.setBounds(384, 48, 45, 20);
    label11.setText("Dauer");
    label11.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(label11);
    label12.setBounds(384, 96, 45, 20);
    label12.setText("Medium");
    label12.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(label12);
    label13.setBounds(384, 152, 45, 20);
    label13.setText("Sprecher");
    label13.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(label13);
    btHoerbuch.setBounds(376, 312, 123, 33);
    btHoerbuch.setLabel("Hörbuch");
    btHoerbuch.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        btHoerbuch_ActionPerformed(evt);
      }
    });
    btHoerbuch.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(btHoerbuch);
    label14.setBounds(136, 48, 45, 20);
    label14.setText("Kategorie");
    label14.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(label14);
    label15.setBounds(264, 48, 45, 20);
    label15.setText("Gattung");
    label15.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(label15);
    // Ende Komponenten
      label4.setVisible(false);
      setResizable(false);
      setVisible(true);
  }

  // Anfang Methoden
  

  // Einfügen eines Buches
  
  public void tbBuch_ActionPerformed(ActionEvent evt) {
   if (anz_buch ==anz){
      label4.setVisible(true);
      label4.setText("Keine neuen Bücher einfügbar!");
   }  else{
           buch[anz_buch]=new Buch(tFTitel.getText(),tFAutor.getText(),tFISBN.getText());
           textArea1.append(ausgabe(buch[anz_buch])+ "\n");
           anz_buch++;
      }

  }
 // Einfügen eines fiktionalen Buches
 
  public void btFiktional_ActionPerformed(ActionEvent evt) {

      //Methode für das fiktionale Buch

     }


  // Button für das Einfügen und Anzeigen eines Fachbuches
  
  public void btFachbuch_ActionPerformed(ActionEvent evt) {

     // Methode für das Fachbuch
     
   }
   
// Button für das Einfügen und Anzeigen eines Hörbuches

  public void btHoerbuch_ActionPerformed(ActionEvent evt) {

    // Methode für das Hörbuch
    
  }
  
  
 // Hilfsmethoden für die Ausgabe von Büchern
 
 public String ausgabe(Buch buch){
    return "Buch: " + buch.getTitel()+" "+buch.getAutor()+ " " + "ISBN: "+buch.getISBN();
  }



 public static void main(String[] args) {
    new BuchBUI("BuchBUI");
  }


  // Ende Methoden
}
