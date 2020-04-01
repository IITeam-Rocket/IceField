package models.policies;


import models.characters.Character;
import models.tiles.Tile;

/**
 * Interface that represents a strategy concerning
 * the player's policy of helping a friend who has
 * fallen into water.
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
