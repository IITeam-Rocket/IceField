package models.policies;

import models.characters.Character;

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
        ///TODO
    }
}
