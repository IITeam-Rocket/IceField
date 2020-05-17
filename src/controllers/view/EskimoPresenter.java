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

public class EskimoPresenter extends FigurePresenter {
    private final Eskimo eskimo;

    public EskimoPresenter(Eskimo eskimo) {
        super();
        this.eskimo = eskimo;
    }

    @Override
    public ImageIcon getImage() {
        if(Environment.getInstance().getCurrentPlayer() == eskimo)
            return GameJFrame.getInstance().getTexture("eskimo_active");
        else
            return GameJFrame.getInstance().getTexture("eskimo");
    }

    @Override
    public Figure getFigure() { return eskimo; }

    @Override
    public void draw(int x, int y) {
        super.draw(x, y);
        int bodyHeat = eskimo.getBodyHeat();
        int stamina = eskimo.getStamina();
        ClearSnowPolicy clearSnowPolicy = eskimo.getclearPatchStrategy();
        RescueFriendPolicy rescueFriendPolicy = eskimo.getHelpFriendStrategy();
        FallInWaterPolicy swimOutPolicy = eskimo.getSwimToShoreStrategy();
        Tile tile = eskimo.getTile();
        if (Environment.getInstance().getCurrentPlayer() != null) {
            if (Environment.getInstance().getCurrentPlayer().equals(eskimo)) {
                GameJFrame.getInstance().OutputToTextBox(String.format("eskimo\n\nbodyheat: %d\nstamina: %d\nclearPatchStrategy: %s\nhelpFriendStrategy: %s\nswimToShoreStrategy: %s\ntile: %d",
                        bodyHeat, stamina, clearSnowPolicy.toString(), rescueFriendPolicy.toString(), swimOutPolicy.toString(), tile.getID()));
            }
        }
    }
}
