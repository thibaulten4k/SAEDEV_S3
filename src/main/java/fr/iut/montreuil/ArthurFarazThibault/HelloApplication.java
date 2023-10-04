package fr.iut.montreuil.ArthurFarazThibault;

import fr.iut.montreuil.ArthurFarazThibault.controlleur.ControleurDemarrage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class HelloApplication extends Application {
    ControleurDemarrage cd;
    @Override
    public void start(Stage PrStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vuePartie.fxml"));
        Parent root = fxmlLoader.load();
        PrStage.setTitle("Vue Jeu");
        PrStage.setScene(new Scene(root, 600, 400));
        PrStage.show();


        cd = fxmlLoader.getController();
        cd.initialize(null, null);

    }
    public void setCd(){
        this.cd=new ControleurDemarrage();
    }




    public static void main(String[] args) {
        launch();
    }
}