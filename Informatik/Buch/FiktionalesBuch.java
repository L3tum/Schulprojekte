/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 31.08.2015
  * @author 
  */

public class FiktionalesBuch extends Buch {
  
  // Anfang Attribute
  private String gattung;
  // Ende Attribute
  
  public FiktionalesBuch(String gattung, String titel, String ISBN, int anzahl, String autor, int preis) {
    super(titel, autor, ISBN);
    this.gattung = gattung;
  }

  // Anfang Methoden
  public String getGattung() {
    return gattung;
  }

  // Ende Methoden
} // end of FiktionalesBuch
