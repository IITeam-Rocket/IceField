package models.figures;

import controllers.game.GameJFrame;
import models.Environment;
import models.exceptions.EndOfGameException;
import models.items.Item;
import models.policies.*;
import models.tiles.IcePatch;
import models.tiles.Tile;

import java.io.Serializable;


/**
 * Represents a playable character of the game.
 *
 * @author Józsa György
 * @version 3.0
 * @see models.figures.Figure
 * @see models.Subject
 * @see java.io.Serializable
 * @since skeleton
 * @since 2020.03.10
 */
public abstract class Character extends Figure implements Serializable {
    /**
     * The stamina of this character. It shows the number of the moves the character can do in this round.
     */
    protected int stamina;
    /**
     * The body heat of this character. It shows the number of the lives the character has.
     */
    private int bodyHeat;
    /**
     * The help friend strategy of this character.
     * It shows the behavior of the character when another character falls in water.
     */
    private RescueFriendPolicy helpFriendStrategy = new NoRescuePolicy();
    /**
     * The clear patch strategy of this character.
     * It indicates the number of snow that the character can clear in one step.
     */
    private ClearSnowPolicy clearPatchStrategy = new EmptyHandPolicy();


    /**
     * Creates a new Character with the given body heat and stamina.
     *
     * @param bodyHeat the value of the new character's body heat
     * @param stamina  the value of the new character's stamina
     */
    Character(int bodyHeat, int stamina) {
        this.bodyHeat = bodyHeat;
        this.stamina = stamina;
        swimToShoreStrategy = new HasNoDiveSuitPolicy();
    }

    /**
     * Removes some snow from the Tile
     * the player stands on.
     */
    public void clearPatch() {
        if (stamina > 0) {
            clearPatchStrategy.clear(tile);
            stamina--;
        } else
            GameJFrame.getInstance().OutputToTextBox("Not Enough Stamina available to complete this action!");
    }


    /**
     * Retrieves the item hidden in the current Tile.
     */
    public void retrieveItem() {
        if (stamina > 0) {
            IcePatch p = (IcePatch) this.tile;
            Item find = p.unBuryItem(this);

            if (find != null){
                find.uponDiscovery(this);
                p.setBuriedItem(null);
                stamina--;
            }


        } else
            GameJFrame.getInstance().OutputToTextBox("Not Enough Stamina available to complete this action!");
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
    private void removeHeat(int quantity) throws IllegalArgumentException, EndOfGameException {
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
        if (stamina > 0)
            Environment.getInstance().winGame();
        else
            GameJFrame.getInstance().OutputToTextBox("Not Enough Stamina available to complete this action!");
    }

    /**
     * Attempts to rescue another character who
     * has fallen in water, and can't get out.
     *
     * @param friend the victim to rescue
     */
    public void rescueFriend(Character friend) {
        if (stamina > 0) {
            helpFriendStrategy.executeStrategy(friend, tile);
            if (!helpFriendStrategy.toString().equals(new NoRescuePolicy().toString()))
                --stamina;
        }
        else
            GameJFrame.getInstance().OutputToTextBox("Not Enough Stamina available to complete this action!");
        notifyObservers();
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
     * Sets the character's bodyHeat to the parameter.
     *
     * @param bodyHeat the character's new bodyHeat
     */
    public void setBodyHeat(int bodyHeat) {
        this.bodyHeat = bodyHeat;
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
     * Sets the character's stamina to the parameter.
     *
     * @param stamina the character's new stamina
     */
    public void setStamina(int stamina) {
        this.stamina = stamina;
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
     * Sets the character's helpFriendStrategy to the parameter.
     *
     * @param helpFriendStrategy the character's new helpFriendStrategy
     */
    public void setHelpFriendStrategy(RescueFriendPolicy helpFriendStrategy) {
        this.helpFriendStrategy = helpFriendStrategy;
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
     * Sets the character's swimToShoreStrategy to the parameter.
     *
     * @param swimToShoreStrategy the character's new swimToShoreStrategy
     */
    public void setSwimToShoreStrategy(FallInWaterPolicy swimToShoreStrategy) {
        this.swimToShoreStrategy = swimToShoreStrategy;
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
     * Sets the character's tile to the parameter.
     *
     * @param tile the character's new tile
     */
    public void setTile(Tile tile) {
        this.tile = tile;
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

    /**
     * Moves the player to the destination Tile.
     *
     * @param destination the destination to move to
     */
    @Override
    public void moveTo(Tile destination) {
        if (stamina == 0) return;
        if (destination.acceptFigure(this)) {
            stamina--;
            notifyObservers();
        }
    }

    /**
     * Returns the instance's ClearSnowPolicy
     *
     * @return clearPatchStrategy
     */
    public ClearSnowPolicy getclearPatchStrategy() {
        return this.clearPatchStrategy;
    }

    @Override
    public void step(){
        stamina = 4;
    }
}