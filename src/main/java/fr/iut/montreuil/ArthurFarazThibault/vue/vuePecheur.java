package fr.iut.montreuil.ArthurFarazThibault.vue;

import fr.iut.montreuil.ArthurFarazThibault.modele.Case;
import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Archer;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Harponneur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Lanceur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Tremailleur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class vuePecheur {

    private static Image harponneur = new Image((vuePoisson.class.getResource( "/harponneur.png").toExternalForm()));
    private static Image archer = new Image((vuePoisson.class.getResource( "/archer.png").toExternalForm()));
    private static Image lanceur = new Image((vuePoisson.class.getResource( "/lanceur.png").toExternalForm()));
    private static Image tremailleur = new Image((vuePoisson.class.getResource( "/tremailleur.png").toExternalForm()));
    private static Image punkAChien = new Image((vuePoisson.class.getResource( "/punkAChien.png").toExternalForm()));


    public static void creerSprite(Pane vueMap, Pecheur p){
        ImageView imV = new ImageView();

        if (p instanceof Harponneur)
            imV.setImage(harponneur);
        else if (p instanceof Archer)
            imV.setImage(archer);
        else if (p instanceof Lanceur)
            imV.setImage(lanceur);
        else if (p instanceof Tremailleur)
            imV.setImage(tremailleur);
        else
            imV.setImage(punkAChien);

        imV.setY(p.getYpropertyValue() - Case.tailleCase/2);
        imV.setX(p.getXpropertyValue() - Case.tailleCase/2);

        vueMap.getChildren().add(imV);
    }

}
