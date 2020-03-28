package models.tiles;

import models.characters.Character;

import static controllers.TabController.*;

/**
 * An IcePatch that is stable, meaning
 * it may support an indefinite number of
 * characters.
 */
public class StableIcePatch extends IcePatch {
    /**
     * Accepts the player who tries to move on it.
     *
     * @param character the player to accept
     * @return true
     */
    @Override
    public boolean acceptCharacter(Character character) {
        addIndent();
        printlnWithIndents("StableIcePatch.acceptCharacter()");
        printlnWithIndents("return: true");
        removeIndent();
        return true;
    }

    /**
     * Returns the maximum number of characters the
     * Tile can hold at one time.
     *
     * @return -1
     */
    @Override
    public int getCapacity() {
        addIndent();
        printlnWithIndents("StableIcePatch.getCapacity()");
        printlnWithIndents("return: true");
        removeIndent();
        return -1;
    }
}
