package fr.iut.montreuil.ArthurFarazThibault.modele;

public class Poisson extends Acteur{

    private int vitesse;
    private int pv;
    private int recompense;
    private int degat;

    private int indiceParcours;
    private int compteur;

    // Ici c'est 12 car le cercle est construit en partant du millieu
    public Poisson(int x, int y, Environnement terrain, int vitesse, int pv, int recompense, int degat) {
        super(terrain.getParcours().get(0).getX() * Case.tailleCase + Case.tailleCase/2,
              terrain.getParcours().get(0).getY() * Case.tailleCase + Case.tailleCase/2,
                terrain);

        this.vitesse = vitesse;
        this.pv = pv;
        this.indiceParcours = 0;
        this.compteur = 0;
        this.recompense = recompense ;
        this.degat = degat;
    }

    public int getPv() { return this.pv; }

    public void setIndiceParcours(int indice) { indiceParcours = indice; }

    public int getRecompense() { return recompense ; }
    public void setRecompense(int nouvelleRecompense) { recompense = nouvelleRecompense; }

    public void setPv(int pv) { this.pv = pv; }
    public void subirDegat(int degat) {
        this.pv += -degat;
    }

    public void setVitesse(int vitesse){this.vitesse=vitesse;}
    public void setCompteur(int compteur) { this.compteur = compteur; }


    public void actionUnTour() {
        if (this.estSortiDuTerrain()) {
            this.meurt();
        } else {
            this.seDeplace();
        }
        if (this.aDepasseCaseCible()) {
            this.replacePoisson();
        }
    }

    public void replacePoisson(){
        indiceParcours++;
        compteur = 0;
        setXpropertyValue((Case.tailleCase/2) + Case.tailleCase * environnement.getParcours().get(indiceParcours).getX());
        setYpropertyValue((Case.tailleCase/2) + Case.tailleCase * environnement.getParcours().get(indiceParcours).getY());
    }

    public boolean aDepasseCaseCible(){
        return compteur >= Case.tailleCase;
    }

    public boolean estSortiDuTerrain(){
        return indiceParcours >= environnement.getParcours().size() -1;
    }

    public void meurt(){
        environnement.setPvPropertyValue(environnement.getPvPropertyValue() - 5);
        this.setPv(0);
        this.setRecompense(0);
        environnement.subirDegat(degat);
    }


    public void seDeplace(){

        Case caseActuel = environnement.getParcours().get(indiceParcours);
        Case caseSuivante = environnement.getParcours().get(indiceParcours + 1);

        if (caseActuel.getX() < caseSuivante.getX()) {
            setXpropertyValue(getXpropertyValue() + vitesse);
        }
        if (caseActuel.getX() > caseSuivante.getX()) {
            setXpropertyValue(getXpropertyValue() - vitesse);
        }
        if (caseActuel.getY() < caseSuivante.getY()) {
            setYpropertyValue(getYpropertyValue() + vitesse);
        }
        if (caseActuel.getY() > caseSuivante.getY()) {
            setYpropertyValue(getYpropertyValue() - vitesse);
        }
        compteur  = compteur + vitesse;
    }

    public int getVitesse() {
        return vitesse;
    }

    public String toString() { return "Poisson : " + this.id; }

}
