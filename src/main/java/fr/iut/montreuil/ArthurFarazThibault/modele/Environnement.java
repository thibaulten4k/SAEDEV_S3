package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.bonus.Bonus;
import fr.iut.montreuil.ArthurFarazThibault.modele.obstacles.Buisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.obstacles.Rocher;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Environnement {

    private static Environnement uniqueInstance = new Environnement(15, 10);

    private int nbColonnes;
    private int nbLignes;
    
    private Case[][] terrain;
    private ArrayList<Case> parcours;

    private ObservableList<Poisson> listePoissons;
    private ObservableList<Pecheur> listePecheurs;
    private ObservableList<Projectile> listeProjectiles;
    private ObservableList<Obstacle> listeObstacles;

    private IntegerProperty argentProperty;
    private IntegerProperty pvProperty;
    private int argentMax;
    private StrategieVague vague;
    private IntegerProperty nbPoissonsTue ;

    public Environnement(int largeur, int hauteur) {
        this.nbColonnes = largeur;
        this.nbLignes = hauteur;

        this.listePoissons = FXCollections.observableArrayList();
        this.listePecheurs = FXCollections.observableArrayList();
        this.listeProjectiles = FXCollections.observableArrayList();
        this.listeObstacles = FXCollections.observableArrayList();

        this.terrain = new Case[hauteur][largeur];
        this.construire();
        this.pvProperty =  new SimpleIntegerProperty(100);
        this.argentProperty = new SimpleIntegerProperty(350);
        this.argentMax = 2000;
        this.nbPoissonsTue = new SimpleIntegerProperty(0);

    }

    public void setVague() { this.vague = new VagueAvecPause(5, 100, 0, 0, 0, 25, 180) {
    }; }

    public static Environnement getInstance() {
        return uniqueInstance;

    }
    public static void InitialiseEnvironnement(){
        uniqueInstance=new Environnement(15, 10);
    }

    public void construire() {
        for (int col = 0; col < this.nbLignes; col++) {
            for (int lig = 0; lig < this.nbColonnes; lig++) {
                this.terrain[col][lig] = new Case(col, lig, 1);
            }
        }

    }

    //salut c'est moi
    public void chargementTerrain(int[] carte) {
        int curseur = 0;

        for (int col = 0; col < this.nbLignes; col++) {
            for (int lig = 0; lig < this.nbColonnes; lig++) {
                terrain[col][lig].setPoids(carte[curseur]);
                curseur++;
            }
        }

        AlgoChemin chemin = new AlgoChemin(this);
        this.parcours = chemin.trouverParcours();
    }

    public void generationObstacles() {
        double tauxBuisson = 0.20;
        double tauxRocher = 0.30;
        double random;

        for (int col = 0; col < this.nbLignes; col++) {
            for (int lig = 0; lig < this.nbColonnes; lig++) {
                if(Environnement.getInstance().getPoidsCase(col, lig) == 1) {
                    random = Math.random();
                    if (random <= tauxBuisson) {
                        Environnement.getInstance().ajouterAListeObstacles(new Buisson(lig, col) );
                    } else if (random <= tauxRocher) {
                        Environnement.getInstance().ajouterAListeObstacles(new Rocher(lig, col) );
                    }
                }


            }
        }

    }

    public void subirDegat(int degat) {
        if ( (pvProperty.getValue() - degat) >= 0 )
        pvProperty.setValue(pvProperty.getValue() - degat);
        else {
            this.setPvPropertyValue(0);
        }

    }



    public StrategieVague getVague(){
        return this.vague;
    }

    public int getNbColonnes() { return nbColonnes; }
    public int getNbLignes() { return nbLignes; }
    public Case[][] getTerrain() { return terrain; }
    public double getPoidsCase(int x, int y) { return terrain[x][y].getPoids(); }
    public int getPvPropertyValue() { return pvProperty.getValue(); }
    public IntegerProperty getPvProperty() { return pvProperty; }
    public IntegerProperty getArgentProperty() { return argentProperty; }

    public int getArgentPropertyValue () { return argentProperty.getValue() ; }
    public void setArgentPropertyValue(int argent) { this.argentProperty.setValue(argent) ; }

    public void setPvPropertyValue(int pvProperty) { this.pvProperty.setValue(pvProperty); }

    public ObservableList<Poisson> getListePoissons() { return this.listePoissons; }
    public ObservableList<Pecheur> getListePecheurs() { return this.listePecheurs; }
    public ObservableList<Projectile> getListeProjectiles() { return this.listeProjectiles; }
    public ObservableList<Obstacle> getListeObstacles() { return this.listeObstacles; }

    public IntegerProperty getNbPoissonsTue () { return this.nbPoissonsTue ; }

    public boolean caseOccupee(int x, int y) {
        for (Pecheur p : listePecheurs)
            if (p.getXpropertyValue() == x && p.getYpropertyValue() == y)
                return true;

        for (Obstacle o : listeObstacles)
            if(o.getXpropertyValue() == x && o.getYpropertyValue() == y)
                return true;

        return false;
    }

    public Pecheur caseOccupeePecheur(int x, int y) {
        for (Pecheur p : listePecheurs)
            if (p.getXpropertyValue() == x && p.getYpropertyValue() == y)
                return p;

        return null;
    }
    public Obstacle caseOccupeeObstacle(int x, int y) {
        for (Obstacle o : listeObstacles)
            if(o.getXpropertyValue() == x && o.getYpropertyValue() == y)
                return o;

        return null;
    }

    public void faireUnTour() {

        if ( !this.vague.getPause() ) {

            if (pvProperty.getValue() > 0 && vague.getNumVague() <= 10) {

                for (Pecheur p : listePecheurs) {
                    p.actionUnTour();
                }

                for (int i = listeProjectiles.size() - 1; i >= 0; i--) {
                    Projectile p = listeProjectiles.get(i);
                    if (p.getDureeDeVie() <= 0) {
                        listeProjectiles.remove(p);
                    } else {
                        p.actionUnTour();
                    }

                }

                for (int i = listePoissons.size() - 1; i >= 0; i--) {
                    Poisson p = listePoissons.get(i);
                    if (p.getPv() <= 0) {
                        recupArgent(p.getRecompense());
                        listePoissons.remove(p);
                        nbPoissonsTue.setValue(nbPoissonsTue.getValue() + 1);
                        vague.incrementerCompteurObjectif();
                    } else {
                        p.actionUnTour();
                    }

                }

                vague.actionUnTour();

            }

        }



    }

    public void ajouterAListePecheurs(Pecheur pecheur) {
        if ( this.vague.autoriserPlacementPecheur() ) {

            if (this.getPoidsCase(pecheur.getYpropertyValue() / Case.tailleCase, pecheur.getXpropertyValue() / Case.tailleCase) != 1) {
                System.out.println("Il y a un obstacle sur cette case !");
            }
            else if (caseOccupee(pecheur.getXpropertyValue(), pecheur.getYpropertyValue())) {
                System.out.println("Case déjà occupée !");
            }
            else if (pecheur.getCout() > this.argentProperty.getValue()) {
                System.out.println("Erreur ! pas assez d'argent ! ");
            }
            else {
                this.setArgentPropertyValue(getArgentPropertyValue() - pecheur.getCout());
                this.listePecheurs.add(pecheur);
            }

        }



    }
    public void ajouterAListePoissons(Poisson poisson) { this.listePoissons.add(poisson); }
    public void ajouterAListeObstacles(Obstacle obstacle) { this.listeObstacles.add(obstacle); }
    public void ajouterAListeProjectiles(Projectile projectile) { this.listeProjectiles.add(projectile); }
    public void ajouterBonusAEnvironnement(Bonus bonus) {
        if (this.getArgentPropertyValue() >= bonus.getCout()) {
            bonus.appliquerBonus();
            this.setArgentPropertyValue(this.getArgentPropertyValue() - bonus.getCout());
        }
        else {
            System.out.println("Pas assez d'argent, nécessite: " + bonus.getCout() +"!") ;
        }
    }

    public ArrayList<Case> getParcours() { return this.parcours; }

    public void recupArgent ( int argent ) {
        this.setArgentPropertyValue(getArgentPropertyValue() + argent);
        if ( this.getArgentPropertyValue() > argentMax )
            setArgentPropertyValue(argentMax);

    }

}