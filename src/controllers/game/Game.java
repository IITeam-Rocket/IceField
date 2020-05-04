package controllers.game;

import controllers.view.MapPresenter;
import models.Environment;
import models.figures.Figure;
import models.tiles.Tile;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    final MapPresenter mp = MapPresenter.getInstance();
    Environment environment = Environment.getInstance();

    private PrintStream os = System.out;
    private Scanner in = new Scanner(System.in);
    private boolean running = true;

    CommandInterpreter cip = new CommandInterpreter(this);

    private void InitializeObservers() {
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

    public void PlayGame() {
        InitializeObservers();

        while (running) {
            if (in.hasNextLine()) {
                String line = in.nextLine();

                cip.Interpret(line);
            }
        }
    }

    public void changeOutput(PrintStream out) {
        os = out;
    }

    public void changeInput(Scanner in) {
        this.in = in;
    }

    public PrintStream getOutput() {
        return os;
    }

    public Scanner getInput() {
        return in;
    }
}
