package models.items;

import models.figures.Character;
import models.policies.HasRopePolicy;

import java.io.Serializable;

/**
 * An Item that changes the finding player's
 * RescueFriendPolicy.
 *
 * @author Józsa György
 * @version 2.0
 * @since skeleton
 * @since 2020.03.10
 */
public class Rope extends Item implements Serializable {
    /**
     * Changes the finder's RescueFriendPolicy to
     * an instance of HasRopePolicy.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        System.out.println("unburied item: 2");
        finder.changeRescuePolicy(new HasRopePolicy());
    }
}
