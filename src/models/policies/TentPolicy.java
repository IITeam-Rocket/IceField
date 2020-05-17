package models.policies;

import models.exceptions.EndOfGameException;
import models.figures.Figure;

import java.io.Serializable;

/**
 * The strategy of a Tile to protect
 * the players from snow storm for one
 * turn, but not from an attack.
 *
 * @author Józsa György
 * @version 2.0
 * @since prototype
 * @since 2020.04.14
 */
public class TentPolicy implements ProtectionPolicy, Serializable {

    /**
     * Shows the state of the tent.
     */
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
        if (!isIntact)
            victim.reactToStorm();
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
        if (!victim.equals(attacker))
            throw new EndOfGameException("A character has been mauled!");
    }

    /**
     * Steps the object for aging effects.
     */
    @Override
    public void step() {
        isIntact = false;
    }

    /**
     * Returns the priority of the strategy
     *
     * @return one if the tent is intact,
     * zero otherwise
     */
    @Override
    public int getPriority() {
        return isIntact ? 1 : 0;
    }

    /**
     * Converts the name of the strategy to String so we can use it to print it
     *
     * @return The name of the Strategy
     */
    @Override
    public String toString() {
        return "TentPolicy";
    }
}
