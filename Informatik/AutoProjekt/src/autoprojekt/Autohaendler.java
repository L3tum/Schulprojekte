/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoprojekt;

import java.util.ArrayList;
import java.util.List;


public class Autohaendler {
    
    private List<Auto> autos = new ArrayList<Auto>();
    private int kapital;
    private String name;
    
    public Autohaendler(List<Auto> autos, int kapital, String name) {
        this.kapital = kapital;
        this.autos = autos;
        this.name = name;
    }
    
    public void BuyAuto(Auto auto) {
        if(kapital > auto.getPreis()) {
            kapital -= auto.getPreis();
            autos.add(auto);
        }
        else {
            System.out.println(name + " hat nicht genügend Kapital um das Auto zu kaufen!");
        }
        
    }
    
    public void SellAuto(Auto auto) {
        kapital += auto.getPreis();
        autos.remove(auto);
    }
    
    public List<Auto> GetAutos() {
        return autos;
    }
    
    public int GetKapital() {
        return kapital;
    }
    
    public String GetName() {
        return name;
    }
    
    
}
