package models.policies;

import models.figures.Figure;

import java.io.Serializable;


/**
 * A class representing the strategy of the
 * player if they fall into water. This strategy
 * is to not swim out and die.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.policies.FallInWaterPolicy
 * @since skeleton
 * @since 2020.03.10
 */
public class HasNoDiveSuitPolicy implements FallInWaterPolicy, Serializable {
    /**
     * Executes the strategy. The strategy is to not
     * do anything and die.
     *
     * @param player the player, who fell in water.
     */
    @Override
    public void executeStrategy(Figure player) {
    }
}
