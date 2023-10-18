package fr.iut.montreuil.ArthurFarazThibault.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Environnement {

    private static Environnement uniqueInstance = null;

    private int nbColonnes;
    private int nbLignes;
    
    private Case[][] terrain;
    private ArrayList<Case> parcours;
    private ObservableList<Poisson> listePoissons;
    private ObservableList<Pecheur> listePecheurs;
    private ObservableList<Projectile> listeProjectiles;
    private IntegerProperty argentProperty;
    private IntegerProperty pvProperty;
    private int argentMax ;
    private Vague vague ;
    private IntegerProperty nbPoissonsTue ;

    public Environnement(int largeur, int hauteur) {
        this.nbColonnes = largeur;
        this.nbLignes = hauteur;

        this.listePoissons = FXCollections.observableArrayList();
        this.listePecheurs = FXCollections.observableArrayList();
        this.listeProjectiles = FXCollections.observableArrayList();

        this.terrain = new Case[hauteur][largeur];
        this.construire();
        this.pvProperty =  new SimpleIntegerProperty(100);
        this.argentProperty = new SimpleIntegerProperty(350);
        this.argentMax = 2000;
        this.nbPoissonsTue = new SimpleIntegerProperty(0);
    }

    public static Environnement getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Environnement(15, 10);

        return uniqueInstance;

    }

    public void setVague() {
        this.vague = new Vague(5,  100, 0, 0, 0, 25, 180);
    }

    //METHODES TERRAIN

    public void construire() {
        for (int col = 0; col < this.nbLignes; col++) {
            for (int lig = 0; lig < this.nbColonnes; lig++) {
                this.terrain[col][lig] = new Case(col, lig, 1);
            }
        }

    }

    public void chargement(int[] carte) {
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

    public int getNbColonnes() { return nbColonnes; }
    public int getNbLignes() { return nbLignes; }
    public Case[][] getTerrain() { return terrain; }
    public double getPoidsCase(int x, int y) { return terrain[x][y].getPoids(); }
    public ArrayList<Case> getParcours() { return this.parcours; }

    //METHODE ARGENT (POTENTIELLEMENT POUR UN FUTUR JOUEUR)

    public void recupArgent ( int argent ) {
        this.setArgentPropertyValue(getArgentPropertyValue() + argent);
        if ( this.getArgentPropertyValue() > argentMax )
            setArgentPropertyValue(argentMax);

    }

    public IntegerProperty getArgentProperty() { return argentProperty; }

    public int getArgentPropertyValue () { return argentProperty.getValue() ; }
    public void setArgentPropertyValue(int argent) { this.argentProperty.setValue(argent) ; }


    //METHODE PV (POTENTIELLEMENT POUR UN FUTUR JOUEUR)

    public void subirDegat(int degat) {
        if ( (pvProperty.getValue() - degat) >= 0 )
        pvProperty.setValue(pvProperty.getValue() - degat);
        else {
            this.setPvPropertyValue(0);
        }

    }
    public int getPvPropertyValue() { return pvProperty.getValue(); }
    public IntegerProperty getPvProperty() { return pvProperty; }

    public void setPvPropertyValue(int pvProperty) { this.pvProperty.setValue(pvProperty); }


    //GESTION DES VAGUES

    public Vague getVague(){
        return this.vague;
    }
    public IntegerProperty getNbPoissonsTue () { return this.nbPoissonsTue ; }

    public boolean estPresent(Poisson cible) {
        for (Poisson p : listePoissons) {
            if (p == cible)
                return true;
        }
        return false;

    }

    //GESTION D'AJOUTS A L'ENVIRONNEMENT


    public ObservableList<Poisson> getListePoissons() { return this.listePoissons; }
    public ObservableList<Pecheur> getListePecheurs() { return this.listePecheurs; }
    public ObservableList<Projectile> getListeProjectiles() { return this.listeProjectiles; }


    public boolean caseOccupee(int x, int y) {
        for (Pecheur pecheur : listePecheurs)
            if (pecheur.getXpropertyValue() == x && pecheur.getYpropertyValue() == y)
                return true;

        return false;
    }



    public void ajouterPecheur(Pecheur pecheur) {
        if (this.getPoidsCase(pecheur.getYpropertyValue() / Case.tailleCase, pecheur.getXpropertyValue() / Case.tailleCase) != 1) {
            System.out.println("Il y a un obstacle sur cette case !");
        }
        else if (caseOccupee(pecheur.getXpropertyValue(), pecheur.getYpropertyValue())) {
            System.out.println("Case déjà occupée !");
        }
        else if (pecheur.getCoût() > this.argentProperty.getValue()) {
            System.out.println("Erreur ! pas assez d'argent ! ");
        }
        else {
            this.setArgentPropertyValue(getArgentPropertyValue() - pecheur.getCoût());
            this.listePecheurs.add(pecheur);
        }

    }

    public void ajouterAListePoisson(Poisson poisson) { this.listePoissons.add(poisson); }



    //METHODES GESTION D'UN TOUR

    public void faireUnTour() {
        if (pvProperty.getValue() > 0 && vague.getNumVague() <= 10) {

            this.pecheursAgissent();
            this.projectilesAgissent();
            this.poissonsAgissent();
            vague.actionUnTour();

        }

    }

    public void pecheursAgissent(){
        for (Pecheur pecheur : listePecheurs) {
            pecheur.actionUnTour();
        }
    }

    public void projectilesAgissent(){
        for (int i = listeProjectiles.size() - 1; i >= 0; i--) {
            Projectile projectile = listeProjectiles.get(i);
            if (projectile.getDureeDeVie() <= 0) {
                listeProjectiles.remove(projectile);
            } else {
                projectile.actionUnTour();
            }

        }
    }

    public void poissonsAgissent(){
        for (int i = listePoissons.size() - 1; i >= 0; i--) {
            Poisson poisson = listePoissons.get(i);
            if (poisson.getPv() <= 0) {
                recupArgent(poisson.getRecompense());
                listePoissons.remove(poisson);
                nbPoissonsTue.setValue(nbPoissonsTue.getValue() + 1);
                vague.incrementerCompteurObjectif();
            } else {
                poisson.actionUnTour();
            }

        }
    }

//FIN





}

