package controllers.view;

import models.tiles.Tile;

abstract public class TilePresenter {
    private final int x;
    private final int y;

    public TilePresenter(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        // TODO implement draw()
    }

    abstract public boolean isNeighbour(TilePresenter tile);

    abstract public Tile getTile();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
