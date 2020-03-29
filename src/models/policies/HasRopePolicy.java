package models.policies;


import models.characters.Character;
import models.tiles.Tile;

import static controllers.TabController.*;

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
     * @param dest   the destination tile
     */
    @Override
    public void executeStrategy(Character friend, Tile dest) {
        addIndent();
        printlnWithIndents("RescueFriendPolicy.executeStrategy()");

        dest.acceptCharacter(friend);

        Tile source = friend.getTile();
        source.removeCharacter(friend);

        printlnWithIndents("return");
        removeIndent();
    }
}
