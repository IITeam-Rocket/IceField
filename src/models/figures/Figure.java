package models.figures;

import models.Subject;
import models.exceptions.EndOfGameException;
import models.policies.FallInWaterPolicy;
import models.tiles.Tile;

import java.io.Serializable;

/**
 * Represents a figure that is standing on a tile.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.Subject
 * @see java.io.Serializable
 * @since prototype
 * @since 2020.03.10
 */
abstract public class Figure extends Subject implements Serializable {
    /**
     * The first and last name actual tile of this figure.
     */
    Tile tile;
    /**
     * The swim to shore strategy of this figure.
     * Indicates the behavior of the figure when falls in water.
     */
    FallInWaterPolicy swimToShoreStrategy;

    /**
     * Moves the player to the destination Tile.
     *
     * @param destination the destination to move to
     *
     * @throws EndOfGameException if a player dies
     */
    abstract public void moveTo(Tile destination) throws EndOfGameException;

    /**
     * Executes the FallInWaterStrategy to avoid death.
     *
     * @return true, if swimming out was successful, false otherwise.
     */
    public boolean swimToShore() {
        return swimToShoreStrategy.executeStrategy(this);
    }

    /**
     * Returns the Tile the figure is currently standing on.
     *
     * @return the Tile the figure is on
     */
    public Tile getTile() {
        return tile;
    }

    /**
     * Sets the figure's tile to the parameter.
     *
     * @param tile the figure's new tile
     */
    public void setTile(Tile tile) {
        this.tile = tile;
    }

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

    /**
     * Sets the figure's swimToShoreStrategy to the parameter.
     *
     * @param swimToShoreStrategy the figure's new swimToShoreStrategy
     */
    public void setSwimToShoreStrategy(FallInWaterPolicy swimToShoreStrategy) {
        this.swimToShoreStrategy = swimToShoreStrategy;
    }

    /**
     * Removes the figure from the list of figures standing on tile
     *
     * @param tile the tile to remove the figure from
     */
    public void removeFromTile(Tile tile) {
        tile.removeFigure(this);
    }


    /**
     * Helper method to initialize observers
     */
    abstract void initObservers();

    public void step() /*throws EndOfGameException*/ {}
}
