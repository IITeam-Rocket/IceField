package models.items;

import models.characters.Character;
import models.policies.HasDiveSuitPolicy;

import static controllers.TabController.addIndent;
import static controllers.TabController.printlnWithIndents;
import static controllers.TabController.removeIndent;

/**
 * An item that changes the finder's
 * FallInWaterPolicy.
 */
public class DiveSuit extends Item {
    /**
     * Changes the finder's FallInWaterPolicy to
     * an instance of HasDiveSuitPolicy.
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        addIndent();
        printlnWithIndents("DiveSuit.uponDiscovery(finder)");

        finder.changeWaterPolicy(new HasDiveSuitPolicy());

        printlnWithIndents("return");
        removeIndent();
    }
}
