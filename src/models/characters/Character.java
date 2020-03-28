package models.characters;

import models.Environment;
import models.policies.FallInWaterPolicy;
import models.policies.HasNoDiveSuitPolicy;
import models.policies.NoRescuePolicy;
import models.policies.RescueFriendPolicy;
import models.tiles.Tile;

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
        printlnWithIndents("Character.clearPatch()");

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
        printlnWithIndents("Character.moveTo(destination)");

        if(destination.acceptCharacter(this)){
            tile.removeCharacter(this);
        }

        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Retrieves the item hidden in the current Tile.
     */
    public void retrieveItem() {
        addIndent();
        printlnWithIndents("Character.retriveItem()");

        //TODO: tile.unburyItem(this) tile doesn't have unburyItem

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
        printlnWithIndents("Character.adHeat(" + quantity + ")");

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
        addIndent();
        printlnWithIndents("Character.removeHeat(" + quantity + ")");

        bodyHeat -= quantity;
        if (bodyHeat <= 0)
            Environment.getInstance().gameOver();

        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * The player crafts the SignalFlare. If
     * all the parts have been discovered, it wins
     * the game, otherwise nothing happens.
     */
    public void craftSignalFlare() {
        addIndent();
        printlnWithIndents("Character.craftSignalFlare()");

        Environment.getInstance().winGame();

        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Executes the FallInWaterStrategy to avoid death.
     */
    public void swimToShore() {
        addIndent();
        printlnWithIndents("Character.swimToShore()");

        swimToShoreStrategy.executeStrategy(this);

        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Attempts to rescue another character who
     * has fallen in water, and can't get out.
     *
     * @param friend the victim to rescue
     */
    public void rescueFriend(Character friend) {
        addIndent();
        printlnWithIndents("Character.rescueFriend(friend)");

        helpFriendStrategy.executeStrategy(friend, tile);

        printlnWithIndents("return");
        removeIndent();
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
    public void changeRescuePolicy(RescueFriendPolicy strategy){
        addIndent();
        printlnWithIndents("Character.changeRescuePolicy(strategy)");

        helpFriendStrategy = strategy;

        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Changes the player's strategy to avoid death upon
     * falling in water.
     *
     * @param strategy the new strategy
     */
    public void changeWaterPolicy(FallInWaterPolicy strategy) {
        addIndent();
        printlnWithIndents("Character.changeWaterPolicy(strategy)");

        swimToShoreStrategy = strategy;

        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Returns the body-heat of the character.
     *
     * @return the bodyHeat of the character
     */
    public int getBodyHeat() {
        addIndent();
        printlnWithIndents("Character.getBodyHeat()");


        printlnWithIndents("return " + bodyHeat );
        removeIndent();

        return bodyHeat;
    }

    /**
     * Returns the stamina of the character.
     *
     * @return the number of actions the character
     * can execute
     */
    public int getStamina() {
        addIndent();
        printlnWithIndents("Character.getStamina()");

        printlnWithIndents("return " + stamina);
        removeIndent();

        return stamina;
    }

    /**
     * Returns the strength of the character.
     *
     * @return the amount of snow the character
     * can clear
     */
    public int getStrength() {
        addIndent();
        printlnWithIndents("Character.getStrength()");

        printlnWithIndents("return " + strength);
        removeIndent();

        return strength;
    }

    /**
     * Returns the character's strategy in the event of
     * rescuing a friend.
     *
     * @return the character's strategy of helping a friend
     */
    public RescueFriendPolicy getHelpFriendStrategy() {
        addIndent();
        printlnWithIndents("Character.getHelpFriendStrategy()");

        printlnWithIndents("return helpFriendStrategy");
        removeIndent();

        return helpFriendStrategy;
    }

    /**
     * Returns the character's strategy of getting out of water.
     *
     * @return the character's strategy of getting out of water
     */
    public FallInWaterPolicy getSwimToShoreStrategy() {
        addIndent();
        printlnWithIndents("Character.getSwimToShoreStrategy()");

        printlnWithIndents("return swimToShoreStrategy");
        removeIndent();

        return swimToShoreStrategy;
    }

    /**
     * Returns the Tile the character is currently standing on.
     *
     * @return the Tile the character is on
     */
    public Tile getTile() {
        addIndent();
        printlnWithIndents("Character.getTile()");

        printlnWithIndents("return tile");
        removeIndent();


        return tile;
    }

    /**
     * Sets the character's strength
     *
     * @param quantity the character's new strength
     */
    public void setStrength(int quantity){
        strength = quantity;
    }
}