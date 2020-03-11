package models.tiles;

import models.characters.Character;

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
        return -1;
    }
}
