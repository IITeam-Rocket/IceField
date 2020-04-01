package models.items;

import models.Environment;
import models.characters.Character;

import static controllers.TabController.*;

/**
 * A gun that is a part of the SignalFlare
 * needed to win the game
 */
public class Gun extends Item {
    /**
     * Records that the gun has been discovered.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        addIndent();
        printlnWithIndents("Gun.uponDiscovery(finder)");

        Environment.getInstance().recordGun();

        printlnWithIndents("return");
        removeIndent();
    }
}
