package fr.iut.montreuil.ArthurFarazThibault.modele;

<<<<<<< HEAD
public abstract class ForgePoisson {
=======
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Archer;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Harponneur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Lanceur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Tremailleur;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Alose;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Esturgeon;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Lamproie;
import fr.iut.montreuil.ArthurFarazThibault.modele.poissons.Saumon;

public class ForgePoisson {
>>>>>>> f7b501e40788cfeb904626a43bcf5da56c303996
    private int newX;
    private int newY;

    public ForgePoisson() {
        newX = Environnement.getInstance().getParcours().get(0).getX() * Case.tailleCase + Case.tailleCase / 2;
        newY = Environnement.getInstance().getParcours().get(0).getY() * Case.tailleCase + Case.tailleCase / 2;
    }

<<<<<<< HEAD
    public abstract Poisson creerPoissons(int x, int y);

    public void forgerPoisson() {
        Poisson p = creerPoissons(newX, newY);
        Environnement.getInstance().ajouterAListePoisson(p);
=======
    public Poisson forgerPoisson(String typePoisson) {
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
>>>>>>> f7b501e40788cfeb904626a43bcf5da56c303996

    }

}