package controllers.view;

import models.tiles.Tile;

abstract public class TilePresenter {
    private int x, y;

    public void draw() {
        // TODO implement draw()
    }

    abstract public boolean isNeighbour(TilePresenter tile);

    abstract public Tile getTile();
}
