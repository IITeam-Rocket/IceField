package models.tiles;

import models.figures.Figure;
import models.items.Item;

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

    /**
     * Represents the whether the hole
     * has been identified or not.
     * False, if the hole is hidden,
     * true otherwise.
     */
    private boolean isDiscovered = false;

    /**
     * Default constructor
     */
    public Hole() {
        super();
    }

    /**
     * Constructor with explicit ID
     * tag.
     *
     * @param ID the ID of the hole.
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
     * @return false
     */
    @Override
    public boolean acceptCharacter(Figure figure) {
        if (!isDiscovered) {
            reveal();
            entities.add(figure);
            figure.setTile(this);
            figure.swimToShore();
        }
        return false;
    }

    /**
     * Buries an item in the Tile
     *
     * @param item the item to bury
     *
     * @return false
     */
    @Override
    public boolean storeItem(Item item) {
        return false;
    }

    /**
     * Realises the storm's effects.
     */
    @Override
    public void reactToStorm() {
        snowDepth++;
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
