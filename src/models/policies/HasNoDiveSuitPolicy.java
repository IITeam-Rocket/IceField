package models.policies;

import models.characters.Character;

import static controllers.TabController.*;

/**
 * A class representing the strategy of the
 * player if they fall into water. This strategy
 * is to not swim out and die.
 */
public class HasNoDiveSuitPolicy implements FallInWaterPolicy {
    /**
     * Executes the strategy. The strategy is to not
     * do anything and die.
     *
     * @param player the player, who fell in water.
     */
    @Override
    public void executeStrategy(Character player) {
        addIndent();
        printlnWithIndents("HasNoDiveSuitPolicy.executeStrategy()");
        printlnWithIndents("return");
        removeIndent();
    }
}
