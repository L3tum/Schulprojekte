/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoprojekt;

/**
 *
 * @author tim.goeller
 */
public class Auto {
    private String farbe;
    private int radgroesse;
    private int leistung;
    private int typ;
    private String modell;
    private int preis;
    private String marke;
    
    public Auto(String farbe, int radgroesse, int leistung, int typ, String modell, int preis, String marke) {
        
        this.farbe = farbe;
        this.radgroesse = radgroesse;
        this.leistung = leistung;
        this.typ = typ;
        this.modell = modell;
        this.preis = preis;
        this.marke = marke;
    }
    
    public String getModell() {
        return modell;
    }
    
    public int getRadgroesse() {
        return radgroesse;
    }
    
    public int getLeistung() {
        return leistung;
    }
    
    public int getTyp() {
        return typ;
    }
    
    public String getFarbe() {
        return farbe;
    }
    
    public int getPreis() {
        return preis;
    }
    public String getMarke(){
        return marke;
    }
}
