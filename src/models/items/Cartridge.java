package models.items;

import models.Environment;
import models.figures.Character;

import java.io.Serializable;

/**
 * A cartridge that is a part of the SignalFlare
 * needed to win the game.
 *
 * @author Józsa György
 * @version 3.0
 * @since skeleton
 * @since 2020.03.10
 */
public class Cartridge extends Item implements Serializable {
    /**
     * Records that the cartridge has been discovered.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        System.out.println("unburied item: 8");
        Environment.getInstance().recordCartridge();
    }
}
