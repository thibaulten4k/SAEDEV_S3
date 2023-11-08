package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Alose;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Esturgeon;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Lamproie;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Saumon;

public class FabriquePoisson {
    private int newX;
    private int newY;

    public FabriquePoisson() {
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
        Environnement.getInstance().ajouterAListePoisson(p);
        return p;

    }

}