package fr.iut.montreuil.ArthurFarazThibault.modele.projectiles;

import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.modele.deplacements.TeteChercheuse;
import fr.iut.montreuil.ArthurFarazThibault.modele.effet.Affaiblissement;

public class Chien extends Projectile {

    public Chien(int x, int y, Poisson poisson) {
        super(x, y, 12, 7, 8, 60, 60, poisson, new Affaiblissement());
        this.setComportement(new TeteChercheuse(this, poisson));
    }

}

