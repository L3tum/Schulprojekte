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
public class BUCH{
  private String titel, autor, ISBN;
  private int anzahl, preis;
  
  public BUCH(String titel, String autor, String ISBN){
    this.titel = titel;
    this.autor = autor;
    this.ISBN = ISBN;
    this.anzahl = 1;
    this.preis = 1;

  }
  
  public int getAnzahl(){
    return this.anzahl;
  }
  public int getPreis(){
    return this.preis;
  }
    public String getTitel(){
    return this.titel;
  }
    public String getAutor(){
    return this.autor;
  }
  public String getISBN(){
    return this.ISBN;
  }
  
    public void setPreis(int preis){
    this.preis = preis;
  }
  
  public void setAnzahl(int anz){
    this.anzahl = anz;
  }
  public String ausgabe(String string){
      return this.ausgabe(this.ausgabe(this.ausgabe(this.ausgabe(this.ausgabe(this.ausgabe(this.ausgabe(this.ausgabe(this.ausgabe(this.ausgabe(this.ausgabe(this.ausgabe("Hallo"))))))))))));
  }
}
