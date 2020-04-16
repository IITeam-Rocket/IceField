package models.figures;

import models.tiles.Tile;

import java.util.Random;

/**
 * Represents a polar bear that wanders
 * around randomly. Upon entering a tile,
 * it attacks every figure on the tile.
 *
 * @author Józsa György
 * @version 1.0
 * @see models.figures.Figure
 * @since prototype
 * @since 2020.04.16
 */
public class PolarBear extends Figure {

    // TODO: 2020. 04. 16. javadoc
    @Override
    public void step() {
        Random random = new Random();
        int idx = random.nextInt(tile.getNeighbours().size());
        Tile destination = tile.getNeighbours().get(idx);

        moveTo(destination);

        // TODO: 2020. 04. 16. attack tile
    }
}
