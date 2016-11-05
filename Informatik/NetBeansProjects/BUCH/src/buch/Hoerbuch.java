/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buch;

/**
 *
 * @author tom.pauly
 */
public class Hoerbuch extends BUCH {
  
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
