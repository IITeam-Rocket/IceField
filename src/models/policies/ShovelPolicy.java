package models.policies;

import models.tiles.Tile;

import java.io.Serializable;

/**
 * Represents a strategy for clearing two
 * units of snow from a tile.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.policies.ClearSnowPolicy
 * @since prototype
 * @since 2020.04.15
 */
public class ShovelPolicy implements ClearSnowPolicy, Serializable {

    /**
     * Returns the priority of the strategy,
     * which is two.
     *
     * @return two
     */
    @Override
    public int getPriority() {
        return 2;
    }

    /**
     * Clears two units of snow from the
     * parameter tile
     *
     * @param target the tile from which snow
     *               will be cleared
     */
    @Override
    public void clear(Tile target) {
        target.removeSnow(2);
    }

    /**
     * Converts the name of the strategy to String so we can use it to print it
     *
     * @return The name of the Strategy
     */
    @Override
    public String toString() {
        return "ShovelPolicy";
    }
}
