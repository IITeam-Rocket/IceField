package models.policies;

import models.figures.Figure;
import models.tiles.Tile;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing the player's strategy of
 * getting out of water upon falling in it.
 * This strategy is to swim out to the nearest
 * neighbouring Tile.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.policies.FallInWaterPolicy
 * @since skeleton
 * @since 2020.03.10
 */
public class SwimOutPolicy implements FallInWaterPolicy, Serializable {
    /**
     * Executes the player's strategy of getting out of water
     *
     * @param player the player, who fell in water.
     */
    @Override
    public void executeStrategy(Figure player) {
        Tile source = player.getTile();
        ArrayList<Tile> neighbourtiles = source.getNeighbours();

        for (Tile t : neighbourtiles) {
            if (t.acceptCharacter(player))
                break;
        }
        source.removeCharacter(player);
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "SwimOutPolicy";
    }
}
