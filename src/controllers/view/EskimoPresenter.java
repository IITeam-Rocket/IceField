package controllers.view;

import models.figures.Eskimo;

public class EskimoPresenter extends FigurePresenter {
    private Eskimo eskimo;

    public EskimoPresenter(Eskimo eskimo) {
        this.eskimo = eskimo;
    }

    @Override
    public void draw(int x, int y) {
        //TODO implement draw()
        super.draw(x, y);
    }
}
