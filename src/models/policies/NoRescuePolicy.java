package models.policies;


import models.characters.Character;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * A class representing the strategy of the player
 * to help a friend in need. This particular
 * strategy is to have no strategy, thus doing nothing.
 */
public class NoRescuePolicy implements RescueFriendPolicy {

    /**
     * Does nothing, as there is no strategy.
     *
     * @param friend the friend who fell in water.
     */
    @Override
    public void executeStrategy(Character friend) {
        throw new NotImplementedException();
    }
}
