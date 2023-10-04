package fr.iut.montreuil.ArthurFarazThibault.vue;

import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class vueTerrain {

    private Pane vueMap;
    private Environnement terrain;
    private int tailleCase;

    private Image water = new Image((getClass().getResource( "/water.png").toExternalForm()));
    private Image grass = new Image((getClass().getResource( "/grass.png").toExternalForm()));
    private Image bush = new Image((getClass().getResource( "/bush.png").toExternalForm()));
    private Image rock = new Image((getClass().getResource( "/rock.png").toExternalForm()));

    public vueTerrain(Environnement terrain, Pane vueMap, int tailleCase) {
        this.vueMap = vueMap;
        this.terrain = terrain;
        this.tailleCase = tailleCase;
        affichageMap();
    }

    private void affichageMap () {

        for (int i = 0; i < this.terrain.getNbLignes(); i++) {
            for (int j = 0; j < this.terrain.getNbColonnes(); j++) {
                ImageView imV = new ImageView();

                if (this.terrain.getPoidsCase(i, j) == 0 || this.terrain.getPoidsCase(i, j) == 9)
                    imV.setImage(water);
                else if (this.terrain.getPoidsCase(i, j) == 1)
                    imV.setImage(grass);
                else if (this.terrain.getPoidsCase(i, j) == 2)
                    imV.setImage(bush);
                else
                    imV.setImage(rock);

                vueMap.getChildren().add(imV);
                imV.setY(i * tailleCase);
                imV.setX(j * tailleCase);
//              imV.setOnMouseDragOver();

                imV.setOnMouseEntered(e ->  imV.setOpacity(0.75));
                imV.setOnMouseExited(e ->  imV.setOpacity(1));

            }
        }
    }


}
