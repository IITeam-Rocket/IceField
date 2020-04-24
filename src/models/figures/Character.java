package models.figures;

import models.Environment;
import models.exceptions.EndOfGameException;
import models.items.Item;
import models.policies.*;
import models.tiles.IcePatch;
import models.tiles.Tile;


/**
 * Represents a playable character of the game.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.figures.Figure
 * @since skeleton
 * @since 2020.03.10
 */
public abstract class Character extends Figure {
    // TODO: 2020. 04. 24. javadoc
    protected int bodyHeat;
    // TODO: 2020. 04. 24. javadoc
    protected int stamina;
    // TODO: 2020. 04. 24. javadoc
    protected RescueFriendPolicy helpFriendStrategy = new NoRescuePolicy();
    // TODO: 2020. 04. 24. javadoc
    protected ClearSnowPolicy clearPatchStrategy = new EmptyHandPolicy();


    // TODO: 2020. 04. 15. javadoc 
    protected Character(int bodyHeat, int stamina) {
        this.bodyHeat = bodyHeat;
        this.stamina = stamina;
        swimToShoreStrategy = new HasNoDiveSuitPolicy();
    }

    /**
     * Removes some snow from the Tile
     * the player stands on.
     */
    public void clearPatch() {
        // TODO: 2020. 04. 15. implement
    }


    /**
     * Retrieves the item hidden in the current Tile.
     */
    public void retrieveItem() {
        IcePatch p = (IcePatch) this.tile;
        Item find = p.unBuryItem(this);

        if (find != null)
            find.uponDiscovery(this);
    }

    /**
     * Increases bodyHeat.
     *
     * @param quantity the amount of heat
     *
     * @throws IllegalArgumentException if quantity is negative
     */
    public void addHeat(int quantity) throws IllegalArgumentException {
        if (quantity < 1)
            throw new IllegalArgumentException("Must not be negative");
        bodyHeat += quantity;
    }

    /**
     * Decreases bodyHeat. End the game if it
     * falls to zero.
     *
     * @param quantity the amount of heat
     */
    public void removeHeat(int quantity) throws IllegalArgumentException, EndOfGameException {
        if (quantity < 1)
            throw new IllegalArgumentException("Must not be negative");
        bodyHeat -= quantity;
        if (bodyHeat <= 0)
            throw new EndOfGameException("A player has frozen to death!");
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
     * Attempts to rescue another character who
     * has fallen in water, and can't get out.
     *
     * @param friend the victim to rescue
     */
    public void rescueFriend(Character friend) {
        helpFriendStrategy.executeStrategy(friend, tile);
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
     * Changes the player's strategy to clear
     * snow.
     *
     * @param strategy the new strategy
     */
    public void changeClearSnowPolicy(ClearSnowPolicy strategy) {
        if (strategy.getPriority() >= clearPatchStrategy.getPriority())
            clearPatchStrategy = strategy;
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

    /**
     * Realises a attack's effect on the figure.
     *
     * @throws EndOfGameException always
     */
    @Override
    public void reactToAttack() throws EndOfGameException {
        throw new EndOfGameException("A player has been attacked!");
    }

    /**
     * Realises a blizzard's effect on the figure.
     *
     * @throws EndOfGameException if character's
     *                            body heat reaches zero.
     */
    @Override
    public void reactToStorm() throws EndOfGameException {
        removeHeat(1);
    }

    /**
     * Changes the tile's ProtectionPolicy to
     * a new instance of TentPolicy.
     */
    public void buildTent() {
        ((IcePatch) tile).changeProtectionPolicy(new TentPolicy());
    }

    // TODO: 2020. 04. 24. javadoc
    public void setBodyHeat(int bodyHeat) {
        this.bodyHeat = bodyHeat;
    }

    // TODO: 2020. 04. 24. javadoc
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    // TODO: 2020. 04. 24. javadoc
    public void setSwimToShoreStrategy(FallInWaterPolicy swimToShoreStrategy) {
        this.swimToShoreStrategy = swimToShoreStrategy;
    }

    // TODO: 2020. 04. 24. javadoc
    public void setHelpFriendStrategy(RescueFriendPolicy helpFriendStrategy) {
        this.helpFriendStrategy = helpFriendStrategy;
    }

    // TODO: 2020. 04. 24. javadoc
    public void setTile(Tile tile) {
        this.tile = tile;
    }
}