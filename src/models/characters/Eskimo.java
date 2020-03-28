package models.characters;

import models.policies.IgluPolicy;
import models.tiles.IcePatch;
import models.tiles.Tile;

/**
 * A character with the ability to build Igloos
 */
public class Eskimo extends Character {

    public Eskimo() {
        super(5, 4, 1);
    }

    public Eskimo(Tile starting) {
        super(5, 4, 1);
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
            ((IcePatch) tile).changeFrostBitePolicy(new IgluPolicy());
    }
}
