package fr.iut.montreuil.ArthurFarazThibault.modele;

import fr.iut.montreuil.ArthurFarazThibault.modele.deplacements.LigneDroite;

public abstract class Projectile extends ActeurMobile {

    private int taille;
    private int dureeDeVie;
    private int degatColison;
    protected Poisson cible;
    private Effet effet;

    public Projectile(int x, int y, int vitesse, int degat, int taille, int dureeDeVie, int degatColision, Poisson cible, Effet effet) {
        super(x, y, vitesse, degat);

        this.taille = taille;
        this.dureeDeVie = dureeDeVie;
        this.degatColison = degatColision;
        this.cible = cible;

        this.effet = effet;
    }

    public int getDureeDeVie() { return dureeDeVie; }
    public void soustraireDureeDeVie(int mallus) {
        dureeDeVie += mallus;

        if(dureeDeVie < 0)
            dureeDeVie = 0;

    }

    public boolean poissonToucher(Poisson p) {
        return ( ( Math.abs(p.getXpropertyValue() - this.getXpropertyValue()) + Math.abs(p.getYpropertyValue() - this.getYpropertyValue()) ) <= this.taille);
    }

    @Override
    public void actionUnTour() {
        comportement.seDeplace();
        attaquer();
        if(comportement.estSortieDuTerrain())
            this.dureeDeVie = 0;

        this.soustraireDureeDeVie(-1);
    }

    public void attaquer() {
        for (Poisson p : Environnement.getInstance().getListePoissons()) {
            if (poissonToucher(p)) {
                p.subirDegat(this.getDegat());
                if(effet != null)
                    effet.appliquerEffet(p);
                this.soustraireDureeDeVie(-degatColison);
            }
        }
    }

    public String toString() { return "Projectile : " + this.id; }

}
