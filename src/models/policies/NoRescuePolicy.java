package models.policies;

import models.figures.Character;
import models.tiles.Tile;

import java.io.Serializable;

/**
 * A class representing the strategy of the player
 * to help a friend in need. This particular
 * strategy is to have no strategy, thus doing nothing.
 *
 * @author Józsa György
 * @version 2.0
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

    }
}
