package controllers.view;

import controllers.game.GameJFrame;
import models.Environment;
import models.figures.Figure;
import models.figures.PolarBear;

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
        super.draw(x, y);
        //TODO implement draw()
    }
}
