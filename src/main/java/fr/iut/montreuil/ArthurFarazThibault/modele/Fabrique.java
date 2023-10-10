package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Archer;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Harponneur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Lanceur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Tremailleur;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Alose;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Esturgeon;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Lamproie;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Saumon;

public class Fabrique {

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