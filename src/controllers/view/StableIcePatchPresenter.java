package controllers.view;

import controllers.game.GameJFrame;
import models.tiles.StableIcePatch;
import models.tiles.Tile;

import javax.swing.*;
import java.io.Serializable;

public class StableIcePatchPresenter extends TilePresenter implements Serializable {
    private final StableIcePatch icePatch;

    /**
     * Constructor
     * @param icePatch StableIcePatch to present
     * @param x where X
     * @param y where Y
     */
    public StableIcePatchPresenter(StableIcePatch icePatch, int x, int y) {
        super(x, y);
        this.icePatch = icePatch;

        button.setIcon(GameJFrame.getInstance().getTexture("stable"));

        button.setText(Integer.toString(icePatch.getID()));

        draw();
    }

    /**
     * Draw
     */
    @Override
    public void draw() {
        int snowDepth = icePatch.getSnowDepth();
        int protectionPriority = icePatch.getProtectionStrategy().getPriority(); //iglu 2 sátor 1 noProtection 0
        boolean analyzed = icePatch.isAnalyzed();

        String Protection = "";
        if (protectionPriority == 2)
            Protection = "_iglu";
        else if (protectionPriority == 1)
            Protection = "_tent";

        ImageIcon base;

        base = GameJFrame.getInstance().getTexture("stable_" + snowDepth + Protection);

        if (analyzed)
            button.setText("-1");
        else
            button.setText("");

        super.drawFigures(base, icePatch);
    }

    /**
     * Check if the TilePresenter's Tile whether is a neighbour of the current Tile
     * @param tile TilePresenter to test
     * @return Boolean result
     */
    @Override
    public boolean isNeighbour(TilePresenter tile) {
        return icePatch.getNeighbours().contains(tile.getTile());
    }

    /**
     * Get Tile
     * @return Tile
     */
    @Override
    public Tile getTile() {
        return icePatch;
    }
}
