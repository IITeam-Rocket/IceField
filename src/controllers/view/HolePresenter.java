package controllers.view;

import models.tiles.Hole;
import models.tiles.Tile;

public class HolePresenter extends TilePresenter {
    private final Hole hole;

    public HolePresenter(Hole hole) {
        this.hole = hole;
    }

    @Override
    public void draw() {
        int snowDepth = hole.getSnowDepth();
        boolean isDiscovered = hole.isAnalyzed();

        //TODO implement further
    }

    @Override
    public boolean isNeighbour(TilePresenter tile) {
        return hole.getNeighbours().contains(tile.getTile());
    }

    @Override
    public Tile getTile() {
        return hole;
    }
}
