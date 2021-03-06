package models.policies;

import models.tiles.Tile;

import java.io.Serializable;

/**
 * Represents a strategy for clearing two
 * units of snow from a tile for the first
 * three uses, after which only clearing
 * one unit.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.policies.ClearSnowPolicy
 * @since prototype
 * @since 2020.04.15
 */
public class FragileShovelPolicy implements ClearSnowPolicy, Serializable {
    /**
     * The number of the times this fragile shovel can be used.
     */
    private int count = 3;

    /**
     * Returns the priority of the strategy.
     * The priority is one if the shovel
     * isn't broken, otherwise, it is zero
     *
     * @return one if not broken, zero otherwise
     */
    @Override
    public int getPriority() {
        if (count > 0)
            return 1;
        return 0;
    }

    /**
     * Clears two units of snow from the
     * parameter tile for the first three uses,
     * after which it breaks, and it clears only one.
     *
     * @param target the tile from which snow
     *               will be cleared
     */
    @Override
    public void clear(Tile target) {
        int quantity = count > 0 ? 2 : 1;
        target.removeSnow(quantity);
        count--;
    }

    /**
     * Converts the name of the strategy to String so we can use it to print it
     *
     * @return The name of the Strategy
     */
    @Override
    public String toString() {
        if(count > 0)
            return "FragileShovelPolicy";
        else
            return "EmptyHandPolicy";
    }
}
