package models.tiles;

import models.policies.FrostBitePolicy;
import models.characters.Character;
import models.items.Item;

/**
 * A Tile frozen with ice on which characters
 * can stand on.
 */
abstract public class IcePatch extends Tile {

    /**
     * Returns the item hidden in the IcePatch.
     *
     * @param player the player who picked the item up
     * @return the buried item
     */
    public Item unBuryItem(Character player) {
        return null;
    }

    /**
     * Realises the storm's effects.
     */
    @Override
    public void reactToStorm() {

    }

    /**
     * Changes the strategy of the Tile for a storm.
     *
     * @param strategy the new strategy
     */
    public void changeFrostBitePolicy(FrostBitePolicy strategy) {
    }

}
