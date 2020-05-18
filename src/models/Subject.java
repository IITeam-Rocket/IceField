package models;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing an observed entity.
 *
 * @author Józsa György
 * @version 1.0
 * @since graphical
 * @since 2020.04.28.
 */
public class Subject {
    /**
     * List of observing objects to notify on change.
     */
    private List<Observer> observers = new ArrayList<>();

    /**
     * Registers a new Observer object to notify upon change.
     *
     * @param o the new object
     */
    public void register(Observer o) {
        observers.add(o);
    }

    /**
     * Notifies all recorded observers that a change has been made.
     */
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    /**
     * Removes a given Observer object from the list to notify upon change.
     *
     * @param o the object to remove
     */
    public void remove(Observer o) {
        observers.remove(o);
    }

    /**
     * Clears the list of observers to notify upon change.
     */
    public void clear() {
        observers = new ArrayList<>();
    }
}
