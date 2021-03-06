package models.tiles;

import models.figures.Figure;

import java.io.Serializable;

/**
 * An IcePatch that is stable, meaning
 * it may support an indefinite number of
 * characters.
 *
 * @author Józsa György
 * @version 3.0
 * @see models.tiles.IcePatch
 * @see models.tiles.Tile
 * @see java.io.Serializable
 * @see models.Subject
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
    public boolean acceptFigure(Figure figure) {
        moveFigureToThisTile(figure);
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

    /**
     * Accept Figure Without Removal
     * @param figure Figure
     * @return was it a success
     */
    @Override
    public boolean acceptFigureWithoutRemoval(Figure figure) {
        addCharacter(figure);
        figure.setTile(this);
        return true;
    }
}
