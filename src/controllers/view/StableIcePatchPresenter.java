package controllers.view;

import controllers.game.GameJFrame;
import models.policies.ProtectionPolicy;
import models.tiles.StableIcePatch;
import models.tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class StableIcePatchPresenter extends TilePresenter implements Serializable {
    private final StableIcePatch icePatch;

    public StableIcePatchPresenter(StableIcePatch icePatch, int x, int y) {
        super(x, y);
        this.icePatch = icePatch;

        button.setIcon(GameJFrame.getInstance().getTexture("stable"));

        button.setText(Integer.toString(icePatch.getID()));

        draw();
    }

    @Override
    public void draw() {
        int snowDepth = icePatch.getSnowDepth();
        int protpririty = icePatch.getProtectionStrategy().getPriority(); //iglu 2 sátor 1 noprot 0
        boolean analyzed = icePatch.isAnalyzed();

        String Protection = new String("");
        if(protpririty == 2)
            Protection = "_iglu";
        else if(protpririty == 1)
            Protection = "_tent";

        ImageIcon base;

        base = GameJFrame.getInstance().getTexture("stable_" + String.valueOf(snowDepth) + Protection);

        if(analyzed)
            button.setText("-1");
        else
            button.setText("");

        super.drawFigures(base, icePatch);
        //SwingUtilities.updateComponentTreeUI(GameJFrame.getInstance());




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
