package obj;

import java.util.ArrayList;
import java.util.List;

public class Kunde {
    private String vorname;
    private String name;
    private String bday;
    private int kn;
    private String geschlecht;
    private String land;
    private int kontenAnzahl;
    private List<Konto> myList = new ArrayList<Konto>();

    public Kunde(String bday, int kn, String geschlecht, String land, String iban, int zinsen, int guthaben, int kontoNummer, String name, String vorname){
        this.name = name;
        this.vorname = vorname;
        this.bday = bday;
        this.kn = kn;
        this.geschlecht = geschlecht;
        this.land = land;
        this.myList.add(kontoNummer, new Konto(iban, zinsen, guthaben));
        this.kontenAnzahl++;
    }

    //Setters
    public void geschlechtsUmwandlung(String geschlecht){
        this.geschlecht = geschlecht;
    }
    public void addKonto(String iban, int zinsen, int guthaben, int kontoNummer){
        this.myList.add(kontoNummer, new Konto(iban, zinsen, guthaben));
        this.kontenAnzahl++;
    }

    //Getters
    public String getGeschlecht(){
        return this.geschlecht;
    }
    public int getKn(){
        return this.kn;
    }
    public String getBday(){
        return this.bday;
    }
    public String getLand() {
        return this.land;
    }
    public List<Konto> getMyList(){
        return myList;
    }

    public int getKontenAnzahl() {
        return kontenAnzahl;
    }
}
