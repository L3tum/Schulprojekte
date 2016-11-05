/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankautomat;

/**
 *
 * @author tom.pauly
 */
public class Konto {
    String iban;
    int guthaben;
    int zinsen;
    
    Konto(String iban, int zinsen){
        this.iban = iban;
        this.zinsen = zinsen;
        this.guthaben = 0;
    }
    public void einzahlen(int am){
        this.guthaben = this.guthaben + am;
    }
    public void auszahlen(int am){
        this.guthaben = this.guthaben - am;
    }
    public String getIban(){
        return this.iban;
    }
    public int getGuthaben(){
        return this.guthaben;
    }
    public int getZinsen(){
        return this.zinsen;
    }
    public void setZinsen(int zinsen){
        this.zinsen = zinsen;
    }
}
