package controllers.view;

import models.figures.Figure;
import models.tiles.Tile;

public abstract class FigurePresenter {

    public abstract Figure getFigure();

    public void draw(int x, int y) {

    }
}
