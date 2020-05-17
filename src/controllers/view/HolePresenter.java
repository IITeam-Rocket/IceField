package controllers.view;

import controllers.game.GameJFrame;
import models.tiles.Hole;
import models.tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

public class HolePresenter extends TilePresenter implements Serializable {
    private final Hole hole;

    /**
     * Constructor
     * @param hole Hole to present
     * @param x where X
     * @param y where Y
     */
    public HolePresenter(Hole hole, int x, int y) {
        super(x, y);
        this.hole = hole;

        button.setIcon(GameJFrame.getInstance().getTexture("stable"));

        button.setText(Integer.toString(hole.getID()));

        draw();
    }

    /**
     * Draw
     */
    @Override
    public void draw() {
        int snowDepth = hole.getSnowDepth();
        boolean isDiscovered = hole.isAnalyzed();

        ImageIcon base;

        if(!isDiscovered)
        {
            base = GameJFrame.getInstance().getTexture("stable_" + String.valueOf(snowDepth));
            button.setText("");
        }
        else
        {
            base = GameJFrame.getInstance().getTexture("water");
            button.setText("0");
        }

        super.drawFigures(base, hole);
    }

    /**
     * Check if the TilePresenter's Tile whether is a neighbour of the current Tile
     * @param tile TilePresenter to test
     * @return Boolean result
     */
    @Override
    public boolean isNeighbour(TilePresenter tile) {
        return hole.getNeighbours().contains(tile.getTile());
    }

    /**
     * Get Tile
     * @return Tile
     */
    @Override
    public Tile getTile() {
        return hole;
    }
}
