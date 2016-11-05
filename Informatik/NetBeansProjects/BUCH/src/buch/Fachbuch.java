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
public class Fachbuch extends BUCH{
  private String kategorie;
  
  public Fachbuch(String titel, String autor, String ISBN, String kategorie){
    super(titel, autor, ISBN);
    this.kategorie = kategorie;
    }
  public String getKategorie(){
    return kategorie;
    }
  }
