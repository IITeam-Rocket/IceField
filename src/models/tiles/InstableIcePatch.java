package models.tiles;

import models.figures.Figure;

import java.io.Serializable;

/**
 * An unstable IcePatch that may hold
 * a number of people before flipping
 * over.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.tiles.IcePatch
 * @see models.tiles.Tile
 * @since skeleton
 * @since 2020.03.10
 */

public class InstableIcePatch extends IcePatch implements Serializable {

    /**
     * The capacity of this InstableIcePatch.
     */
    int playerCapacity;
    /**
     * The state of the InstableIcePatch with the default value: false.
     */
    boolean flipped = false;

    /**
     * Creates a new InstableIcePatch with the given playerCapacity.
     *
     * @param playerCapacity the new InstableIcePatch's capacity
     */
    public InstableIcePatch(int playerCapacity) {
        super();
        this.playerCapacity = playerCapacity;
    }

    /**
     * Creates a new InstableIcePatch with the given playerCapacity and with the given ID.
     *
     * @param playerCapacity the new InstableIcePatch's capacity.
     * @param ID the new InstableIcePatch's unique ID.
     */
    public InstableIcePatch(int ID, int playerCapacity) {
        super(ID);
        this.playerCapacity = playerCapacity;
    }

    /**
     * Accepts the player who tries to move on it.
     *
     * @param figure the player to accept
     *
     * @return true if successful, false otherwise
     */
    @Override
    public boolean acceptCharacter(Figure figure) {
        if(flipped)
            return false;
        addCharacter(figure);
        if(entities.size() > playerCapacity) {
            flip();
            for (Figure f : entities) {
                f.swimToShore();
            }
        }
        return true;
    }

    /**
     * Returns the maximum number of characters the
     * Tile can hold at one time.
     *
     * @return the maximum number of characters
     */
    @Override
    public int getCapacity() {
        return playerCapacity;
    }

    /**
     * Flips the Tile, switching its
     * behaviour from stable to hole
     * and vice versa.
     */
    public void flip() {
        flipped = !flipped;
    }

    /**
     * Returns whether the Patch is unfit for
     * standing on it
     *
     * @return false, if the Patch can
     */
    public boolean isFlipped() {
        return flipped;
    }

    /**
     * Sets the InstableIcePatch is flipped or not.
     *
     * @param flipped the flipped attribute's new value
     */
    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }

    /**
     * Sets the InstableIcePatch's playerCapacity to the parameter.
     *
     * @param playerCapacity the playerCapacity attribute's new value
     */
    public void setPlayerCapacity(int playerCapacity) {
        this.playerCapacity = playerCapacity;
    }
}
