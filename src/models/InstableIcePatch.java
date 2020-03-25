package models;

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
    public boolean acceptCharacter(Character character) {
        return false;
    }

    /**
     * Returns the maximum number of characters the
     * Tile can hold at one time.
     *
     * @return the maximum number of characters
     */
    @Override
    public int getCapacity() {
        return playerCapacity;
    }

    /**
     * Flips the Tile, switching its
     * behaviour from stable to hole
     * and vice versa.
     */
    public void flip() {
    }

    /**
     * Returns whether the Patch is unfit for
     * standing on it
     *
     * @return false, if the Patch can
     */
    public boolean isFlipped() {
        return flipped;
    }
}
