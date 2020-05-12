package controllers.view;

import models.tiles.Hole;

public class HolePresenter extends TilePresenter {
    private final Hole hole;

    public HolePresenter(Hole hole) {
        this.hole = hole;
    }

    @Override
    public void draw() {
        int snowDepth = hole.getSnowDepth();
        boolean isDicovered = hole.isAnalyzed();

        //TODO implement further
    }
}
