package controllers.game;

import controllers.TextToCommandInterpeter;
import controllers.view.MapPresenter;
import models.Environment;
import models.figures.Figure;
import models.tiles.Tile;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private final MapPresenter mp = MapPresenter.getInstance();
    private Environment environment = Environment.getInstance();

    private PrintStream os = System.out;
    private Scanner in = new Scanner(System.in);
    private boolean running = true;

    private TextToCommandInterpeter cip = new TextToCommandInterpeter(this);

    private CommandInterpreter commandInterpreter = new CommandInterpreter(this);

    public Game() {

    }

    private void initializeObservers() {
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

    public void playGame() {
        initializeObservers();

        while (running) {
            if (in.hasNextLine()) {
                String line = in.nextLine();

                commandInterpreter.interpret(cip.interpter(line));
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

    public void endGame() {
        this.running = false;
    }
}
