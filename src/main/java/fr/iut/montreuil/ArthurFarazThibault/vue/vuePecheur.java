package fr.iut.montreuil.ArthurFarazThibault.vue;

import fr.iut.montreuil.ArthurFarazThibault.modele.Case;
import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Archer;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Harponneur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Lanceur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class vuePecheur {

    private Pane vueMap;
    private Pecheur p;

    private Image harponneur = new Image((getClass().getResource( "/harponneur.png").toExternalForm()));
    private Image archer = new Image((getClass().getResource( "/archer.png").toExternalForm()));
    private Image lanceur = new Image((getClass().getResource( "/lanceur.png").toExternalForm()));
    private Image tremailleur = new Image((getClass().getResource( "/tremailleur.png").toExternalForm()));

    public vuePecheur(Pane vueMap, Pecheur p) {
        this.vueMap = vueMap;
        this.p = p;
        ImageView imV = new ImageView();

        if (p instanceof Harponneur)
            imV.setImage(harponneur);
        else if (p instanceof Archer)
            imV.setImage(archer);
        else if (p instanceof Lanceur)
            imV.setImage(lanceur);
        else
            imV.setImage(tremailleur);

        imV.setY(p.getYpropertyValue() - Case.tailleCase/2);
        imV.setX(p.getXpropertyValue() - Case.tailleCase/2);

        vueMap.getChildren().add(imV);
    }

}
