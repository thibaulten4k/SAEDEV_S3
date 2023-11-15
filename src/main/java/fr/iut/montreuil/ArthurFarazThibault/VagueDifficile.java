package fr.iut.montreuil.ArthurFarazThibault;

import fr.iut.montreuil.ArthurFarazThibault.modele.StrategieVague;

public class VagueDifficile extends StrategieVague {

    public VagueDifficile ( int tauxSpawn, int tauxSaumon, int tauxAlose, int tauxLamproie, int tauxEsturgeon, int objectif, int delai ) {

        super(tauxSpawn,tauxSaumon,tauxAlose,tauxLamproie,tauxEsturgeon,objectif,delai,0);

    }


}
