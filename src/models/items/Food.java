package models.items;

import models.figures.Character;

import java.io.Serializable;

/**
 * An Item that gives the finding player bodyHeat.
 *
 * @author Józsa György
 * @version 3.0
 * @since skeleton
 * @since 2020.03.10
 */
public class Food extends Item implements Serializable {
    /**
     * gives the finding player a unit of bodyHeat.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        System.out.println("unburied item: 1");
        finder.addHeat(1);
    }
}
