package tuerme;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.List;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tom.pauly
 */
class FXMLController implements Initializable{

     @FXML
     ImageView stab1;
     
     @FXML
     ImageView stab2;
     
     @FXML
     ImageView stab3;
     
     @FXML
     AnchorPane anchor;
     
     @FXML
     Button addMoar;
     
     List<ImageView> scheiben = new ArrayList<>();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    
    public BufferedImage scale(BufferedImage sbi, int imageType, int dWidth, int dHeight, double fWidth, double fHeight) {
    BufferedImage dbi = null;
    if(sbi != null) {
        dbi = new BufferedImage(dWidth, dHeight, imageType);
        Graphics2D g = dbi.createGraphics();
        AffineTransform at = AffineTransform.getScaleInstance(fWidth, fHeight);
        g.drawRenderedImage(sbi, at);
    }
    return dbi;
}
    
}
