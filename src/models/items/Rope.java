package models.items;

import models.characters.Character;
import models.items.Item;
import models.policies.HasRopePolicy;

/**
 * An Item that changes the finding player's
 * RescueFriendPolicy.
 */
public class Rope extends Item {
    /**
     * Changes the finder's RescueFriendPolicy to
     * an instance of HasRopePolicy.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        finder.changeRescuePolicy(new HasRopePolicy());
    }
}
