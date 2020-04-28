package models.policies;

import models.exceptions.EndOfGameException;
import models.figures.Figure;

import java.io.Serializable;

/**
 * The strategy of a Tile to not
 * protect its inhabitants from a
 * snow storm.
 *
 * @author Józsa György
 * @version 3.0
 * @see models.policies.ProtectionPolicy
 * @since skeleton
 * @since 2020.03.10
 */
public class NoProtectionPolicy implements ProtectionPolicy, Serializable {

    /**
     * Provides no protection against a storm,
     * instead damages the inhabitant.
     *
     * @param victim the character being exposed
     *               to the storm
     *
     * @throws EndOfGameException If victim's body heat reaches zero.
     * @see EndOfGameException
     */
    @Override
    public void protectAgainstStorm(Figure victim) throws EndOfGameException {
        victim.reactToStorm();
    }

    /**
     * Provides no protection against an attack,
     * ends the game.
     *
     * @param victim   the victim suffering the attack
     * @param attacker the attacker who initiates the attack
     *
     * @throws EndOfGameException If victim is not attacker.
     * @see EndOfGameException
     */
    @Override
    public void protectAgainstAttack(Figure victim, Figure attacker) throws EndOfGameException {
        if (victim != attacker)
            throw new EndOfGameException("A character has been mauled!");
    }

    /**
     * Returns the priority of the strategy
     *
     * @return zero
     */
    @Override
    public int getPriority() {
        return 0;
    }

    /**
     * Converts the name of the strategy to String so we can use it to print it
     *
     * @return The name of the Strategy
     */
    @Override
    public String toString() {
        return "NoProtectionPolicy";
    }
}
