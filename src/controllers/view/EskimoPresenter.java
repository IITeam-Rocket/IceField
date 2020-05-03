package controllers.view;

import models.figures.Eskimo;
import models.policies.ClearSnowPolicy;
import models.policies.FallInWaterPolicy;
import models.policies.RescueFriendPolicy;
import models.tiles.Tile;

public class EskimoPresenter extends FigurePresenter {
    private Eskimo eskimo;

    public EskimoPresenter(Eskimo eskimo) {
        this.eskimo = eskimo;
    }

    @Override
    public void draw(int x, int y) {
        int bodyHeat = eskimo.getBodyHeat();
        int stamina = eskimo.getStamina();
        ClearSnowPolicy clearSnowPolicy = eskimo.getclearPatchStrategy();
        RescueFriendPolicy rescueFriendPolicy = eskimo.getHelpFriendStrategy();
        FallInWaterPolicy swimOutPolicy = eskimo.getSwimToShoreStrategy();
        Tile tile = eskimo.getTile();

        //TODO implement further
    }
}
