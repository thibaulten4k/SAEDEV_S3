package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.forge.ForgePoisson;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Vague {

    private double tauxSpawn;

    public IntegerProperty numVague;

    private fr.iut.montreuil.ArthurFarazThibault.modele.forge.ForgePoisson ForgePoisson;

    private DoubleProperty tauxSaumon ;
    private DoubleProperty tauxAlose ;
    private DoubleProperty tauxLamproie ;
    private DoubleProperty tauxEsturgeon ;

    private int objectif ;
    private int compteurObjectif;

    private int delai;
    private int compteurDelai;


    public Vague (int tauxSpawn, int tauxSaumon, int tauxAlose, int tauxLamproie, int tauxEsturgeon, int objectif, int delai) {
        this.tauxSpawn = tauxSpawn * 0.001;
        this.numVague = new SimpleIntegerProperty(1);

        this.tauxSaumon = new SimpleDoubleProperty(tauxSaumon * 0.01);
        this.tauxAlose = new SimpleDoubleProperty(this.tauxSaumon.getValue() + tauxAlose * 0.01) ;
        this.tauxLamproie = new SimpleDoubleProperty(this.tauxAlose.getValue() + tauxLamproie * 0.01);
        this.tauxEsturgeon = new SimpleDoubleProperty(this.tauxLamproie.getValue() + tauxEsturgeon * 0.01);

        this.objectif = objectif;
        this.compteurObjectif = 0;

        this.delai = delai;
        this.compteurDelai = delai;
        this.ForgePoisson = new ForgePoisson();


    }

    public void incrementerCompteurObjectif() { this.compteurObjectif++; }
    public IntegerProperty getNumVagueProperty(){ return numVague; }
    public int getNumVague(){ return numVague.getValue(); }

    public DoubleProperty tauxSaumonProperty() { return tauxSaumon; }
    public DoubleProperty tauxAloseProperty() { return tauxAlose; }
    public DoubleProperty tauxLamproieProperty() { return tauxLamproie;}
    public DoubleProperty tauxEsturgeonProperty() { return tauxEsturgeon;}

    public void ajouterPoisson() {
        double aleatoire = Math.random() ;
        String typePoisson;

        if (aleatoire >= 0 && aleatoire < tauxSaumon.getValue()) {
            typePoisson = "Saumon";
        }
        else if (aleatoire < tauxAlose.getValue()){
            typePoisson = "Alose";
        }
        else if (aleatoire < tauxLamproie.getValue()){
            typePoisson = "Lamproie";
        }
        else{
            typePoisson = "Esturgeon";
        }
        this.ForgePoisson.fabriquerPoisson(typePoisson);

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
        tauxAlose.setValue(tauxAlose.getValue() + tauxSaumon.getValue());
        tauxLamproie.setValue(tauxLamproie.getValue() + tauxAlose.getValue());
        tauxEsturgeon.setValue(tauxEsturgeon.getValue() + tauxLamproie.getValue());

    }

    public void incrementerLesTaux(double taux) {
        if (tauxAlose.getValue() - tauxSaumon.getValue() >= 0)
            tauxAlose.setValue(tauxAlose.getValue()  - tauxSaumon.getValue());
        if (tauxLamproie.getValue() - tauxSaumon.getValue() >= 0)
            tauxLamproie.setValue(tauxLamproie.getValue() - tauxSaumon.getValue());
        if (tauxEsturgeon.getValue() - tauxSaumon.getValue() >= 0)
            tauxEsturgeon.setValue(tauxEsturgeon.getValue()  - tauxSaumon.getValue());

        tauxSaumon.setValue(tauxSaumon.getValue() - taux);

        double aleatoire = Math.random();

        if (aleatoire >= 0 && aleatoire < 0.35)
            tauxAlose.setValue(tauxAlose.getValue() + taux);
        else if (aleatoire < 0.70)
            tauxLamproie.setValue(tauxLamproie.getValue() + taux);
        else
            tauxEsturgeon.setValue(tauxEsturgeon.getValue() + taux);

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
