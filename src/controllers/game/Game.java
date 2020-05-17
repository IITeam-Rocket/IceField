package controllers.game;

import controllers.RandomControllerUtil;
import controllers.TextToCommandInterpreter;
import controllers.view.MapPresenter;
import models.Environment;
import models.figures.Figure;
import models.tiles.Tile;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private final MapPresenter mp = MapPresenter.getInstance();
    private final Environment environment = Environment.getInstance();

    private PrintStream os = System.out;
    private Scanner in = new Scanner(System.in);
    public boolean running = false;

    private final TextToCommandInterpreter cip = new TextToCommandInterpreter(this);

    private final CommandInterpreter commandInterpreter = new CommandInterpreter();

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

        commandInterpreter.interpret(cip.interpreter("input map.txt"));
        running = true;
        while (running) {
            if (in.hasNextLine()) {
                String line = in.nextLine();
                commandInterpreter.interpret(cip.interpreter(line));
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
        commandInterpreter.interpret(cip.interpreter("nextcharacter"));
    }

    /**
     * Do a move using commands
     * @param t Tile to move to
     */
    public void Move(Tile t) {
        commandInterpreter.interpret(cip.interpreter(String.format("move %d", t.getID())));
    }

    /**
     * Do a rescue using the commands
     * @param t Tile to rescue from
     */
    public void Rescue(Tile t){commandInterpreter.interpret(cip.interpreter(String.format("rescue %d", t.getID())));}

    /**
     * Craft the signalflare using commands
     */
    public void CraftSignalFlare() {
        commandInterpreter.interpret(cip.interpreter("craftsignalflare"));
    }

    /**
     * Unbury using the commands
     */
    public void Unbury() {
        commandInterpreter.interpret(cip.interpreter("unbury"));
    }

    /**
     * Clear snow using commands
     */
    public void clearSnow() {
        commandInterpreter.interpret(cip.interpreter("clearsnow"));
    }

    /**
     * Simulate weather using commands
     */
    public void simulateWeather() {
        commandInterpreter.interpret(cip.interpreter("simulateweather"));
    }

    /**
     * Change random using commands
     */
    public void random() {
        if (RandomControllerUtil.getRandom()) {
            commandInterpreter.interpret(cip.interpreter("random off"));
        } else {
            commandInterpreter.interpret(cip.interpreter("random on"));
        }
    }

    /**
     * Use special ability using commands
     * @param t Tile to use ability on
     */
    public void useSpecial(Tile t) {
        commandInterpreter.interpret(cip.interpreter(String.format("usespecial %d", t.getID())));
    }
}
