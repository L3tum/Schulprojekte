/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 31.08.2015
  * @author 
  */

public class Hoerbuch extends Buch {
  
  // Anfang Attribute
  private int dauer;
  private String medium;
  private String sprecher;
  // Ende Attribute
  
  public Hoerbuch(int dauer, String medium, String sprecher, String titel, String ISBN, String autor, int anzahl, int preis) {
    super(titel, autor, ISBN);
    this.dauer = dauer;
    this.medium = medium;
    this.sprecher = sprecher;
  }

  // Anfang Methoden
  public int getDauer() {
    return dauer;
  }

  public String getMedium() {
    return medium;
  }

  public String getSprecher() {
    return sprecher;
  }

  // Ende Methoden
} // end of Hoerbuch
