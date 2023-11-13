package fr.iut.montreuil.ArthurFarazThibault.modele.projectiles;

import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.modele.deplacements.LigneDroite;

public class Harpon extends Projectile {

    public Harpon (int x, int y, Poisson poisson) {
        super(x, y, 10, 13, 8, 75, 15, poisson, null);
        this.setComportement(new LigneDroite(this, poisson));
    }

}
