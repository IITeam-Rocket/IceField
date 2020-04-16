package models.items;

import models.figures.Character;

/**
 * A class representing a hidden item in the IcePatch.
 * Upon digging it out, it gives the discoverer a bonus.
 *
 * @author Józsa György
 * @version 2.0
 * @since skeleton
 * @since 2020.03.10
 */
public abstract class Item {
    /**
     * upon discovery, has some effect on the game.
     *
     * @param finder the character who discovered the item
     */
    abstract public void uponDiscovery(Character finder);
}
