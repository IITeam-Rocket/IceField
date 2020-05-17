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
import java.io.Serializable;

public class ResearcherPresenter extends FigurePresenter implements Serializable {
    private final Researcher researcher;

    /**
     * Constructor
     * @param researcher The Researcher to present
     */
    public ResearcherPresenter(Researcher researcher) {
        super();
        this.researcher = researcher;
    }

    /**
     * Get the Image to Draw
     * @return ImageIcon
     */
    @Override
    public ImageIcon getImage() {
        if(Environment.getInstance().getCurrentPlayer() == researcher)
            return GameJFrame.getInstance().getTexture("researcher_active");
        else
            return GameJFrame.getInstance().getTexture("researcher");
    }

    /**
     * Get Figure
     * @return Figure
     */
    @Override
    public Figure getFigure() { return researcher; }

    /**
     * Draw
     * @param x where X
     * @param y where Y
     */
    @Override
    public void draw(int x, int y) {
        super.draw(x, y);
        int bodyHeat = researcher.getBodyHeat();
        int stamina = researcher.getStamina();
        ClearSnowPolicy clearSnowPolicy = researcher.getClearPatchStrategy();
        RescueFriendPolicy rescueFriendPolicy = researcher.getHelpFriendStrategy();
        FallInWaterPolicy swimOutPolicy = researcher.getSwimToShoreStrategy();
        Tile tile = researcher.getTile();

        if (Environment.getInstance().getCurrentPlayer() != null) {
            if (Environment.getInstance().getCurrentPlayer().equals(researcher)) {
                GameJFrame.getInstance().CharacterOutInfo(String.format("researcher\n\nbody heat: %d\nstamina: %d\nclearPatchStrategy: %s\nhelpFriendStrategy: %s\nswimToShoreStrategy: %s\ntile: %d",
                        bodyHeat, stamina, clearSnowPolicy.toString(), rescueFriendPolicy.toString(), swimOutPolicy.toString(), tile.getID()));
            }
        }
    }
}
