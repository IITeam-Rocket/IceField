package controllers.view;

import controllers.game.GameJFrame;
import models.tiles.Hole;
import models.tiles.Tile;

import java.awt.*;

public class HolePresenter extends TilePresenter {
    private final Hole hole;

    public HolePresenter(Hole hole, int x, int y) {
        super(x, y);
        this.hole = hole;
    }

    @Override
    public void draw() {
        int snowDepth = hole.getSnowDepth();
        boolean isDiscovered = hole.isAnalyzed();

        button.setPreferredSize(new Dimension(60, 60));
        button.setIcon(GameJFrame.getInstance().getTexture("stable"));
        button.setVisible(true);

        GameJFrame.getInstance().add(button);


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
