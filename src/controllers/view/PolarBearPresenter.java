package controllers.view;

import controllers.game.GameJFrame;
import models.Environment;
import models.figures.Figure;
import models.figures.PolarBear;
import models.policies.FallInWaterPolicy;
import models.tiles.Tile;

import javax.swing.*;
import java.io.Serializable;

public class PolarBearPresenter extends FigurePresenter implements Serializable {
    private final PolarBear bear;

    /**
     * Constructor
     */
    public PolarBearPresenter(PolarBear bear) {
        super();
        this.bear = bear;
    }

    /**
     * Get Image
     * @return ImageIcon
     */
    @Override
    public ImageIcon getImage() {
        if(Environment.getInstance().getCurrentPlayer() == bear)
            return GameJFrame.getInstance().getTexture("bear_active");
        else
            return GameJFrame.getInstance().getTexture("bear");
    }

    /**
     * Get Figure
     * @return Figure
     */
    @Override
    public Figure getFigure() { return bear; }

    /**
     * Draw
     * @param x where X
     * @param y where Y
     */
    @Override
    public void draw(int x, int y) {
        FallInWaterPolicy swimToShoreStrategy = bear.getSwimToShoreStrategy();
        Tile tile = bear.getTile();
        if (Environment.getInstance().getCurrentPlayer() != null) {
            if (Environment.getInstance().getCurrentPlayer().equals(bear)) {
                GameJFrame.getInstance().CharacterOutInfo(String.format("polar bear\n\nswimToShoreStrategy: %s\ntile: %d",
                        swimToShoreStrategy.toString(), tile.getID()));
            }
        }
        super.draw(x, y);
    }
}
