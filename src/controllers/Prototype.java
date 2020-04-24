package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Prototype {
    private Scanner in;
    private boolean file;
    private boolean running;
    private PrintStream console;

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

    private void command_input(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;

        if(lineParts[1].equals("console")) {
            System.out.println("Setting input to console...");
            in = new Scanner(System.in);
            System.out.println("Input set to console!");
            return;
        }

        try {
            in = new Scanner(new File(lineParts[1]));
        } catch (FileNotFoundException e) {
            System.out.println("Setting input to " + lineParts[1] + "...");
            System.out.println("File " + lineParts[1] + " doesn't exist!");
            System.out.println("Input set to " + lineParts[1] + "!");
        }
    }

    private void command_output(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;

        if(lineParts[1].equals("console")) {
            System.out.println("Setting output to console...");
            System.setOut(console);
            System.out.println("Output set to console!");
            return;
        }

        try {
            PrintStream o = new PrintStream(new File(lineParts[1]));
            System.out.println("Setting output to " + lineParts[1] + "...");
            System.setOut(o);
            System.out.println("Output set to " + lineParts[1] + "!");
        } catch (FileNotFoundException e) {
            System.out.println("File " + lineParts[1] + " doesn't exist!");
        }
    }

    private void command_load(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;
    }

    private void command_save(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;
    }

    private void command_random(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;
    }

    private void command_nextcharacter(String[] lineParts) {

    }

    private void command_move(String[] lineParts) {
        if(!checkParamNumNoErrorMessage(lineParts, 1)) {

        }
        else {

        }
    }

    private void command_unbury(String[] lineParts) {

    }

    private void command_clearsnow(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;
    }

    private void command_simulateweather(String[] lineParts) {

    }

    private void command_rescue(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;
    }

    private void command_craftsignalflare(String[] lineParts) {

    }

    private void command_buildiglu(String[] lineParts) {

    }

    private void command_buildtent(String[] lineParts) {

    }

    private void command_analyzetile(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;
    }

    private void command_addtile(String[] lineParts) {
        if(!checkParamNum(lineParts, 1))
            return;
    }

    private void command_neighbourtile(String[] lineParts) {
        if(!checkParamNum(lineParts, 2))
            return;
    }

    private void command_additemtotile(String[] lineParts) {
        if(!checkParamNumNoErrorMessage(lineParts, 2)) {

        }
        else {

        }
    }

    private void command_addcharactertotile(String[] lineParts) {
        if(!checkParamNumNoErrorMessage(lineParts, 2)) {

        }
        else {

        }
    }

    private void command_addsnowtotile(String[] lineParts) {
        if(!checkParamNum(lineParts, 2))
            return;
    }

    private boolean checkParamNumNoErrorMessage(String[] lineParts, int paramNumWithoutCommand) {
        return !(lineParts.length < paramNumWithoutCommand + 1);
    }

    private boolean checkParamNum(String[] lineParts, int paramNumWithoutCommand) {
        if(lineParts.length < paramNumWithoutCommand + 1) {
            missingParameter(lineParts[0]);
            return false;
        }
        return true;
    }

    private void missingParameter(String command) {
        invalidParameter(command, "Missing parameter!");
    }

    private void invalidParameter(String command, String param) {
        System.out.println("Invalid parameter in " + "\"" + command + "\" command: " + param);
    }

    private void invalidCommand(String line) {
        invalidCommand(line, "");
    }

    private void invalidCommand(String line, String errorMessage) {
        System.out.println("Invalid command: " + line);
    }

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

    public void run()
    {
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
