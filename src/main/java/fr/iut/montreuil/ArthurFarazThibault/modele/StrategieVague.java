package fr.iut.montreuil.ArthurFarazThibault.modele;

import javafx.beans.property.IntegerProperty;

public abstract class StrategieVague {

    public IntegerProperty numVague;  // numéro de la vague actuelle
    private double tauxSpawn;   // taux de spwan générale (augmente à chaque vague)

    private ForgePoisson ForgePoisson;  // créer des poissons

    private double tauxSaumon ;  // probabilité d'apparition des poissons
    private double tauxAlose ;
    private double tauxLamproie ;
    private double tauxEsturgeon ;

    private int objectif ; // objectif pour finir vague (ou jeu)
    private int compteurObjectif;  // avancée de la partie

    private int delai;
    private int compteurDelai;


    public void incrementerCompteurObjectif() { this.compteurObjectif++; }
    public IntegerProperty getNumVagueProperty(){ return numVague; }
    public int getNumVague(){ return numVague.getValue(); }

    public void ajouterPoisson() {
        double aleatoire = Math.random() ;
        String typePoisson;

        if ( aleatoire >= 0 && aleatoire < tauxSaumon ) {
            typePoisson = "Saumon";
        }
        else if (aleatoire < tauxAlose){
            typePoisson = "Alose";
        }
        else if (aleatoire < tauxLamproie ){
            typePoisson = "Lamproie";
        }
        else{
            typePoisson = "Esturgeon";
        }
        this.ForgePoisson.forgerPoisson(typePoisson);

        compteurDelai = 0;
    }





}
