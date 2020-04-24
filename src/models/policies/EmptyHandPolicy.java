package models.policies;

import models.tiles.Tile;

import java.io.Serializable;

/**
 * Represents a strategy for clearing a unit
 * of snow from a tile.
 *
 * @author Józsa György
 * @version 1.0
 * @see models.policies.ClearSnowPolicy
 * @since prototype
 * @since 2020.04.15
 */
public class EmptyHandPolicy implements ClearSnowPolicy, Serializable {

    /**
     * Returns the priority of the strategy,
     * which is zero.
     *
     * @return zero
     */
    @Override
    public int getPriority() {
        return 0;
    }

    /**
     * Clears one unit of snow from the
     * parameter tile
     *
     * @param target the tile from which snow
     *               will be cleared
     */
    @Override
    public void clear(Tile target) {
        target.removeSnow(1);
    }
}
