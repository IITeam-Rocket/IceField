package models.figures;

import models.exceptions.EndOfGameException;
import models.tiles.Tile;

import java.io.Serializable;

/**
 * A character with the ability to analyze
 * the surrounding tiles' capacity to hold
 * players.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.figures.Character
 * @see models.figures.Figure
 * @since skeleton
 * @since 2020.03.10
 */
public class Researcher extends Character implements Serializable {

    /**
     * Creates a new eskimo with 4 body heat and 4 stamina.
     */
    public Researcher() {
        super(4, 4);
    }

    /**
     * Creates a new eskimo with the given tile and with 4 body heat and 4 stamina.
     */
    public Researcher(Tile starting) {
        super(4, 4);
        this.tile = starting;
    }

    /**
     * Analyzes the target tile, and finds its
     * capacity.
     *
     * @param target the Tile on which the ability
     *               is performed.
     */
    @Override
    public void useSpecial(Tile target) {
        int capacity = target.getCapacity();
        System.out.println("capacity: " + capacity);
    }

    /**
     * TODO: description
     *
     * @throws EndOfGameException if the Researcher dies.
     */
    @Override
    public void step() throws EndOfGameException {
        System.out.println("researcher");
        System.out.println("bodyheat: " + bodyHeat);
        System.out.println("stamina: " + stamina);
        System.out.println("clearPatchStrategy: " + clearPatchStrategy.toString());
        System.out.println("helpFriendStrategy: " + helpFriendStrategy.toString());
        System.out.println("swimToShoreStrategy: " + swimToShoreStrategy.toString());
        System.out.println("tile: " + tile.getID());

        //TODO Ha meghal?
    }

    /**
     * Returns the base body heat of the figure
     *
     * @return four
     */
    @Override
    public int getBaseBodyHeat() {
        return 4;
    }
}
