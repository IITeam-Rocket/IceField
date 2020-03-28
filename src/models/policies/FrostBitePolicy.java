package models.policies;


import models.characters.Character;
import models.exceptions.EndofGameException;

/**
 * An interface representing the strategy of
 * a Tile concerning a storm's effect on its
 * inhabitants.
 */
public interface FrostBitePolicy {
    /**
     * Executes the strategy.
     *
     * @param victim the character being exposed
     *               to the storm
     */
    void executeStrategy(Character victim) throws EndofGameException;
}
