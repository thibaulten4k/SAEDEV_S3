package fr.iut.montreuil.ArthurFarazThibault.modele.bonus;

import fr.iut.montreuil.ArthurFarazThibault.modele.Acteur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Case;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import fr.iut.montreuil.ArthurFarazThibault.modele.Obstacle;

public abstract class BonusTerrain extends Bonus {

    protected Obstacle obstacle;

    public BonusTerrain(double x, double y, int cout) {
        super(x, y, cout);
        this.obstacle = Environnement.getInstance().caseOccupeeObstacle(this.getXpropertyValue(), this.getYpropertyValue());

        if(obstacle != null) {
            Environnement.getInstance().ajouterBonusAEnvironnement(this);
        }
    }

}
