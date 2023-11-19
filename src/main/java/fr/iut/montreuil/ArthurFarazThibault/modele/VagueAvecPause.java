package fr.iut.montreuil.ArthurFarazThibault.modele;

    public class VagueAvecPause extends StrategieVague {

    public VagueAvecPause ( int tauxSpawn, int tauxSaumon, int tauxAlose, int tauxLamproie, int tauxEsturgeon, int objectif, int delai ) {

        super(tauxSpawn,tauxSaumon,tauxAlose,tauxLamproie,tauxEsturgeon,objectif,delai);

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
            this.setPauseTrue();

        }


    }
