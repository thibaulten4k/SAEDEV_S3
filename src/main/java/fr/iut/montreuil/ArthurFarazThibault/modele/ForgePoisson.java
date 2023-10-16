package fr.iut.montreuil.ArthurFarazThibault.modele;

public abstract class ForgePoisson {
    private int newX;
    private int newY;

    public ForgePoisson() {
        newX = Environnement.getInstance().getParcours().get(0).getX() * Case.tailleCase + Case.tailleCase / 2;
        newY = Environnement.getInstance().getParcours().get(0).getY() * Case.tailleCase + Case.tailleCase / 2;
    }

    public abstract Poisson creerPoissons(int x, int y);

    public void forgerPoisson() {
        Poisson p = creerPoissons(newX, newY);
        Environnement.getInstance().ajouterAListePoisson(p);

    }

}