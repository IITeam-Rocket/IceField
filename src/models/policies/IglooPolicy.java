package models.policies;

import models.figures.Figure;

import java.io.Serializable;

/**
 * The strategy of a Tile to protect
 * its inhabitants from a storm and
 * an attack.
 *
 * @author Józsa György
 * @version 3.0
 * @see models.policies.ProtectionPolicy
 * @since skeleton
 * @since 2020.03.10
 */
public class IglooPolicy implements ProtectionPolicy, Serializable {

    /**
     * Executes strategy of protecting against a storm.
     *
     * @param victim the character being exposed
     *               to the storm
     */
    @Override
    public void protectAgainstStorm(Figure victim) {
        //Empty
    }

    /**
     * Executes strategy of protecting the victim.
     *
     * @param victim   the victim suffering the attack
     * @param attacker the attacker who initiates the attack
     */
    @Override
    public void protectAgainstAttack(Figure victim, Figure attacker) {
        if(victim != attacker)
            System.out.println("Polarbear attacks character on tile "+ victim.getTile().getID()+", but survives due to iglu!");
    }

    /**
     * Returns the priority of the strategy
     *
     * @return 2
     */
    @Override
    public int getPriority() {
        return 2;
    }

    /**
     * Converts the name of the strategy to String so we can use it to print it
     *
     * @return The name of the Strategy
     */
    @Override
    public String toString() {
        return "IglooPolicy";
    }
}
