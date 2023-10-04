package fr.iut.montreuil.ArthurFarazThibault.controlleur;

import fr.iut.montreuil.ArthurFarazThibault.modele.Poisson;
import fr.iut.montreuil.ArthurFarazThibault.vue.vuePecheur;
import fr.iut.montreuil.ArthurFarazThibault.vue.vuePoisson;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;


public class ObservateurListePoissons implements ListChangeListener<Poisson> {

    private Pane vueMap;

    public ObservateurListePoissons(Pane vueMap) {
        super();
        this.vueMap = vueMap;
    }

    private void enleverSprite (Poisson mort) {
        this.vueMap.getChildren().remove(this.vueMap.lookup("#"+mort.getId()));
    }

    @Override
    public void onChanged(javafx.collections.ListChangeListener.Change<? extends Poisson> p) {
        while(p.next()){

            for (Poisson nouveau: p.getAddedSubList()){
                vuePoisson v = new vuePoisson(vueMap, nouveau);
            }

            for (Poisson mort: p.getRemoved()){
                enleverSprite (mort);
            }
        }
    }

}
