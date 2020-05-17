package controllers.view;

import models.policies.ProtectionPolicy;
import models.tiles.InstableIcePatch;
import models.tiles.Tile;

public class InstableIcePatchPresenter extends TilePresenter {
    private final InstableIcePatch icePatch;

    public InstableIcePatchPresenter(InstableIcePatch icePatch, int x, int y) {
        super(x, y);
        this.icePatch = icePatch;
    }

    @Override
    public void draw() {
        int snowDepth = icePatch.getSnowDepth();
        ProtectionPolicy po = icePatch.getProtectionStrategy();
        int capacity = icePatch.getCapacity();
        boolean flipped = icePatch.isFlipped();

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
