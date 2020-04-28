package models.figures;

import models.tiles.Tile;

import java.io.Serializable;

/**
 * A character with the ability to analyze
 * the surrounding tiles' capacity to hold
 * players.
 *
 * @author Józsa György
 * @version 3.0
 * @see models.figures.Character
 * @see models.figures.Figure
 * @see models.Subject
 * @see java.io.Serializable
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
        if (stamina <= 0)
            return;
        if (tile.getNeighbours().contains(target)) {
            target.reveal();
            stamina--;
        }
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
