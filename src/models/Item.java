package models;

/**
 * A class representing a hidden item in the IcePatch.
 * Upon digging it out, it gives the discoverer a bonus.
 */
public abstract class Item {
    /**
     * upon discovery, gives some bonus to the player who dug it up.
     *
     * @param finder the character who discovered the item
     */
    abstract public void uponDiscovery(Character finder);
}
