package fr.iut.montreuil.ArthurFarazThibault.modele.forge;

import fr.iut.montreuil.ArthurFarazThibault.modele.Case;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.*;

public class ForgePecheur {

    public static void creerPecheur (double x, double y, int typePecheur) {

        Environnement environnement = Environnement.getInstance();

        int newX = (int)(x / Case.tailleCase) * Case.tailleCase + Case.tailleCase/2;
        int newY = (int)(y / Case.tailleCase) * Case.tailleCase + Case.tailleCase/2;
        Pecheur pecheur;

        switch (typePecheur) {
            case 1:
                pecheur = new Harponneur(newX , newY);
                environnement.ajouterAListePecheurs(pecheur);
                break;

            case 2:
                pecheur = new Lanceur(newX, newY);
                environnement.ajouterAListePecheurs(pecheur);
                break;

            case 3:
                pecheur = new Archer(newX, newY);
                environnement.ajouterAListePecheurs(pecheur);
                break;

            case 4:
                pecheur = new Tremailleur(newX, newY);
                environnement.ajouterAListePecheurs(pecheur);
                break;
            case 5:
                pecheur = new PunkAChien(newX, newY);
                environnement.ajouterAListePecheurs(pecheur);
                break;
        }

    }

}
