package models.characters;

import models.tiles.IcePatch;
import models.tiles.Tile;

/**
 * A character with the ability to build Igloos
 */
public class Eskimo extends Character {

    /**
     * Builds an Igloo on the target Tile,
     * changing its FrostBitePolicy.
     *
     * @param target the Tile on which the ability
     */
    @Override
    public void useSpecial(Tile target) {
        // Tile-t nem lehet úgy castolni hogy legyen changeFrostBitePolicy() fv
    }
}
