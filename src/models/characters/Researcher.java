package models.characters;

import models.tiles.IcePatch;
import models.tiles.Tile;

/**
 * A character with the ability to analyze
 * the surrounding tiles' capacity to hold
 * players.
 */
public class Researcher extends Character {
    public Researcher(int stamina) {
        super(4, stamina);
    }

    /**
     * Analyzes the target tile, and finds its
     * capacity.
     *
     * @param target the Tile on which the ability
     *               is performed.
     */
    @Override
    public void useSpecial(Tile target) {
        target.getCapacity();
    }
}
