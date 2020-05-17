package controllers.view;

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

    /**
     * Private Constructor, Singleton
     */
    private MapPresenter() {
        figures = new ArrayList<>();
        tiles = new ArrayList<>();
    }

    private List<FigurePresenter> figures;
    private List<TilePresenter> tiles;

    /**
     * Get Singleton instance
     * @return Instance
     */
    public static MapPresenter getInstance() {
        return instance;
    }

    /**
     * Get Figures
     * @return Figures
     */
    public List<FigurePresenter> getFigures() {
        return figures;
    }

    /**
     * Get Tiles
     * @return Tiles
     */
    public List<TilePresenter> getTiles() {
        return tiles;
    }

    /**
     * Set Figures
     * @param figures Figures
     */
    public void setFigures(List<FigurePresenter> figures) {
        this.figures = figures;
    }

    /**
     * Set Tiles
     * @param tiles Tiles
     */
    public void setTiles(List<TilePresenter> tiles) {
        this.tiles = tiles;

        for(int i = 0; i < tiles.size(); i++)
            tiles.get(i).init();

        update();
    }

    /**
     * Find Figure
     * @param figure Figure to find
     * @return FigurePresenter of found Figure
     */
    public FigurePresenter findFigure(Figure figure) {
        for(int i = 0; i < figures.size(); i++) {
            if(figures.get(i).getFigure() == figure)
                return figures.get(i);
        }
        return null;
    }

    /**
     * Reset
     */
    public void reset() {
        for(int i = 0; i < tiles.size(); i++)
            tiles.get(i).destroy();

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

    /**
     * Paint
     * @param g Graphics to draw with
     */
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

    /**
     * Gets X coord
     * @param figure Figure to get X for
     * @return found X
     */
    public int getXCoord(FigurePresenter figure) {
        for(int i = 0; i < tiles.size(); i++) {
            for(int j = 0; j < tiles.get(i).getTile().getEntities().size(); j++) {
                if(tiles.get(i).getTile().getEntities().get(j) == figure.getFigure())
                    return tiles.get(i).x;
            }
        }

        return -1;
    }

    /**
     * Gets Y coord
     * @param figure Figure to get Y for
     * @return found Y
     */
    public int getYCoord(FigurePresenter figure) {
        for(int i = 0; i < tiles.size(); i++) {
            for(int j = 0; j < tiles.get(i).getTile().getEntities().size(); j++) {
                if(tiles.get(i).getTile().getEntities().get(j) == figure.getFigure())
                    return tiles.get(i).y;
            }
        }

        return -1;
    }

    /**
     * Add TilePresenter
     * @param tile TilePresenter to add
     */
    public void addTilePresenter(TilePresenter tile) {
        tiles.add(tile);
    }

    /**
     * Add FigurePresenter
     * @param figure FigurePresenter to add
     */
    public void addFigurePresenter(FigurePresenter figure) {
        figures.add(figure);
    }
}
