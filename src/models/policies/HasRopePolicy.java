package models.policies;

import controllers.game.GameJFrame;
import models.figures.Character;
import models.tiles.Tile;

import java.io.Serializable;

/**
 * A strategy of the player to help their friend
 * when said friend has fallen into water. This strategy is
 * to pull them out with a rope.
 *
 * @author Józsa György
 * @version 3.0
 * @see models.policies.RescueFriendPolicy
 * @since skeleton
 * @since 2020.03.10
 */
public class HasRopePolicy implements RescueFriendPolicy, Serializable {

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
        dest.acceptFigure(friend);

        source.removeFigure(friend);
        GameJFrame.getInstance().OutputToTextBox("Friend rescued!");

    }

    /**
     * Converts the name of the strategy to String so we can use it to print it
     *
     * @return The name of the Strategy
     */
    @Override
    public String toString() {
        return "HasRopePolicy";
    }
}
