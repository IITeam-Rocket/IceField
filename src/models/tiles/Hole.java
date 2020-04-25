package models.tiles;

import models.exceptions.EndOfGameException;
import models.figures.Figure;

import java.io.Serializable;

/**
 * A tile with no solid platform.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.tiles.Tile
 * @since skeleton
 * @since 2020.03.10
 */
public class Hole extends Tile implements Serializable {

    /**
     * The state of this hole. If it is true someone discovered the hole.
     */
    private boolean isDiscovered = false;

    /**
     * Creates a new Hole.
     */
    public Hole() {
        super();
    }

    /**
     * Creates a new Hole with the given ID.
     * The ID should be unique.
     */
    public Hole(int ID) {
        super(ID);
    }

    /**
     * If the Hole has not been revealed, the
     * accepts the player, otherwise it doesn't.
     *
     * @param figure the player to accept
     *
     * @return true if successful, false otherwise
     */
    @Override
    public boolean acceptCharacter(Figure figure) {
        if(isDiscovered)
            return false;
        reveal();
        addCharacter(figure);
        figure.swimToShore();
        return true;
    }

    /**
     * Realises the storm's effects.
     *
     */
    @Override
    public void reactToStorm() {
        if (snowDepth < maxSnowDepth)
            addSnow(1);
    }

    /**
     * Returns the maximum number of characters the
     * Tile can hold at one time, which is zero.
     * It also reveals the hole.
     *
     * @return 0
     */
    @Override
    public int getCapacity() {
        reveal();
        return 0;
    }

    /**
     * Sets isDiscovered true.
     */
    public void reveal() {
        isDiscovered = true;
    }

    /**
     * Performs duties that must be done
     * at the end of a turn
     *
     * @throws EndOfGameException if it contains players
     */
    @Override
    public void step() throws EndOfGameException {
        if (entities.size() > 0)
            throw new EndOfGameException("A player has drowned!");
    }

    /**
     * Returns the state of this Hole.
     * @return this Hole is discovered or not.
     */
    public boolean isDiscovered() {
        return isDiscovered;
    }

    /**
     * Sets the isDiscovered attribute to the given value.
     * @param discovered the new value of the isDiscovered attribute.
     */
    public void setDiscovered(boolean discovered) {
        isDiscovered = discovered;
    }
}
