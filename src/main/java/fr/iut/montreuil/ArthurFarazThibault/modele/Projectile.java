package fr.iut.montreuil.ArthurFarazThibault.modele;

public abstract class Projectile extends Acteur {

    private int vitesse;
    private int degat;
    private int taille;
    private int dureeDeVie;
    private Poisson cible;

    private double coefX;
    private double coefY;
    private double magnitude;

    public Projectile(int x, int y, int vitesse, int degat, int taille, int dureeDeVie, Poisson cible) {
        super(x, y);

        this.vitesse = vitesse;
        this.degat = degat;
        this.taille = taille;
        this.dureeDeVie = dureeDeVie;
        this.cible = cible;

        this.coefX = calculerCoefX(cible);
        this.coefY = calculerCoefY(cible);
        this.magnitude = calculerMagnitude(coefX, coefY);
    }

    public int getDureeDeVie() { return dureeDeVie; }
    public int getDegat() { return degat; }

    public void soustraireDureeDeVie(int mallus) { dureeDeVie += - mallus; }

    public double calculerCoefX(Poisson p) {return p.getXpropertyValue() - this.getXpropertyValue();}
    public double calculerCoefY(Poisson p) {
        return p.getYpropertyValue() - this.getYpropertyValue();
    }

    public Poisson getCible() { return cible; }

    public double calculerMagnitude(double coefX, double coefY) {
        return Math.sqrt(Math.pow(coefX, 2) + Math.pow(coefY, 2));
    }

    public boolean poissonToucher(Poisson p) {
        return ( ( Math.abs(p.getXpropertyValue() - this.getXpropertyValue()) + Math.abs(p.getYpropertyValue() - this.getYpropertyValue()) ) <= this.taille);
    }

    @Override
    public void actionUnTour() {

        setXpropertyValue((int)(getXpropertyValue() + coefX/magnitude * vitesse));
        setYpropertyValue((int)(getYpropertyValue() + coefY/magnitude * vitesse));

        if (!dansLeTerrain())
            dureeDeVie = 0;

        attaquer();

    }

    public boolean dansLeTerrain() { return (getXpropertyValue() >= 0 && getXpropertyValue() <= Environnement.getInstance().getNbColonnes() * Case.tailleCase && getYpropertyValue() >= 0 && getYpropertyValue() <= Environnement.getInstance().getNbLignes() * Case.tailleCase); }

    public abstract void attaquer();

}
