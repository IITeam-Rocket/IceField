package models.characters;

import models.Environment;
import models.policies.FallInWaterPolicy;
import models.policies.HasNoDiveSuitPolicy;
import models.policies.NoRescuePolicy;
import models.policies.RescueFriendPolicy;
import models.tiles.Tile;
import controllers.TabController;

import static controllers.TabController.*;

/**
 * Represents a player character of the game.
 */
public abstract class Character {
    protected int bodyHeat;
    protected int stamina;
    protected int strength;
    protected RescueFriendPolicy helpFriendStrategy;
    protected FallInWaterPolicy swimToShoreStrategy;
    protected Tile tile;

    protected Character(int bodyHeat, int stamina, int strength) {
        this.bodyHeat = bodyHeat;
        this.strength = strength;
        this.stamina = stamina;
        helpFriendStrategy = new NoRescuePolicy();
        swimToShoreStrategy = new HasNoDiveSuitPolicy();
    }

    /**
     * Removes some snow from the Tile
     * the player stands on.
     */
    public void clearPatch() {
        addIndent();
        printlnWithIndents("clearPatch()");

        tile.removeSnow(strength);

        printlnWithIndents("return");

        removeIndent();
    }

    /**
     * Moves the player to the destination Tile.
     *
     * @param destination the destination to move to
     */
    public void moveTo(Tile destination) {
        addIndent();
        printlnWithIndents("moveTo(" + destination +")");

        //TODO

        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Retrieves the item hidden in the current Tile.
     */
    public void retrieveItem() {
        addIndent();
        printlnWithIndents("retriveItem()");

        //TODO

        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Increases bodyHeat.
     *
     * @param quantity the amount of heat
     */
    public void addHeat(int quantity) {
        addIndent();
        printlnWithIndents("adHeat(" + quantity + ")");

        bodyHeat += quantity;

        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Decreases bodyHeat. End the game if it
     * falls to zero.
     *
     * @param quantity the amount of heat
     */
    public void removeHeat(int quantity) {
        bodyHeat -= quantity;
        if (bodyHeat <= 0)
            Environment.getInstance().gameOver();
    }

    /**
     * The player crafts the SignalFlare. If
     * all the parts have been discovered, it wins
     * the game, otherwise nothing happens.
     */
    public void craftSignalFlare() {
        Environment.getInstance().winGame();
    }

    /**
     * Executes the FallInWaterStrategy to avoid death.
     */
    public void swimToShore() {
        swimToShoreStrategy.executeStrategy(this);
    }

    /**
     * Attempts to rescue another character who
     * has fallen in water, and can't get out.
     *
     * @param friend the victim to rescue
     */
    public void rescueFriend(Character friend) {
        helpFriendStrategy.executeStrategy(friend);
    }

    /**
     * Uses the special ability of the player
     *
     * @param target the Tile on which the ability
     *               is performed.
     */
    abstract public void useSpecial(Tile target);

    /**
     * Changes the player's strategy to rescue a friend who
     * has fallen in water.
     *
     * @param strategy the new strategy
     */
    public void changeRescuePolicy(RescueFriendPolicy strategy) {
        helpFriendStrategy = strategy;
    }

    /**
     * Changes the player's strategy to avoid death upon
     * falling in water.
     *
     * @param strategy the new strategy
     */
    public void changeWaterPolicy(FallInWaterPolicy strategy) {
        swimToShoreStrategy = strategy;
    }

    /**
     * Returns the body-heat of the character.
     *
     * @return the bodyHeat of the character
     */
    public int getBodyHeat() {
        return bodyHeat;
    }

    /**
     * Returns the stamina of the character.
     *
     * @return the number of actions the character
     * can execute
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * Returns the strength of the character.
     *
     * @return the amount of snow the character
     * can clear
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Returns the character's strategy in the event of
     * rescuing a friend.
     *
     * @return the character's strategy of helping a friend
     */
    public RescueFriendPolicy getHelpFriendStrategy() {
        return helpFriendStrategy;
    }

    /**
     * Returns the character's strategy of getting out of water.
     *
     * @return the character's strategy of getting out of water
     */
    public FallInWaterPolicy getSwimToShoreStrategy() {
        return swimToShoreStrategy;
    }

    /**
     * Returns the Tile the character is currently standing on.
     *
     * @return the Tile the character is on
     */
    public Tile getTile() {
        return tile;
    }
}