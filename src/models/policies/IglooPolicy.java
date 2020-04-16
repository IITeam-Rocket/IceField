package models.policies;

import models.exceptions.EndOfGameException;
import models.figures.Figure;

/**
 * The strategy of a Tile to protect
 * its inhabitants from a storm and
 * an attack.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.policies.ProtectionPolicy
 * @since skeleton
 * @since 2020.03.10
 */
public class IglooPolicy implements ProtectionPolicy {

    /**
     * Executes strategy of protecting against a storm.
     *
     * @param victim the character being exposed
     *               to the storm
     *
     * @throws EndOfGameException Never
     * @see EndOfGameException
     */
    @Override
    public void protectAgainstStorm(Figure victim) throws EndOfGameException {
    }

    /**
     * Executes strategy of protecting the victim.
     *
     * @param victim   the victim suffering the attack
     * @param attacker the attacker who initiates the attack
     *
     * @throws EndOfGameException Never
     * @see EndOfGameException
     */
    @Override
    public void protectAgainstAttack(Figure victim, Figure attacker) throws EndOfGameException {
    }
}
