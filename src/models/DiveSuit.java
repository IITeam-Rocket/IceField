package models;

/**
 * An item that changes the finder's
 * FallInWaterPolicy.
 */
public class DiveSuit extends Item {
    /**
     * Changes the finder's FallInWaterPolicy to
     * an instance of HasDiveSuitPolicy.
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        finder.changeWaterPolicy(new HasDiveSuitPolicy());
    }
}
