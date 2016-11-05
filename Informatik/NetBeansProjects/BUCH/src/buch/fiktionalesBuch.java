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
public class fiktionalesBuch extends BUCH{
  
  // Anfang Attribute
  private String gattung;
  // Ende Attribute
  
  public fiktionalesBuch(String gattung, String titel, String ISBN, int anzahl, String autor, int preis) {
    super(titel, autor, ISBN);
    this.gattung = gattung;
  }

  // Anfang Methoden
  public String getGattung() {
    return gattung;
  }

  // Ende Methoden
}
