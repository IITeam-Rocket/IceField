package models.tiles;

import models.figures.Figure;

/**
 * A tile with no solid platform.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.tiles.Tile
 * @since skeleton
 * @since 2020.03.10
 */
public class Hole extends Tile {

    private boolean isDiscovered = false;

    public Hole() {
        super();
    }

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
        //TODO
        return false;
    }

    /**
     * Realises the storm's effects.
     *
     */
    @Override
    public void reactToStorm() {
        // TODO: 2020. 04. 24. implement
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

    public boolean isDiscovered() {
        return isDiscovered;
    }

    public void setDiscovered(boolean discovered) {
        isDiscovered = discovered;
    }
}
