package models.items;

import models.Environment;
import models.characters.Character;

import static controllers.TabController.addIndent;
import static controllers.TabController.printlnWithIndents;
import static controllers.TabController.removeIndent;

/**
 * A beacon that is one part of the SignalFlare
 * needed to win the game
 */
public class Beacon extends Item {
    /**
     * Records that the beacon has been discovered.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        addIndent();
        printlnWithIndents("beaconDiscovery(finder)");

        Environment.getInstance().recordBeacon();

        printlnWithIndents("return");
        removeIndent();
    }
}
