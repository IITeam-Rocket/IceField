package models;

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
        if (target == tile)
            ((IcePatch) tile).changeFrostBitePolicy(new IgluPolicy());
    }
}
