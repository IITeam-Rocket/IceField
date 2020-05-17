package controllers.view;

import controllers.game.GameJFrame;
import models.Environment;
import models.figures.Eskimo;
import models.figures.Figure;
import models.policies.ClearSnowPolicy;
import models.policies.FallInWaterPolicy;
import models.policies.RescueFriendPolicy;
import models.tiles.Tile;

import javax.swing.*;
import java.io.Serializable;

public class EskimoPresenter extends FigurePresenter implements Serializable {
    private final Eskimo eskimo;

    /**
     * Constructor
     * @param eskimo The Eskimo to present
     */
    public EskimoPresenter(Eskimo eskimo) {
        super();
        this.eskimo = eskimo;
    }

    /**
     * Get the Image to Draw
     * @return ImageIcon
     */
    @Override
    public ImageIcon getImage() {
        if(Environment.getInstance().getCurrentPlayer() == eskimo)
            return GameJFrame.getInstance().getTexture("eskimo_active");
        else
            return GameJFrame.getInstance().getTexture("eskimo");
    }

    /**
     * Get Figure
     * @return Figure
     */
    @Override
    public Figure getFigure() { return eskimo; }

    /**
     * Draw
     * @param x where X
     * @param y where Y
     */
    @Override
    public void draw(int x, int y) {
        super.draw(x, y);
        int bodyHeat = eskimo.getBodyHeat();
        int stamina = eskimo.getStamina();
        ClearSnowPolicy clearSnowPolicy = eskimo.getClearPatchStrategy();
        RescueFriendPolicy rescueFriendPolicy = eskimo.getHelpFriendStrategy();
        FallInWaterPolicy swimOutPolicy = eskimo.getSwimToShoreStrategy();
        Tile tile = eskimo.getTile();
        if (Environment.getInstance().getCurrentPlayer() != null && Environment.getInstance().getCurrentPlayer().equals(eskimo)) {
            GameJFrame.getInstance().characterOutInfo(String.format("eskimo\n\nbody heat: %d\nstamina: %d\nclearPatchStrategy: %s\nhelpFriendStrategy: %s\nswimToShoreStrategy: %s\ntile: %d",
                    bodyHeat, stamina, clearSnowPolicy.toString(), rescueFriendPolicy.toString(), swimOutPolicy.toString(), tile.getID()));
        }
    }
}
