package fr.iut.montreuil.ArthurFarazThibault.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.LinkedList;

public class Vague {

    private FabriqueAlose fabAlose;
    private FabriqueEsturgeon fabEstu;
    private FabriqueSaumon fabSaum;
    private FabriqueLamproie fabLamp;

    private double tauxSpawn;

    public IntegerProperty numVague;

    private double tauxSaumon ;
    private double tauxAlose ;
    private double tauxLamproie ;
    private double tauxEsturgeon ;

    private int objectif ;
    private int compteurObjectif;

    private int delai;
    private int compteurDelai;


    public Vague (int tauxSpawn, int tauxSaumon, int tauxAlose, int tauxLamproie, int tauxEsturgeon, int objectif, int delai) {
        this.tauxSpawn = tauxSpawn * 0.001;
        this.numVague = new SimpleIntegerProperty(1);

        this.tauxSaumon = tauxSaumon * 0.01;
        this.tauxAlose = this.tauxSaumon + tauxAlose * 0.01;
        this.tauxLamproie = this.tauxAlose + tauxLamproie * 0.01;
        this.tauxEsturgeon = this.tauxLamproie + tauxEsturgeon * 0.01;

        this.objectif = objectif;
        this.compteurObjectif = 0;

        this.delai = delai;
        this.compteurDelai = delai;

        fabAlose = new FabriqueAlose();
        fabEstu = new FabriqueEsturgeon();
        fabLamp = new FabriqueLamproie();
        fabSaum = new FabriqueSaumon();

    }
    public void fabriquerSaumon(){ fabSaum.forgerPoisson(); }
    public void fabriquerAlose(){ fabAlose.forgerPoisson(); }
    public void fabriquerLamproie(){ fabLamp.forgerPoisson(); }
    public void fabriquerEsturgeon(){ fabEstu.forgerPoisson(); }

    public void incrementerCompteurObjectif() { this.compteurObjectif++; }
    public IntegerProperty getNumVagueProperty(){ return numVague; }
    public int getNumVague(){ return numVague.getValue(); }

    public void ajouterPoisson() {
        double aleatoire = Math.random() ;

        if ( aleatoire >= 0 && aleatoire < tauxSaumon ) {
            fabriquerSaumon();
        }
        else if (aleatoire < tauxAlose){
            fabriquerAlose();
        }
        else if (aleatoire < tauxLamproie ){
            fabriquerLamproie();
        }
        else{
            fabriquerEsturgeon();
        }

        compteurDelai = 0;
    }

    public void actionUnTour() {
        compteurDelai++;

        if (compteurDelai >= delai)
            ajouterPoisson();

        if (compteurObjectif == objectif)
            evolutionVague();

    }

    public void calculerLesTaux() {
        tauxAlose += tauxSaumon;
        tauxLamproie += tauxAlose;
        tauxEsturgeon += tauxLamproie;

    }

    public void incrementerLesTaux(double taux) {
        if (tauxAlose - tauxSaumon >= 0)
            tauxAlose -= tauxSaumon;
        if (tauxLamproie - tauxSaumon >= 0)
            tauxLamproie -= tauxSaumon;
        if (tauxEsturgeon - tauxSaumon >= 0)
            tauxEsturgeon  -= tauxSaumon;

        tauxSaumon -= taux;

        double aleatoire = Math.random();

        if (aleatoire >= 0 && aleatoire < 0.35)
            tauxAlose += taux;
        else if (aleatoire < 0.70)
            tauxLamproie += taux;
        else
            tauxEsturgeon += taux;

        calculerLesTaux();
    }

    public void evolutionVague() {
            objectif = (int)(objectif * 1.2);
            compteurObjectif = 0;

            tauxSpawn = tauxSpawn * 2;
            if (tauxSpawn > 0.1)
                tauxSpawn = 0.1;


            delai = (int) (delai/1.5);
            if (delai < 3)
                delai = 3;

            incrementerLesTaux(0.1);

            numVague.setValue(numVague.getValue() + 1);

    }



}
