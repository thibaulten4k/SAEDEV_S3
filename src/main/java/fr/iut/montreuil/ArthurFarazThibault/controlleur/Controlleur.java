package fr.iut.montreuil.ArthurFarazThibault.controlleur;

import fr.iut.montreuil.ArthurFarazThibault.modele.Case;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import fr.iut.montreuil.ArthurFarazThibault.modele.bonus.BonusBombe;
import fr.iut.montreuil.ArthurFarazThibault.modele.bonus.BonusDelai;
import fr.iut.montreuil.ArthurFarazThibault.modele.bonus.BonusPortee;
import fr.iut.montreuil.ArthurFarazThibault.modele.bonus.BonusStat;
import fr.iut.montreuil.ArthurFarazThibault.modele.forge.ForgePecheur;

import fr.iut.montreuil.ArthurFarazThibault.vue.vueTerrain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



//import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class Controlleur implements Initializable {

    public final static int tailleCase = 32;
    private Timeline gameLoop;
    private int temps;
    private Environnement environnement;
    private boolean pause;



    @FXML
    private RadioButton selectionnerHarponneur, selectionnerLanceur, selectionnerArcher, selectionnerTremailleur, selectionnerPunkAChien,
            selectionnerBombe, selectionnerPotionVitesse, selectionnerPotionPortee;
    @FXML
    private ToggleGroup groupeRadio;
    @FXML
    private Label affichagePv ;
    @FXML
    private Label affichageArgent ;
    @FXML
    private Label affichagePoissons;
    @FXML
    private Label AffichageVague;
    @FXML
    private Pane vueMap;

    private Stage stage;
    private Parent root;

    private double frameRate = 0.017;

    int[] niveau1 = {1, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1,
            1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1,
            1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1,
            1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1,
            1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1};

    int[] niveau2 = {2, 2, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 3,
            2, 2, 1, 1, 1, 1, 1, 2, 2, 1, 0, 0, 0, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 0, 1, 0, 1, 1,
            9, 0, 0, 0, 0, 1, 1, 2, 1, 1, 0, 1, 0, 0, 0,
            1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1,
            1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 2,
            3, 3, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 3, 2,
            3, 3, 2, 1, 1, 1, 0, 0, 0, 0, 0, 1, 3, 3, 3,
            3, 3, 3, 3, 1, 1, 1, 3, 3, 1, 1, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};

    int[] niveau3 = {3, 3, 3, 3, 1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1,
            3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            3, 3, 1, 0, 3, 1, 1, 1, 1, 3, 3, 1, 1, 1, 3,
            3, 3, 3, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 0, 3, 3, 1, 1, 1, 1, 1, 1, 1, 3, 3,
            3, 3, 3, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1,
            3, 3, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1,
            3, 3, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 2,
            3, 3, 3, 1, 1, 1, 1, 1, 1, 2, 2, 1, 0, 1, 2,
            3, 3, 3, 3, 1, 1, 1, 2, 2, 2, 2, 1, 9, 2, 2};


    public void setstage(Stage stage){
        this.stage=stage;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.pause = true;

        creerSpritesBoutonsRadio();

        this.environnement = Environnement.getInstance();

        this.environnement.chargementTerrain(niveau1);
        this.environnement.setVague();
        vueTerrain vue = new vueTerrain(environnement, vueMap, Case.tailleCase);

        this.environnement.getListePoissons().addListener(new ObservateurListePoissons(this.vueMap));
        this.environnement.getListePecheurs().addListener(new ObservateurListePecheurs(this.vueMap));
        this.environnement.getListeProjectiles().addListener(new ObservateurListeProjectiles(this.vueMap));
        this.environnement.getListeObstacles().addListener(new ObservateurListeObstacles(this.vueMap));

        this.affichagePv.textProperty().bind(this.environnement.getPvProperty().asString());
        this.affichageArgent.textProperty().bind(this.environnement.getArgentProperty().asString());
        this.affichagePoissons.textProperty().bind(this.environnement.getNbPoissonsTue().asString());
        this.AffichageVague.textProperty().bind(this.environnement.getVague().getNumVagueProperty().asString());

        this.environnement.generationObstacles();

        gameLoop();
        //demarre l'animation
        gameLoop.play();
    }



    @FXML
    public void creerSpritesBoutonsRadio() {
        Image harponneur_carte = new Image((getClass().getResource( "/harponneur_carte.png").toExternalForm()));
        Image archer_carte = new Image((getClass().getResource( "/archer_carte.png").toExternalForm()));
        Image lanceur_carte = new Image((getClass().getResource( "/lanceur_carte.png").toExternalForm()));
        Image tremailleur_carte = new Image((getClass().getResource( "/tremailleur_carte.png").toExternalForm()));
        Image punkAChien_carte = new Image((getClass().getResource( "/punkAChien_carte.png").toExternalForm()));

        Image bombe_carte = new Image((getClass().getResource( "/bombe_carte.png").toExternalForm()));
        Image potion_vitesse_carte = new Image((getClass().getResource( "/potion_vitesse_carte.png").toExternalForm()));
        Image potion_portee_carte = new Image((getClass().getResource( "/potion_portee_carte.png").toExternalForm()));
        Image potion_degat_carte = new Image((getClass().getResource( "/potion_degat_carte.png").toExternalForm()));

        ImageView harponneur = new ImageView(harponneur_carte);
        selectionnerHarponneur.setGraphic(harponneur);

        ImageView archer = new ImageView(archer_carte);
        selectionnerArcher.setGraphic(archer);

        ImageView lanceur = new ImageView(lanceur_carte);
        selectionnerLanceur.setGraphic(lanceur);

        ImageView tremailleur = new ImageView(tremailleur_carte);
        selectionnerTremailleur.setGraphic(tremailleur);

        ImageView punkAChien = new ImageView(punkAChien_carte);
        selectionnerPunkAChien.setGraphic(punkAChien);


        ImageView bombe = new ImageView(bombe_carte);
        selectionnerBombe.setGraphic(bombe);

        ImageView potionVitesse = new ImageView(potion_vitesse_carte);
        selectionnerPotionVitesse.setGraphic(potionVitesse);

        ImageView potionPortee = new ImageView(potion_portee_carte);
        selectionnerPotionPortee.setGraphic(potionPortee);
    }

    @FXML
    public void placerPecheurObjet(MouseEvent event) {
        if (groupeRadio.getSelectedToggle().equals(selectionnerHarponneur)) {
            ForgePecheur.creerPecheur(event.getX(), event.getY(), 1);
        }
        else if (groupeRadio.getSelectedToggle().equals(selectionnerLanceur)) {
            ForgePecheur.creerPecheur(event.getX(), event.getY(), 2);
        }
        else if (groupeRadio.getSelectedToggle().equals(selectionnerArcher)) {
            ForgePecheur.creerPecheur(event.getX(), event.getY(), 3);
        }
        else if (groupeRadio.getSelectedToggle().equals(selectionnerTremailleur)) {
            ForgePecheur.creerPecheur(event.getX(), event.getY(), 4);
        } else if (groupeRadio.getSelectedToggle().equals(selectionnerPunkAChien)) {
            ForgePecheur.creerPecheur(event.getX(), event.getY(), 5);
        }


        else if(groupeRadio.getSelectedToggle().equals(selectionnerPotionPortee)) {
            new BonusPortee(event.getX(), event.getY(), 300, 1);
        }
        else if(groupeRadio.getSelectedToggle().equals(selectionnerPotionVitesse)) {
            new BonusDelai(event.getX(), event.getY(), 400, 2);
        }
        else {
            new BonusBombe(event.getX(), event.getY(), 200);
        }

    }

    public void marcheArrêt(ActionEvent event) {
        if(pause) {
            System.out.println("Marche");
            pause = false;
        }
        else {
            System.out.println("Arrêt");
            pause = true;
        }

    }

    @FXML
    public void vitesseMoitié(ActionEvent event) {
        gameLoop.setRate(0.5);
        reloadGameLoop();
    }
    @FXML
    public void vitesseNormal(ActionEvent event) {
        gameLoop.setRate(1);
        reloadGameLoop();
    }
    @FXML
    public void vitesseDoublé(ActionEvent event) {
        gameLoop.setRate(2);
        reloadGameLoop();
    }

    public void reloadGameLoop() {
        gameLoop.currentRateProperty();
        gameLoop.play();
    }

    private void gameLoop() {

        gameLoop = new Timeline();
        temps=0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(

                Duration.seconds(0.017),
                (ev ->{

                    if(environnement.getPvPropertyValue() <= 0) {
                        lancerecranGameOver();
                    }

                    else if(environnement.getVague().getNumVague() >= 10){
                        lancerEcranVictoire();
                    } else {
                        if(!pause) {
                            environnement.faireUnTour();
                            temps++;
                        }
                    }
                })
        );
        gameLoop.getKeyFrames().add(kf);
        Duration.seconds(frameRate);
    }

    public void lancerecranGameOver() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/iut/montreuil/ArthurFarazThibault/vueGameOver.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ControleurGameOver controleur = loader.getController();

        stage = (Stage) ((javafx.scene.Node) vueMap).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);// Largeur 940px : 840px pour la carte, 100px pour le volet droit
        stage.setResizable(false);                     // Hauteur 560px : 480 pour la carte, 80px pour le volet bas
        stage.setTitle("Poisson contre pêcheur");
        stage.setScene(scene);
        stage.show();
        gameLoop.stop();

    }

    public void lancerEcranVictoire() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/iut/montreuil/ArthurFarazThibault/vueVictoire.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ControleurVictoire controleur = loader.getController();

        stage = (Stage) ((javafx.scene.Node) vueMap).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);// Largeur 940px : 840px pour la carte, 100px pour le volet droit
        stage.setResizable(false);                     // Hauteur 560px : 480 pour la carte, 80px pour le volet bas
        stage.setTitle("Poisson contre pêcheur");
        stage.setScene(scene);
        stage.show();
        gameLoop.stop();

    }

}

//token thibault: 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