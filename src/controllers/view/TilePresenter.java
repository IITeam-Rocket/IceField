package controllers.view;

abstract public class TilePresenter {
    private int x, y;

    public void draw() {
        // TODO implement draw()
    }

    abstract public boolean isNeighbour(TilePresenter tile);
}
