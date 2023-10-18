package fr.iut.montreuil.ArthurFarazThibault.modele.deplacements;

import fr.iut.montreuil.ArthurFarazThibault.modele.ActeurMobile;
import fr.iut.montreuil.ArthurFarazThibault.modele.ComportementDeplacement;
import fr.iut.montreuil.ArthurFarazThibault.modele.Case;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;

public class SuivreParcours extends ComportementDeplacement {

    private int indiceParcours, compteur;
    private ActeurMobile acteur;

    public SuivreParcours(ActeurMobile acteur) {
        this.acteur = acteur;
        indiceParcours = 0;
        this.compteur = 0;

    }

    public void setIndiceParcours(int indiceParcours) {
        this.indiceParcours = indiceParcours;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }

    @Override
    public boolean estSortieDuTerrain() {
        return this.indiceParcours == Environnement.getInstance().getParcours().size()-1;

    }

    public boolean aDepasseCaseCible(){
        return this.compteur >= Case.tailleCase;
    }

    public void replaceActeur(){
        this.indiceParcours++;
        this.compteur = 0;
        acteur.setXpropertyValue((Case.tailleCase/2) + Case.tailleCase * Environnement.getInstance().getParcours().get(this.indiceParcours).getX());
        acteur.setYpropertyValue((Case.tailleCase/2) + Case.tailleCase * Environnement.getInstance().getParcours().get(this.indiceParcours).getY());

    }

    public void seDeplace() {
        Case caseActuel = Environnement.getInstance().getParcours().get(this.indiceParcours);
        Case caseSuivante = Environnement.getInstance().getParcours().get(this.indiceParcours + 1);

        if (caseActuel.getX() < caseSuivante.getX()) {
            acteur.setXpropertyValue(acteur.getXpropertyValue() + acteur.getVitesse());
        }
        if (caseActuel.getX() > caseSuivante.getX()) {
            acteur.setXpropertyValue(acteur.getXpropertyValue() - acteur.getVitesse());
        }
        if (caseActuel.getY() < caseSuivante.getY()) {
            acteur.setYpropertyValue(acteur.getYpropertyValue() + acteur.getVitesse());
        }
        if (caseActuel.getY() > caseSuivante.getY()) {
            acteur.setYpropertyValue(acteur.getYpropertyValue() - acteur.getVitesse());
        }
        this.compteur  = this.compteur + acteur.getVitesse();

        if (this.aDepasseCaseCible())
            this.replaceActeur();

    }

}
