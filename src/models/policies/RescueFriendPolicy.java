package models.policies;

import models.figures.Character;
import models.tiles.Tile;

/**
 * Interface that represents a strategy concerning
 * the player's policy of helping a friend who has
 * fallen into water.
 *
 * @author Józsa György
 * @version 2.0
 * @since skeleton
 * @since 2020.03.10
 */
public interface RescueFriendPolicy {
    /**
     * Executes the strategy of the player.
     *
     * @param friend the friend who fell in water
     * @param dest the tile where the friend will be rescued
     */
    void executeStrategy(Character friend, Tile dest);
}
