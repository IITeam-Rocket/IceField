package controllers.view;

import models.policies.ProtectionPolicy;
import models.tiles.StableIcePatch;

public class StableIcePatchPresenter extends TilePresenter {
    private StableIcePatch icePatch;

    public StableIcePatchPresenter(StableIcePatch icePatch) {
        this.icePatch = icePatch;
    }

    @Override
    public void draw() {
        int snowDepth = icePatch.getSnowDepth();
        ProtectionPolicy po = icePatch.getProtectionStrategy();

        //TODO implement further
    }
}
