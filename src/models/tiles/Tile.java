package models.tiles;

import models.figures.Character;
import models.figures.Figure;
import models.items.Item;

import java.util.ArrayList;

/**
 * A class representing an IceTile
 * which is a part of the IceField
 *
 * @author Józsa György
 * @version 2.0
 * @since skeleton
 * @since 2020.03.10
 */
abstract public class Tile {
    protected static final int maxSnowDepth = 6;
    protected final int ID;
    protected int snowDepth;
    protected ArrayList<Figure> entities = new ArrayList<>();
    protected ArrayList<Tile> neighbours = new ArrayList<>();

    public Tile(int ID) {
        this.ID = ID;
    }

    /**
     * Accepts the player who tries to move on it.
     *
     * @param figure the player to accept
     *
     * @return true if successful, false otherwise
     */
    abstract public boolean acceptCharacter(Figure figure);

    /**
     * Removes the figure from the Tile.
     *
     * @param figure the figure to remove
     */
    public void removeCharacter(Figure figure) {
        entities.remove(figure);
    }

    /**
     * Increases the amount of snow on the Tile.
     *
     * @param quantity the amount of snow to add
     */
    public void addSnow(int quantity) {
        //TODO
    }

    /**
     * Decreases the amount of snow on the Tile.
     *
     * @param quantity the amount of snow to remove
     */
    public void removeSnow(int quantity) {
        // TODO
    }

    /**
     * Buries an item in the Tile
     *
     * @param item the item to bury
     */
    public void storeItem(Item item) {
        //TODO
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

    public void setSnowDepth(int snowDepth) {
        this.snowDepth = snowDepth;
    }

    /**
     * Returns a list of Characters currently standing
     * on the Tile.
     *
     * @return a list of Characters standing on the Tile
     */
    public ArrayList<Figure> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Figure> entities) {
        this.entities = entities;
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

    public void setNeighbours(ArrayList<Tile> neighbours) {
        this.neighbours = neighbours;
    }

    /**
     * Adds a Character to the list of Characters
     * currently standing on the Tile.
     *
     * @param character the Character to add
     */
    public void addCharacter(Character character) {
        this.entities.add(character);
    }
}
