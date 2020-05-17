package controllers.view;

import controllers.game.GameJFrame;
import models.policies.ProtectionPolicy;
import models.tiles.StableIcePatch;
import models.tiles.Tile;

import javax.swing.*;
import java.awt.*;

public class StableIcePatchPresenter extends TilePresenter {
    private final StableIcePatch icePatch;

    public StableIcePatchPresenter(StableIcePatch icePatch, int x, int y) {
        super(x, y);
        this.icePatch = icePatch;
    }

    @Override
    public void draw() {
        int snowDepth = icePatch.getSnowDepth();
        ProtectionPolicy po = icePatch.getProtectionStrategy();

        button.setBounds(x, y, 60, 60);
        button.setIcon(GameJFrame.getInstance().getTexture("stable"));
        button.setVisible(true);

        GameJFrame.getInstance().add(button);

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
