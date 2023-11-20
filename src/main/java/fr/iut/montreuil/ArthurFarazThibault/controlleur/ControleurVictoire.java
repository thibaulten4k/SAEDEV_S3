package fr.iut.montreuil.ArthurFarazThibault.controlleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControleurVictoire {
    private Stage stage;
    private Parent root;


    @FXML
    private void Victoire(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/iut/montreuil/ArthurFarazThibault/vuePartie2.fxml"));
        root = loader.load();


        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 480, 735);// Largeur 940px : 840px pour la carte, 100px pour le volet droit
        stage.setResizable(false);                     // Hauteur 560px : 480 pour la carte, 80px pour le volet bas
        stage.setTitle("Poisson contre pêcheur");
        stage.setScene(scene);
        stage.show();
    }



}
