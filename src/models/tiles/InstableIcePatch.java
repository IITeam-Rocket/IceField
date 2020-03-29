package models.tiles;

import models.characters.Character;

import static controllers.TabController.*;

/**
 * An unstable IcePatch that may hold
 * a number of people before flipping
 * over.
 */
public class InstableIcePatch extends IcePatch {

    int playerCapacity;
    boolean flipped;

    /**
     * Accepts the player who tries to move on it.
     *
     * @param character the player to accept
     * @return true if successful, false otherwise
     */
    @Override
    public boolean acceptCharacter(Character character){
    addIndent();
    printlnWithIndents("InstableIcePatch.acceptCharacter()");
    printlnWithIndents("return: true");
    removeIndent();
    return true;
    }

    /**
     * Returns the maximum number of characters the
     * Tile can hold at one time.
     *
     * @return the maximum number of characters
     */
    @Override
    public int getCapacity() {
        addIndent();
        printlnWithIndents("InstableIcePatch.getCapacity()");
        printlnWithIndents("return: " + playerCapacity);
        removeIndent();
        return playerCapacity;
    }

    /**
     * Flips the Tile, switching its
     * behaviour from stable to hole
     * and vice versa.
     */
    public void flip() {
        addIndent();
        printlnWithIndents("InstableIcePatch.flip()");

        flipped = !flipped;

        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Returns whether the Patch is unfit for
     * standing on it
     *
     * @return false, if the Patch can
     */
    public boolean isFlipped() {
        addIndent();
        printlnWithIndents("InstableIcePatch.isFlipped()");
        printlnWithIndents("return: "+ flipped);
        removeIndent();

        return flipped;
    }

    public void setPlayerCapacity(int playerCapacity) {
        this.playerCapacity = playerCapacity;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }
}
