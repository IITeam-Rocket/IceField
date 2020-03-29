package models.policies;

import models.characters.Character;
import models.tiles.Tile;

import java.util.ArrayList;

import static controllers.TabController.*;

/**
 * A class representing the player's strategy of
 * getting out of water upon falling in it.
 * This strategy is to swim out to the nearest
 * neighbouring Tile.
 */
public class HasDiveSuitPolicy implements FallInWaterPolicy {
    /**
     * Executes the player's strategy of getting out of water
     *
     * @param player the player, who fell in water.
     */
    @Override
    public void executeStrategy(Character player) {

        addIndent();
        printlnWithIndents("HasDiveSuitPolicy.executeStrategy()");

        Tile source = player.getTile();
        ArrayList<Tile> neighbourtiles = source.getNeighbours();

        for(Tile t : neighbourtiles)
        {
            if(t.acceptCharacter(player))
                break;
        }

        source.removeCharacter(player);

        printlnWithIndents("return");
        removeIndent();

    }
}
