package controllers;

import models.characters.Researcher;
import models.tiles.Hole;
import models.tiles.InstableIcePatch;
import models.tiles.StableIcePatch;

/**
 * A class that sets up and executes use cases
 */
public class UseCaseExecutor {

    /**
     * Sets up and executes the MoveCharacterToStable use case.
     */
    public static void moveCharacterToStable() {
        StableIcePatch source = new StableIcePatch();
        StableIcePatch dest = new StableIcePatch();
        Researcher explorer = new Researcher(source);

        explorer.moveTo(dest);
    }

    /**
     * Sets up and executes the MoveCharacterToInstable use case
     */
    public static void moveCharacterToInstable() {
        StableIcePatch source = new StableIcePatch();
        InstableIcePatch dest = new InstableIcePatch();
        Researcher explorer = new Researcher(source);

        explorer.moveTo(dest);
    }

    /**
     * Sets up and executes the moveCharacterToInstableNoDiveSuit use case
     */
    public static void moveCharacterToInstableNoDiveSuit() {
        //TODO
    }

    /**
     * Sets up and executes the moveCharacterToInstableWithDiveSuit use case
     */
    public static void moveCharacterToInstableWithDiveSuit() {
        //TODO
    }

    /**
     * Sets up and executes the moveCharacterToUndiscoveredHole use case
     */
    public static void moveCharacterToUndiscoveredHole(){
        //TODO
    }

    /**
     * Sets up and executes the moveCharacterToDiscoveredHole use case
     */
    public static void moveCharacterToDiscoveredHole(){
        //TODO
    }

    /**
     * Sets up and executes the craftSignalFlare use case
     */
    public static void craftSignalFlare(){
        //TODO
    }

    /**
     * Sets up and executes the clearPatch use case
     */
    public static void clearPatch(){
        //TODO
    }

    /**
     * Sets up and executes the analyzeStable use case
     */
    public static void analyzeStable(){
        //TODO
    }

    /**
     * Sets up and executes the analyzeInstable use case
     */
    public static void analyzeInstable(){
        //TODO
    }

    /**
     * Sets up and executes the analyzeHole use case
     */
    public static void analyzeHole(){
        //TODO
    }

    /**
     * Sets up and executes the buildIglu use case
     */
    public static void buildIglu(){
        //TODO
    }

    /**
     * Sets up and executes the rescueFriendWithRope use case
     */
    public static void rescueFriendWithRope(){
        //TODO
    }

    /**
     * Sets up and executes the rescueFriendWithNothing use case
     */
    public static void rescueFriendWithNothing(){
        //TODO
    }

    /**
     * Sets up and executes the makeStormWithoutIglu use case
     */
    public static void makeStormWithoutIglu(){
        //TODO
    }

    /**
     * Sets up and executes the makeStormWithIglu use case
     */
    public static void makeStormWithIglu(){
        //TODO
    }

    /**
     * Sets up and executes the unburyFood use case
     */
    public static void unburyFood(){
        //TODO
    }

    /**
     * Sets up and executes the unburyDiveSuit use case
     */
    public static void unburyDiveSuit(){
        //TODO
    }

    /**
     * Sets up and executes the unburyRope use case
     */
    public static void unburyRope(){
        //TODO
    }

    /**
     * Sets up and executes the unburyShovel use case
     */
    public static void unburyShovel(){
        //TODO
    }

    /**
     * Sets up and executes the unburyCartridge use case
     */
    public static void unburyCartridge(){
        //TODO
    }

    /**
     * Sets up and executes the unburyBeacon use case
     */
    public static void unburyBeacon(){
        //TODO
    }

    /**
     * Sets up and executes the unburyGun use case
     */
    public static void unburyGun(){
        //TODO
    }

}
