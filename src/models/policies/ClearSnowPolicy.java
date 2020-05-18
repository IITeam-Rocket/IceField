package models.policies;

import models.tiles.Tile;

/**
 * Represents a strategy of clearing snow
 * from a tile.
 *
 * @author Józsa György
 * @version 2.0
 * @since prototype
 * @since 2020.04.15
 */
public interface ClearSnowPolicy {

    /**
     * Returns the priority of the strategy.
     *
     * @return the priority
     */
    int getPriority();

    /**
     * Clears some amount of snow from the
     * parameter tile
     *
     * @param target the tile from which snow
     *               will be cleared
     */
    void clear(Tile target);
}
