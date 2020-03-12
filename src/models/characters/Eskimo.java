package models.characters;

import models.policies.IgluPolicy;
import models.tiles.IcePatch;
import models.tiles.Tile;

/**
 * A character with the ability to build Igloos
 */
public class Eskimo extends Character {

    public Eskimo(int stamina) {
        super(5, stamina);
    }

    /**
     * Builds an Igloo on the target Tile,
     * changing its FrostBitePolicy.
     *
     * @param target the Tile on which the ability
     */
    @Override
    public void useSpecial(Tile target) {
        if(target.getCapacity() != 0)
            ((IcePatch) target).changeFrostBitePolicy(new IgluPolicy());
    }
}
