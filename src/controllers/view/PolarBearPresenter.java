package controllers.view;

import controllers.game.GameJFrame;
import models.Environment;
import models.figures.Figure;
import models.figures.PolarBear;
import models.policies.FallInWaterPolicy;
import models.tiles.Tile;

import javax.swing.*;

public class PolarBearPresenter extends FigurePresenter {
    private final PolarBear bear;

    public PolarBearPresenter(PolarBear bear) {
        super();
        this.bear = bear;
    }

    @Override
    public ImageIcon getImage() {
        if(Environment.getInstance().getCurrentPlayer() == bear)
            return GameJFrame.getInstance().getTexture("bear_active");
        else
            return GameJFrame.getInstance().getTexture("bear");
    }

    @Override
    public Figure getFigure() { return bear; }

    @Override
    public void draw(int x, int y) {
        FallInWaterPolicy swimToShoreStrategy = bear.getSwimToShoreStrategy();
        Tile tile = bear.getTile();
        if (Environment.getInstance().getCurrentPlayer() != null) {
            if (Environment.getInstance().getCurrentPlayer().equals(bear)) {
                GameJFrame.getInstance().OutputToTextBox(String.format("polar bear\n\nswimToShoreStrategy: %s\ntile: %d",
                        swimToShoreStrategy.toString(), tile.getID()));
            }
        }
        super.draw(x, y);
        //TODO implement draw()
    }
}
