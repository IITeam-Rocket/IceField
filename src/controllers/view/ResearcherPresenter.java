package controllers.view;

import controllers.game.GameJFrame;
import models.Environment;
import models.figures.Figure;
import models.figures.Researcher;
import models.policies.ClearSnowPolicy;
import models.policies.FallInWaterPolicy;
import models.policies.RescueFriendPolicy;
import models.tiles.Tile;

import javax.swing.*;

public class ResearcherPresenter extends FigurePresenter {
    private final Researcher researcher;

    public ResearcherPresenter(Researcher researcher) {
        super();
        this.researcher = researcher;
    }

    @Override
    public ImageIcon getImage() {
        if(Environment.getInstance().getCurrentPlayer() == researcher)
            return GameJFrame.getInstance().getTexture("researcher_active");
        else
            return GameJFrame.getInstance().getTexture("researcher");
    }

    @Override
    public Figure getFigure() { return researcher; }

    @Override
    public void draw(int x, int y) {
        super.draw(x, y);
        int bodyHeat = researcher.getBodyHeat();
        int stamina = researcher.getStamina();
        ClearSnowPolicy clearSnowPolicy = researcher.getclearPatchStrategy();
        RescueFriendPolicy rescueFriendPolicy = researcher.getHelpFriendStrategy();
        FallInWaterPolicy swimOutPolicy = researcher.getSwimToShoreStrategy();
        Tile tile = researcher.getTile();

        //TODO implement further
    }
}
