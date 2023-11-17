package fr.iut.montreuil.ArthurFarazThibault.modele;

public abstract class Projectile extends ActeurMobile {

    protected int dureeDeVie;
    protected int degatColison;
    protected Poisson cible;
    protected Effet effet;

    protected static long compteurProjectile = 0;

    public Projectile(int x, int y, int taille, int vitesse, int degat, int dureeDeVie, int degatColision, Poisson cible, Effet effet) {
        super(x, y, taille, vitesse, degat);

        this.dureeDeVie = dureeDeVie;
        this.degatColison = degatColision;
        this.cible = cible;

        this.effet = effet;
    }

    public int getDureeDeVie() { return dureeDeVie; }
    public void setDureeDeVie(int dureeDeVie) { this.dureeDeVie = dureeDeVie; }

    public void soustraireDureeDeVie(int mallus) {
        dureeDeVie += mallus;

        if(dureeDeVie < 0)
            dureeDeVie = 0;

    }

    public boolean acteurToucher(Acteur acteur) {
        return ( ( Math.abs(acteur.getXpropertyValue() - this.getXpropertyValue()) + Math.abs(acteur.getYpropertyValue() - this.getYpropertyValue()) )
                < (this.taille.getValue()) + acteur.getTaillePropertyValue() );
    }

    @Override
    public String genererId() {
        compteurProjectile++;
        return "Proj: " + compteurProjectile;
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
            if (acteurToucher(p)) {
                p.subirDegat(this.getDegat());
                if(effet != null)
                    effet.appliquerEffet(p);
                this.soustraireDureeDeVie(-degatColison);
            }
        }

    }

    public String toString() { return "Projectile : " + this.id; }

}
