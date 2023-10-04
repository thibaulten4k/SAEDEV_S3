package fr.iut.montreuil.ArthurFarazThibault;

import fr.iut.montreuil.ArthurFarazThibault.modele.Environnement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnvironnementTest {

    @Test
    public void testAddition() {
        Environnement e = new Environnement(10,10) ;

        Assertions.assertEquals(2, e.testAddition());


    }
}