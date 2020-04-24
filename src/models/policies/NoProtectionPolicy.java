package models.policies;

import models.exceptions.EndOfGameException;
import models.figures.Figure;

/**
 * The strategy of a Tile to not
 * protect its inhabitants from a
 * snow storm.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.policies.ProtectionPolicy
 * @since skeleton
 * @since 2020.03.10
 */
public class NoProtectionPolicy implements ProtectionPolicy {

    /**
     * Provides no protection against a storm,
     * instead damages the inhabitant.
     *
     * @param victim the character being exposed
     *               to the storm
     *
     * @throws EndOfGameException If victim's body heat reaches zero.
     */
    @Override
    public void protectAgainstStorm(Figure victim) throws EndOfGameException {
        //TODO: figure or character?
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
}
