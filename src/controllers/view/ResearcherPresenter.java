package controllers.view;

import models.figures.Researcher;
import models.policies.ClearSnowPolicy;
import models.policies.FallInWaterPolicy;
import models.policies.RescueFriendPolicy;
import models.tiles.Tile;

public class ResearcherPresenter extends FigurePresenter {
    private final Researcher researcher;

    public ResearcherPresenter(Researcher researcher) {
        this.researcher = researcher;
    }

    @Override
    public void draw(int x, int y) {
        int bodyHeat = researcher.getBodyHeat();
        int stamina = researcher.getStamina();
        ClearSnowPolicy clearSnowPolicy = researcher.getclearPatchStrategy();
        RescueFriendPolicy rescueFriendPolicy = researcher.getHelpFriendStrategy();
        FallInWaterPolicy swimOutPolicy = researcher.getSwimToShoreStrategy();
        Tile tile = researcher.getTile();

        //TODO implement further
    }
}
