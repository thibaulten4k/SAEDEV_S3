package fr.iut.montreuil.ArthurFarazThibault.controlleur;

import fr.iut.montreuil.ArthurFarazThibault.modele.Case;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import fr.iut.montreuil.ArthurFarazThibault.modele.Fabrique;
import fr.iut.montreuil.ArthurFarazThibault.modele.ForgePecheur ;
import fr.iut.montreuil.ArthurFarazThibault.modele.SimpleFabriquePecheur ;

import fr.iut.montreuil.ArthurFarazThibault.modele.ForgePecheur;
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
    private ForgePecheur fP ; //



    @FXML
    private RadioButton selectionnerHarponneur;
    @FXML
    private RadioButton selectionnerLanceur;
    @FXML
    private RadioButton selectionnerArcher;
    @FXML
    private RadioButton selectionnerTremailleur;
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

    int[] niveau1 = {3, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1,
            1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1,
            1, 0, 0, 0, 0, 0, 1, 0, 1, 2, 2, 1, 0, 1, 1,
            1, 1, 1, 1, 1, 0, 1, 0, 1, 2, 2, 1, 0, 1, 1,
            2, 1, 1, 1, 1, 0, 0, 0, 1, 2, 2, 1, 0, 1, 1,
            2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 0, 1, 1,
            2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 1, 0, 1, 1,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 1, 1};

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

        this.environnement = new Environnement(15,10);

        this.environnement.chargement(niveau2);
        vueTerrain vue = new vueTerrain(environnement, vueMap, Case.tailleCase);

        this.environnement.getListePoissons().addListener(new ObservateurListePoissons(this.vueMap));
        this.environnement.getListePecheurs().addListener(new ObservateurListePecheurs(this.vueMap));
        this.environnement.getListeProjectiles().addListener(new ObservateurListeProjectiles(this.vueMap));

        //this.environnement.getPvProperty().addListener((obs, old, newValue) -> affichagePv.setText(newValue.toString()));
        //this.environnement.getArgentProperty().addListener( (obs, old, newValue ) -> affichageArgent.setText(newValue.toString()) );

        this.affichagePv.textProperty().bind(this.environnement.getPvProperty().asString());
        this.affichageArgent.textProperty().bind(this.environnement.getArgentProperty().asString());
        this.affichagePoissons.textProperty().bind(this.environnement.getNbPoissonsTue().asString());
        this.AffichageVague.textProperty().bind(this.environnement.getVague().getNumVagueProperty().asString());


        initAnimation();
        //demarre l'animation
        gameLoop.play();
    }



    @FXML
    public void creerSpritesBoutonsRadio() {
        Image harponneur_carte = new Image((getClass().getResource( "/harponneur_carte.png").toExternalForm()));
        Image archer_carte = new Image((getClass().getResource( "/archer_carte.png").toExternalForm()));
        Image lanceur_carte = new Image((getClass().getResource( "/lanceur_carte.png").toExternalForm()));
        Image tremailleur_carte = new Image((getClass().getResource( "/tremailleur_carte.png").toExternalForm()));

        ImageView harponneur = new ImageView(harponneur_carte);
        selectionnerHarponneur.setGraphic(harponneur);

        ImageView archer = new ImageView(archer_carte);
        selectionnerArcher.setGraphic(archer);

        ImageView lanceur = new ImageView(lanceur_carte);
        selectionnerLanceur.setGraphic(lanceur);

        ImageView tremailleur = new ImageView(tremailleur_carte);
        selectionnerTremailleur.setGraphic(tremailleur);
    }

    @FXML
    public void placerPecheur(MouseEvent event) {
        if (groupeRadio.getSelectedToggle().equals(selectionnerHarponneur)) {
            Fabrique.creerPecheur(event.getX(), event.getY(), 1, environnement);
            //fP.creerPecheur(event.getX(), event.getY(), "harponneur") ;
        }
        else if (groupeRadio.getSelectedToggle().equals(selectionnerLanceur)) {
            Fabrique.creerPecheur(event.getX(), event.getY(), 2, environnement);
            //fP.creerPecheur(event.getX(), event.getY(), "lanceur") ;
        }
        else if (groupeRadio.getSelectedToggle().equals(selectionnerArcher)) {
            Fabrique.creerPecheur(event.getX(), event.getY(), 3, environnement);
            //fP.creerPecheur(event.getX(), event.getY(), "archer") ;
        }
        else {
            Fabrique.creerPecheur(event.getX(), event.getY(), 4, environnement);
            //fP.creerPecheur(event.getX(), event.getY(), "tremailleur") ;
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

    private void initAnimation() {

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