package controllers;

import models.characters.Researcher;
import models.tiles.StableIcePatch;

/**
 * A class that sets up and executes use cases
 */
public class UseCaseExecutor {

    /**
     * Sets up and executes the MoveCharacterToStable use case
     */
    public static void MoveCharacterToStable() {
        StableIcePatch source = new StableIcePatch();
        StableIcePatch dest = new StableIcePatch();
        Researcher explorer = new Researcher(source);

        explorer.moveTo(dest);
    }
}
