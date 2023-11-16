package fr.iut.montreuil.ArthurFarazThibault.controlleur;

import fr.iut.montreuil.ArthurFarazThibault.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.security.PrivateKey;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class ControleurDemarrage implements Initializable {

    private Stage stage;
    private Parent root;
    private Controlleur controleur;


    @FXML
    private void started(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/iut/montreuil/ArthurFarazThibault/vuePartie2.fxml"));
        root = loader.load();
        controleur = loader.getController(); // Retrieve the controller instance
        controleur.setstage(stage);
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 480, 735);// Largeur 940px : 840px pour la carte, 100px pour le volet droit
        stage.setResizable(false);                     // Hauteur 560px : 480 pour la carte, 80px pour le volet bas
        stage.setTitle("River Rush");
        stage.setScene(scene);
        stage.show();
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


}


//TEST DE PUSH PAR ROBIN