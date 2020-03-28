package models.tiles;

import models.characters.Character;
import models.items.Item;

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
        ///TODO
    }

    /**
     * Increases the amount of snow on the Tile.
     *
     * @param quantity the amount of snow to add
     */
    public void addSnow(int quantity) {
        ///TODO
    }

    /**
     * Decreases the amount of snow on the Tile.
     *
     * @param quantity the amount of snow to remove
     */
    public void removeSnow(int quantity) {
        ///TODO
    }

    /**
     * Buries an item in the Tile
     *
     * @param item the item to bury
     */
    public void storeItem(Item item) {
        ///TODO
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

    /**
     * Returns the number of layers of snow on the
     * Tile.
     *
     * @return the layers of snow on the Tile
     */
    public int getSnowDepth() {
        return snowDepth;
    }

    /**
     * Returns a list of Characters currently standing
     * on the Tile.
     *
     * @return a list of Characters standing on the Tile
     */
    public ArrayList<Character> getCharacters() {
        return characters;
    }

    /**
     * Returns a list of Tiles consisting of the Tile's
     * neighbouring Tiles.
     *
     * @return a list of neighbouring Tiles
     */
    public ArrayList<Tile> getNeighbours() {
        return neighbours;
    }
}
