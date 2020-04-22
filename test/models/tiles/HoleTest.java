package models.tiles;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HoleTest {
    private Hole hole;
    private Hole hole1;
    private Hole hole2;

    @BeforeEach
    public void setUp() {
        hole = new Hole();
        hole1 = new Hole(17);
        hole2 = new Hole(24);
    }

    @Test
    @Order(0)
    public void can_initialize_with_no_arguments() {
        assertNotNull(hole, "Hole did not initialize at all!");
        assertEquals(1, hole.getID(), "ID did not initialize correctly!");
        assertFalse(hole.isDiscovered(), "Already revealed on initialization!");
    }

    @Test
    @Order(1)
    public void can_initialize_with_ID() {
        assertNotNull(hole1, "First hole did not initialize at all!");
        assertNotNull(hole2, "Second hole did not initialize at all!");
        assertEquals(17, hole1.getID(), "First hole has a wrong ID!");
        assertEquals(24, hole2.getID(), "Second hole has a wrong ID!");
        assertFalse(hole1.isDiscovered(), "First hole is already revealed on initialization!");
        assertFalse(hole2.isDiscovered(), "Second hole is already revealed on initialization!");
    }


    @Test
    @Order(2)
    public void reveal_causes_isDiscovered_to_be_true() {
        hole.reveal();
        assertTrue(hole.isDiscovered(), "Revealing did not cause the hole to be discovered!");
    }
}