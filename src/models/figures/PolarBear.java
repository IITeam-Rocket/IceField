package models.figures;

import controllers.view.MapPresenter;
import models.exceptions.EndOfGameException;
import models.policies.SwimOutPolicy;
import models.tiles.Tile;

import java.io.Serializable;

/**
 * Represents a polar bear that wanders
 * around randomly. Upon entering a tile,
 * it attacks every figure on the tile.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.figures.Figure
 * @see models.Subject
 * @see java.io.Serializable
 * @since prototype
 * @since 2020.04.16
 */
public class PolarBear extends Figure implements Serializable {

    public PolarBear() {
        swimToShoreStrategy = new SwimOutPolicy();
    }

    /**
     * Moves the player to the destination Tile.
     *
     * @param destination the destination to move to
     *
     * @throws EndOfGameException if a player dies
     */
    @Override
    public void moveTo(Tile destination) throws EndOfGameException{
        if (destination.acceptFigure(this))
            System.out.println("move character to " + destination.getID() + ": successful");
        tile.reactToAttack(this);
    }

    /**
     * Realises a attack's effect on the figure.
     */
    @Override
    public void reactToAttack() {
        //Empty
    }

    /**
     * Realises a blizzard's effect on the figure.
     */
    @Override
    public void reactToStorm() {
        //Empty
    }

    /**
     * Helper method to initialize observers
     */
    @Override
    void initObservers() {
        register(MapPresenter.getInstance());
    }

    /**
     * Returns the base body heat of the figure
     *
     * @return negative one
     */
    @Override
    public int getBaseBodyHeat() {
        return -1;
    }
}
