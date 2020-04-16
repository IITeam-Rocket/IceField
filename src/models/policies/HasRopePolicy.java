package models.policies;

import models.figures.Character;
import models.tiles.Tile;

/**
 * A strategy of the player to help their friend
 * when said friend has fallen into water. This strategy is
 * to pull them out with a rope.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.policies.RescueFriendPolicy
 * @since skeleton
 * @since 2020.03.10
 */
public class HasRopePolicy implements RescueFriendPolicy {

    /**
     * Executes the strategy. Pulls the character
     * to his tile.
     *
     * @param friend the friend who fell in water
     * @param dest   the destination tile
     */
    @Override
    public void executeStrategy(Character friend, Tile dest) {

        Tile source = friend.getTile();
        dest.acceptCharacter(friend);

        source.removeCharacter(friend);

    }
}
