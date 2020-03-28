package models.items;

import models.characters.Character;

import static controllers.TabController.addIndent;
import static controllers.TabController.printlnWithIndents;
import static controllers.TabController.removeIndent;

/**
 * An Item that gives the finding character
 * strength up to a unit of 2.
 */
public class Shovel extends Item {
    /**
     * Sets the finder player's strength to 2, if it's lower.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        addIndent();
        printlnWithIndents("Shovel.uponDiscovery(finder)");

        finder.setStrength(2);

        printlnWithIndents("return");
        removeIndent();
    }
}
