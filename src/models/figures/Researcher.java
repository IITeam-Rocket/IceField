package models.figures;

import models.tiles.Tile;

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
public class Researcher extends Character {

    // TODO: 2020. 04. 15. javadoc
    public Researcher() {
        super(4, 4);
    }

    // TODO: 2020. 04. 15. javadoc
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
        ///TODO implement useSpecial()
        target.getCapacity();
    }

    // TODO: 2020. 04. 16. javadoc
    @Override
    public void step() {
        // TODO: 2020. 04. 16. implement
    }
}
