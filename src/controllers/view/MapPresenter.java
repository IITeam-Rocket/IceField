package controllers.view;

import controllers.game.Game;
import controllers.game.GameJFrame;
import models.Observer;
import models.figures.Figure;

import java.awt.*;
import java.awt.geom.Line2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MapPresenter implements Observer, Serializable {
    private static final MapPresenter instance = new MapPresenter();

    private MapPresenter() {
        figures = new ArrayList<>();
        tiles = new ArrayList<>();
    }

    private List<FigurePresenter> figures;
    private List<TilePresenter> tiles;

    public static MapPresenter getInstance() {
        return instance;
    }

    public List<FigurePresenter> getFigures() {
        return figures;
    }

    public List<TilePresenter> getTiles() {
        return tiles;
    }

    public void setFigures(List<FigurePresenter> figures) {
        this.figures = figures;
    }

    public void setTiles(List<TilePresenter> tiles) {
        this.tiles = tiles;

        for(int i = 0; i < tiles.size(); i++)
            tiles.get(i).init();
    }

    public FigurePresenter findFigure(Figure figure) {
        for(int i = 0; i < figures.size(); i++) {
            if(figures.get(i).getFigure() == figure)
                return figures.get(i);
        }
        return null;
    }

    public void reset() {
        for(int i = 0; i < tiles.size(); i++)
            tiles.get(i).destory();

        figures.clear();
        tiles.clear();
    }

    /**
     * Updates the object.
     */
    @Override
    public void update() {
        for(int i = 0; i < tiles.size(); i++)
            tiles.get(i).draw();

        for(int i = 0; i < figures.size(); i++)
            figures.get(i).draw(getXCoord(figures.get(i)), getYCoord(figures.get(i)));

        GameJFrame.getInstance().repaint();
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
        for(int i = 0; i < tiles.size(); i++) {
            for(int j = 0; j < tiles.get(i).getTile().getEntities().size(); j++) {
                if(tiles.get(i).getTile().getEntities().get(j) == figure.getFigure())
                    return tiles.get(i).x;
            }
        }

        return -1;
    }

    public int getYCoord(FigurePresenter figure) {
        for(int i = 0; i < tiles.size(); i++) {
            for(int j = 0; j < tiles.get(i).getTile().getEntities().size(); j++) {
                if(tiles.get(i).getTile().getEntities().get(j) == figure.getFigure())
                    return tiles.get(i).y;
            }
        }

        return -1;
    }

    public void addTilePresenter(TilePresenter tile) {
        tiles.add(tile);
    }

    public void addFigurePresenter(FigurePresenter figure) {
        figures.add(figure);
    }
}
