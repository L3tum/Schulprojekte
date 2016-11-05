/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientenverwaltung;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.Animation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Callback;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Tom
 */
public class FXMLController implements Initializable {

    // CustomCellFactory for creating CustomCells
    public class CustomCellFactory implements
            Callback<ListView<String>, ListCell<String>> {

        List<ListCell<String>> allCells = new ArrayList<>();

        @Override
        public ListCell<String> call(final ListView<String> p) {
            final CustomCell cell = new CustomCell();
            allCells.add(cell);
            return cell;
        }

        public List<ListCell<String>> getAllCells() {
            return allCells;
        }
    }

    // CustomCell is where the exposure occurs. Here, it's based on the
    // Cell being selected in the ListView. You could choose a different
    // trigger here but you'll need to explore.
    public class CustomCell extends ListCell<String> {

        // General display stuff
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                setText(item == null ? "" : item);
                setGraphic(null);
            }
        }
    }

    public boolean rotate = false;

    private final Queue<Patient> patienten = new Queue<>();
    private Patient current;

    private final int COLUMNS = 4;
    private final int COUNT = 10;
    private final int OFFSET_X = 18;
    private final int OFFSET_Y = 25;
    private final int WIDTH = 374;
    private final int HEIGHT = 243;

    CustomCellFactory patientenFactory = new CustomCellFactory();
    CustomCellFactory allergienFactory = new CustomCellFactory();
    Rectangle2D oldRect = new Rectangle2D(696, 399, 202, 114);

    private Image image;

    public Media media;

    private Animation animation;

    private Rectangle2D oldFelderLeeren;
    private ChangeListener<Boolean> namensListener;
    private ChangeListener<Boolean> vornamensListener;
    private ChangeListener<Boolean> blutgruppenListener;
    private ChangeListener<Boolean> notfallnummerListener;
    private ChangeListener<Boolean> ortsListener;
    private ChangeListener<Boolean> plzListener;
    private ChangeListener<Boolean> straßenListener;
    private ChangeListener<Boolean> hnListener;
    private ChangeListener<Boolean> rnListener;

    @FXML
    Button rückwärtsPatientenButton;

    @FXML
    Button vorwärtsPatientenButton;

    @FXML
    Button patientenHinzufügen;

    @FXML
    Button patientenAktualisieren;

    @FXML
    Button felderLeeren;

    @FXML
    Button allergienVorwärtsButton;

    @FXML
    Button allergienRückwärtsButton;

    @FXML
    Button allergienHinzufügen;

    @FXML
    ListView patientenList;

    @FXML
    ListView allergienList;

    @FXML
    TextField name;

    @FXML
    TextField vorname;

    @FXML
    TextField notfallnummer;

    @FXML
    TextField blutgruppe;

    @FXML
    TextField ort;

    @FXML
    TextField hausnummer;

    @FXML
    TextField straße;

    @FXML
    TextField rufnummer;

    @FXML
    TextField plz;

    @FXML
    TextField allergie;

    @FXML
    ImageView imageView;

    @FXML
    ProgressBar pBar;

    @FXML
    ProgressBar pBarSpin;

    @FXML
    ProgressIndicator indi1;

    @FXML
    ProgressIndicator indi2;

    @FXML
    ImageView explosion;

    @FXML
    MenuButton languages;

    @FXML
    MenuItem deutsch;

    @FXML
    MenuItem english;

    @FXML
    MenuButton settings;

    @FXML
    RadioMenuItem playMusic;

    @FXML
    RadioMenuItem endingAnim;

    @FXML
    RadioMenuItem autoUpdatePatient;

    @FXML
    RadioMenuItem showExplo;

    @FXML
    Label blutgruppeL;

    @FXML
    Label namenL;

    @FXML
    Label vornamenL;

    @FXML
    Label notfallnummerL;

    @FXML
    Label ortL;

    @FXML
    Label straßeL;

    @FXML
    Label hausnummerL;

    @FXML
    Label rufnummerL;

    @FXML
    Label plzL;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String key = "NCkh1MFhgW8T9E8Pa4VF04tG3r5WteK9"; // 128 bit key
        String initVector = "AAECAwQFBgcICQoL"; // 16 bytes IV

        Queue<String> encrypted;

        try {
            if (new File("Save.dat").exists()) {
                FileInputStream file = new FileInputStream(new File("Save.dat"));
                ObjectInputStream o = new ObjectInputStream(file);
                encrypted = (Queue<String>) o.readObject();
                while (encrypted.front() != null) {
                    System.out.println(encrypted.front());
                    String temp = Encryptor.decrypt(key, initVector, encrypted.front());
                    if (temp != null && !temp.trim().equals("")) {
                        patienten.enqueue(Patient.ToPatient(temp));
                    }
                    encrypted.dequeue();
                }
            }
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(ex.toString());
        }

        ShowPatienten();

        final URL resource = getClass().getResource("Icons/explosion.mp3");
        media = new Media(resource.toString());

        this.patientenList.setCellFactory(patientenFactory);
        this.allergienList.setCellFactory(allergienFactory);

        explosion.setImage(null);
        explosion.setVisible(false);
        this.pBar.setVisible(rotate);
        this.pBarSpin.setVisible(rotate);
        this.indi1.setVisible(rotate);
        this.indi2.setVisible(rotate);

        if (new File("Settings.dat").exists()) {
            Settings.Deserialize("Settings.dat");
        }

        this.playMusic.setSelected(Settings.playSong);
        this.endingAnim.setSelected(Settings.coolEnding);
        this.showExplo.setSelected(Settings.showExplosion);
        this.autoUpdatePatient.setSelected(Settings.changeOnFocus);

        if (Settings.changeOnFocus) {
            AddAutoUpdate();
        }

        if (Settings.showAnim) {
            imageView.setVisible(false);
            animation = new SpriteAnimation(
                    imageView,
                    Duration.millis(1000),
                    COUNT, COLUMNS,
                    OFFSET_X, OFFSET_Y,
                    WIDTH, HEIGHT
            );
            animation.setCycleCount(Animation.INDEFINITE);
            animation.play();
        }

        if (!Settings.german) {
            mouseClickedEnglish();
        }

        Playit();
    }

    @FXML
    protected void mouseClickedDeutsch() {
        try {
            UpdateLanguage(new File(getClass().getResource("Languages/Deutsch.xml").toURI()));
            Settings.german = true;
        } catch (URISyntaxException ex) {
            System.out.println(ex.toString());
        }
    }

    @FXML
    protected void mouseClickedEnglish() {
        try {
            UpdateLanguage(new File(getClass().getResource("Languages/English.xml").toURI()));
            Settings.german = false;
        } catch (URISyntaxException ex) {
            System.out.println(ex.toString());
        }
    }

    @FXML
    protected void mouseClickedPlayMusic() {
        Settings.playSong = !Settings.playSong;
        this.playMusic.setSelected(Settings.playSong);
    }

    @FXML
    protected void mouseClickedEndingAnimation() {
        Settings.coolEnding = !Settings.coolEnding;
        this.endingAnim.setSelected(Settings.coolEnding);
    }

    @FXML
    protected void mouseClickedShowExplosion() {
        Settings.showExplosion = !Settings.showExplosion;
        this.showExplo.setSelected(Settings.showExplosion);
    }

    @FXML
    protected void mouseClickedAutoUpdate() {
        Settings.changeOnFocus = !Settings.changeOnFocus;
        this.autoUpdatePatient.setSelected(Settings.changeOnFocus);
        if (!Settings.changeOnFocus) {
            RemoveAutoUpdate();
        } else {
            AddAutoUpdate();
        }
    }

    @FXML
    protected void mouseEntered() {
        rotate = true;
        imageView.setVisible(rotate);
        this.pBar.setVisible(rotate);
        this.pBarSpin.setVisible(rotate);
        this.indi1.setVisible(rotate);
        this.indi2.setVisible(rotate);
    }

    @FXML
    protected void mouseExited() {
        rotate = false;
        imageView.setVisible(rotate);
        this.pBar.setVisible(rotate);
        this.pBarSpin.setVisible(rotate);
        this.indi1.setVisible(rotate);
        this.indi2.setVisible(rotate);
    }

    @FXML
    protected void vorwärtsPatientenClicked() {
        int index = patientenList.getSelectionModel().getSelectedIndex();
        if (index == patientenList.getItems().size() - 1) {
            patientenList.getSelectionModel().select(0);
        } else {
            patientenList.getSelectionModel().select(index + 1);
        }
    }

    @FXML
    protected void rückwärtsPatientenClicked() {
        int index = patientenList.getSelectionModel().getSelectedIndex();
        switch (index) {
            case 0:
                patientenList.getSelectionModel().select(patientenList.getItems().size() - 1);
                break;
            case -1:
                patientenList.getSelectionModel().select(patientenList.getItems().size() - 1);
                break;
            default:
                patientenList.getSelectionModel().select(index - 1);
                break;
        }
    }

    @FXML
    protected void patientHinzufügenClicked() {
        if (!this.vorname.getText().equals("") && !this.name.getText().equals("")) {
            Patient patient = new Patient(this.name.getText(), this.vorname.getText());
            patient.setBlutgruppe(blutgruppe.getText());
            patient.setHausnummer(hausnummer.getText());
            patient.setNotfallnummer(notfallnummer.getText());
            patient.setOrt(ort.getText());
            patient.setPlz(plz.getText());
            patient.setRufnummer(rufnummer.getText());
            patient.setStrasse(straße.getText());
            patienten.enqueue(patient);
            ShowPatienten();
            GetCurrentPatient(patientenList.getSelectionModel().getSelectedIndex());
            UpdateFields();
        }
    }

    @FXML
    protected void patientAktualisierenClicked() {
        if (current != null) {
            current.setBlutgruppe(blutgruppe.getText());
            current.setHausnummer(hausnummer.getText());
            current.setNotfallnummer(notfallnummer.getText());
            current.setOrt(ort.getText());
            current.setPlz(plz.getText());
            current.setRufnummer(rufnummer.getText());
            current.setStrasse(straße.getText());
            ShowAllergien(current);
        }
    }

    @FXML
    protected void felderLeerenClicked() {
        current = null;
        this.blutgruppe.setText("");
        this.hausnummer.setText("");
        this.name.setText("");
        this.vorname.setText("");
        this.notfallnummer.setText("");
        this.ort.setText("");
        this.plz.setText("");
        this.straße.setText("");
        this.rufnummer.setText("");
        ShowAllergien(null);
    }

    @FXML
    protected void allergieHinzufügenClicked() {
        if (current != null && !this.allergie.getText().equals("")) {
            current.getAllergien().enqueue(this.allergie.getText());
            ShowAllergien(current);
        }
    }

    @FXML
    protected void allergieVorwärtsClicked() {
        if (current != null) {
            int index = allergienList.getSelectionModel().getSelectedIndex();
            if (index == current.GetAllergienLength() - 1) {
                allergienList.getSelectionModel().select(0);
            } else {
                allergienList.getSelectionModel().select(index + 1);
            }
        }
    }

    @FXML
    protected void allergieRückwärtsClicked() {
        if (current != null) {
            int index = allergienList.getSelectionModel().getSelectedIndex();
            switch (index) {
                case 0:
                    allergienList.getSelectionModel().select(current.GetAllergienLength() - 1);
                    break;
                case -1:
                    allergienList.getSelectionModel().select(current.GetAllergienLength() - 1);
                    break;
                default:
                    allergienList.getSelectionModel().select(index - 1);
                    break;
            }
        }
    }

    @FXML
    protected void MouseClickedInPatientenList(MouseEvent evt) {
        if (evt.getButton() == MouseButton.PRIMARY) {
            if (evt.getClickCount() == 2) {
                GetCurrentPatient(patientenList.getSelectionModel().getSelectedIndex());
                UpdateFields();
            } else if (evt.getClickCount() == 1) {
                current = null;
                UpdateFields();
            }
        } else if (evt.getButton() == MouseButton.SECONDARY) {
            if (Settings.showExplosion) {
                ListCell<String> cell = patientenFactory.getAllCells().get(patientenList.getSelectionModel().getSelectedIndex());

                double Xstart = (patientenList.getLayoutX() + cell.getLayoutX()) - ((explosion.getTranslateX() - patientenList.getTranslateX()) / 2);
                double Ystart = (patientenList.getLayoutY() + cell.getLayoutY()) - ((explosion.getTranslateY() - patientenList.getTranslateY()) / 2);

                DisplayExplosion(new Rectangle2D(Xstart, Ystart, oldRect.getWidth(), oldRect.getHeight()));
            }
            RemovePatient(patientenList.getSelectionModel().getSelectedIndex());
            ShowPatienten();
            UpdateFields();
        }
    }

    @FXML
    protected void MouseClickedInAllergienList(MouseEvent evt) {
        if (current != null && this.allergienList.getSelectionModel().getSelectedIndex() != -1) {
            if (evt.getButton() == MouseButton.SECONDARY) {
                current.RemoveAllergieAtIndex(this.allergienList.getSelectionModel().getSelectedIndex());
                ShowAllergien(current);
            }
        }
    }

    private void UpdateFields() {
        if (current != null) {
            this.blutgruppe.setText(current.getBlutgruppe());
            this.hausnummer.setText(current.getHausnummer());
            this.name.setText(current.getName());
            this.vorname.setText(current.getVorname());
            this.notfallnummer.setText(current.getNotfallnummer());
            this.ort.setText(current.getOrt());
            this.plz.setText(current.getPlz());
            this.straße.setText(current.getStrasse());
            this.rufnummer.setText(current.getRufnummer());
            ShowAllergien(current);
        } else {
            felderLeerenClicked();
        }
    }

    private void ShowAllergien(Patient patient) {
        if (patient != null) {
            ObservableList<String> list;
            list = FXCollections.observableArrayList();
            while (patient.getAllergien().front() != null) {
                list.add(patient.getAllergien().front());
            }
            java.util.Collections.sort(list);
            list.stream().forEach(patient.getAllergien()::enqueue);
            this.allergienList.setItems(list);
        } else {
            ObservableList<String> list;
            list = FXCollections.observableArrayList();
            allergienList.setItems(list);
        }
    }

    private void GetCurrentPatient(int index) {
        Queue<Patient> tempQueue = new Queue<>();
        int counter = 0;
        while (patienten.front() != null) {
            if (counter == index) {
                current = patienten.front();
                break;
            } else {
                tempQueue.enqueue(patienten.front());
                patienten.dequeue();
            }
        }
        while (tempQueue.front() != null) {
            patienten.enqueue(tempQueue.front());
            tempQueue.dequeue();
        }
    }

    private void RemovePatient(int index) {
        if (index != -1) {
            current = null;
            Queue<Patient> tempQueue = new Queue<>();
            int counter = 0;
            while (patienten.front() != null) {
                if (counter == index) {
                    patienten.dequeue();
                    break;
                } else {
                    tempQueue.enqueue(patienten.front());
                    patienten.dequeue();
                    counter++;
                }
            }
            while (tempQueue.front() != null) {
                patienten.enqueue(tempQueue.front());
                tempQueue.dequeue();
            }
        }
    }

    private void ShowPatienten() {
        if (patienten.front() != null) {
            Queue<Patient> tempQueue3 = new Queue<>();
            ObservableList<String> list = FXCollections.observableArrayList();
            while (patienten.front() != null) {
                list.add(patienten.front().getName() + ", " + patienten.front().getVorname());
                tempQueue3.enqueue(patienten.front());
                patienten.dequeue();
            }
            java.util.Collections.sort(list);
            Patient[] patients = new Patient[list.size()];
            this.patientenList.setItems(list);
            list.stream().map((namme) -> namme.split(", ")[0]).map((names) -> SearchSpecial(tempQueue3, names)).forEach((temp) -> {
                patienten.enqueue(temp);
            });
        } else {
            patientenList.getItems().clear();
        }
    }

    private Patient SearchSpecial(Queue<Patient> queue, String name) {
        Queue<Patient> tempQueue = new Queue<>();
        while (queue.front() != null) {
            if (queue.front().getName().equals(name)) {
                Patient temp = queue.front();
                queue.dequeue();
                while (tempQueue.front() != null) {
                    queue.enqueue(tempQueue.front());
                    tempQueue.dequeue();
                }
                return temp;
            } else {
                tempQueue.enqueue(queue.front());
                queue.dequeue();
            }
        }
        while (tempQueue.front() != null) {
            queue.enqueue(tempQueue.front());
            tempQueue.dequeue();
        }
        return null;
    }

    public void DisplayExplosion(Rectangle2D displayIn) {
        image = new Image(getClass().getResource("Icons/space-explosion-gif-3.gif").toString());
        explosion.setLayoutX(displayIn.getMinX());
        explosion.setLayoutY(displayIn.getMinY());
        explosion.setFitWidth(displayIn.getWidth());
        explosion.setFitHeight(displayIn.getHeight());
        explosion.setVisible(true);
        explosion.setImage(image);
        MediaPlayer player = new MediaPlayer(media);
        player.play();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                explosion.setLayoutX(oldRect.getMinX());
                explosion.setLayoutY(oldRect.getMinY());
                explosion.setFitWidth(oldRect.getWidth());
                explosion.setFitHeight(oldRect.getHeight());
                explosion.setVisible(false);
                explosion.setImage(null);
                player.stop();
            }
        }, 4000);
        new Threading("ViewPort Thread", explosion, image, oldRect, displayIn, media).start();
    }

    private void Playit() {
        new ThreadingM("Player", getClass().getResource("Icons/Spiel mir das Lied vom Tod Soundtrack.mp3").toString()).start();
    }

    private void UpdateLanguage(File language) {
        Language lang = Language.Deserialize(language.getAbsolutePath());
        this.allergienHinzufügen.setText(lang.getAllergieHinzufügen());
        this.allergienRückwärtsButton.setText(lang.getRückwärts());
        this.allergienVorwärtsButton.setText(lang.getVorwärts());
        this.vorwärtsPatientenButton.setText(lang.getVorwärts());
        this.rückwärtsPatientenButton.setText(lang.getRückwärts());
        this.patientenAktualisieren.setText(lang.getPatientAktualisieren());
        this.patientenHinzufügen.setText(lang.getPatientHinzufügen());
        this.felderLeeren.setText(lang.getFelderLeeren());
        this.vornamenL.setText(lang.getVorname());
        this.namenL.setText(lang.getName());
        this.blutgruppeL.setText(lang.getBlutgruppe());
        this.notfallnummerL.setText(lang.getNotfallnummer());
        this.ortL.setText(lang.getOrt());
        this.plzL.setText(lang.getPostleitzahl());
        this.straßeL.setText(lang.getStraße());
        this.hausnummerL.setText(lang.getHausnummer());
        this.rufnummerL.setText(lang.getRufnummer());
        this.settings.setText(lang.getSettingsButtonText());
        this.languages.setText(lang.getLanguagesButtonText());
        this.deutsch.setText(lang.getDeutschButtonText());
        this.english.setText(lang.getEnglishButtonText());
        this.playMusic.setText(lang.getPlayMusicButton());
        this.showExplo.setText(lang.getShowExploButtonText());
        this.endingAnim.setText(lang.getEndingAnimationButtonText());
        this.autoUpdatePatient.setText(lang.getAutoUpdateButtonText());
    }

    private void RemoveAutoUpdate() {
        this.name.focusedProperty().removeListener(namensListener);
        this.vorname.focusedProperty().removeListener(vornamensListener);
        this.blutgruppe.focusedProperty().removeListener(blutgruppenListener);
        this.notfallnummer.focusedProperty().removeListener(notfallnummerListener);
        this.ort.focusedProperty().removeListener(ortsListener);
        this.plz.focusedProperty().removeListener(plzListener);
        this.straße.focusedProperty().removeListener(straßenListener);
        this.hausnummer.focusedProperty().removeListener(hnListener);
        this.rufnummer.focusedProperty().removeListener(rnListener);
        this.felderLeeren.setLayoutX(oldFelderLeeren.getMinX());
        this.felderLeeren.setLayoutY(oldFelderLeeren.getMinY());
        this.patientenAktualisieren.setVisible(true);
    }

    private void AddAutoUpdate() {
        namensListener = new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {

                } else if (current != null) {
                    current.setName(name.getText());
                }
            }
        };
        this.name.focusedProperty().addListener(namensListener);

        vornamensListener = new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {

                } else if (current != null) {
                    current.setVorname(vorname.getText());
                }
            }
        };
        this.vorname.focusedProperty().addListener(vornamensListener);

        notfallnummerListener = new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {

                } else if (current != null) {
                    current.setNotfallnummer(notfallnummer.getText());
                }
            }
        };
        this.notfallnummer.focusedProperty().addListener(notfallnummerListener);

        blutgruppenListener = new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {

                } else if (current != null) {
                    current.setBlutgruppe(blutgruppe.getText());
                }
            }
        };
        this.blutgruppe.focusedProperty().addListener(blutgruppenListener);

        ortsListener = new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {

                } else if (current != null) {
                    current.setOrt(ort.getText());
                }
            }
        };
        this.ort.focusedProperty().addListener(ortsListener);

        plzListener = new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {

                } else if (current != null) {
                    current.setPlz(plz.getText());
                }
            }
        };
        this.plz.focusedProperty().addListener(plzListener);

        straßenListener = new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {

                } else if (current != null) {
                    current.setStrasse(straße.getText());
                }
            }
        };
        this.straße.focusedProperty().addListener(straßenListener);

        hnListener = new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {

                } else if (current != null) {
                    current.setHausnummer(hausnummer.getText());
                }
            }
        };
        this.hausnummer.focusedProperty().addListener(hnListener);

        rnListener = new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {

                } else if (current != null) {
                    current.setRufnummer(rufnummer.getText());
                }
            }
        };
        this.rufnummer.focusedProperty().addListener(rnListener);

        oldFelderLeeren = new Rectangle2D(felderLeeren.getLayoutX(), felderLeeren.getLayoutY(), 0, 0);
        this.felderLeeren.setLayoutX(patientenAktualisieren.getLayoutX());
        this.felderLeeren.setLayoutY(patientenAktualisieren.getLayoutY());
        this.patientenAktualisieren.setVisible(false);
    }

    public Queue<Patient> getPatienten() {
        return patienten;
    }
}

class Threading extends Thread {

    private Thread t;
    private final String threadName;
    private final ImageView imageView;
    private final Rectangle2D oldR;
    private final Rectangle2D newR;
    private final Image images;
    private final MediaPlayer player;

    Threading(String name, ImageView imageView, Image image, Rectangle2D oldR, Rectangle2D newR, Media media) {
        this.images = image;
        this.imageView = imageView;
        this.oldR = oldR;
        this.newR = newR;
        threadName = name;
        this.player = new MediaPlayer(media);
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        try {
            imageView.setLayoutX(newR.getMinX());
            imageView.setLayoutY(newR.getMinY());
            imageView.setFitWidth(newR.getWidth());
            imageView.setFitHeight(newR.getHeight());
            imageView.setVisible(true);
            imageView.setImage(images);
            player.play();
            Thread.sleep(4000);
            imageView.setLayoutX(oldR.getMinX());
            imageView.setLayoutY(oldR.getMinY());
            imageView.setFitWidth(oldR.getWidth());
            imageView.setFitHeight(oldR.getHeight());
            imageView.setVisible(false);
            imageView.setImage(null);
            player.stop();
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

class ThreadingM extends Thread {

    private Thread t;
    private final String threadName;
    private final MediaPlayer player;

    ThreadingM(String name, String media) {
        threadName = name;
        this.player = new MediaPlayer(new Media(media));
        if (Settings.playSong) {
            player.play();
        }
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        while (true) {
            if (Settings.playSong && (player.getStatus().equals(MediaPlayer.Status.STOPPED) || player.getStatus().equals(MediaPlayer.Status.READY) || player.getStatus().equals(MediaPlayer.Status.PAUSED) || player.getStatus().equals(MediaPlayer.Status.HALTED))) {
                player.play();
            }
            if (!Settings.playSong) {
                player.stop();
            }
        }
    }

    @Override
    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
