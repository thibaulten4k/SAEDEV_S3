package fr.iut.montreuil.ArthurFarazThibault.modele.projectiles;

import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.modele.deplacements.TeteChercheuse;
import fr.iut.montreuil.ArthurFarazThibault.modele.effet.AucunEffet;

public class Chien extends Projectile {

    public Chien(int x, int y, Poisson poisson) {
        super(x, y, 10, 7, 14, 60, 60, poisson, new AucunEffet());
        this.setComportement(new TeteChercheuse(this, poisson));
    }

}
