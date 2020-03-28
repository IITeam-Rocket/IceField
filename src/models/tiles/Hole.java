package models.tiles;

import models.characters.Character;

import static controllers.TabController.*;

/**
 * A tile with no solid platform.
 */
public class Hole extends Tile {
    /**
     * If the Hole has not been revealed, the
     * accepts the player, otherwise it doesn't.
     *
     * @param character the player to accept
     * @return true if successful, false otherwise
     */
    @Override
    public boolean acceptCharacter(Character character) {
        addIndent();
        printlnWithIndents("Hole.acceptCharacter()");
        printlnWithIndents("return: false");
        removeIndent();
        return false;
    }

    /**
     * Realises the storm's effects.
     */
    @Override
    public void reactToStorm() {
        addIndent();
        printlnWithIndents("Hole.reactToStorm()");

        addSnow(1);

        printlnWithIndents("return");
        removeIndent();

    }

    /**
     * Returns the maximum number of characters the
     * Tile can hold at one time, which is zero.
     *
     * @return 0
     */
    @Override
    public int getCapacity() {
        addIndent();
        printlnWithIndents("Hole.getCapacity()");
        printlnWithIndents("return: 0");
        removeIndent();

        return 0;
    }
}
