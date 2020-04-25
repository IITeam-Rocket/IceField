package models;

import models.exceptions.EndOfGameException;
import models.figures.Figure;
import models.tiles.Tile;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

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

    // TODO: 2020. 04. 24. javadoc
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
            System.out.println("Couldn't save with serialization! File " + path + " doesn't exist!");
            return false;
        }
    }

    /**
     * Reads the instance object from the given path using serialization
     *
     * @param path The path where the object should be read from serialized
     * @return Return whether or not the serialization was a success
     */
    public static boolean serializeRead(String path) {
        try {
            FileInputStream f = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(f);
            Environment env = (Environment)in.readObject();

            Tile.setIDCounter(env.getIceTiles().size());

            instance.reset();

            instance.setIceTiles(env.getIceTiles());
            instance.setPlayers(env.getPlayers());
            instance.setCurrentPlayer(env.getCurrentPlayer());

            if(env.isBeaconIsDiscovered())
                instance.recordBeacon();
            if(env.isCartridgeIsDiscovered())
                instance.recordCartridge();
            if(env.isGunIsDiscovered())
                instance.recordGun();

            in.close();

            return true;
        } catch(IOException ex) {
            System.out.println("Couldn't load with serialization! File " + path + " doesn't exist or doesn't contain the correct data!");
            return  false;
        } catch(ClassNotFoundException ex) {
            System.out.println("Couldn't save with serialization! ClassNotFound");
            return false;
        }
    }

    /**
     * Resets the content of the current Environment class
     */
    private void reset()
    {
        iceTiles = new ArrayList<>();
        players = new ArrayList<>();
        currentPlayer = null;
        beaconIsDiscovered = false;
        cartridgeIsDiscovered = false;
        gunIsDiscovered = false;
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
    public void makeStorm() throws EndOfGameException {
        // TODO: 2020. 04. 25. check
        ArrayList<Tile> target = getRandomTiles();
        for (Tile t: target) {
            t.addSnow(1);
            t.reactToStorm();
        }
    }

    /**
     * Randomly chooses a set of tiles.
     *
     * @return a random set of tiles.
     */
    public ArrayList<Tile> getRandomTiles() {
        // TODO: 2020. 04. 25. check
        ArrayList<Tile> randomTiles = new ArrayList();
        Random rand = new Random();
        int numberOfRandomTiles = rand.nextInt(iceTiles.size());
        while(randomTiles.size() != numberOfRandomTiles){
            int nextID = rand.nextInt(iceTiles.size());
            Tile nextTile = iceTiles.get(nextID);
            if(!randomTiles.contains(nextTile))
                randomTiles.add(nextTile);
        }
        return randomTiles;
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
