package controllers.view;

import models.policies.ProtectionPolicy;
import models.tiles.StableIcePatch;
import models.tiles.Tile;

public class StableIcePatchPresenter extends TilePresenter {
    private final StableIcePatch icePatch;

    public StableIcePatchPresenter(StableIcePatch icePatch) {
        this.icePatch = icePatch;
    }

    @Override
    public void draw() {
        int snowDepth = icePatch.getSnowDepth();
        ProtectionPolicy po = icePatch.getProtectionStrategy();

        //TODO implement further
    }

    @Override
    public boolean isNeighbour(TilePresenter tile) {
        return icePatch.getNeighbours().contains(tile.getTile());
    }

    @Override
    public Tile getTile() {
        return icePatch;
    }
}
