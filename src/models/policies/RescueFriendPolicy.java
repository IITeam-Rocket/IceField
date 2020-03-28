package models.policies;


import models.characters.Character;

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
     */
    void executeStrategy(Character friend);
}
