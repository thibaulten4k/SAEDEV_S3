package fr.iut.montreuil.ArthurFarazThibault.modele.deplacements;

import fr.iut.montreuil.ArthurFarazThibault.modele.*;

public class TeteChercheuse extends ComportementDeplacement{

    private double coefX, coefY, magnitude;
    private int distance, indice;
    private ActeurMobile acteur;
    private Poisson cible;

    public TeteChercheuse(ActeurMobile acteur, Poisson cible) {
        this.acteur = acteur;
        this.cible = cible;
        coefY = calculerCoefY(cible);
        coefX = calculerCoefX(cible);
        magnitude = calculerMagnitude(coefX, coefY);
        distance = calculerDistance(acteur, cible);
        indice = 0;
    }

    public double calculerCoefY(Poisson p) {
        return p.getYpropertyValue() - acteur.getYpropertyValue();
    }
    public double calculerCoefX(Poisson p) {return p.getXpropertyValue() - acteur.getXpropertyValue();}
    public double calculerMagnitude(double coefX, double coefY) { return Math.sqrt(Math.pow(coefX, 2) + Math.pow(coefY, 2)); }
    public int calculerDistance(Acteur acteur, Poisson poisson) { return poisson.getXpropertyValue() - acteur.getXpropertyValue() + poisson.getYpropertyValue() - acteur.getYpropertyValue(); }

    public void reactualisePositionCible() {
        coefY = calculerCoefY(cible);
        coefX = calculerCoefX(cible);
        magnitude = calculerMagnitude(coefX, coefY);
    }

    @Override
    public boolean estSortieDuTerrain() {
        return acteur.getXpropertyValue() > Environnement.getInstance().getNbColonnes() * Case.tailleCase || acteur.getXpropertyValue() < 0 || acteur.getYpropertyValue() > Environnement.getInstance().getNbLignes() * Case.tailleCase || acteur.getYpropertyValue() < 0;
    }

    @Override
    public void seDeplace() {
        acteur.setXpropertyValue((int)(acteur.getXpropertyValue() + coefX/magnitude * acteur.getVitesse()));
        acteur.setYpropertyValue((int)(acteur.getYpropertyValue() + coefY/magnitude * acteur.getVitesse()));
        indice += acteur.getVitesse();

        if(indice > (distance/2) && cible.getPv() > 0) {
            distance = distance/2;
            indice = 0;
            this.reactualisePositionCible();
        }

    }

}
