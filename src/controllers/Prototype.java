package controllers;

import models.Environment;
import models.exceptions.EndOfGameException;
import models.figures.Eskimo;
import models.figures.Figure;
import models.figures.PolarBear;
import models.figures.Researcher;
import models.items.*;
import models.tiles.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *  A class which controls the Prototype version and it's main purpose is to interpret console commands and give feedback
 */
public class Prototype {
    private Scanner in;
    private boolean file;
    private boolean running;
    private PrintStream console;
    private int currentPlayerID;
    private boolean isDev;

    public Prototype() {
        isDev = false;
    }

    public Prototype(boolean dev) {
        isDev = dev;
    }
    /**
     * Prints the info about the creators of the program
     */
    private void printInfo() {
        System.out.println("Szoftver projekt laboratórium - Prototípus");
        System.out.println("21 - team_rocket");
        System.out.println();
        System.out.println("Konzulens: Dr. Goldschmidt Balázs");
        System.out.println();
        System.out.println("Ábrahám Dániel          DASGYJ  d.abraham96@icloud.com");
        System.out.println("Matyasi Lilla Nóra      X986BV  lilla.matyasi@gmail.com");
        System.out.println("Kovács Marcell          U1UOXZ  kovacs.marcell99@gmail.com");
        System.out.println("Józsa György Bence      PAYR41  jozsa.gyuri9910@gmail.com");
        System.out.println("Tóth Máté               HBFE3R  extralarge3@gmail.com");
        System.out.println();
    }

    /**
     * Prints the item IDs
     */
    private void printItems()
    {
        System.out.println("1 food");
        System.out.println("2 rope");
        System.out.println("3 fragile shovel");
        System.out.println("4 shovel");
        System.out.println("5 divesuit");
        System.out.println("6 beacon");
        System.out.println("7 gun");
        System.out.println("8 cartridge");
        System.out.println("9 tent");
    }

    /**
     * Prints the character IDs
     */
    private void printCharacters()
    {
        System.out.println("1 eskimo");
        System.out.println("2 researcher");
        System.out.println("3 polarbear");
    }

    /**
     * Interprets the command input
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_input(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;

        if(lineParts[1].equals("console")) {
            System.out.println("set input: console");
            in = new Scanner(System.in);
            return;
        }

        try {
            System.out.println("set input: " + lineParts[1]);
            in = new Scanner(new File(lineParts[1]));
        } catch (FileNotFoundException e) {
            System.out.println("File " + lineParts[1] + " doesn't exist!");
        }
    }

    /**
     * Interprets the command output
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_output(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;

        if(lineParts[1].equals("console")) {
            System.out.println("set output: console");
            System.setOut(console);
            System.out.println("set output: console");
            return;
        }

        try {
            PrintStream o = new PrintStream(new File(lineParts[1]));
            System.out.println("set output: " + lineParts[1]);
            System.setOut(o);
            System.out.println("set output: " + lineParts[1]);
        } catch (FileNotFoundException e) {
            System.out.println("File " + lineParts[1] + " doesn't exist!");
        }
    }

    /**
     * Interprets the command load
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_load(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;

        if(Environment.serializeRead(lineParts[1]))
            System.out.println("loaded: " + lineParts[1]);
    }

    /**
     * Interprets the command save
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_save(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;

        if(Environment.serializeWrite(lineParts[1]))
            System.out.println("saved: " + lineParts[1]);
    }

    /**
     * Interprets the command random
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_random(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;

        if(lineParts[1].equals("on")) {
            RandomController.setRandom(true);
            System.out.println("set random: on");
        }
        else if(lineParts[1].equals("off")) {
            RandomController.setRandom(true);
            System.out.println("set random: off");
        }
        else
            invalidParameter("random", lineParts[1]);
    }

    /**
     * Interprets the command nextcharacter
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_nextcharacter(String[] lineParts) {
        if(Environment.getInstance().getPlayers().size() == 0) {
            System.out.println("There are currently no characters!");
            return;
        }

        if(Environment.getInstance().getCurrentPlayer() == null) {
            Environment.getInstance().setCurrentPlayer(Environment.getInstance().getPlayers().get(0));
            currentPlayerID = 0;
        }
        else {
            if (currentPlayerID == Environment.getInstance().getPlayers().size() - 1) {
                currentPlayerID = 0;
                //TODO: End round
                System.out.println("Ending round...");
                for (Tile t : Environment.getInstance().getIceTiles()) {
                    try {
                        t.step();
                    } catch (EndOfGameException e) {
                        Environment.getInstance().winGame();
                    }
                }
            }
            else
                currentPlayerID++;

            Environment.getInstance().setCurrentPlayer(Environment.getInstance().getPlayers().get(currentPlayerID));

            Environment.getInstance().getCurrentPlayer().step();
        }

        //TODO: Implement PolearBear Stuff, when random is on and when random is off

        //TODO: Implement logic

    }

    /**
     * Interprets the command move
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_move(String[] lineParts) {
        if(Environment.getInstance().getCurrentPlayer() == null) {
            System.out.println("There is no Figure selected, please use the \"nextcharacter\" command before the first move!");
            return;
        }

        Tile currentTile = Environment.getInstance().getCurrentPlayer().getTile();

        if(!checkParamNumNoErrorMessage(lineParts, 1)) {
            System.out.print("neighbours: ");
            for(Tile tile : currentTile.getNeighbours()) {
                System.out.print(tile.getID() + " ");
            }
            System.out.println();
        }
        else {
            int tileID;

            try {
                tileID = Integer.parseInt(lineParts[1]);
            }
            catch (NumberFormatException e) {
                invalidParameter("move", lineParts[1]);
                return;
            }

            for(Tile tile : currentTile.getNeighbours()) {
                if(tile.getID() == tileID) {
                    Environment.getInstance().getCurrentPlayer().moveTo(tile);
                    System.out.println("move character to " + tileID + ": successful");
                    return;
                }
            }

            System.out.println("move character to " + tileID + ": unsuccessful");
            System.out.println("The current Tile has no neighbour with the ID " + tileID);
        }
    }

    /**
     * Interprets the command unbury
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_unbury(String[] lineParts) {
        if(Environment.getInstance().getCurrentPlayer() == null) {
            System.out.println("There is no Figure selected, please use the \"nextcharacter\" command before the first unbury!");
            return;
        }

        Figure figure = Environment.getInstance().getCurrentPlayer();

        if(figure.getBaseBodyHeat() == -1)
            System.out.println("The polarbear can't unbury!");
        else if(figure.getBaseBodyHeat() == 4)
            ((Researcher)figure).retrieveItem();
        else if(figure.getBaseBodyHeat() == 5)
            ((Eskimo)figure).retrieveItem();
        else
            System.out.println("Unknown Figure Type!");
    }

    /**
     * Interprets the command clearsnow
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_clearsnow(String[] lineParts) {
        if(Environment.getInstance().getCurrentPlayer() == null) {
            System.out.println("There is no Figure selected, please use the \"nextcharacter\" command before the first clearsnow!");
            return;
        }

        Figure figure = Environment.getInstance().getCurrentPlayer();

        if(figure.getBaseBodyHeat() == -1)
            System.out.println("The polarbear can't clearsnow!");
        else if(figure.getBaseBodyHeat() == 4)
            ((Researcher)figure).clearPatch();
        else if(figure.getBaseBodyHeat() == 5)
            ((Eskimo)figure).clearPatch();
        else
            System.out.println("Unknown Figure Type!");
    }

    /**
     * Interprets the command simulateweather
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_simulateweather(String[] lineParts) {
        Environment.getInstance().makeStorm();
        System.out.println("weather simulated");
    }

    /**
     * Interprets the command rescue
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_rescue(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;

        if(Environment.getInstance().getCurrentPlayer() == null) {
            System.out.println("There is no Figure selected, please use the \"nextcharacter\" command before the first rescue!");
            return;
        }

        Figure figure = Environment.getInstance().getCurrentPlayer();

        int tileID;

        try {
            tileID = Integer.parseInt(lineParts[1]);
        }
        catch (NumberFormatException e) {
            invalidParameter("rescue", lineParts[1]);
            return;
        }

        if(Environment.getInstance().getIceTiles().size() - 1 < tileID || tileID < 0) {
            System.out.println("Tile ID must be between 0 and the maximum ID of " + (Environment.getInstance().getIceTiles().size() - 1));
            return;
        }

        boolean found = false;

        Figure characterToRescue = null;

        for(Tile tile : Environment.getInstance().getIceTiles()) {
            if (tile.getID() == tileID) {
                found = true;
                if(tile.getEntities().size() == 0) {
                    System.out.println("There are no characters on this tile!");
                    return;
                }

                boolean nonPolarBear = false;
                for(Figure f : tile.getEntities()) {
                    if(f.getBaseBodyHeat() != -1) {
                        nonPolarBear = true;
                        characterToRescue = f;
                        break;
                    }
                }

                if(!nonPolarBear) {
                    System.out.println("There are no non polarbear characters on this tile!");
                    return;
                }

                break;
            }
        }

        if(figure.getBaseBodyHeat() == -1)
            System.out.println("The polarbear can't rescue!");
        else if(figure.getBaseBodyHeat() == 4)
            ((Researcher)figure).rescueFriend((models.figures.Character) characterToRescue);
        else if(figure.getBaseBodyHeat() == 5)
            ((Eskimo)figure).rescueFriend((models.figures.Character) characterToRescue);
        else
            System.out.println("Unknown Figure!");
    }

    /**
     * Interprets the command craftsignalflare
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_craftsignalflare(String[] lineParts) {
        if(Environment.getInstance().getCurrentPlayer() == null) {
            System.out.println("There is no Figure selected, please use the \"nextcharacter\" command before the first craftsignalflare!");
            return;
        }

        if(!Environment.getInstance().isBeaconIsDiscovered() || !Environment.getInstance().isGunIsDiscovered() || !Environment.getInstance().isCartridgeIsDiscovered())
            System.out.print("Cant't craft Signal Flare, ");

        if(!Environment.getInstance().isBeaconIsDiscovered())
            System.out.print("beacon ");
        if(!Environment.getInstance().isGunIsDiscovered())
            System.out.print("gun ");
        if(!Environment.getInstance().isCartridgeIsDiscovered())
            System.out.print("cartridge ");

        if(!Environment.getInstance().isBeaconIsDiscovered() || !Environment.getInstance().isGunIsDiscovered() || !Environment.getInstance().isCartridgeIsDiscovered()) {
            System.out.println(" missing!");
            return;
        }

        //TODO: Tudni kéne milyen karakterrel van dolgunk a medve havat lapátolni
    }

    /**
     * Interprets the command buildiglu
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_buildiglu(String[] lineParts) {
        if(Environment.getInstance().getCurrentPlayer() == null) {
            System.out.println("There is no Figure selected, please use the \"nextcharacter\" command before the first buildiglu!");
            return;
        }

        //TODO: Tudni kéne milyen karakterrel van dolgunk a medve havat lapátolni
    }

    /**
     * Interprets the command buildtent
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_buildtent(String[] lineParts) {
        if(Environment.getInstance().getCurrentPlayer() == null) {
            System.out.println("There is no Figure selected, please use the \"nextcharacter\" command before the first buildtent!");
            return;
        }

        //TODO: Tudni kéne milyen karakterrel van dolgunk a medve havat lapátolni
    }

    /**
     * Interprets the command analyzetile
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_analyzetile(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;

        if(Environment.getInstance().getCurrentPlayer() == null) {
            System.out.println("There is no Figure selected, please use the \"nextcharacter\" command before the first analyzetile!");
            return;
        }

        //TODO: Tudni kéne milyen karakterrel van dolgunk a medve havat lapátolni
    }

    /**
     * Interprets the command addtile
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_addtile(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;

        Tile tile;

        if(lineParts[1].equals("hole"))
            tile = new Hole();
        else if(lineParts[1].equals("stable"))
            tile = new StableIcePatch();
        else if(lineParts[1].equals("instable")) {
            if(!checkParamNum(lineParts, 2))
                return;

            try {
                int capacity = Integer.parseInt(lineParts[2]);

                if(capacity <= 0) {
                    System.out.println("Instable IcePatch capacity needs to be greater than 0!");
                    return;
                }

                tile = new InstableIcePatch(capacity);
            }
            catch (NumberFormatException e) {
                invalidParameter("addtile instable", lineParts[2]);
                return;
            }
        }
        else {
            invalidParameter("addtile", lineParts[1]);
            return;
        }
        System.out.println("tile added");
        System.out.println("type: " + lineParts[1]);
        System.out.println("ID: " + tile.getID());

        Environment.getInstance().getIceTiles().add(tile);
    }

    /**
     * Interprets the command neighbourtile
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_neighbourtile(String[] lineParts) {
        if(!checkParamNum(lineParts, 2))
            return;

        int firstID, secondID;

        try {
            firstID = Integer.parseInt(lineParts[1]);
        }
        catch (NumberFormatException e) {
            invalidParameter("neighbourtile", lineParts[1]);
            return;
        }

        try {
            secondID = Integer.parseInt(lineParts[2]);
        }
        catch (NumberFormatException e) {
            invalidParameter("neighbourtile " + lineParts[1], lineParts[2]);
            return;
        }

        if(Environment.getInstance().getIceTiles().size() - 1 < firstID || firstID < 0 || Environment.getInstance().getIceTiles().size() - 1 < secondID || secondID < 0) {
            System.out.println("Tile IDs must be between 0 and the maximum ID of " + (Environment.getInstance().getIceTiles().size() - 1));
            return;
        }

        if(firstID == secondID) {
            System.out.println("A tile can't be it's own neighbour!");
            return;
        }

        Tile firstTile = Environment.getInstance().getIceTiles().get(firstID);
        Tile secondTile = Environment.getInstance().getIceTiles().get(secondID);

        for(Tile tile : firstTile.getNeighbours()) {
            if(tile == secondTile) {
                System.out.println("These tiles are already neighbours!");
                return;
            }
        }

        for(Tile tile : secondTile.getNeighbours()) {
            if(tile == firstTile) {
                System.out.println("These tiles are already neighbours!");
                return;
            }
        }

        firstTile.getNeighbours().add(secondTile);
        secondTile.getNeighbours().add(firstTile);

        System.out.println("neighbours: " + firstID + ", " + secondID);
    }

    /**
     * Interprets the command additemtotile
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_additemtotile(String[] lineParts) {
        if(!checkParamNumNoErrorMessage(lineParts, 2)) {
            printItems();
        }
        else {
            int tileID;
            int itemID;

            try {
                tileID = Integer.parseInt(lineParts[1]);
            }
            catch (NumberFormatException e) {
                invalidParameter("additemtotile", lineParts[1]);
                return;
            }

            try {
                itemID = Integer.parseInt(lineParts[2]);
            }
            catch (NumberFormatException e) {
                invalidParameter("additemtotile " + lineParts[1], lineParts[2]);
                return;
            }

            if(Environment.getInstance().getIceTiles().size() - 1 < tileID || tileID < 0) {
                System.out.println("Tile ID must be between 0 and the maximum ID of " + (Environment.getInstance().getIceTiles().size() - 1));
                return;
            }

            Tile tile = Environment.getInstance().getIceTiles().get(tileID);

            if(tile.getCapacity() == 0) {
                System.out.println("Items can't be placed in a hole!");
                return;
            }

            IcePatch icePatch = (IcePatch)tile;

            switch (itemID) {
                case 1:
                    icePatch.setBuriedItem(new Food());
                    break;
                case 2:
                    icePatch.setBuriedItem(new Rope());
                    break;
                case 3:
                    icePatch.setBuriedItem(new FragileShovel());
                    break;
                case 4:
                    icePatch.setBuriedItem(new Shovel());
                    break;
                case 5:
                    icePatch.setBuriedItem(new DiveSuit());
                    break;
                case 6:
                    icePatch.setBuriedItem(new Beacon());
                    break;
                case 7:
                    icePatch.setBuriedItem(new Gun());
                    break;
                case 8:
                    icePatch.setBuriedItem(new Cartridge());
                    break;
                case 9:
                    icePatch.setBuriedItem(new Tent());
                    break;
                default:
                    System.out.println("Item ID must be between with 1 and 9!");
                    return;
            }

            System.out.println("item added: " + tileID + ", " + itemID);
        }
    }

    /**
     * Interprets the command addcharactertotile
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_addcharactertotile(String[] lineParts) {
        if(!checkParamNumNoErrorMessage(lineParts, 2)) {
            printCharacters();
        }
        else {
            int tileID;
            int characterID;

            try {
                tileID = Integer.parseInt(lineParts[1]);
            } catch (NumberFormatException e) {
                invalidParameter("addcharactertotile", lineParts[1]);
                return;
            }

            try {
                characterID = Integer.parseInt(lineParts[2]);
            } catch (NumberFormatException e) {
                invalidParameter("addcharactertotile " + lineParts[1], lineParts[2]);
                return;
            }

            if (Environment.getInstance().getIceTiles().size() - 1 < tileID || tileID < 0) {
                System.out.println("Tile ID must be between 0 and the maximum ID of " + (Environment.getInstance().getIceTiles().size() - 1));
                return;
            }

            Tile tile = Environment.getInstance().getIceTiles().get(tileID);

            if (tile.getCapacity() == 0) {
                System.out.println("Characters can't be placed in a hole!");
                return;
            }

            IcePatch icePatch = (IcePatch) tile;

            switch (characterID){
                case 1:
                    icePatch.addCharacter(new Eskimo());
                    break;
                case 2:
                    icePatch.addCharacter(new Researcher());
                    break;
                case 3:
                    icePatch.addCharacter(new PolarBear());
                    break;
                default:
                    System.out.println("Character ID must be between with 1 and 3!");
                    return;
            }

            System.out.println("character added: " + tileID + ", " + characterID);
        }
    }

    /**
     * Interprets the command addsnowtotile
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     */
    private void command_addsnowtotile(String[] lineParts) {
        if(!checkParamNumNoErrorMessage(lineParts, 2)) {
            printCharacters();
        }
        else {
            int tileID;
            int snowQuantity;

            try {
                tileID = Integer.parseInt(lineParts[1]);
            } catch (NumberFormatException e) {
                invalidParameter("addsnowtotile", lineParts[1]);
                return;
            }

            try {
                snowQuantity = Integer.parseInt(lineParts[2]);
            } catch (NumberFormatException e) {
                invalidParameter("addsnowtotile " + lineParts[1], lineParts[2]);
                return;
            }

            if (Environment.getInstance().getIceTiles().size() - 1 < tileID || tileID < 0) {
                System.out.println("Tile ID must be between 0 and the maximum ID of " + (Environment.getInstance().getIceTiles().size() - 1));
                return;
            }

            int result = Environment.getInstance().getIceTiles().get(tileID).addSnow(snowQuantity);

            System.out.println("snow added: " + tileID + ", " + result);
        }
    }

    /**
     * Checks if there are enough parameters to interpret the line, without an error message
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     * @param paramNumWithoutCommand The number of parameters not counting the command itself
     * @return returns are there enough parameters
     */
    private boolean checkParamNumNoErrorMessage(String[] lineParts, int paramNumWithoutCommand) {
        return !(lineParts.length < paramNumWithoutCommand + 1);
    }

    /**
     * Checks if there are enough parameters to interpret the line, given an error message if there aren't enough
     *
     * @param lineParts The line's parts which should be interpreted, split at every space delim
     * @param paramNumWithoutCommand The number of parameters not counting the command itself
     * @return returns are there enough parameters
     */
    private boolean checkParamNum(String[] lineParts, int paramNumWithoutCommand) {
        if(lineParts.length < paramNumWithoutCommand + 1) {
            missingParameter(lineParts[0]);
            return false;
        }
        return true;
    }

    /**
     * Prints an error, that a parameter was missing in a command
     *
     * @param command The command which was tryed to be interpreted
     */
    private void missingParameter(String command) {
        invalidParameter(command, "Missing parameter!");
    }

    /**
     * Prints an error, that a parameter was invalid in a command
     *
     * @param command The command which was tryed to be interpreted
     * @param param The parameter which was wrong during the interpretation
     */
    private void invalidParameter(String command, String param) {
        System.out.println("Invalid parameter in " + "\"" + command + "\" command: " + param);
    }

    /**
     * Prints an error, that the command was invalid without a bonus error message
     *
     * @param line The line which should be interpreted
     */
    private void invalidCommand(String line) {
        invalidCommand(line, "");
    }

    /**
     * Prints an error, that the command was invalid with a bonus error message
     *
     * @param line The line which should be interpreted
     * @param errorMessage Error message
     */
    private void invalidCommand(String line, String errorMessage) {
        System.out.println("Invalid command: " + line + (errorMessage.equals("") ? "" : (" because " + errorMessage)));
    }

    /**
     * Interprets the given line as defined in the input language
     *
     * @param line The line which should be interpreted
     */
    private void interpret(String line) {
        String[] lineSegments = line.split(" ");
        if(lineSegments.length == 0) {
            invalidCommand("No command entered!");
            return;
        }

        switch (lineSegments[0]) {
            case "input":
                command_input(lineSegments);
                break;
            case "output":
                command_output(lineSegments);
                break;
            case "load":
                command_load(lineSegments);
                break;
            case "save":
                command_save(lineSegments);
                break;
            case "random":
                command_random(lineSegments);
                break;
            case "nextcharacter":
                command_nextcharacter(lineSegments);
                break;
            case "move":
                command_move(lineSegments);
                break;
            case "unbury":
                command_unbury(lineSegments);
                break;
            case "clearsnow":
                command_clearsnow(lineSegments);
                break;
            case "simulateweather":
                command_simulateweather(lineSegments);
                break;
            case "rescue":
                command_rescue(lineSegments);
                break;
            case "craftsignalflare":
                command_craftsignalflare(lineSegments);
                break;
            case "buildiglu":
                command_buildiglu(lineSegments);
                break;
            case "buildtent":
                command_buildtent(lineSegments);
                break;
            case "analyzetile":
                command_analyzetile(lineSegments);
                break;
            case "addtile":
                command_addtile(lineSegments);
                break;
            case "neighbourtile":
                command_neighbourtile(lineSegments);
                break;
            case "additemtotile":
                command_additemtotile(lineSegments);
                break;
            case "addcharactertotile":
                command_addcharactertotile(lineSegments);
                break;
            case "addsnowtotile":
                command_addsnowtotile(lineSegments);
                break;
            case "exit":
                running = false;
                break;
            case "quit":
                running = false;
                break;
            default:
                invalidCommand(line);
                break;
        }
    }

    /**
     * Runs the prototype
     */
    public void run()
    {
        if (!isDev)
            printInfo();

        in = new Scanner(System.in);
        file = false;
        running = true;
        console = System.out;

        while(running)
        {
            if(file && !in.hasNextLine())
            {
                System.out.println("File input successfully run!");
                file = false;
                in = new Scanner(System.in);
            }

            if(in.hasNextLine()) {
                String line = in.nextLine();
                line = line.toLowerCase();
                interpret(line);
            }
        }
    }
}
