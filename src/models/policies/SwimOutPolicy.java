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
            if (t.acceptFigure(player))
                break;
        }
        source.removeFigure(player);
    }

    /**
     * Converts the name of the strategy to String so we can use it to print it
     *
     * @return The name of the Strategy
     */
    @Override
    public String toString() {
        return "SwimOutPolicy";
    }
}
