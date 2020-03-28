package models.characters;

import models.policies.IgluPolicy;
import models.tiles.IcePatch;
import models.tiles.Tile;

import static controllers.TabController.addIndent;
import static controllers.TabController.printlnWithIndents;
import static controllers.TabController.removeIndent;

/**
 * A character with the ability to build Igloos
 */
public class Eskimo extends Character {

    public Eskimo() {
        super(5, 4, 1);
    }

    /**
     * Builds an Igloo on the target Tile,
     * changing its FrostBitePolicy.
     *
     * @param target the Tile on which the ability
     */
    @Override
    public void useSpecial(Tile target) {
        addIndent();
        printlnWithIndents("buildingIglu(target)");

        if (target == tile)
            ((IcePatch) tile).changeFrostBitePolicy(new IgluPolicy());

        printlnWithIndents("return");
        removeIndent();
    }
}
