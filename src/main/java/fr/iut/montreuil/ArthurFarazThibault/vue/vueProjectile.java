package fr.iut.montreuil.ArthurFarazThibault.vue;

import fr.iut.montreuil.ArthurFarazThibault.modele.projectiles.Filet;
import fr.iut.montreuil.ArthurFarazThibault.modele.projectiles.Fleche;
import fr.iut.montreuil.ArthurFarazThibault.modele.projectiles.Harpon;
import fr.iut.montreuil.ArthurFarazThibault.modele.Projectile;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class vueProjectile {

    public static void creerSprite (Projectile projectile, Pane vueMap) {

        Shape forme;

        if (projectile instanceof Harpon) {
            forme= new Circle(6);
            forme . setFill (Color.YELLOW);
        }
        else if (projectile instanceof Fleche) {
            forme= new Circle(4);
            forme . setFill (Color.BROWN);
        }
        else if (projectile instanceof Filet){
            forme= new Circle(8);
            forme . setFill (Color.GRAY);
        } else {
            forme = new Rectangle(12, 12);
            forme . setFill(Color.ROSYBROWN);
        }

        forme.setId(projectile.getId());

        forme.translateXProperty().bind(projectile.getXproperty());
        forme.translateYProperty().bind(projectile.getYproperty());

        vueMap.getChildren().add(forme);
    }
}
