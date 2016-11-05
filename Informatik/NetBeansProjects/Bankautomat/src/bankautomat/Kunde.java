/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankautomat;

/**
 *
 * @author tom.pauly
 */
public class Kunde {
    String vorname;
    String name;
    String kn;
    String geb;
    ZaI z = new ZaI();
    Konto konto;
    
    Kunde(String vorname, String name, String geb, String kn){
        this.vorname = vorname;
        this.name = name;
        this.geb = geb;
        this.kn = kn;
        this.konto = new Konto(z.getAm(), 50);
    }
    public String getV(){
        return this.vorname;
    }
    public String getN(){
        return this.name;
    }
    public String getKN(){
        return this.kn;
    }
    public String getGeb(){
        return this.geb;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setVName(String name){
        this.vorname = name;
    }
    public Konto getKonto(){
        return this.konto;
    }
}
