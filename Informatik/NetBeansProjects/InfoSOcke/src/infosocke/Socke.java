
package infosocke;

import java.lang.Exception;


public class Socke {
    private String farbe;
    private int groesse;
    private String material;
    private String art;
    private boolean benutzt;
    private boolean nass;
    
    public Socke(String farbe, int groesse, String material, String art) {
        this.farbe = farbe;
        this.groesse = groesse;
        this.material = material;
        this.art = art;
        this.benutzt = false;
        this.nass = false;
    }
    public String getFarbe(){
        return this.farbe;
    }
    public int getGroesse(){
        return this.groesse;
    }
    public String getMaterial(){
        return this.material;
    }
    public String getArt(){
        return this.art;
    }
    public void benutzen(){
        if(this.benutzt){
            System.out.println("ACHTUNG! DIESE SOCKE WURDE BEREITS BENUTZT!");
        }
        else if(this.nass){
            System.out.println("ACHTUNG! DIESE SOCKE IST FEUCHT!");
        }
        System.out.println("Sie benutzen nun diese Socke. Viel SPaß!");
        try{
             Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        this.benutzt = true;
    }
    public void waschen(){
        if(!this.benutzt){
            System.out.println("DIESE SOCKE IST NICHT DRECKIG!");
        }
        System.out.println("Diese Socke wird gewaschen!");
        this.benutzt = false;
        this.nass = true;
    }
    public void trocknen(){
        if(!this.nass){
            System.out.println("DIESE SOCKE IST NICHT NASS!");
        }
        System.out.println("Diese Socke wird getrocknet!");
        this.nass = false;
    }
}
