package fr.iut.montreuil.ArthurFarazThibault.modele;

public class FabriquePecheur {

    public static void creerPecheur ( double x, double y, int typePecheur, Environnement environnement ) {

        int newX = (int)(x / Case.tailleCase) * Case.tailleCase + Case.tailleCase/2;
        int newY = (int)(y / Case.tailleCase) * Case.tailleCase + Case.tailleCase/2;
        Pecheur pecheur;

        switch (typePecheur) {
            case 1:
                pecheur = new Harponneur(newX , newY, environnement);
                environnement.ajouterPecheur(pecheur);
                break;

            case 2:
                pecheur = new Lanceur(newX, newY, environnement);
                environnement.ajouterPecheur(pecheur);
                break;

            case 3:
                pecheur = new Archer(newX, newY, environnement);
                environnement.ajouterPecheur(pecheur);
                break;

            case 4:
                pecheur = new Tremailleur(newX, newY, environnement);
                environnement.ajouterPecheur(pecheur);
        }

    }
}
