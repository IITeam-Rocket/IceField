package models.figures;

import models.exceptions.EndOfGameException;
import models.policies.FallInWaterPolicy;
import models.tiles.Tile;

import java.io.Serializable;

/**
 * Represents a figure that is standing on a tile.
 *
 * @author Józsa György
 * @version 1.0
 * @since prototype
 * @since 2020.03.10
 */
abstract public class Figure implements Serializable {
    // TODO: 2020. 04. 24. javadoc
    protected Tile tile;
    // TODO: 2020. 04. 24. javadoc
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

    // TODO: 2020. 04. 24. javadoc
    public Tile getTile() {
        return tile;
    }

    // TODO: 2020. 04. 16. javadoc
    public void setTile(Tile tile) {
        this.tile = tile;
    }

    // TODO: 2020. 04. 24. javadoc
    abstract public void step();

    /**
     * Realises a attack's effect on the figure.
     *
     * @throws EndOfGameException on player death
     */
    abstract public void reactToAttack() throws EndOfGameException;

    /**
     * Realises a blizzard's effect on the figure.
     *
     * @throws EndOfGameException on player death
     */
    abstract public void reactToStorm() throws EndOfGameException;

    /**
     * Returns the base body heat of the figure
     *
     * @return the base body heat
     */
    abstract public int getBaseBodyHeat();

    public FallInWaterPolicy getSwimToShoreStrategy() {
        return swimToShoreStrategy;
    }

    // TODO: 2020. 04. 24. javadoc
    public void setSwimToShoreStrategy(FallInWaterPolicy swimToShoreStrategy) {
        this.swimToShoreStrategy = swimToShoreStrategy;
    }
}
