/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev3a17v0.pkg1;

import Entity.User;
import Service.ServiceUser;
import static Service.ServiceUser.currentUser;
import Technique.MailSend;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import static pidev3a17v0.pkg1.indexController.loginWindow;

/**
 *
 * @author USER-PC
 */
public class loginController implements Initializable {
    
    
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton login;
        @FXML
    private Label result;
            @FXML
    private Label forget;
                @FXML
    private JFXButton Cancel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO   
        Cancel.addEventHandler(MouseEvent.MOUSE_CLICKED, x-> {
            System.out.println("cancel clicked");
          Stage stage = (Stage) Cancel.getScene().getWindow();
            // do what you have to do
            stage.close();
        
        
        });
        
        
        forget.addEventHandler(MouseEvent.MOUSE_CLICKED, x-> {
            System.out.println("cancel clicked");
            if (email.getText().isEmpty())
            {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Email not Valid");
                alert.setContentText("you have to set a valid email");
                alert.showAndWait();
            
            }
            else{
                ServiceUser s=new ServiceUser();
                if (!s.isValidUser(email.getText().toString()))
                {   Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Email not Valid");
                    alert.setContentText("no such user ");
                    alert.showAndWait();
                }
                else{
                        
                        MailSend m=new MailSend();
                        String subject="Password recovery";
                        int randomPIN = (int)(Math.random()*9000)+1000;
                        String pin = String.valueOf(randomPIN);
                        String message="your token is "+pin+" its valid only for 1 hour !!";
                        System.out.println(randomPIN);
                    try {
                        s.addToken(randomPIN,email.getText().toString());
                    } catch (SQLException ex) {
                        Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        m.sendMail("alaa.fouzai@esprit.tn",email.getText().toString(),subject,message);
                        TextInputDialog dialog = new TextInputDialog();
                            dialog.setTitle("tokin input");
                            dialog.setHeaderText("plz enter the token you get from email");
                            dialog.setContentText("Token:");

                            // Traditional way to get the response value.
                            Optional<String> result = dialog.showAndWait();
                            System.out.println("result :"+result.get()+", pin :"+pin.toString());
                            if (s.isValidToken(result.get(),email.getText())) {
                                System.out.println("success");
                                //doo stuff
                            }
                            else 
                            {Alert alert = new Alert(AlertType.ERROR);
                                    alert.setTitle("Information Dialog");
                                    alert.setHeaderText("Token not Valid or timed out");
                                    alert.setContentText("you have to set a valid Token");
                                    alert.showAndWait();
                            }
                           
                
                }
            
            }
                
                
        
        
        });
        login.addEventHandler(MouseEvent.MOUSE_CLICKED, e-> {
            
                System.out.println(email.getText()+password.getText());
                ServiceUser serviceUser =new ServiceUser();
                
                try {
                    if (serviceUser.Autentifier(email.getText(), password.getText()))
                    {   
                        loginWindow.close();
                    }
                    else
                        result.setText("no user found");
                } catch (SQLException ex) {
                    Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
                }
        } 
        );
        }
}
