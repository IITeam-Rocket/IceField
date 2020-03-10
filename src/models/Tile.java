package models;

import java.util.ArrayList;

/**
 * A class representing an IceTile
 * which is a part of the IceField
 */
abstract public class Tile {
    protected int snowDepth;
    protected ArrayList<Character> characters;
    protected ArrayList<Tile> neighbours;

    /**
     * Accepts the player who tries to move on it.
     *
     * @param character the player to accept
     * @return true if successful, false otherwise
     */
    abstract public boolean acceptCharacter(Character character);

    /**
     * Removes the character from the Tile.
     *
     * @param character the character to remove
     */
    public void removeCharacter(Character character) {
    }

    /**
     * Increases the amount of snow on the Tile.
     *
     * @param quantity the amount of snow to add
     */
    public void addSnow(int quantity) {
    }

    /**
     * Decreases the amount of snow on the Tile.
     *
     * @param quantity the amount of snow to remove
     */
    public void removeSnow(int quantity) {
    }

    /**
     * Buries an item in the Tile
     *
     * @param item the item to bury
     */
    public void storeItem(Item item) {
    }

    /**
     * Realises the storm's effects.
     */
    abstract public void reactToStorm();

    /**
     * Returns the maximum number of characters the
     * Tile can hold at one time.
     *
     * @return the maximum number of characters
     */
    abstract public int getCapacity();

}
