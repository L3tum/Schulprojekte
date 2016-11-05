/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientenverwaltung;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tom.pauly
 */
public class Patient extends Kunde implements java.io.Serializable{

    private String blutgruppe;
    private String[] allergien = new String[100];
    private String notfallnummer;
    
    public Patient(String name, String vorname) {
        super(name, vorname);
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
    public String[] getAllergien() {
        return allergien;
    }

    /**
     * @param allergien the allergien to set
     */
    public void setAllergien(String[] allergien) {
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
    
}
