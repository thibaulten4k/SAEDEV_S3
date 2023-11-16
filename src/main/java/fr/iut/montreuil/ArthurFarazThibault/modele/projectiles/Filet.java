package fr.iut.montreuil.ArthurFarazThibault.modele.projectiles;

import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.modele.deplacements.LigneDroite;
import fr.iut.montreuil.ArthurFarazThibault.modele.effet.Ralentissement;

public class Filet extends Projectile {

    public Filet (int x, int y, Poisson poisson) {
        super(x, y, 12, 5, 2, 45, 15, poisson, new Ralentissement());
        this.setComportement(new LigneDroite(this, poisson));
    }

}
