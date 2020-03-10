package models;


/**
 * A strategy of the player to help their friend
 * when said friend has fallen into water. This strategy is
 * to pull them out with a rope.
 */
public class HasRopePolicy implements RescueFriendPolicy {

    /**
     * Executes the strategy. Pulls the character
     * to his tile.
     *
     * @param friend the friend who fell in water
     */
    @Override
    public void executeStrategy(Character friend) {

    }
}
