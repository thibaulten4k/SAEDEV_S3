package fr.iut.montreuil.ArthurFarazThibault.modele;

public abstract class FabriquePoisson{
    int newX;
    int newY;
    public FabriquePoisson(Environnement terrain){
        newX = terrain.getParcours().get(0).getX() * Case.tailleCase + Case.tailleCase/2 ;
        newY = terrain.getParcours().get(0).getX() * Case.tailleCase + Case.tailleCase/2 ;
    }

    public abstract void creerPoissons( int typePoisson, Environnement terrain ); /*{

        int newX = terrain.getParcours().get(0).getX() * Case.tailleCase + Case.tailleCase/2 ;
        int newY = terrain.getParcours().get(0).getX() * Case.tailleCase + Case.tailleCase/2 ;
        Poisson poisson ;

        switch (typePoisson) {
            case 1:
                poisson = new Saumon( newX , newY, terrain ) ;
                terrain.ajouterPoisson(poisson);
                break;

            case 2:
                poisson = new Alose( newX, newY, terrain ) ;
                terrain.ajouterPoisson(poisson);
                break;

            case 3:
                poisson = new Esturgeon ( newX, newY, terrain ) ;
                terrain.ajouterPoisson(poisson);
                break;

            case 4:
                poisson = new Lamproie( newX, newY, terrain ) ;
                terrain.ajouterPoisson(poisson);
                break;
        }

    }
}
*/