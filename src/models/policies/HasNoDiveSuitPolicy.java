package models.policies;

import controllers.game.GameJFrame;
import models.figures.Figure;

import java.io.Serializable;


/**
 * A class representing the strategy of the
 * player if they fall into water. This strategy
 * is to not swim out and die.
 *
 * @author Józsa György
 * @version 3.0
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
        GameJFrame.getInstance().getGame().NextCharacter();
    }

    /**
     * Converts the name of the strategy to String so we can use it to print it
     *
     * @return The name of the Strategy
     */
    @Override
    public String toString() {
        return "HasNoDiveSuitPolicy";
    }
}
