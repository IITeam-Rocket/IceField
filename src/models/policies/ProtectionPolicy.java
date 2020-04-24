package models.policies;

import models.exceptions.EndOfGameException;
import models.figures.Figure;

/**
 * An interface representing the strategy of
 * a Tile concerning a storm's effect on its
 * inhabitants.
 *
 * @author Józsa György
 * @version 2.0
 * @since skeleton
 * @since 2020.03.10
 */
public interface ProtectionPolicy {

    /**
     * Executes strategy of protecting against a storm.
     *
     * @param victim the character being exposed
     *               to the storm
     *
     * @throws EndOfGameException Signifying end of game
     * @see EndOfGameException
     */
    void protectAgainstStorm(Figure victim) throws EndOfGameException;

    /**
     * Executes strategy of protecting against an attack.
     *
     * @param victim   the victim suffering the attack
     * @param attacker the attacker who initiates the attack
     *
     * @throws EndOfGameException Signifying end of game
     * @see EndOfGameException
     */
    void protectAgainstAttack(Figure victim, Figure attacker) throws EndOfGameException;

    /**
     * Steps the object for aging effects.
     */
    default void step() {
    }

    /**
     * Returns the priority of the strategy
     *
     * @return the priority
     */
    int getPriority();
}
