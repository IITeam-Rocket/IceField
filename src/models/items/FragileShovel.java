package models.items;

import models.figures.Character;
import models.policies.FragileShovelPolicy;

import java.io.Serializable;

/**
 * A class representing a fragile shovel
 * that can be used to clear 2 units of
 * snow from a tile. It however will break
 * upon its third use.
 *
 * @author Józsa György
 * @version 3.0
 * @see models.items.Item
 * @since prototype
 * @since 2020.04.24
 */
public class FragileShovel extends Item implements Serializable {
    /**
     * Changes the strategy of the finder to clear an
     * ice patch.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        System.out.println("unburied item: 3");
        finder.changeClearSnowPolicy(new FragileShovelPolicy());
    }
}
