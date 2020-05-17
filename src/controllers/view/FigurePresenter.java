package controllers.view;

import controllers.game.GameJFrame;
import models.figures.Figure;
import models.tiles.Tile;

import javax.swing.*;

public abstract class FigurePresenter {

    public abstract Figure getFigure();

    public abstract ImageIcon getImage();

    public void draw(int x, int y) {

    }
}
