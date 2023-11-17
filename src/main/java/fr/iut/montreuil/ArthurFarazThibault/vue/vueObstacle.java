package fr.iut.montreuil.ArthurFarazThibault.vue;

import fr.iut.montreuil.ArthurFarazThibault.modele.Case;
import fr.iut.montreuil.ArthurFarazThibault.modele.Obstacle;
import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.modele.obstacles.Rocher;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Archer;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Harponneur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Lanceur;
import fr.iut.montreuil.ArthurFarazThibault.modele.pecheurs.Tremailleur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class vueObstacle {

    private Pane vueMap;
    private Obstacle obstacle;

    private Image rocher = new Image((getClass().getResource( "/rock.png").toExternalForm()));
    private Image buisson = new Image((getClass().getResource( "/bush.png").toExternalForm()));

    public vueObstacle(Pane vueMap, Obstacle obstacle) {
        this.vueMap = vueMap;
        this.obstacle = obstacle;
        ImageView imV = new ImageView();

        if (obstacle instanceof Rocher)
            imV.setImage(rocher);
        else
            imV.setImage(buisson);

        imV.setY(obstacle.getYpropertyValue() - Case.tailleCase/2);
        imV.setX(obstacle.getXpropertyValue() - Case.tailleCase/2);

        imV.setId(obstacle.getId());

        vueMap.getChildren().add(imV);
    }

}
