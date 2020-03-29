package models.policies;

import models.characters.Character;
import models.exceptions.EndOfGameException;

import static controllers.TabController.*;

/**
 * The strategy of a Tile to not
 * protect its inhabitants from a
 * snow storm.
 */
public class NoProtectionPolicy implements FrostBitePolicy {
    /**
     * Provides no protection, instead damages the
     * inhabitant.
     *
     * @param victim the character being exposed
     *               to the storm
     */
    @Override
    public void executeStrategy(Character victim) throws EndOfGameException {
        addIndent();
        printlnWithIndents("NoProtectionPolicy.executeStrategy()");

        victim.removeHeat(1);

        printlnWithIndents("return");
        removeIndent();
    }
}
