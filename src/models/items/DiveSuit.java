package models.items;

import models.figures.Character;
import models.policies.SwimOutPolicy;

import java.io.Serializable;

/**
 * An item that changes the finder's
 * FallInWaterPolicy.
 *
 * @author Józsa György
 * @version 2.0
 * @since skeleton
 * @since 2020.03.10
 */
public class DiveSuit extends Item implements Serializable {
    /**
     * Changes the finder's FallInWaterPolicy to
     * an instance of HasDiveSuitPolicy.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        System.out.println("unburied item: 5");
        finder.changeWaterPolicy(new SwimOutPolicy());
    }
}
