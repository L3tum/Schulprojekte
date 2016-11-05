/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekursion;

/**
 *
 * @author tom.pauly
 */
public class Würfel {
    private int seiten;
    public Würfel(int pSeiten){
        this.seiten = pSeiten;
    }
    public int wuerfel(){
        return 1 + (int)(Math.random() * seiten);
    }
    public int gibSeiten(){
        return this.seiten;
    }
}
