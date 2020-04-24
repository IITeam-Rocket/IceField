package models.tiles;

import models.figures.Character;
import models.items.Item;
import models.policies.NoProtectionPolicy;
import models.policies.ProtectionPolicy;

/**
 * A Tile frozen with ice on which characters
 * can stand on.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.tiles.Tile
 * @since skeleton
 * @since 2020.03.10
 */
abstract public class IcePatch extends Tile {

    private Item buriedItem;
    private ProtectionPolicy protectionStrategy = new NoProtectionPolicy();

    public IcePatch() {
        super();
    }

    public IcePatch(int ID) {
        super(ID);
    }

    /**
     * Returns the item hidden in the IcePatch.
     *
     * @param player the player who picked the item up
     *
     * @return the buried item
     */
    public Item unBuryItem(Character player) {
        //TODO
        return buriedItem;
    }

    /**
     * Realises the storm's effects.
     */
    @Override
    public void reactToStorm() {
        //TODO
    }

    /**
     * Changes the strategy of the Tile for a storm.
     *
     * @param strategy the new strategy
     */
    public void changeFrostBitePolicy(ProtectionPolicy strategy) {
        ///TODO
    }

    /**
     * Buries an item in the Tile
     *
     * @param item the item to bury
     *
     * @return true if the item was stored,
     * false otherwise
     */
    @Override
    public boolean storeItem(Item item) {
        if (buriedItem != null)
            return false;
        buriedItem = item;
        return true;
    }

    public Item getBuriedItem() {
        return buriedItem;
    }

    public void setBuriedItem(Item buriedItem) {
        this.buriedItem = buriedItem;
    }

    public void setProtectionStrategy(ProtectionPolicy protectionStrategy) {
        this.protectionStrategy = protectionStrategy;
    }
}
