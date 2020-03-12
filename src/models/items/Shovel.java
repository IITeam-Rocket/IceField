package models.items;

import models.characters.Character;
import models.items.Item;

/**
 * An Item that gives the finding character
 * strength up to a unit of 2.
 */
public class Shovel extends Item {
    /**
     * Sets the finder player's strength to 2, if it's lower.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        finder.setStrength(2);
    }
}
