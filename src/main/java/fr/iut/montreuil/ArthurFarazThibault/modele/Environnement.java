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
        this.pvProperty =  new SimpleIntegerProperty(100) ;
        this.argentProperty = new SimpleIntegerProperty(350) ;
        this.argentMax = 2000;
        this.vague = new Vague(5,  100, 0, 0, 0, 25, 180) ;
        this.nbPoissonsTue = new SimpleIntegerProperty(0) ;
    }

    public static Environnement getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Environnement(15, 10);

        return uniqueInstance;

    }

    public void construire() {

        for (int col = 0; col < this.nbLignes; col++) {
            for (int lig = 0; lig < this.nbColonnes; lig++) {
                this.terrain[col][lig] = new Case(col, lig, 1);
            }
        }
    }

    //salut c'est moi
    public void chargement(int[] carte) {

        int curseur = 0;

        for (int col = 0; col < this.nbLignes; col++) {
            for (int lig = 0; lig < this.nbColonnes; lig++) {
                terrain[col][lig].setPoids(carte[curseur]);
                curseur++;
            }
        }

        AlgoChemin chemin = new AlgoChemin(this);
        parcours = chemin.trouverParcours();

    }

    public void subirDegat(int degat) {

        if ( (pvProperty.getValue() - degat) >= 0 )
        pvProperty.setValue(pvProperty.getValue() - degat);
        else {
            this.setPvPropertyValue(0);
        }

    }



    public Vague getVague(){
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

    public IntegerProperty getNbPoissonsTue () { return this.nbPoissonsTue ; }

    public boolean estEncoreEnvie (Poisson cible) {
        for (Poisson p : listePoissons) {
            if (p == cible)
                return true;
        }
        return false;
    }

    public boolean caseOccupee(int x, int y) {
        for (Pecheur p : listePecheurs)
            if (p.getXpropertyValue() == x && p.getYpropertyValue() == y)
                return true;

        return false;
    }

    public void faireUnTour() {

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

    public ArrayList<Case> getParcours() { return this.parcours; }

    public void recupArgent ( int argent ) {
        this.setArgentPropertyValue(getArgentPropertyValue() + argent );
        if ( this.getArgentPropertyValue() > argentMax )
            setArgentPropertyValue(argentMax);
    }

}

