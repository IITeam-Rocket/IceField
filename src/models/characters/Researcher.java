package models.characters;

import models.tiles.Tile;

import static controllers.TabController.*;

/**
 * A character with the ability to analyze
 * the surrounding tiles' capacity to hold
 * players.
 */
public class Researcher extends Character {

    public Researcher() {
        super(4, 4, 1);
    }

    public Researcher(Tile starting) {
        super(4, 4, 1);
        this.tile = starting;
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
        addIndent();
        printlnWithIndents("Researcher.useSpecial(target)");

        target.getCapacity();

        printlnWithIndents("return");
        removeIndent();
    }
}
