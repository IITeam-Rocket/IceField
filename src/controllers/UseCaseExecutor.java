package controllers;

import models.Environment;
import models.characters.Character;
import models.characters.Researcher;
import models.policies.HasDiveSuitPolicy;
import models.tiles.Hole;
import models.tiles.InstableIcePatch;
import models.tiles.StableIcePatch;
import models.tiles.Tile;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
        StableIcePatch source = new StableIcePatch();
        InstableIcePatch dest = new InstableIcePatch();
        dest.setPlayerCapacity(0);
        Researcher explorer = new Researcher(source);

        explorer.moveTo(dest);
    }

    /**
     * Sets up and executes the moveCharacterToInstableWithDiveSuit use case
     */
    public static void moveCharacterToInstableWithDiveSuit() {
        StableIcePatch source = new StableIcePatch();
        InstableIcePatch dest = new InstableIcePatch();
        dest.setPlayerCapacity(0);
        Researcher explorer = new Researcher(source);
        explorer.setSwimToShoreStrategy(new HasDiveSuitPolicy());

        explorer.moveTo(dest);
    }

    /**
     * Sets up and executes the moveCharacterToUndiscoveredHole use case
     */
    public static void moveCharacterToUndiscoveredHole() {
        StableIcePatch source = new StableIcePatch();
        Hole dest = new Hole();
        Researcher explorer = new Researcher(source);

        explorer.moveTo(dest);
    }

    /**
     * Sets up and executes the moveCharacterToDiscoveredHole use case
     */
    public static void moveCharacterToDiscoveredHole() {
        StableIcePatch source = new StableIcePatch();
        Hole dest = new Hole();
        dest.setDiscovered(true);
        Researcher explorer = new Researcher(source);

        explorer.moveTo(dest);
    }

    /**
     * Sets up and executes the craftSignalFlare use case
     */
    public static void craftSignalFlare() {
        boolean beaconFound = getYesNo("Has the Beacon been found?");
        boolean cartridgeFound = getYesNo("Has the Cartridge been found?");
        boolean gunFound = getYesNo("Has the Gun been found?");

        StableIcePatch tile = new StableIcePatch();
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(tile);
        Researcher player = new Researcher(tile);
        ArrayList<Character> players = new ArrayList<>();
        players.add(player);
        Environment environment = Environment.getInstance();
        environment.setBeaconIsDiscovered(beaconFound);
        environment.setCartridgeIsDiscovered(cartridgeFound);
        environment.setGunIsDiscovered(gunFound);
        environment.setPlayers(players);
        environment.setIceTiles(tiles);
        environment.setCurrentPlayer(player);

        player.craftSignalFlare();
    }

    /**
     * Sets up and executes the clearPatch use case
     */
    public static void clearPatch() {
        StableIcePatch tile = new StableIcePatch();
        Researcher explorer = new Researcher(tile);

        explorer.clearPatch();
    }

    /**
     * Sets up and executes the analyzeStable use case
     */
    public static void analyzeStable() {
        StableIcePatch tile = new StableIcePatch();
        StableIcePatch target = new StableIcePatch();
        ArrayList<Tile> neighbours = new ArrayList<>();
        neighbours.add(target);
        tile.setNeighbours(neighbours);
        Researcher explorer = new Researcher(tile);

        explorer.useSpecial(target);
    }

    /**
     * Sets up and executes the analyzeInstable use case
     */
    public static void analyzeInstable() {
        StableIcePatch tile = new StableIcePatch();
        InstableIcePatch target = new InstableIcePatch();
        ArrayList<Tile> neighbours = new ArrayList<>();
        neighbours.add(target);
        tile.setNeighbours(neighbours);
        Researcher explorer = new Researcher(tile);

        explorer.useSpecial(target);
    }

    /**
     * Sets up and executes the analyzeHole use case
     */
    public static void analyzeHole() {
        StableIcePatch tile = new StableIcePatch();
        Hole target = new Hole();
        ArrayList<Tile> neighbours = new ArrayList<>();
        neighbours.add(target);
        tile.setNeighbours(neighbours);
        Researcher explorer = new Researcher(tile);

        explorer.useSpecial(target);
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
    public static void unburyGun() {
        //TODO
    }

    /**
     * Asks the user to answer to a Yes or No question,
     * and returns with the boolean answer.
     *
     * @param question a String containing a simple question
     * @return true if answer was a yes, false otherwise
     */
    private static boolean getYesNo(String question) {

        System.out.println(question + " (y/n)");

        while (true) {
            System.out.print("> ");
            String input;
            Scanner in = new Scanner(System.in);

            try {
                input = in.next();
            } catch (InputMismatchException exception) {
                System.out.println("Please enter y/n!");
                continue;
            }

            if (input.equals("y"))
                return true;
            else if (input.equals("n"))
                return false;
            else
                System.out.println("Please enter y/n!");
        }
    }

}
