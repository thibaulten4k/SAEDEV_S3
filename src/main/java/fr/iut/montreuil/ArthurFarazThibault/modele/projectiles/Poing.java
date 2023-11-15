package fr.iut.montreuil.ArthurFarazThibault.modele.projectiles;

import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.modele.deplacements.LigneDroite;
import fr.iut.montreuil.ArthurFarazThibault.modele.effet.Ralentissement;
import fr.iut.montreuil.ArthurFarazThibault.modele.effet.RetourDebutParcours;

public class Poing extends Projectile {

    public Poing (int x, int y, Poisson poisson) {
        super(x, y, 10, 0, 20, 1, 1, poisson, new RetourDebutParcours());
        this.setComportement(new LigneDroite(this, poisson));
    }

}
