package fr.iut.montreuil.ArthurFarazThibault.modele.deplacements;

import fr.iut.montreuil.ArthurFarazThibault.modele.ActeurMobile;
import fr.iut.montreuil.ArthurFarazThibault.modele.ComportementDeplacement;
import fr.iut.montreuil.ArthurFarazThibault.modele.*;

public class LigneDroite extends ComportementDeplacement {

    private double coefX, coefY, magnitude;
    private ActeurMobile acteur;

    public LigneDroite(ActeurMobile acteur, Poisson cible) {
        this.acteur = acteur;
        coefY = calculerCoefY(cible);
        coefX = calculerCoefX(cible);
        magnitude = calculerMagnitude(coefX, coefY);

    }

    public double calculerCoefY(Poisson p) {
        return p.getYpropertyValue() - acteur.getYpropertyValue();
    }
    public double calculerCoefX(Poisson p) {return p.getXpropertyValue() - acteur.getXpropertyValue();}
    public double calculerMagnitude(double coefX, double coefY) { return Math.sqrt(Math.pow(coefX, 2) + Math.pow(coefY, 2)); }

    @Override
    public boolean estSortieDuTerrain() { return acteur.getXpropertyValue() > Environnement.getInstance().getNbColonnes() * Case.tailleCase || acteur.getXpropertyValue() < 0 || acteur.getYpropertyValue() > Environnement.getInstance().getNbLignes() * Case.tailleCase || acteur.getYpropertyValue() < 0; }

    @Override
    public void seDeplace() {
        acteur.setXpropertyValue((int)(acteur.getXpropertyValue() + coefX/magnitude * acteur.getVitesse()));
        acteur.setYpropertyValue((int)(acteur.getYpropertyValue() + coefY/magnitude * acteur.getVitesse()));

    }
}
