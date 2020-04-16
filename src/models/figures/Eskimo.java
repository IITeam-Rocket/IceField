package models.figures;

import models.policies.IglooPolicy;
import models.tiles.IcePatch;
import models.tiles.Tile;

/**
 * A character with the ability to build Igloos
 *
 * @author Józsa György
 * @version 2.0
 * @see models.figures.Figure
 * @see models.figures.Character
 * @since skeleton
 * @since 2020.03.10
 */
public class Eskimo extends Character {

    // TODO: 2020. 04. 15. javadoc
    public Eskimo() {
        super(5, 4);
    }

    // TODO: 2020. 04. 15. javadoc
    public Eskimo(Tile starting) {
        super(5, 4);
        this.tile = starting;
    }

    /**
     * Builds an Igloo on the target Tile,
     * changing its FrostBitePolicy.
     *
     * @param target the Tile on which the ability
     */
    @Override
    public void useSpecial(Tile target) {
        if (target == tile)
            ((IcePatch) tile).changeFrostBitePolicy(new IglooPolicy());
    }

    // TODO: 2020. 04. 16. javadoc
    @Override
    public void step() {
        // TODO: 2020. 04. 16. implement
    }
}
