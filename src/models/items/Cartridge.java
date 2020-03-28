package models.items;

import models.Environment;
import models.characters.Character;

import static controllers.TabController.addIndent;
import static controllers.TabController.printlnWithIndents;
import static controllers.TabController.removeIndent;

/**
 * A cartridge that is a part of the SignalFlare
 * needed to win the game.
 */
public class Cartridge extends Item {
    /**
     * Records that the cartridge has been discovered.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        addIndent();
        printlnWithIndents("Cartridge.uponDiscovery(finder)");

        Environment.getInstance().recordCartridge();

        printlnWithIndents("return");
        removeIndent();
    }
}
