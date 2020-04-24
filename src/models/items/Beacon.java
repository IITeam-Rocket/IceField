package models.items;

import models.Environment;
import models.figures.Character;

import java.io.Serializable;

/**
 * A beacon that is one part of the SignalFlare
 * needed to win the game
 *
 * @author Józsa György
 * @version 2.0
 * @since skeleton
 * @since 2020.03.10
 */
public class Beacon extends Item implements Serializable {
    /**
     * Records that the beacon has been discovered.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        Environment.getInstance().recordBeacon();
    }
}
