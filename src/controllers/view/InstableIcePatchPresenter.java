package controllers.view;

import controllers.game.GameJFrame;
import models.policies.ProtectionPolicy;
import models.tiles.InstableIcePatch;
import models.tiles.Tile;

import java.awt.*;

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
