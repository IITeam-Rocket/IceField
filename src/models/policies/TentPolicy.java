package models.policies;

import models.exceptions.EndOfGameException;
import models.figures.Figure;

/**
 * The strategy of a Tile to protect
 * the players from snow storm for one
 * turn, but not from an attack.
 *
 * @author Józsa György
 * @version 1.0
 * @since prototype
 * @since 2020.04.14
 */
public class TentPolicy implements ProtectionPolicy {

    private boolean isIntact = true;

    /**
     * Executes strategy of protecting against a storm.
     *
     * @param victim the character being exposed
     *               to the storm
     *
     * @throws EndOfGameException Signifying end of game
     * @see EndOfGameException
     */
    @Override
    public void protectAgainstStorm(Figure victim) throws EndOfGameException {
        if (!isIntact) {
            //TODO figura vagy karakter legyen?
        }
    }

    /**
     * Executes strategy of protecting against an attack.
     *
     * @param victim   the victim suffering the attack
     * @param attacker the attacker who initiates the attack
     *
     * @throws EndOfGameException Signifying end of game
     * @see EndOfGameException
     */
    @Override
    public void protectAgainstAttack(Figure victim, Figure attacker) throws EndOfGameException {
        if (victim != attacker)
            throw new EndOfGameException("A character has been mauled!");
    }

    /**
     * Steps the object for aging effects.
     */
    @Override
    public void step() {
        isIntact = false;
    }
}