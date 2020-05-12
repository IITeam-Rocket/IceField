package controllers.view;

import models.figures.PolarBear;

public class PolarBearPresenter extends FigurePresenter {
    private final PolarBear bear;

    public PolarBearPresenter(PolarBear bear) {
        this.bear = bear;
    }

    @Override
    public void draw(int x, int y) {
        //TODO implement draw()
        super.draw(x, y);
    }
}
