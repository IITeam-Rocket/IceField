package models.policies;

import models.characters.Character;
import models.policies.FrostBitePolicy;

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
    public void executeStrategy(Character victim) {

    }
}
