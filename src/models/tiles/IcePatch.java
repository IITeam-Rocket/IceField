package models.tiles;

import models.characters.Character;
import models.exceptions.EndOfGameException;
import models.items.Item;
import models.policies.FrostBitePolicy;
import models.policies.NoProtectionPolicy;

import static controllers.TabController.*;

/**
 * A Tile frozen with ice on which characters
 * can stand on.
 */
abstract public class IcePatch extends Tile {

    private Item buriedItem;
    private FrostBitePolicy frostBiteStrategy = new NoProtectionPolicy();

    /**
     * Returns the item hidden in the IcePatch.
     *
     * @param player the player who picked the item up
     * @return the buried item
     */
    public Item unBuryItem(Character player) {
        addIndent();
        printlnWithIndents("IcePatch.unBuryItem(player)");

        if(snowDepth > 0){
            printlnWithIndents("return: null");
            removeIndent();
            return null;
        }
        printlnWithIndents("return: item");
        removeIndent();
        return buriedItem;
    }

    /**
     * Realises the storm's effects.
     */
    @Override
    public void reactToStorm() {
        addIndent();
        printlnWithIndents("IcePatch.ReactToStorm()");

        addSnow(1);
        for (Character victim : characters) {
            try {
                frostBiteStrategy.executeStrategy(victim);
            } catch (EndOfGameException e) {
                e.printStackTrace();
            }
        }

        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Changes the strategy of the Tile for a storm.
     *
     * @param strategy the new strategy
     */
    public void changeFrostBitePolicy(FrostBitePolicy strategy) {
        ///TODO
    }

    public Item getBuriedItem() {
        return buriedItem;
    }

    public void setBuriedItem(Item buriedItem) {
        this.buriedItem = buriedItem;
    }

    public void setFrostBiteStrategy(FrostBitePolicy frostBiteStrategy) {
        this.frostBiteStrategy = frostBiteStrategy;
    }
}
