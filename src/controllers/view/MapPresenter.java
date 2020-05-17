package controllers.view;

import controllers.game.GameJFrame;
import models.Observer;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class MapPresenter implements Observer  {
    private static final MapPresenter instance = new MapPresenter();

    private MapPresenter() {
        figures = new ArrayList<>();
        tiles = new ArrayList<>();
    }

    private final List<FigurePresenter> figures;
    private final List<TilePresenter> tiles;

    public static MapPresenter getInstance() {
        return instance;
    }

    /**
     * Updates the object.
     */
    @Override
    public void update() {
        tiles.forEach(t -> {
            t.draw();
        });

        figures.forEach(f -> f.draw(getXCoord(f), getYCoord(f)));
        GameJFrame.getInstance().repaint();
    }

    public void afterDraw() {
        tiles.forEach(t -> {
            t.button.grabFocus();
        });
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        Graphics2D g2 = (Graphics2D) g;

        for(int i = 0; i < tiles.size(); i++) {
            for(int j = 0; j < tiles.size(); j++) {
                if (tiles.get(i).isNeighbour(tiles.get(j))) {
                    Line2D lin = new Line2D.Float(tiles.get(i).x, tiles.get(i).y, tiles.get(j).x, tiles.get(j).y);
                    g2.draw(lin);
                }
            }
        }
    }

    public int getXCoord(FigurePresenter figure) {
        // TODO return value
        return 0;
    }

    public int getYCoord(FigurePresenter figure) {
        // TODO return value
        return 0;
    }

    public void addTilePresenter(TilePresenter tile) {
        tiles.add(tile);
    }

    public void addFigurePresenter(FigurePresenter figure) {
        figures.add(figure);
    }
}
