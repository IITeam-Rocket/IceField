package controllers.game;

import controllers.RandomController;
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
    public boolean running = false;

    private TextToCommandInterpeter cip = new TextToCommandInterpeter(this);

    private CommandInterpreter commandInterpreter = new CommandInterpreter();

    /**
     * Constructor
     */
    public Game() { }

    /**
     * Initialize the observers
     */
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

    /**
     * Interpreter main logic during the game
     */
    public void playGame() {
        initializeObservers();

        commandInterpreter.interpret(cip.interpter("input map.txt"));
        running = true;
        while (running) {
            if (in.hasNextLine()) {
                String line = in.nextLine();
                commandInterpreter.interpret(cip.interpter(line));
            }
        }
    }

    /**
     * Change output
     * @param out The output to change to
     */
    public void changeOutput(PrintStream out) {
        os = out;
    }

    /**
     * Change input
     * @param in The input to change to
     */
    public void changeInput(Scanner in) {
        this.in = in;
    }

    /**
     * Get output
     * @return The current output
     */
    public PrintStream getOutput() {
        return os;
    }

    /**
     * Get input
     * @return The current input
     */
    public Scanner getInput() {
        return in;
    }

    /**
     * Stop the game
     */
    public void endGame() {
        this.running = false;
    }

    /**
     * Next character
     */
    public void NextCharacter() {
        GameJFrame.getInstance().OutputToTextBox("");
        commandInterpreter.interpret(cip.interpter("nextcharacter"));
    }

    /**
     * Do a move using commands
     * @param t Tile to move to
     */
    public void Move(Tile t) {
        commandInterpreter.interpret(cip.interpter(String.format("move %d", t.getID())));
    }

    /**
     * Do a rescue using the commands
     * @param t Tile to rescue from
     */
    public void Rescue(Tile t){commandInterpreter.interpret(cip.interpter(String.format("rescue %d", t.getID())));}

    /**
     * Craft the signalflare using commands
     */
    public void CraftSignalFlare() { commandInterpreter.interpret(cip.interpter("craftsignalflare")); }

    /**
     * Unbury using the commands
     */
    public void Unbury() {
        commandInterpreter.interpret(cip.interpter("unbury"));
    }

    /**
     * Clear snow using commands
     * @param t Tile to clear snow from
     */
    public void clearSnow(Tile t) {
        commandInterpreter.interpret(cip.interpter(String.format("clearsnow %d", t.getID())));
    }

    /**
     * Simulate weather using commands
     */
    public void simulateWeather() {
        commandInterpreter.interpret(cip.interpter("simulateweather"));
    }

    /**
     * Change random using commands
     */
    public void random() {
        if (RandomController.getRandom()) {
            commandInterpreter.interpret(cip.interpter("random off"));
        } else {
            commandInterpreter.interpret(cip.interpter("random on"));
        }
    }

    /**
     * Use special ability using commands
     * @param t Tile to use ability on
     */
    public void useSpecial(Tile t) {
        commandInterpreter.interpret(cip.interpter(String.format("usespecial %d", t.getID())));
    }
}
