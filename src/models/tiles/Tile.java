package models.tiles;

import models.characters.Character;
import models.items.Item;

import java.util.ArrayList;

import static controllers.TabController.*;

/**
 * A class representing an IceTile
 * which is a part of the IceField
 */
abstract public class Tile {
    protected int snowDepth;
    static final int maxsnowDepth = 6;
    protected ArrayList<Character> characters = new ArrayList<>();
    protected ArrayList<Tile> neighbours = new ArrayList<>();

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
        addIndent();
        printlnWithIndents("Tile.removeCharacter()");

        characters.remove(character);

        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Increases the amount of snow on the Tile.
     *
     * @param quantity the amount of snow to add
     */
    public void addSnow(int quantity) {
        addIndent();
        printlnWithIndents("Tile.addSnow()");

        snowDepth += quantity;

        if (snowDepth > maxsnowDepth)
            snowDepth = maxsnowDepth;

        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Decreases the amount of snow on the Tile.
     *
     * @param quantity the amount of snow to remove
     */
    public void removeSnow(int quantity) {
        addIndent();
        printlnWithIndents("Tile.removeSnow()");

        if(snowDepth > 0) //hardcoded????
            snowDepth--;

        printlnWithIndents("return");
        removeIndent();
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
        addIndent();
        printlnWithIndents("Tile.getSnowDepth()");
        printlnWithIndents("return: " + snowDepth);
        removeIndent();
        return snowDepth;
    }

    /**
     * Returns a list of Characters currently standing
     * on the Tile.
     *
     * @return a list of Characters standing on the Tile
     */
    public ArrayList<Character> getCharacters() {
        addIndent();
        printlnWithIndents("Tile.getCharacters()");
        printlnWithIndents("return: ArrayList<Character>");
        removeIndent();
        return characters;
    }

    /**
     * Returns a list of Tiles consisting of the Tile's
     * neighbouring Tiles.
     *
     * @return a list of neighbouring Tiles
     */
    public ArrayList<Tile> getNeighbours() {
        addIndent();
        printlnWithIndents("Tile.getNeighbours()");
        printlnWithIndents("return: ArrayList<Tile>");
        removeIndent();
        return neighbours;
    }

    /**
     * Adds a Character to the list of Characters
     * currently standing on the Tile.
     *
     * @param character the Character to add
     */
    public void addCharacter(Character character) {
        this.characters.add(character);
    }


    public void setSnowDepth(int snowDepth) {
        this.snowDepth = snowDepth;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public void setNeighbours(ArrayList<Tile> neighbours) {
        this.neighbours = neighbours;
    }
}
