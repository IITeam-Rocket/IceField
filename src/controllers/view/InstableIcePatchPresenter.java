package controllers.view;

import models.policies.ProtectionPolicy;
import models.tiles.InstableIcePatch;

public class InstableIcePatchPresenter extends TilePresenter {
    private InstableIcePatch icePatch;

    public InstableIcePatchPresenter(InstableIcePatch icePatch) {
        this.icePatch = icePatch;
    }

    @Override
    public void draw() {
        int snowDepth = icePatch.getSnowDepth();
        ProtectionPolicy po = icePatch.getProtectionStrategy();
        int capacity = icePatch.getCapacity();
        boolean flipped = icePatch.isFlipped();

        //TODO implement further
    }
}
