package controllers;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that controls the randomness
 * of the game.
 *
 * @author Józsa György
 * @version 1.0
 * @since prototype
 * @since 2020.04.24
 */
public class RandomControllerUtil {

    /**
     * Boolean flag signifying whether
     * the randomness of the game is
     * turned on or off.
     */
    static private boolean random = true;

    /**
     * List of listeners
     */
    static private final List<RandomListener> listeners = new ArrayList<>();

    /**
     * Add Listener
     *
     * @param rl Listener to add
     */
    static public void addListener(RandomListener rl) {
        listeners.add(rl);
    }

    /**
     * Returns with the randomness-value of
     * the game.
     *
     * @return true if random is true,
     * false otherwise
     */
    static public boolean getRandom() {
        return random;
    }

    /**
     * Sets the randomness-value to the
     * parameter value
     *
     * @param newValue the new value of randomness
     */
    static public void setRandom(boolean newValue) {
        random = newValue;
        listeners.forEach(rl -> rl.onRandomChange(random));
    }

    /**
     * Switches the randomness on or off
     * depending on the current state.
     */
    static public void switchRandomness() {
        random = !random;
    }
}