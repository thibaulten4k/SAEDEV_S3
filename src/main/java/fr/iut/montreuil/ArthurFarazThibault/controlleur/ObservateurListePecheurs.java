package fr.iut.montreuil.ArthurFarazThibault.controlleur;




import fr.iut.montreuil.ArthurFarazThibault.modele.Pecheur;
import fr.iut.montreuil.ArthurFarazThibault.vue.vuePecheur;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class ObservateurListePecheurs implements ListChangeListener<Pecheur> {

    private Pane vueMap;

    public ObservateurListePecheurs(Pane vueMap) {
        super();
        this.vueMap = vueMap;
    }

    private void enleverSprite (Pecheur mort) {
        this.vueMap.getChildren().remove(this.vueMap.lookup("#"+mort.getId()));
    }

    @Override
    public void onChanged(javafx.collections.ListChangeListener.Change<? extends Pecheur> p) {
        while(p.next()){

                for (Pecheur nouveau: p.getAddedSubList()){
                    vuePecheur.creerSprite(vueMap, nouveau);
                }

                for (Pecheur mort: p.getRemoved()){
                    enleverSprite (mort);
                }
        }

    }

}
