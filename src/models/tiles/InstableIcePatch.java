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

    // TODO: 2020. 04. 24. javadoc
    int playerCapacity;
    // TODO: 2020. 04. 24. jaavadoc
    boolean flipped = false;

    // TODO: 2020. 04. 24. javadoc
    public InstableIcePatch(int playerCapacity) {
        super();
        this.playerCapacity = playerCapacity;
    }

    // TODO: 2020. 04. 24. javadoc
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
        //TODO
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
        //TODO
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

    // TODO: 2020. 04. 24. javadoc
    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }

    // TODO: 2020. 04. 24. javadoc
    public void setPlayerCapacity(int playerCapacity) {
        this.playerCapacity = playerCapacity;
    }
}
