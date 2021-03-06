package models.policies;

import models.figures.Figure;

/**
 * A strategy of a player to do when they
 * fall in water.
 *
 * @author Józsa György
 * @version 3.0
 * @since skeleton
 * @since 2020.03.10
 */
public interface FallInWaterPolicy {
    /**
     * Executes the strategy.
     *
     * @param player the player, who fell in water.
     *
     * @return true if strategy was successfully executed.
     */
    boolean executeStrategy(Figure player);
}
