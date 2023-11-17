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


    private static Image harponneur = new Image((vuePecheur.class.getResource( "/harponneur.png").toExternalForm()));
    private static Image archer = new Image((vuePecheur.class.getResource( "/archer.png").toExternalForm()));
    private static Image lanceur = new Image((vuePecheur.class.getResource( "/lanceur.png").toExternalForm()));
    private static Image tremailleur = new Image((vuePecheur.class.getResource( "/tremailleur.png").toExternalForm()));
    private static Image punkAChien = new Image((vuePecheur.class.getResource( "/punkAChien.png").toExternalForm()));

    public static void creerSprite(Pane vueMap, Pecheur pecheur) {
        ImageView imV = new ImageView();

        if (pecheur instanceof Harponneur)
            imV.setImage(harponneur);
        else if (pecheur instanceof Archer)
            imV.setImage(archer);
        else if (pecheur instanceof Lanceur)
            imV.setImage(lanceur);
        else if (pecheur instanceof Tremailleur)
            imV.setImage(tremailleur);
        else
            imV.setImage(punkAChien);

        imV.setY(pecheur.getYpropertyValue() - Case.tailleCase/2);
        imV.setX(pecheur.getXpropertyValue() - Case.tailleCase/2);

        vueMap.getChildren().add(imV);
    }

}
