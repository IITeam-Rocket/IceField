package models;

/**
 * A strategy of a player to do when they
 * fall in water.
 */
public interface FallInWaterPolicy {
    /**
     * Executes the strategy.
     *
     * @param player the player, who fell in water.
     */
    void executeStrategy(Character player);
}
