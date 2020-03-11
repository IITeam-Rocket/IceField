package models;

import models.characters.Character;
import models.tiles.Tile;

import java.util.ArrayList;

/**
 * Singleton class representing the Environment and the Game
 * It controls the gameplay with the environmental state
 * such as the relationship between Tiles and making a storm.
 */

public class Environment {

    static private Environment instance = new Environment();
    ArrayList<Tile> iceTiles;
    ArrayList<Character> players;
    Character currentPlayer;
    private boolean beaconIsDiscovered = false;
    private boolean cartridgeIsDiscovered = false;
    private boolean gunIsDiscovered = false;

    private Environment() {
    }

    /**
     * Returns the instance of the singleton Environment.
     *
     * @return the singleton object
     */
    static public Environment getInstance() {
        return instance;
    }

    /**
     * Records the discovery of Beacon.
     */
    public void recordBeacon() {
        this.beaconIsDiscovered = true;
    }

    /**
     * Records the discovery of Cartridge.
     */
    public void recordCartridge() {
        this.cartridgeIsDiscovered = true;
    }

    /**
     * Records the discovery of Gun.
     */
    public void recordGun() {
        this.gunIsDiscovered = true;
    }

    /**
     * Initiates a storm that fills the Tiles with snow,
     * and takes the Characters' body-heat.
     */
    public void makeStorm() {
    }

    /**
     * Randomly chooses a set of tiles.
     *
     * @return a random set of tiles.
     */
    public ArrayList<Tile> getRandomTiles() {
        return null;
    }

    /**
     * Plays the losing game sequence.
     */
    public void gameOver() {
    }

    /**
     * Plays the winning game sequence.
     */
    public void winGame() {
    }

    /**
     * Controls the entire gameplay.
     */
    public void playGame() {
    }

}
