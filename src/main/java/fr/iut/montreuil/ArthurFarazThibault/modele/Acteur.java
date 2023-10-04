package fr.iut.montreuil.ArthurFarazThibault.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Acteur {

    // Les gens à créditer :
    // Rayan Kheroua
    // Robin Castel

    protected IntegerProperty xProperty, yproperty;
    protected Environnement environnement;

    protected String id;
    protected static long compteur;

    public Acteur (int x, int y, Environnement terrain) {
        this.xProperty = new SimpleIntegerProperty(x);
        this.yproperty = new SimpleIntegerProperty(y);
        this.environnement = terrain;
        this.id = "A" + compteur;
        compteur++;
    }

    public void setXpropertyValue(int x) {
        this.xProperty.setValue(x);
    }
    public void setYpropertyValue(int y) {
        this.yproperty.setValue(y);
    }

    public int getXpropertyValue() { return xProperty.getValue(); }
    public int getYpropertyValue() { return yproperty.getValue(); }

    public IntegerProperty getXproperty() { return xProperty; }
    public IntegerProperty getYproperty() {
        return yproperty;
    }

    public String getId() { return id; }

    public abstract void actionUnTour();

}
