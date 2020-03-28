package models.characters;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharactesTest {
    Character eskimo;
    Character researcher;
    @BeforeAll
    void Inicialization(){
        eskimo = new Eskimo();
        researcher = new Researcher();
    }

    @Test
    void EskimoDefaultBodyHeatTest() {
        assertEquals(5, eskimo.bodyHeat, "Wong do not hot");
    }

    @Test
    void EskimoBodyHeatGetterTest() {
        assertEquals(eskimo.bodyHeat, eskimo.getBodyHeat(), "Wong never how");
    }


}
