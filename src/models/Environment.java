package models;

import models.figures.Figure;
import models.tiles.Tile;

import java.io.Serializable;
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

public class Environment implements Serializable {

    // TODO: 2020. 04. 24. jaavadoc
    static private final Environment instance = new Environment();
    // TODO: 2020. 04. 24. javadoc
    private ArrayList<Tile> iceTiles = new ArrayList<>();
    // TODO: 2020. 04. 24. javadoc
    private ArrayList<Figure> players = new ArrayList<>();
    // TODO: 2020. 04. 24. javadoc
    private Figure currentPlayer;
    // TODO: 2020. 04. 24. javadc
    private boolean beaconIsDiscovered = false;
    // TODO: 2020. 04. 24. javadoc
    private boolean cartridgeIsDiscovered = false;
    // TODO: 2020. 04. 24. javadoc
    private boolean gunIsDiscovered = false;

    // TODO: 2020. 04. 24. javadoc
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
     * Return a list of Figures in the game
     *
     * @return the list of players
     */
    public ArrayList<Figure> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Figure> players) {
        this.players = players;
    }

    /**
     * Returns the current player
     *
     * @return the current player
     */
    public Figure getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Figure currentPlayer) {
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
     */
    public void gameOver() {
        // TODO: 2020. 04. 15. implement

    }
}
