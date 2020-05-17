package models;

import controllers.game.GameJFrame;
import models.exceptions.EndOfGameException;
import models.figures.Figure;
import models.tiles.Tile;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Singleton class representing the Environment.
 * It contains the environmental state such as the relationship between Tiles and making a storm.
 *
 * @author Józsa György
 * @version 3.0
 * @since skeleton
 * @since 2020.03.10
 */

public class Environment implements Serializable {

    /**
     * The only live instance of the class.
     */
    static private final Environment instance = new Environment();
    /**
     * Contains the Tile's of the game.
     */
    private ArrayList<Tile> iceTiles = new ArrayList<>();
    /**
     * Contains the Figure's of the game.
     */
    private ArrayList<Figure> players = new ArrayList<>();
    /**
     * The player, who is currently on turn.
     */
    private Figure currentPlayer;
    /**
     * Shows that the beacon is discovered or not.
     */
    private boolean beaconIsDiscovered = false;
    /**
     * Shows that the cartridge is discovered or not.
     */
    private boolean cartridgeIsDiscovered = false;
    /**
     * Shows that the gun is discovered or not.
     */
    private boolean gunIsDiscovered = false;

    private Tile beaconLocation = null;

    private Tile cartidgeLocation = null;

    private Tile gunLocation = null;

    /**
     * Creates a new Environment.
     */
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
     * Writes the instance object to the given path using serialization
     *
     * @param path The path where the object should be written serialized
     *
     * @return Return whether or not the serialization was a success
     */
    public static boolean serializeWrite(String path) {
        try {
            FileOutputStream f = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(instance);
            out.close();
            return true;
        } catch (IOException ex) {
            System.out.println("File " + path + " doesn't exist!");
            return false;
        }
    }

    /**
     * Reads the instance object from the given path using serialization
     *
     * @param path The path where the object should be read from serialized
     *
     * @return Return whether or not the serialization was a success
     */
    public static boolean serializeRead(String path) {
        try {
            FileInputStream f = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(f);
            Environment env = (Environment) in.readObject();

            Tile.setIDCounter(env.getIceTiles().size());

            instance.reset();

            instance.setIceTiles(env.getIceTiles());
            instance.setPlayers(env.getPlayers());
            instance.setCurrentPlayer(env.getCurrentPlayer());

            if (env.isBeaconIsDiscovered())
                instance.recordBeacon(env.getBeaconLocation());

            if (env.isCartridgeIsDiscovered())
                instance.recordCartridge(env.getCartidgeLocation());

            if (env.isGunIsDiscovered())
                instance.recordGun(env.getGunLocation());


            in.close();

            return true;
        } catch (IOException ex) {
            System.out.println("Couldn't load with serialization! File " + path + " doesn't exist or doesn't contain the correct data!");
            return false;
        } catch (ClassNotFoundException ex) {
            System.out.println("Couldn't save with serialization! ClassNotFound");
            return false;
        }
    }

    /**
     * Resets the content of the current Environment class
     */
    public void reset() {
        iceTiles = new ArrayList<>();
        players = new ArrayList<>();
        currentPlayer = null;
        beaconIsDiscovered = false;
        cartridgeIsDiscovered = false;
        gunIsDiscovered = false;
        Tile.setIDCounter(0);
    }

    /**
     * Records the discovery of Beacon.
     */
    public void recordBeacon(Tile tile) {
        this.beaconIsDiscovered = true;
        setBeaconLocation(tile);
    }

    /**
     * Records the discovery of Cartridge.
     */
    public void recordCartridge(Tile tile) {
        this.cartridgeIsDiscovered = true;
        setCartidgeLocation(tile);
    }

    /**
     * Records the discovery of Gun.
     */
    public void recordGun(Tile tile) {
        this.gunIsDiscovered = true;
        setGunLocation(tile);
    }

    /**
     * Initiates a storm that fills the Tiles with snow,
     * and takes the Characters' body-heat.
     *
     * @throws EndOfGameException if a player character
     *                            dies
     */
    public void makeStorm() throws EndOfGameException {
        ArrayList<Tile> target = getRandomTiles();
        for (Tile t : target)
            t.reactToStorm();
    }

    /**
     * Randomly chooses a set of tiles.
     *
     * @return a random set of tiles.
     */
    private ArrayList<Tile> getRandomTiles() {
        ArrayList<Tile> randomTiles = new ArrayList<>();
        Random rand = new Random();
        int numberOfRandomTiles = rand.nextInt(iceTiles.size());
        if (iceTiles.size() == 1)
            numberOfRandomTiles = 1;
        while (randomTiles.size() != numberOfRandomTiles) {
            int nextID = rand.nextInt(iceTiles.size());
            Tile nextTile = iceTiles.get(nextID);
            if (!randomTiles.contains(nextTile))
                randomTiles.add(nextTile);
        }
        return randomTiles;
    }

    /**
     * Returns with a list of all the Tiles present in the game
     *
     * @return the list of Tiles in the game
     */
    public ArrayList<Tile> getIceTiles() {
        return iceTiles;
    }

    private void setIceTiles(ArrayList<Tile> iceTiles) {
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

    private void setPlayers(ArrayList<Figure> players) {
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

    protected void setCurrentPlayer(Figure currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setCurrentPlayer(int ID) {
        this.currentPlayer = this.players.get(ID);
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

    protected void setBeaconIsDiscovered(boolean beaconIsDiscovered) {
        this.beaconIsDiscovered = beaconIsDiscovered;
    }

    public Tile getBeaconLocation() {
        return beaconLocation;
    }

    private void setBeaconLocation(Tile tile) {
        beaconLocation = tile;
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

    protected void setCartridgeIsDiscovered(boolean cartridgeIsDiscovered) {
        this.cartridgeIsDiscovered = cartridgeIsDiscovered;
    }

    public Tile getCartidgeLocation() {
        return cartidgeLocation;
    }

    private void setCartidgeLocation(Tile tile) {
        cartidgeLocation = tile;
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

    protected void setGunIsDiscovered(boolean gunIsDiscovered) {
        this.gunIsDiscovered = gunIsDiscovered;
    }

    public Tile getGunLocation() {
        return gunLocation;
    }

    private void setGunLocation(Tile tile) {
        gunLocation = tile;
    }

    /**
     * Plays the winning game sequence.
     */
    public void winGame() {
        if (gunIsDiscovered && beaconIsDiscovered && cartridgeIsDiscovered)
            System.out.println("signal flare crafted");
        else
            System.out.println("at least one part is missing");
    }

    /**
     * Plays the losing game sequence.
     */
    public void gameOver() {
        GameJFrame.getInstance().OutputToTextBox("Game over!");
        GameJFrame.getInstance().showEndGameDialog();
    }
}
