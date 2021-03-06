package models.policies;

import controllers.game.GameJFrame;
import models.figures.Character;
import models.tiles.Tile;

import java.io.Serializable;

/**
 * A class representing the strategy of the player
 * to help a friend in need. This particular
 * strategy is to have no strategy, thus doing nothing.
 *
 * @author Józsa György
 * @version 3.0
 * @see models.policies.RescueFriendPolicy
 * @since skeleton
 * @since 2020.03.10
 */
public class NoRescuePolicy implements RescueFriendPolicy, Serializable {

    /**
     * Does nothing, as there is no strategy.
     *
     * @param friend the friend who fell in water.
     * @param dest   the destination tile
     */
    @Override
    public void executeStrategy(Character friend, Tile dest) {
        //Empty
        GameJFrame.getInstance().outputToTextBox("The character doesn't have a rope!");
    }

    /**
     * Converts the name of the strategy to String so we can use it to print it
     *
     * @return The name of the Strategy
     */
    @Override
    public String toString() {
        return "NoRescuePolicy";
    }
}
