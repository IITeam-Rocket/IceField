package models.figures;

import models.policies.FallInWaterPolicy;
import models.tiles.Tile;

/**
 * Represents a figure that is standing on a tile.
 *
 * @author Józsa György
 * @version 1.0
 * @since prototype
 * @since 2020.03.10
 */
abstract public class Figure {

    protected Tile tile;
    protected FallInWaterPolicy swimToShoreStrategy;

    /**
     * Moves the player to the destination Tile.
     *
     * @param destination the destination to move to
     */
    public void moveTo(Tile destination) {
        if (destination.acceptCharacter(this)) {
            tile.removeCharacter(this);
        }
    }

    /**
     * Executes the FallInWaterStrategy to avoid death.
     */
    public void swimToShore() {
        swimToShoreStrategy.executeStrategy(this);
    }

    public Tile getTile() {
        return tile;
    }

    // TODO: 2020. 04. 16. javadoc

    abstract public void step();

    /**
     * Realises a attack's effect on the figure.
     */
    abstract public void reactToAttack();

    /**
     * Realises a blizzard's effect on the figure.
     */
    abstract public void reactToStorm();

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public FallInWaterPolicy getSwimToShoreStrategy() {
        return swimToShoreStrategy;
    }

    public void setSwimToShoreStrategy(FallInWaterPolicy swimToShoreStrategy) {
        this.swimToShoreStrategy = swimToShoreStrategy;
    }
}
