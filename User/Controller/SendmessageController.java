/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author khalf
 */
public class SendmessageController implements Initializable {

    @FXML
    private TextArea message;
    @FXML
    private TextField Destinatair;
    @FXML
    private TextField objet;
    @FXML
    private Button buttonEnvoyer;
    @FXML
    private Button buttonannuler;
    @FXML
    private Button BoiteEnvoie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SendMessage(ActionEvent event) {
        //recuperer message
        
        
        //revenir vers la page precedente
        //si tout passe bien 
        //revenir vers profile
        ((Node)event.getSource()).getScene().getWindow().hide();
        // et afficher alerte success
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setGraphic(new ImageView(this.getClass().getResource("/images/success_icon.png").toString()));
        alert.setHeaderText("Votre message a été bien envoyer ");
        ButtonType OK = new ButtonType("OK",ButtonBar.ButtonData.OK_DONE);
        alert.getButtonTypes().setAll(OK);
        Optional<ButtonType> result = alert.showAndWait();
       
    }

   @FXML
    void showmsgenvoye(ActionEvent event) {

    }

    @FXML
    private void Annuler(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
}
