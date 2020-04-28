package models.items;

import models.figures.Character;

import java.io.Serializable;

/**
 * A class representing a tent buried in snow
 * that can be erected, providing one turn of
 * protection from blizzards.
 *
 * @author Józsa György
 * @version 3.0
 * @see models.items.Item
 * @since prototype
 * @since 2020.04.24
 */
public class Tent extends Item implements Serializable {
    /**
     * Builds a tent on the tile.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        System.out.println("unburied item: 9");
        finder.buildTent();
    }
}
