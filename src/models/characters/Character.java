package models.characters;

import models.Environment;
import models.policies.*;
import models.tiles.IcePatch;
import models.tiles.Tile;

/**
 * Represents a player character of the game.
 */
public abstract class Character {
    protected int bodyHeat;
    protected int stamina;
    protected int strength;
    protected RescueFriendPolicy helpFriendStrategy;
    protected FallInWaterPolicy swimToShoreStrategy;
    Tile tile;

    public Character(int bodyHeat, int stamina){
        this.bodyHeat = bodyHeat;
        this.stamina = stamina;
        this.strength = 1;
        this.helpFriendStrategy = new NoRescuePolicy();
        this.swimToShoreStrategy = new HasNoDiveSuitPolicy();
    }

    public void setStrength(int s){
        if(s < 0)
            throw new IllegalArgumentException("You must stay positive!");
        if(s > 2)
            throw new IllegalArgumentException("Woah Cowboy, chill out!");

        this.strength = s;
    }

    /**
     * Removes some snow from the Tile
     * the player stands on.
     */
    public void clearPatch() {
        this.tile.removeSnow(strength);
    }

    /**
     * Moves the player to the destination Tile.
     *
     * @param destination the destination to move to
     */
    public void moveTo(Tile destination) {
        destination.acceptCharacter(this);
        this.tile.removeCharacter(this);

        this.tile = destination;
    }

    /**
     * Retrieves the item hidden in the current Tile.
     */
    public void retrieveItem() {
        //probléma, hogy a tile-nak nincsen unBuryItem-je
        ((IcePatch) this.tile).unBuryItem(this);
    }

    /**
     * Increases bodyHeat.
     *
     * @param quantity the amount of heat
     *
     * @throws IllegalArgumentException
     */
    public void addHeat(int quantity) {
        if(quantity < 0)
            throw new IllegalArgumentException("Invalid quantity");
        this.bodyHeat += quantity;
    }

    /**
     * Decreases bodyHeat. End the game if it
     * falls to zero.
     *
     * @param quantity the amount of heat
     *
     * @throws IllegalArgumentException
     */
    public void removeHeat(int quantity) {
        if(quantity < 0)
            throw new IllegalArgumentException("Invalid quantity");
        this.bodyHeat -= quantity;

        if(this.bodyHeat < 0){
            Environment.getInstance().gameOver();
        }
    }

    /**
     * The player crafts the SignalFlare. If
     * all the parts have been discovered, it wins
     * the game, otherwise nothing happens.
     */
    public void craftSignalFlare() {

    }

    /**
     * Executes the FallInWaterStrategy to avoid death.
     *
     * @throws NullPointerException
     */
    public void swimToShore() {
        if(swimToShoreStrategy == null){
            throw new NullPointerException("helpFriendStrategy not initialized");
        }
        swimToShoreStrategy.executeStrategy(this);
    }

    /**
     * Attempts to rescue another character who
     * has fallen in water, and can't get out.
     *
     * @param friend the victim to rescue
     *
     * @throws NullPointerException
     */
    public void rescueFriend(Character friend) {
        if(helpFriendStrategy == null){
            throw new NullPointerException("helpFriendStrategy not initialized");
        }
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
        this.helpFriendStrategy = strategy;
    }

    /**
     * Changes the player's strategy to avoid death upon
     * falling in water.
     *
     * @param strategy the new strategy
     */
    public void changeWaterPolicy(FallInWaterPolicy strategy) {
        this.swimToShoreStrategy = strategy;
    }

}