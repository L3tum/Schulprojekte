/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tom.pauly
 */
public class Kunde {
  
  // Anfang Attribute
  private String name;
  private int kontostand;
  // Ende Attribute
  
  public Kunde(String name, int betrag) {
    this.name = name;
    this.kontostand = 0;
  }

  // Anfang Methoden
  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getKontostand() {
    return kontostand;
  }
  
  public boolean auszahlen(int betrag){
     if (this.kontostand < betrag) {
        return false;
     } // end of if
     else{
       this.kontostand -= betrag;
       return true;
      }
    }
  public void einzahlen(int betrag){
     this.kontostand += betrag;
    }

  // Ende Methoden
} // end of Kunde

