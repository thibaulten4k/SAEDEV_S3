package fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs;

import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import fr.iut.montreuil.ArthurFarazThibault.modele.projectiles.Fleche;

public class Archer extends Pecheur {

    public Archer(int x, int y, Environnement terrain) {
        super(x, y, terrain, 30, 3, 150);
    }

    @Override
    public void attaquer(Poisson p) {
        Projectile proj = new Fleche(this.getXpropertyValue(), this.getYpropertyValue(), environnement, p);
        environnement.getListeProjectiles().add(proj);
    }

}
