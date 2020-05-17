package controllers.view;

import models.figures.Figure;
import models.figures.PolarBear;

public class PolarBearPresenter extends FigurePresenter {
    private final PolarBear bear;

    public PolarBearPresenter(PolarBear bear) {
        super();
        this.bear = bear;
    }

    @Override
    public Figure getFigure() { return bear; }

    @Override
    public void draw(int x, int y) {
        super.draw(x, y);
        //TODO implement draw()


        super.draw(x, y);
    }
}
