package models;

import models.characters.Character;
import models.exceptions.EndOfGameException;
import models.tiles.StableIcePatch;
import models.tiles.Tile;

import java.util.ArrayList;

import static controllers.TabController.*;

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
        addIndent();
        printlnWithIndents("Environment.getInstance()");

        printlnWithIndents("return: instance");
        removeIndent();
        return instance;
    }

    /**
     * Records the discovery of Beacon.
     */
    public void recordBeacon() {
        addIndent();
        printlnWithIndents("Environment.recordBeacon()");
        this.beaconIsDiscovered = true;

        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Records the discovery of Cartridge.
     */
    public void recordCartridge() {
        addIndent();
        printlnWithIndents("Environment.recordCartridge()");

        this.cartridgeIsDiscovered = true;
        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Records the discovery of Gun.
     */
    public void recordGun() {
        addIndent();
        printlnWithIndents("Environment.recordGun()");
        this.gunIsDiscovered = true;
        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Initiates a storm that fills the Tiles with snow,
     * and takes the Characters' body-heat.
     */
    public void makeStorm() {
        addIndent();
        printlnWithIndents("Environment.makeStorm()");

        ArrayList<Tile> randomTiles = getRandomTiles();

        for(Tile tile: randomTiles){
            tile.addSnow(1);
            tile.reactToStorm();
        }

        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Randomly chooses a set of tiles.
     *
     * @return a random set of tiles.
     */
    public ArrayList<Tile> getRandomTiles() {
        addIndent();
        printlnWithIndents("Environment.getRandomTiles()");

        printlnWithIndents("return: tiles");
        removeIndent();

        ArrayList<Tile> tiles = new ArrayList<Tile>();
        StableIcePatch stable = new StableIcePatch();
        stable.addSnow(2);
        tiles.add(stable);

        return tiles;
    }

    /**
     * Plays the winning game sequence.
     */
    public void winGame() {
        addIndent();
        printlnWithIndents("Environment.winGame()");
        ///TODO implement winGame()
        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Controls the entire game-play.
     */
    public void playGame() {
        addIndent();
        printlnWithIndents("Environment.playGame()");
        ///TODO implement playGame()
        printlnWithIndents("return");
        removeIndent();
    }

    /**
     * Returns with a list of all the Tiles present in the game
     *
     * @return the list of Tiles in the game
     */
    public ArrayList<Tile> getIceTiles() {
        addIndent();
        printlnWithIndents("Environment.getIceTiles()");

        printlnWithIndents("return: iceTiles");
        removeIndent();
        return iceTiles;
    }

    /**
     * Return a list of Characters in the game
     *
     * @return the list of players
     */
    public ArrayList<Character> getPlayers() {
        addIndent();
        printlnWithIndents("Environment.getPlayers()");

        printlnWithIndents("return: players");
        removeIndent();
        return players;
    }

    /**
     * Returns the current player
     *
     * @return the current player
     */
    public Character getCurrentPlayer() {
        addIndent();
        printlnWithIndents("Environment.getCurrentPlayer()");

        printlnWithIndents("return: currentPlayer");
        removeIndent();
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
        addIndent();
        printlnWithIndents("Environment.isBeaconIsDiscovered()");

        printlnWithIndents("return: beaconIsDiscovered");
        removeIndent();
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
        addIndent();
        printlnWithIndents("Environment.isCartridgeIsDiscovered()");

        printlnWithIndents("return: cartridgeIsDiscovered");
        removeIndent();
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
        addIndent();
        printlnWithIndents("Environment.isGunIsDiscovered()");

        printlnWithIndents("return: gunIsDiscovered");
        removeIndent();
        return gunIsDiscovered;
    }

    /**
     * Plays the losing game sequence.
     *
     * @throws EndOfGameException always
     */
    public void gameOver() throws EndOfGameException {
        addIndent();
        printlnWithIndents("Environment.gameOver()");

        printlnWithIndents("throw: EndOfGameException");
        removeIndent();
        throw new EndOfGameException("Somebody died!");
    }

    public void setIceTiles(ArrayList<Tile> iceTiles) {
        this.iceTiles = iceTiles;
    }

    public void setPlayers(ArrayList<Character> players) {
        this.players = players;
    }

    public void setCurrentPlayer(Character currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setBeaconIsDiscovered(boolean beaconIsDiscovered) {
        this.beaconIsDiscovered = beaconIsDiscovered;
    }

    public void setCartridgeIsDiscovered(boolean cartridgeIsDiscovered) {
        this.cartridgeIsDiscovered = cartridgeIsDiscovered;
    }

    public void setGunIsDiscovered(boolean gunIsDiscovered) {
        this.gunIsDiscovered = gunIsDiscovered;
    }
}
