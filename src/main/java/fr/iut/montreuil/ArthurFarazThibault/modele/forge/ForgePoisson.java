package fr.iut.montreuil.ArthurFarazThibault.modele.forge;

import fr.iut.montreuil.ArthurFarazThibault.modele.Case;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Alose;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Esturgeon;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Lamproie;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Saumon;

public class ForgePoisson {
    private int newX;
    private int newY;

    public ForgePoisson() {
        newX = Environnement.getInstance().getParcours().get(0).getX() * Case.tailleCase + Case.tailleCase / 2;
        newY = Environnement.getInstance().getParcours().get(0).getY() * Case.tailleCase + Case.tailleCase / 2;
    }

    public Poisson fabriquerPoisson(String typePoisson) {
        Poisson p = new Alose(newX,newY);

        switch (typePoisson) {
            case "Alose":
                p = new Alose(newX , newY);
                break;

            case "Esturgeon":
                p = new Esturgeon(newX, newY);
                break;

            case "Saumon":
                p = new Saumon(newX, newY);
                break;

            case "Lamproie":
                p = new Lamproie(newX, newY);
                break;
        }
        Environnement.getInstance().ajouterAListePoissons(p);
        return p;

    }

}