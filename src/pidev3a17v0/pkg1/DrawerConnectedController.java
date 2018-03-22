/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev3a17v0.pkg1;

import Service.ServiceUser;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import static Service.ServiceUser.currentUser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import pidev3a17v0.pkg1.indexController;
import static pidev3a17v0.pkg1.indexController.AnchorDrower;

/**
 * FXML Controller class
 *
 * @author USER-PC
 */
public class DrawerConnectedController implements Initializable {


    @FXML
    private JFXButton exit;
    @FXML
    private JFXButton profile;
    @FXML
    private ImageView UserImage;
    @FXML
    private JFXButton disconnect;
    @FXML
    private Label nom;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nom.setText("Connected as :"+currentUser.getUser_name());
        disconnect.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{
            System.out.println("disconnect button");
            currentUser.setConfirmation_token("");
            currentUser.setEmail("");
            currentUser.setEnabled(0);
            currentUser.setFirst_name("");
            currentUser.setId(0);
            currentUser.setLast_login("");
            currentUser.setLast_name("");
            currentUser.setNbRating(0);
            currentUser.setPassword("");
            currentUser.setPassword_request_at("");
            currentUser.setPreferance("");
            currentUser.setRoles("");
            currentUser.setStars(0);
            currentUser.setUser_name("");
            currentUser.setWarning(0);
            try {
                AnchorDrower=FXMLLoader.load(getClass().getResource("/GUI/DrawerConnected.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(DrawerConnectedController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(currentUser.toString());
        });
    }    
    
}
