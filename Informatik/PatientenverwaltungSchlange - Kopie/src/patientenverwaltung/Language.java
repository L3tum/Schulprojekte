/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientenverwaltung;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@XmlRootElement
public class Language implements java.io.Serializable {

    @XmlElement
    private String patientHinzufügen = "";

    @XmlElement
    private String patientAktualisieren = "";

    @XmlElement
    private String felderLeeren = "";

    @XmlElement
    private String vorwärts = "";

    @XmlElement
    private String rückwärts = "";

    @XmlElement
    private String allergieHinzufügen = "";

    @XmlElement
    private String vorname = "";

    @XmlElement
    private String name = "";

    @XmlElement
    private String blutgruppe = "";

    @XmlElement
    private String hausnummer = "";

    @XmlElement
    private String straße = "";

    @XmlElement
    private String notfallnummer = "";

    @XmlElement
    private String ort = "";

    @XmlElement
    private String rufnummer = "";

    @XmlElement
    private String postleitzahl = "";
    
    @XmlElement
    private String languagesButtonText = "";
    
    @XmlElement 
    private String deutschButtonText = "";
    
    @XmlElement 
    private String englishButtonText = "";
    
    @XmlElement
    private String settingsButtonText = "";
    
    @XmlElement
    private String playMusicButton = "";
    
    @XmlElement 
    private String endingAnimationButtonText = "";
    
    @XmlElement
    private String autoUpdateButtonText = "";
    
    @XmlElement
    private String showExploButtonText = "";

    public String getLanguagesButtonText() {
        return languagesButtonText;
    }

    public String getDeutschButtonText() {
        return deutschButtonText;
    }

    public String getEnglishButtonText() {
        return englishButtonText;
    }

    public String getSettingsButtonText() {
        return settingsButtonText;
    }

    public String getPlayMusicButton() {
        return playMusicButton;
    }

    public String getEndingAnimationButtonText() {
        return endingAnimationButtonText;
    }

    public String getAutoUpdateButtonText() {
        return autoUpdateButtonText;
    }

    public String getShowExploButtonText() {
        return showExploButtonText;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public String getStraße() {
        return straße;
    }

    public String getNotfallnummer() {
        return notfallnummer;
    }

    public String getOrt() {
        return ort;
    }

    public String getRufnummer() {
        return rufnummer;
    }

    public String getPostleitzahl() {
        return postleitzahl;
    }

    public String getPatientHinzufügen() {
        return patientHinzufügen;
    }

    public String getPatientAktualisieren() {
        return patientAktualisieren;
    }

    public String getFelderLeeren() {
        return felderLeeren;
    }

    public String getVorwärts() {
        return vorwärts;
    }

    public String getRückwärts() {
        return rückwärts;
    }

    public String getAllergieHinzufügen() {
        return allergieHinzufügen;
    }

    public String getVorname() {
        return vorname;
    }

    public String getName() {
        return name;
    }

    public String getBlutgruppe() {
        return blutgruppe;
    }

    /*
    public void Serialize() {
        try {
            JAXBContext jc = JAXBContext.newInstance(this.getClass());
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(this, new File("de.dat"));
        } catch (JAXBException ex) {
            Logger.getLogger(Language.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     */
    public static Language Deserialize(String language) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Language.class);
            Unmarshaller m = jc.createUnmarshaller();
            Language lang = (Language) m.unmarshal(new File(language));
            return lang;
        } catch (JAXBException ex) {
            Logger.getLogger(Language.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
