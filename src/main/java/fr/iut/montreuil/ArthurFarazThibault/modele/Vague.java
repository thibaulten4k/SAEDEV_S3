package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.forge.ForgePoisson;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import fr.iut.montreuil.ArthurFarazThibault.modele.forge.ForgePoisson ;

public class Vague extends StrategieVague {

    public Vague ( int tauxSpawn, int tauxSaumon, int tauxAlose, int tauxLamproie, int tauxEsturgeon, int objectif, int delai  ) {
        super(tauxSpawn,tauxSaumon,tauxAlose,tauxLamproie,tauxEsturgeon,objectif,delai, false);
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

    @Override
    boolean autoriserPlacementPecheur() { return true ; }


}
