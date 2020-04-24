package models;

import models.exceptions.EndOfGameException;
import models.figures.Character;
import models.tiles.Tile;

import java.util.ArrayList;

/**
 * Singleton class representing the Environment and the Game
 * It controls the gameplay with the environmental state
 * such as the relationship between Tiles and making a storm.
 *
 * @author Józsa György
 * @version 2.0
 * @since skeleton
 * @since 2020.03.10
 */

public class Environment {

    static private final Environment instance = new Environment();
    private ArrayList<Tile> iceTiles;
    private ArrayList<Character> players;
    private Character currentPlayer;
    private boolean beaconIsDiscovered = false;
    private boolean cartridgeIsDiscovered = false;
    private boolean gunIsDiscovered = false;

    private Environment() {
        iceTiles = new ArrayList<Tile>();
        players = new ArrayList<Character>();
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
        // TODO: 2020. 04. 15. implement
    }

    /**
     * Randomly chooses a set of tiles.
     *
     * @return a random set of tiles.
     */
    public ArrayList<Tile> getRandomTiles() {
        // TODO: 2020. 04. 15. implement
        return null;
    }

    /**
     * Plays the winning game sequence.
     */
    public void winGame() {
        // TODO: 2020. 04. 15. implement
    }

    /**
     * Controls the entire game-play.
     */
    public void playGame() {
        // TODO: 2020. 04. 15. implement
    }

    /**
     * Returns with a list of all the Tiles present in the game
     *
     * @return the list of Tiles in the game
     */
    public ArrayList<Tile> getIceTiles() {
        return iceTiles;
    }

    public void setIceTiles(ArrayList<Tile> iceTiles) {
        this.iceTiles = iceTiles;
    }

    /**
     * Return a list of Characters in the game
     *
     * @return the list of players
     */
    public ArrayList<Character> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Character> players) {
        this.players = players;
    }

    /**
     * Returns the current player
     *
     * @return the current player
     */
    public Character getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Character currentPlayer) {
        this.currentPlayer = currentPlayer;
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

    public void setBeaconIsDiscovered(boolean beaconIsDiscovered) {
        this.beaconIsDiscovered = beaconIsDiscovered;
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

    public void setCartridgeIsDiscovered(boolean cartridgeIsDiscovered) {
        this.cartridgeIsDiscovered = cartridgeIsDiscovered;
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

    public void setGunIsDiscovered(boolean gunIsDiscovered) {
        this.gunIsDiscovered = gunIsDiscovered;
    }

    /**
     * Plays the losing game sequence.
     *
     * @throws EndOfGameException always
     */
    public void gameOver() throws EndOfGameException {
        // TODO: 2020. 04. 15. implement
    }
}
