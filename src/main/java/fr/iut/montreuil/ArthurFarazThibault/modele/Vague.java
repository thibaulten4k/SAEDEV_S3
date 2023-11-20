package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.forge.ForgePoisson;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import fr.iut.montreuil.ArthurFarazThibault.modele.forge.ForgePoisson ;

public class Vague extends StrategieVague {

    public Vague ( int tauxSpawn, int tauxSaumon, int tauxAlose, int tauxLamproie, int tauxEsturgeon, int objectif, int delai  ) {
        super(tauxSpawn,tauxSaumon,tauxAlose,tauxLamproie,tauxEsturgeon,objectif,delai, false);
    }


    @Override
    boolean autoriserPlacementPecheur() { return true ; }


}
