package obj;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int bankleitzahl;
    private int geld;
    private String fuehrer;
    private String name;
    private int kundenAnzahl;
    private List<Kunde> myList = new ArrayList<Kunde>();

    Bank(int blz, int geld, String fueher, String name){
        this.bankleitzahl = blz;
        this.geld = geld;
        this.fuehrer = fueher;
        this.name = name;
        this.kundenAnzahl = 0;
    }
    public void kundeWerden(String bday, int kn, String geschlecht, String land, String iban, int zinsen, int guthaben, int kontoNummer, String name, String vorname){
        myList.add(kn, new Kunde(bday, kn, land, geschlecht, iban, zinsen, guthaben, kontoNummer, name, vorname));
    }
  
    public void fuehrungsWechsel(String fueher){
        this.fuehrer = fueher;
    }
    public void namensWechsel(String name){
        this.name = name;
    }
    public void verspeckulatius(int am){
        this.geld = this.geld - am;
    }
    public void dividenden(int am){
        this.geld = this.geld + am;
    }


    //Getters
    public String getName() {
        return name;
    }

    public double getGeld() {
        return geld;
    }

    public int getBankleitzahl() {
        return bankleitzahl;
    }

    public int getKundenAnzahl() {
        return kundenAnzahl;
    }

    public List<Kunde> getMyList() {
        return myList;
    }

    public String getFuehrer() {
        return fuehrer;
    }
}

