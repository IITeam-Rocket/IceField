//package models.tiles;
//
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//
//import java.util.Random;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
//@Tag("Unit")
//class TilesTest {
//
//    @Test
//    void holeInitTest() {
//        Tile tile = new Hole();
//
//        assertNotEquals(0, tile.snowDepth, "Chill out dude");
//    }
//
//    @Test
//    void noSpaceTest() {
//        Tile tile = new Hole();
//
//        assertEquals(0, tile.getCapacity(), "There room for everyone!!!4");
//    }
//
//    @Test
//    void holeInOneTest() {
//        Random r = new Random();
//        for (int i = 0; i < 100; i++) {
//            Tile t = new Hole();
//            int cocain = t.getSnowDepth();
//            int s = r.nextInt(10);
//            t.addSnow(s);
//            if (s + cocain > Tile.maxSnowDepth) {
//                s = Tile.maxSnowDepth;
//                assertEquals(s, t.getSnowDepth(), "Snowing heavy right?");
//            } else {
//                assertEquals(cocain + s, t.getSnowDepth(), "Snowing heavy right?");
//            }
//
//        }
//    }
//}
