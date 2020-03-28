package controllers;

import models.characters.Researcher;
import models.tiles.Hole;
import models.tiles.StableIcePatch;

/**
 * A class that sets up and executes use cases
 */
public class UseCaseExecutor {

    /**
     * Sets up and executes the MoveCharacterToStable use case.
     */
    public static void MoveCharacterToStable() {
        StableIcePatch source = new StableIcePatch();
        StableIcePatch dest = new StableIcePatch();
        Researcher explorer = new Researcher(source);

        explorer.moveTo(dest);
    }

    /**
     * Sets up and executes the MoveCharacterToHole use case.
     */
    public static void MoveCharacterToHole() {
        StableIcePatch source = new StableIcePatch();
        Hole dest = new Hole();
        Researcher explorer = new Researcher(source);

        explorer.moveTo(dest);
    }
}
