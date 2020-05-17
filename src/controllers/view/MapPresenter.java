package controllers.view;

import models.Observer;

import java.util.ArrayList;
import java.util.List;

public class MapPresenter implements Observer {
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
            tiles.forEach(t::isNeighbour);
            //TODO what now?
        });

        figures.forEach(f -> f.draw(getXCoord(f), getYCoord(f)));
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
