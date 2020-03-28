package models.characters;

import models.tiles.Tile;

import static controllers.TabController.addIndent;
import static controllers.TabController.printlnWithIndents;
import static controllers.TabController.removeIndent;

/**
 * A character with the ability to analyze
 * the surrounding tiles' capacity to hold
 * players.
 */
public class Researcher extends Character {

    public Researcher() {
        super(4, 4, 1);
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

        ///TODO implement useSpecial()

        printlnWithIndents("return");
        removeIndent();
    }
}
