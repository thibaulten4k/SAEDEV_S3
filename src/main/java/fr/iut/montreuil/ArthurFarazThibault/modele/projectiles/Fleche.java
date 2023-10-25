package fr.iut.montreuil.ArthurFarazThibault.modele.projectiles;

import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import fr.iut.montreuil.ArthurFarazThibault.modele.deplacements.LigneDroite;
import fr.iut.montreuil.ArthurFarazThibault.modele.effet.AucunEffet;

public class Fleche extends Projectile {

    public Fleche (int x, int y, Poisson poisson) {
        super(x, y, 16, 7, 12, 60, 60, poisson, new AucunEffet());
        this.setComportement(new LigneDroite(this, poisson));
    }

}
