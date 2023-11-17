package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.forge.ForgePoisson;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class StrategieVague {

    public IntegerProperty numVague;  // numéro de la vague actuelle
    protected double tauxSpawn;   // taux de spwan générale (augmente à chaque vague)

    protected ForgePoisson forgePoisson;  // créer des poissons

    protected double tauxSaumon ;  // probabilité d'apparition des poissons
    protected double tauxAlose ;
    protected double tauxLamproie ;
    protected double tauxEsturgeon ;

    protected int objectif ; // objectif pour finir vague (ou jeu)
    protected int compteurObjectif;  // avancée de la partie

    protected int delai;
    protected int compteurDelai;

    protected int pause ;  // 0 pour pas de pause et 1 pour pause

    public StrategieVague ( int tauxSpawn, int tauxSaumon, int tauxAlose, int tauxLamproie, int tauxEsturgeon, int objectif, int delai, int pause ) {

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
        this.forgePoisson = new ForgePoisson();

    }

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
        this.forgePoisson.fabriquerPoisson(typePoisson);

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
