package controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A class that controls the menu and executes the use-cases
 */
public class Skeleton {

    private Scanner in = new Scanner(System.in);

    /**
     * Prints the team's info on the screen.
     * Info includes:
     * Title
     * Team ID
     * Team Name
     * Consultant
     * Team members' info
     */
    private void printInfo() {
        System.out.println("Szoftver projekt laboratórium - Skeleton");
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
     * Prints the options the user can choose to the screen.
     */
    private void printMenu() {
        System.out.println("Please choose a menu option (1-8):");
        System.out.println("1. Move Character");
        System.out.println("2. Craft Signal Flare");
        System.out.println("3. Rescue Friend");
        System.out.println("4. Use Special");
        System.out.println("5. Unbury Item");
        System.out.println("6. Make Storm");
        System.out.println("7. Clear Patch");
        System.out.println("8. Exit program");
    }

    /**
     * Executes the proper menu item specified by selectedItem.
     *
     * @param selectedItem the menu item the player has selected.
     */
    private void executeSelected(int selectedItem) {
        switch (selectedItem) {
            case 1:
                menuMoveCharacter();
                printMenu();
                break;
            case 2:
                menuCraftSignalFlare();
                printMenu();
                break;
            case 3:
                menuRescueFriend();
                printMenu();
                break;
            case 4:
                menuUseSpecial();
                printMenu();
                break;
            case 5:
                menuUnburyItem();
                printMenu();
                break;
            case 6:
                menuMakeStorm();
                printMenu();
                break;
            case 7:
                menuClearPatch();
                printMenu();
                break;
            case 8:
                System.out.println("Goodbye :D");
                break;
            default:
                System.out.println("Please enter a number between 1-8!");
        }
    }

    /**
     * Asks the user to select aa menu option from a specified
     * list, and returns the number of the chosen one.
     *
     * @param answers an array of Strings containing the options
     * @return the number of the chosen option
     */
    private int getMenuOption(String[] answers) {
        if (answers.length == 0)
            return -1;
        System.out.println("Please choose a menu option (1-" + answers.length + "):");

        for (int i = 1; i <= answers.length; i++) {
            System.out.println(i + ". " + answers[i - 1]);
        }

        int input;

        while (true) {
            System.out.print("> ");

            try {
                input = in.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("Please enter a number! (1-" + answers.length + ")");
                continue;
            }
            if (input <= 0 || input > answers.length)
                System.out.println("Please enter a number between 1-" + answers.length + "!");
            else
                break;
        }

        return input;
    }

    /**
     * Asks the user to answer to a Yes or No question,
     * and returns with the boolean answer.
     *
     * @param question a String containing a simple question
     * @return true if answer was a yes, false otherwise
     */
    private boolean getYesNo(String question) {

        System.out.println(question + " (y/n)");

        while (true) {
            System.out.print("> ");
            String input;

            try {
                input = in.next();
            } catch (InputMismatchException exception) {
                System.out.println("Please enter y/n!");
                continue;
            }

            if (input.equals("y"))
                return true;
            else if (input.equals("n"))
                return false;
            else
                System.out.println("Please enter y/n!");
        }
    }

    /**
     * Asks the user to enter a number between 0 and max.
     *
     * @param question a String containing a question to which
     *                 the user can answer with the number.
     * @param max      the largest possible number that can be chosen
     * @return the chosen number
     */
    private int getNumber(String question, int max) {

        String range = " (0-" + max + ")";
        System.out.println(question + range);

        int input;

        while (true) {
            System.out.print("> ");
            try {
                input = in.nextInt();

                if (input >= 0 && input <= max)
                    break;
                else
                    System.out.println("Please enter a number" + range + "!");
            } catch (InputMismatchException exception) {
                System.out.println("Please enter a number" + range + "!");
                in.next();
            }
        }

        return input;
    }

    /**
     * Executes one of the 'MoveCharacter' use cases.
     */
    private void menuMoveCharacter() {
        int option = getMenuOption(new String[]{"Move To Hole", "Move To Instable", "Move To Stable"});

        switch (option) {
            case 1:
                //TODO: Lyukra lép
                break;
            case 2:
                //TODO Instablira lép
                break;
            case 3:
                //TODO Stabilra lép
                break;
        }
    }

    /**
     * Executes CraftSignalFlare use case
     */
    private void menuCraftSignalFlare() {
        boolean answerBeacon = getYesNo("Does any character have a Beacon?");
        boolean answerGun = getYesNo("Does any character have a Gun?");
        boolean answerCartridge = getYesNo("Does any character have a Cartridge?");
        boolean answerTile = getYesNo("Are all the characters on the same tile?");

        //TODO: CraftSignalFlare
    }

    /**
     * Executes one of the 'RescueFriend' use cases
     */
    private void menuRescueFriend() {
        boolean answer = getYesNo("Does the character have a rope?");
        if (answer) {
            //TODO: Van kötél

        } else {
            //TODO: Nincs kötél
        }
    }

    /**
     * Executes one of the 'UseSpecial' use cases
     */
    private void menuUseSpecial() {
        int option = getMenuOption(new String[]{"Analyze Tile - Researcher", "Build Iglu - Eskimo"});

        if (option == 0) {
            int subOption = getMenuOption(new String[]{"Analyze Hole", "Analyze Instable", "Analyze Stable"});
            switch (subOption) {
                case 1:
                    //TODO: Lyukat analizál
                    break;
                case 2:
                    //TODO: Instablit analizál
                    break;
                case 3:
                    //TODO: Stabilt analizál
                    break;
            }
        } else {
            //TODO iglut épít
        }
    }

    /**
     * Executes one of the 'Unbury Item' use cases
     */
    private void menuUnburyItem() {
        int option = getMenuOption(new String[]{"Unbury Food", "Unbury Divesuit", "Unbury Shovel", "Unbury Rope", "Unbury Beacon", "Unbury Gun", "Unbury Cartridge"});
        switch (option) {
            case 1:
                //TODO: Kaját ás ki
                break;
            case 2:
                //TODO: Búvárruhát ás ki
                break;
            case 3:
                //TODO: Lapátot ás ki
                break;
            case 4:
                //TODO: Kötelet ás ki
                break;
            case 5:
                //TODO: Jelzőfényt ás ki
                break;
            case 6:
                //TODO: Pisztolyt ás ki
                break;
            case 7:
                //TODO: Patront ás ki
                break;
        }
    }

    /**
     * Executes a 'MakeStorm' use case
     */
    private void menuMakeStorm() {
        boolean hasIglu = getYesNo("Does the tile have an Igloo?");
        //TODO: makeStorm
    }

    private void menuClearPatch() {
        int snowAmount = getNumber("How many units of snow are there currently on the targeted tile?", 6);

        boolean answer = getYesNo("Does a character have a shovel?");

        if (answer) {
            //TODO: Van lapátja, így leszed 2 egység havat
        } else {
            //TODO: Nincs lapátja
        }
    }

    public void run() {
        printInfo();
        printMenu();

        int selectedItem = 0;

        while (selectedItem != 8) {
            try {
                System.out.print("> ");
                selectedItem = in.nextInt();
                executeSelected(selectedItem);
            } catch (InputMismatchException exception) {
                System.out.println("Please enter a number! (1-8)");
            }
        }
    }
}
