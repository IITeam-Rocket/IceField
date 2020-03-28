package controllers;

import models.characters.Researcher;
import models.tiles.StableIcePatch;

/**
 * A class that sets up and executes use cases
 */
public class UseCaseExecutor {

    /**
     * Creates a character and moves it to a StableIcePatch.
     */
    public static void moveCharacterToStable() {
        StableIcePatch source = new StableIcePatch();
        Researcher explorer = new Researcher(source);
        StableIcePatch dest = new StableIcePatch();

        explorer.moveTo(dest);
    }

}
