package controllers.view;

import models.figures.Eskimo;
import models.figures.Figure;
import models.policies.ClearSnowPolicy;
import models.policies.FallInWaterPolicy;
import models.policies.RescueFriendPolicy;
import models.tiles.Tile;

public class EskimoPresenter extends FigurePresenter {
    private final Eskimo eskimo;

    public EskimoPresenter(Eskimo eskimo) {
        super();
        this.eskimo = eskimo;
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

        //MapPresenter.getInstance().getXCoord(this)
        //TODO implement further
    }
}
