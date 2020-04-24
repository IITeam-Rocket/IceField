package models.items;

import models.figures.Character;
import models.policies.FragileShovelPolicy;

// TODO: 2020. 04. 24. javadoc
public class FragileShovel extends Item {
    /**
     * Changes the strategy of the finder to clear an
     * ice patch.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        finder.changeClearSnowPolicy(new FragileShovelPolicy());
    }
}
