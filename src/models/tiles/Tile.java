package models.tiles;

import models.exceptions.EndOfGameException;
import models.figures.Figure;
import models.items.Item;

import java.io.Serializable;
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
abstract public class Tile implements Serializable {
    // TODO: 2020. 04. 24. javadoc
    protected static final int maxSnowDepth = 6;
    // TODO: 2020. 04. 24. javadoc
    protected static int IDCounter = 0;
    // TODO: 2020. 04. 24. javadoc
    protected final int ID;
    // TODO: 2020. 04. 24. javadoc
    protected int snowDepth;
    // TODO: 2020. 04. 24. javadoc
    protected ArrayList<Figure> entities = new ArrayList<>();
    // TODO: 2020. 04. 24. javadoc
    protected ArrayList<Tile> neighbours = new ArrayList<>();

    // TODO: 2020. 04. 24. javadoc
    public Tile() {
        this.ID = IDCounter;
        IDCounter++;
    }

    // TODO: 2020. 04. 24. javadoc
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
     *
     * @return the quantity of snow that was succesfully added
     */
    public int addSnow(int quantity) {
        //TODO: Arra figyelni, hogy van maximum!!!!
        return -1;
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
     *
     * @throws EndOfGameException if a player freezes
     *                            to death
     */
    abstract public void reactToStorm() throws EndOfGameException;

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
     * @param figure the Figure to add
     */
    public void addCharacter(Figure figure) {
        this.entities.add(figure);
    }

    /**
     * Performs duties that must be done
     * at the end of a turn.
     *
     * @throws EndOfGameException if a player dies.
     */
    abstract public void step() throws EndOfGameException;

    /**
     * Returns the possible maximum snow depth on a tile
     *
     * @return the maximum snow depth
     */
    public static int getMaxSnowDepth() {
        return maxSnowDepth;
    }

    /**
     * Returns the next unique Tile ID in row
     *
     * @return the next ID
     */
    public static int getIDCounter() {
        return IDCounter;
    }

    /**
     * Returns the Tile's unique ID
     *
     * @return the Tile's ID
     */
    public int getID() {
        return ID;
    }
}
