/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientenverwaltung;

import java.util.Objects;

/**
 *
 * @author tom.pauly
 */
public class Patient extends Kunde implements java.io.Serializable{

    private String blutgruppe = "";
    private List<String> allergien = new List<>();
    private String notfallnummer = "";
    
    public Patient(String name, String vorname) {
        super(name, vorname);
    }
    public Patient(Patient patient){
        super(patient.getName(), patient.getVorname());
        this.blutgruppe = patient.blutgruppe;
        this.allergien = patient.allergien;
        this.notfallnummer = patient.notfallnummer;
        this.setHausnummer(patient.getHausnummer());
    }

    /**
     * @return the blutgruppe
     */
    public String getBlutgruppe() {
        return blutgruppe;
    }

    /**
     * @param blutgruppe the blutgruppe to set
     */
    public void setBlutgruppe(String blutgruppe) {
        this.blutgruppe = blutgruppe;
    }

    /**
     * @return the allergien
     */
    public List<String> getAllergien() {
        return allergien;
    }

    /**
     * @param allergien the allergien to set
     */
    public void setAllergien(List<String> allergien) {
        this.allergien = allergien;
    }

    /**
     * @return the notfallnummer
     */
    public String getNotfallnummer() {
        return notfallnummer;
    }

    /**
     * @param notfallnummer the notfallnummer to set
     */
    public void setNotfallnummer(String notfallnummer) {
        this.notfallnummer = notfallnummer;
    }
    
    @Override
    public boolean equals(Object other){
        Patient temp = (Patient)other;
        if(this.getName().equals(temp.getName())){
            if(this.getVorname().equals(temp.getVorname())){
                if(this.getAllergien().equals(temp.getAllergien())){
                    if(this.getBlutgruppe().equals(temp.getBlutgruppe())){
                        if(this.getHausnummer().equals(temp.getHausnummer())){
                            if(this.getNotfallnummer().equals(temp.getNotfallnummer())){
                                if(this.getOrt().equals(temp.getOrt())){
                                    if(this.getPlz().equals(temp.getPlz())){
                                        if(this.getRufnummer().equals(temp.getRufnummer())){
                                            if(this.getStrasse().equals(temp.getStrasse())){
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public void SetAllergieAtIndex(String allergie, int index){
        this.allergien.toFirst();
        int counter = 0;
        while(allergien.getContent() != null){
            if(counter == index){
                allergien.setContent(allergie);
                break;
            }
            this.allergien.next();
            counter++;
        }
    }
    
    public void RemoveAllergieAtIndex(int index){
        this.allergien.toFirst();
        int counter = 0;
        while(allergien.getContent() != null){
            if(counter == index){
                allergien.remove();
                break;
            }
            allergien.next();
            counter++;
        }
    }
    
    public int GetAllergienLength(){
        int counter = 0;
        allergien.toFirst();
        while(allergien.getContent() != null){
            counter++;
            allergien.next();
        }
        return counter;
    }
    
    public String AtIndexAllergie(int index){
        int counter = 0;
        String temp = "";
        allergien.toFirst();
        while(allergien.getContent() != null){
            if(counter == index){
                temp = allergien.getContent();
            }
            allergien.next();
            counter++;
        }
        return temp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.blutgruppe);
        hash = 31 * hash + Objects.hashCode(this.allergien);
        hash = 31 * hash + Objects.hashCode(this.notfallnummer);
        return hash;
    }
    
    @Override
    public String toString(){
        return this.getVorname() + ", " + this.getName() + ", " + this.getBlutgruppe() + ", " + this.getNotfallnummer() + ", " + this.getOrt() + ", " + this.getPlz() + ", " + this.getStrasse() + ", " + this.getHausnummer() + ", " + this.getRufnummer();
    }
    
    public static Patient ToPatient(String stringed){
        String[] strings = stringed.split(",");
        Patient temp = new Patient(strings[1].trim(), strings[0].trim());
        temp.setBlutgruppe(strings[2].trim());
        temp.setNotfallnummer(strings[3].trim());
        temp.setOrt(strings[4].trim());
        temp.setPlz(strings[5].trim());
        temp.setStrasse(strings[6].trim());
        temp.setHausnummer(strings[7].trim());
        temp.setRufnummer(strings[8].trim());
        return temp;
    }
}
