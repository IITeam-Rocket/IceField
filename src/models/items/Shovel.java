package models.items;

import models.figures.Character;
import models.policies.ShovelPolicy;

/**
 * An Item that gives the finding character
 * the ability to remove 2 units of snow
 * on clearing.
 *
 * @author Józsa György
 * @version 2.0
 * @since skeleton
 * @since 2020.03.10
 */
public class Shovel extends Item {
    /**
     * Sets the finder player's strength to 2, if it's lower.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        finder.changeClearSnowPolicy(new ShovelPolicy());
    }
}
