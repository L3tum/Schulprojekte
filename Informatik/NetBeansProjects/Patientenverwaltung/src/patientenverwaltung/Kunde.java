/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientenverwaltung;

/**
 *
 * @author tom.pauly
 */
public class Kunde {
  
  // Anfang Attribute
  private String name;
  private String vorname;
  private String strasse;
  private String hausnummer;
  private String plz;
  private String ort;
  private String rufnummer;
  // Ende Attribute
  
  public Kunde(String name, String vorname) {
    this.name = name;
    this.vorname = vorname;
    this.strasse = "";
    this.hausnummer = "";
    this.plz = "";
    this.ort = "";
    this.rufnummer = "";
  }

  // Anfang Methoden
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getVorname() {
    return vorname;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  public String getStrasse() {
    return strasse;
  }

  public void setStrasse(String strasse) {
    this.strasse = strasse;
  }

  public String getHausnummer() {
    return hausnummer;
  }

  public void setHausnummer(String hausnummer) {
    this.hausnummer = hausnummer;
  }

  public String getPlz() {
    return plz;
  }

  public void setPlz(String plz) {
    this.plz = plz;
  }

  public String getOrt() {
    return ort;
  }

  public void setOrt(String ort) {
    this.ort = ort;
  }

  public String getRufnummer() {
    return rufnummer;
  }

  public void setRufnummer(String rufnummer) {
    this.rufnummer = rufnummer;
  }

  // Ende Methoden
} // end of Kunde
