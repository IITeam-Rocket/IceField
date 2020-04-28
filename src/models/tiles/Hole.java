package models.tiles;

import models.exceptions.EndOfGameException;
import models.figures.Figure;
import models.items.Item;

import java.io.Serializable;

/**
 * A tile with no solid platform.
 *
 * @author Józsa György
 * @version 3.0
 * @see models.tiles.Tile
 * @see models.Subject
 * @see java.io.Serializable
 * @since skeleton
 * @since 2020.03.10
 */
public class Hole extends Tile implements Serializable {

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
    public boolean acceptFigure(Figure figure) {
        if (analyzed)
            return false;
        reveal();
        moveFigureToThisTile(figure);
        figure.swimToShore();
        return true;
    }


    /**
     * Realises the storm's effects.
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
     * @return zero
     */
    @Override
    public int getCapacity() {
        return 0;
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
     * Upon attack, does nothing
     *
     * @param attacker the attacking entity
     */
    @Override
    public void reactToAttack(Figure attacker) {
        //Empty
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
}
