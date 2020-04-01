package models.items;

import models.characters.Character;

import static controllers.TabController.*;

/**
 * An Item that gives the finding player bodyHeat.
 */
public class Food extends Item {
    /**
     * gives the finding player a unit of bodyHeat.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        addIndent();
        printlnWithIndents("Food.uponDiscovery(finder)");

        finder.addHeat(1);

        printlnWithIndents("return");
        removeIndent();
    }
}
