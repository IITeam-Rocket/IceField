package models;

import models.characters.Character;
import models.exceptions.EndofGameException;
import models.tiles.Tile;

import java.util.ArrayList;

/**
 * Singleton class representing the Environment and the Game
 * It controls the gameplay with the environmental state
 * such as the relationship between Tiles and making a storm.
 */

public class Environment {

    static private Environment instance = new Environment();
    private ArrayList<Tile> iceTiles;
    private ArrayList<Character> players;
    private Character currentPlayer;
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
        ///TODO implement makeStorm()
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
     * @throws EndofGameException
     */
    public void gameOver() throws EndofGameException {
        throw new EndofGameException("Somebody died!");
    }

    /**
     * Plays the winning game sequence.
     */
    public void winGame() {
        ///TODO implement winGame()
    }

    /**
     * Controls the entire gameplay.
     */
    public void playGame() {
        ///TODO implement playGame()
    }

    /**
     * Returns with a list of all the Tiles present in the game
     *
     * @return the list of Tiles in the game
     */
    public ArrayList<Tile> getIceTiles() {
        return iceTiles;
    }

    /**
     * Return a list of Characters in the game
     *
     * @return the list of players
     */
    public ArrayList<Character> getPlayers() {
        return players;
    }

    /**
     * Returns the current player
     *
     * @return the current player
     */
    public Character getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Returns the whether the Beacon has been discovered
     * in the current game.
     *
     * @return true if the Beacon has been found
     * false otherwise.
     */
    public boolean isBeaconIsDiscovered() {
        return beaconIsDiscovered;
    }

    /**
     * Returns the whether the Cartridge has been discovered
     * in the current game.
     *
     * @return true if the Cartridge has been found
     * false otherwise.
     */
    public boolean isCartridgeIsDiscovered() {
        return cartridgeIsDiscovered;
    }

    /**
     * Returns the whether the Gun has been discovered
     * in the current game.
     *
     * @return true if the Gun has been found
     * false otherwise.
     */
    public boolean isGunIsDiscovered() {
        return gunIsDiscovered;
    }
}
