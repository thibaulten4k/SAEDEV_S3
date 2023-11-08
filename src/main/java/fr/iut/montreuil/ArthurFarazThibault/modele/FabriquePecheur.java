package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Archer;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Harponneur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Lanceur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Tremailleur;
import javafx.beans.property.SimpleListProperty;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement ;

public class FabriquePecheur {

    public static void fabriquerPecheur(double x, double y, int typePecheur) {

        Environnement environnement = Environnement.getInstance();

        int newX = (int)(x / Case.tailleCase) * Case.tailleCase + Case.tailleCase/2;
        int newY = (int)(y / Case.tailleCase) * Case.tailleCase + Case.tailleCase/2;
        Pecheur pecheur = null;

        switch (typePecheur) {
            case 1:
                pecheur = new Harponneur(newX , newY);
                break;

            case 2:
                pecheur = new Lanceur(newX, newY);
                break;

            case 3:
                pecheur = new Archer(newX, newY);
                break;

            case 4:
                pecheur = new Tremailleur(newX, newY);
        }
        environnement.ajouterPecheur(pecheur);

    }

}
