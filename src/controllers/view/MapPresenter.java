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

    private List<FigurePresenter> figures;
    private List<TilePresenter> tiles;

    public static MapPresenter getInstance() {
        return instance;
    }

    /**
     * Updates the object.
     */
    @Override
    public void update() {

    }

    public int getXCoord(FigurePresenter figure) {
        // TODO return value
        return 0;
    }

    public int getYCoord(FigurePresenter figure) {
        // TODO return value
        return 0;
    }
}
