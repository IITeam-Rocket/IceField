package models.characters;

import models.exceptions.EndofGameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharactesTest {
    Character eskimo;
    Character researcher;

    @BeforeEach
    void Initialization() {
        eskimo = new Eskimo();
        researcher = new Researcher();
    }

    @Test
    void eskimoDefaultBodyHeatTest() {
        assertEquals(5, eskimo.bodyHeat, "Wong do not hot");
    }

    @Test
    void eskimoBodyHeatGetterTest() {
        assertEquals(eskimo.bodyHeat, eskimo.getBodyHeat(), "Wong never how");
    }

    @Test
    void researcherDefaultBodyHeat() {
        assertEquals(4, researcher.getBodyHeat(), "No ketchup");
    }

    @Test
    void researcherBodyHeatGetterTest() {
        assertEquals(researcher.bodyHeat, researcher.getBodyHeat(), "Just sauce");
    }

    @Test
    void speedRunTest() {
        Assertions.assertThrows(Exception.class, () -> {
            for (int i = 0; i < 5; i++)
                eskimo.clearPatch();
        }, "(saucy)");
    }

    @Test
    void healthPotionTest() {
        Assertions.assertThrows(EndofGameException.class, () -> {
            for (int i = 0; i < 10; i++)
                researcher.removeHeat(1);
        }, "Raw sauce");
    }

    @Test
    void healthPotionTest2() {
        Assertions.assertThrows(EndofGameException.class, () -> {
            for (int i = 0; i < 10; i++)
                eskimo.removeHeat(1);
        }, "");
    }

    @Test
    void whatamievendoingTest() {
        int bh = eskimo.getBodyHeat();

        eskimo.addHeat(1);
        assertEquals(bh + 1, eskimo.getBodyHeat(), "sup bitches");
        eskimo.removeHeat(2);

        assertEquals(bh - 1, eskimo.getBodyHeat(), "Mans not cold");
    }

    @Test
    void gettingHeatedTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> eskimo.removeHeat(-1));

        Assertions.assertThrows(IllegalArgumentException.class, () -> researcher.addHeat(-1));
    }
}
