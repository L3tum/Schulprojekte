/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientenverwaltung;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author tom.pauly
 */
public class NewFXMain extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;
    private FXMLController controller;

    @Override
    public void start(Stage primaryStage) {
        Encryptor.removeCryptographyRestrictions();
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Patientenverwaltung");

        initRootLayout();

        primaryStage.onCloseRequestProperty().setValue(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent WindowEvent) {
                if (WindowEvent.getEventType() == javafx.stage.WindowEvent.WINDOW_CLOSE_REQUEST) {
                    WindowEvent.consume();
                    if (Settings.coolEnding) {
                        controller.DisplayExplosion(new Rectangle2D(66 / 3, 0, primaryStage.getWidth(), primaryStage.getHeight()));
                    }
                    try {
                        String key = "NCkh1MFhgW8T9E8Pa4VF04tG3r5WteK9"; // 128 bit key
                        String initVector = "AAECAwQFBgcICQoL"; // 16 bytes IV

                        Queue<String> toStringed = new Queue<>();
                        Queue<String> encrypted = new Queue<>();
                        
                        while (controller.getPatienten().front() != null) {
                            toStringed.enqueue(controller.getPatienten().front().toString());
                            controller.getPatienten().dequeue();
                        }

                        while (toStringed.front() != null) {
                            encrypted.enqueue(Encryptor.encrypt(key, initVector, toStringed.front()));
                            toStringed.dequeue();
                        }

                        FileOutputStream fos = new FileOutputStream("Save.dat");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(encrypted);
                        
                        new File("Settings.dat").createNewFile();
                        Settings.Serialize("Settings.dat");
                        
                    } catch (FileNotFoundException ex) {
                        System.out.println(ex.toString());
                    } catch (IOException ex) {
                        System.out.println(ex.toString());
                    }
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            System.exit(0);
                        }

                    }, 4000);
                    
                }
            }
        });
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NewFXMain.class.getResource("FXML.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            controller = loader.getController();

            new Threads("Threads", rootLayout, loader.getController()).start();
        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

class Threads extends Thread {

    private Thread t;
    private final String threadName;
    private final AnchorPane root;
    private final ProgressBar bar;
    private final FXMLController controller;
    private final ProgressIndicator circle1;
    private final ProgressIndicator circle2;
    private final Rotate rotate = new Rotate(0, 100, 9);
    private final Rotate rotation2 = new Rotate(0, 26, 26.5);
    private final Rotate rotation3 = new Rotate(0, 26, 26.5);

    Threads(String name, AnchorPane root, FXMLController con) {
        this.root = root;
        threadName = name;
        this.bar = (ProgressBar) root.getChildren().get(9);
        this.circle1 = (ProgressIndicator) root.getChildren().get(5);
        this.circle2 = (ProgressIndicator) root.getChildren().get(6);
        this.controller = con;
        this.bar.getTransforms().add(0, rotate);
        this.circle1.getTransforms().add(0, rotation2);
        this.circle2.getTransforms().add(0, rotation3);
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (controller.rotate) {
                    if (rotate.getAngle() >= 360.0) {
                        rotate.setAngle(1);
                    } else {
                        rotate.setAngle(rotate.getAngle() + 1);
                    }
                    if (rotation2.getAngle() >= 360.0) {
                        rotation2.setAngle(2);
                    } else {
                        rotation2.setAngle(rotation2.getAngle() + 2);
                    }
                    if (rotation3.getAngle() >= 360.0) {
                        rotation3.setAngle(rotation3.getAngle() - 360 + 4);
                    } else {
                        rotation3.setAngle(rotation3.getAngle() + 4);
                    }
                }
                Thread.sleep(1);
            } catch (Exception ex) {
                System.out.println(ex.toString());
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
