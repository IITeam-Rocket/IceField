package controllers.view;

import controllers.game.GameJFrame;
import models.figures.Figure;
import models.tiles.Tile;

import javax.swing.*;
import java.io.Serializable;

public abstract class FigurePresenter implements Serializable {
    /**
     * Get Figure
     * @return Figure
     */
    public abstract Figure getFigure();

    /**
     * Get Image
     * @return ImageIcon
     */
    public abstract ImageIcon getImage();

    /**
     * Draw
     * @param x where X
     * @param y where Y
     */
    public void draw(int x, int y) {

    }
}
