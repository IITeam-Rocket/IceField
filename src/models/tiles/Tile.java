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
    /**
     * The maximum possible snow depth on a Tile.
     */
    protected static final int maxSnowDepth = 6;
    /**
     * The next unique ID.
     */
    protected static int IDCounter = 0;
    /**
     * The Tile's unique ID.
     */
    protected final int ID;
    /**
     * The actual snow depth on the Tile.
     */
    protected int snowDepth;
    /**
     * Contains the Figures who stands on the Tile.
     */
    protected ArrayList<Figure> entities = new ArrayList<>();
    /**
     * Contains the neighbours of the Tile.
     */
    protected ArrayList<Tile> neighbours = new ArrayList<>();
    /**
     * Stores information on whether the tile has been analyzed or not.
     */
    protected boolean analyzed = false;

    /**
     * Creates a new Tile.
     */
    public Tile() {
        this.ID = IDCounter;
        IDCounter++;
    }

    /**
     * Creates a new Tile with the given ID.
     * The ID should be unique.
     *
     * @param ID the new Tile's unique ID.
     */
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
     * @return the quantity of snow that was successfully added
     */
    public int addSnow(int quantity) {
        int oldSnowDepth = snowDepth;
        snowDepth += quantity;
        if(snowDepth > maxSnowDepth)
            snowDepth = maxSnowDepth;
        return snowDepth - oldSnowDepth;
    }

    /**
     * Decreases the amount of snow on the Tile.
     *
     * @param quantity the amount of snow to remove
     */
    public void removeSnow(int quantity) {
        if(snowDepth <= quantity) {
            System.out.println("cleared snow: " + snowDepth + " unit(s)");
            snowDepth = 0;
        }
        else {
            System.out.println("cleared snow: " + quantity + " unit(s)");
            snowDepth -= quantity;
        }
    }

    /**
     * Buries an item in the Tile
     *
     * @param item the item to bury
     *
     * @return true, if the item has been stored, false otherwise.
     */
    abstract public boolean storeItem(Item item);

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
        figure.setTile(this);
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
     * Sets the next unique Tile ID in row
     *
     * @param idCounter the next ID
     */
    public static void setIDCounter(int idCounter) {
        IDCounter =  idCounter;
    }

    /**
     * Returns the Tile's unique ID
     *
     * @return the Tile's ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Executes the tile's strategy when under attack
     *
     * @param attacker the attacking entity
     *
     * @throws EndOfGameException if a player dies in the process
     */
    abstract public void reactToAttack(Figure attacker) throws EndOfGameException;

    /**
     * @return true if the tile has been analyzed, false otherwise.
     */
    public boolean isAnalyzed() {
        return analyzed;
    }

    /**
     * Reveals the tile, so its capacity can be known.
     */
    public void reveal() {
        analyzed = true;
    }
}
