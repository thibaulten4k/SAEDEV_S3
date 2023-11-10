package fr.iut.montreuil.ArthurFarazThibault.controlleur;

import fr.iut.montreuil.ArthurFarazThibault.modele.Obstacle;
import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.vue.vueObstacle;
import fr.iut.montreuil.ArthurFarazThibault.vue.vuePecheur;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class ObservateurListeObstacles implements ListChangeListener<Obstacle> {

    private Pane vueMap;

    public ObservateurListeObstacles(Pane vueMap) {
        super();
        this.vueMap = vueMap;
    }

    private void enleverSprite (Obstacle detruit) {
        this.vueMap.getChildren().remove(this.vueMap.lookup("#"+detruit.getId()));
    }

    @Override
    public void onChanged(javafx.collections.ListChangeListener.Change<? extends Obstacle> o) {
        while(o.next()){

            for (Obstacle nouveau: o.getAddedSubList()){
                vueObstacle v = new vueObstacle(vueMap, nouveau);
            }

            for (Obstacle mort: o.getRemoved()){
                enleverSprite (mort);
            }
        }

    }

}
