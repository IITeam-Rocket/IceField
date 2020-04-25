package models.tiles;

import models.figures.Figure;

import java.io.Serializable;

/**
 * An IcePatch that is stable, meaning
 * it may support an indefinite number of
 * characters.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.tiles.IcePatch
 * @see models.tiles.Tile
 * @since skeleton
 * @since 2020.03.10
 */
public class StableIcePatch extends IcePatch implements Serializable {

    /**
     * Creates a new StableIcePatch.
     */
    public StableIcePatch() {
        super();
    }

    /**
     * Creates a new StableIcePatch with the given unique ID.
     *
     * @param ID the new StableIcePatch's unique ID.
     */
    public StableIcePatch(int ID) {
        super(ID);
    }

    /**
     * Accepts the player who tries to move on it.
     *
     * @param figure the player to accept
     *
     * @return true
     */
    @Override
    public boolean acceptCharacter(Figure figure) {
        addCharacter(figure);
        return true;
    }

    /**
     * Returns the maximum number of characters the
     * Tile can hold at one time.
     *
     * @return -1
     */
    @Override
    public int getCapacity() {
        return -1;
    }
}
