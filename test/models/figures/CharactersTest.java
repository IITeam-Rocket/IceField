//package models.figures;
//
//import models.exceptions.EndOfGameException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@Tag("Unit")
//public class CharactersTest {
//    Character eskimo;
//    Character researcher;
//
//    @BeforeEach
//    void Initialization() {
//        eskimo = new Eskimo();
//        researcher = new Researcher();
//    }
//
//    @Test
//    void eskimoDefaultBodyHeatTest() {
//        assertEquals(5, eskimo.getBodyHeat(), "Sup");
//    }
//
//    @Test
//    void EskimoDefaultBodyHeatTest() {
//        assertEquals(5, eskimo.bodyHeat, "Wong do not hot");
//    }
//
//    @Test
//    void eskimoBodyHeatGetterTest() {
//        assertEquals(eskimo.bodyHeat, eskimo.getBodyHeat(), "Wong never how");
//    }
//
//    @Test
//    void researcherDefaultBodyHeat() {
//        assertEquals(4, researcher.getBodyHeat(), "No ketchup");
//    }
//
//    @Test
//    void researcherBodyHeatGetterTest() {
//        assertEquals(researcher.bodyHeat, researcher.getBodyHeat(), "Just sauce");
//    }
//
//    @Test
//    void speedRunTest() {
//        assertThrows(Exception.class, () -> {
//            for (int i = 0; i < 5; i++)
//                eskimo.clearPatch();
//        }, "(saucy)");
//    }
//
//    @Test
//    void healthPotionTest() {
//        assertThrows(EndOfGameException.class, () -> {
//            for (int i = 0; i < 10; i++)
//                researcher.removeHeat(1);
//        }, "Raw sauce");
//    }
//
//    @Test
//    void healthPotionTest2() {
//        assertThrows(EndOfGameException.class, () -> {
//            for (int i = 0; i < 10; i++)
//                eskimo.removeHeat(1);
//        }, "");
//    }
//
//    @Test
//    void whatamievendoingTest() throws EndOfGameException {
//        int bh = eskimo.getBodyHeat();
//
//        eskimo.addHeat(1);
//        assertEquals(bh + 1, eskimo.getBodyHeat(), "sup bitches");
//        eskimo.removeHeat(2);
//
//        assertEquals(bh - 1, eskimo.getBodyHeat(), "Mans not cold");
//    }
//
//    @Test
//    void gettingHeatedTest() {
//        assertThrows(IllegalArgumentException.class, () -> eskimo.removeHeat(-1));
//
//        assertThrows(IllegalArgumentException.class, () -> researcher.addHeat(-1));
//    }
//
//    @Test
//    void EskimoBodyHeatGetterTest() {
//        assertEquals(eskimo.bodyHeat, eskimo.getBodyHeat(), "Wong never how");
//    }
//}
