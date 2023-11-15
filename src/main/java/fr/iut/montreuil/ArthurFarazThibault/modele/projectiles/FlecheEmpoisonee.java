package fr.iut.montreuil.ArthurFarazThibault.modele.projectiles;

import fr.iut.montreuil.ArthurFarazThibault.modele.Effet;
import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import fr.iut.montreuil.ArthurFarazThibault.modele.deplacements.LigneDroite;
import fr.iut.montreuil.ArthurFarazThibault.modele.effet.Affaiblissement;
import fr.iut.montreuil.ArthurFarazThibault.modele.effet.Ralentissement;

public class FlecheEmpoisonee extends Projectile {

    public FlecheEmpoisonee (int x, int y, Poisson poisson) {
        super(x, y, 8, 3, 12, 30, 30, poisson, new Affaiblissement());
        this.setComportement(new LigneDroite(this, poisson));
    }

}
