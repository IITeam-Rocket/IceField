package controllers.view;

import controllers.game.GameJFrame;
import models.tiles.Tile;

import javax.swing.*;

abstract public class TilePresenter {
    protected final int x;
    protected final int y;
    protected JButton button;

    public TilePresenter(int x, int y) {
        this.x = x;
        this.y = y;

        button = new JButton();

        button.setBounds(x, y, 60, 60);
        button.setVisible(true);

        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);

        GameJFrame.getInstance().AddTile(button);
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
