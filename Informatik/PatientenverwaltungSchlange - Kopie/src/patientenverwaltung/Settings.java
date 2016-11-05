/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientenverwaltung;

import java.io.File;
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
public class Settings {

    public static boolean coolEnding = false;
    public static boolean playSong = false;
    public static boolean changeOnFocus = true;
    public static final boolean showAnim = true;
    public static boolean showExplosion = true;
    public static boolean german = true;

    public static void Serialize(String relativePath) {
        try {
            PortableSettings ports = new PortableSettings(true);
            JAXBContext jc = JAXBContext.newInstance(PortableSettings.class);
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(ports, new File(relativePath));
        } catch (JAXBException ex) {
            System.out.println(ex.toString());
        }
    }

    public static void Deserialize(String relativePath) {
        try {
            JAXBContext jc = JAXBContext.newInstance(PortableSettings.class);
            Unmarshaller m = jc.createUnmarshaller();
            PortableSettings ports = ((PortableSettings) m.unmarshal(new File(relativePath)));
            coolEnding = ports.coolEnding;
            changeOnFocus = ports.changeOnFocus;
            playSong = ports.playSong;
            showExplosion = ports.showExplosion;
            german = ports.german;
        } catch (JAXBException ex) {
            System.out.println(ex.toString());
        }
    }
}

@XmlRootElement
class PortableSettings {

    @XmlElement
    public boolean coolEnding = false;

    @XmlElement
    public boolean playSong = false;

    @XmlElement
    public boolean changeOnFocus = true;

    @XmlElement
    public boolean showExplosion = true;
    
    @XmlElement
    public boolean german = true;
    
    public PortableSettings(){
        
    }

    public PortableSettings(boolean yes) {
        if (yes) {
            this.coolEnding = Settings.coolEnding;
            this.playSong = Settings.playSong;
            this.changeOnFocus = Settings.changeOnFocus;
            this.showExplosion = Settings.showExplosion;
            this.german = Settings.german;
        }
    }
}
