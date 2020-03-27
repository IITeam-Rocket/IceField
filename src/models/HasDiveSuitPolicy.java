package models;

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

    }
}