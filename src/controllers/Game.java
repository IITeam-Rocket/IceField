package controllers;

import controllers.view.MapPresenter;
import models.Environment;
import models.figures.Figure;
import models.tiles.Tile;

import java.util.ArrayList;

public class Game {
    final MapPresenter mp = MapPresenter.getInstance();
    Environment environment = Environment.getInstance();

    public void PlayGame() {
        ArrayList<Tile> tiles = environment.getIceTiles();
        ArrayList<Figure> figures = environment.getPlayers();


        tiles.forEach(t -> {
            t.clear();
            t.register(mp);
        });


        figures.forEach(f -> {
            f.clear();
            f.register(mp);
        });
    }
}
