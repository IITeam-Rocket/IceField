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

    private void menuCraftSignalFlare() {
        boolean answerBeacon = getYesNo("Does any character have a Beacon?");

        if (answerBeacon) {
            boolean answerGun = getYesNo("Does any character have a Gun?");

            if (answerGun) {
                boolean answerCatridge = getYesNo("Does any character have a Cartridge?");

                if (answerCatridge) {
                    boolean answerTile = getYesNo("Are the characters owning the Beacon, the Gun and the Cartridge on the same tile?");

                    if (answerTile) {
                        //TODO: Eltudják készíteni a jelzőraktát, így ki is lövik és megnyerik a játékot

                    } else {
                        //TODO: Nem egy mezőn vannak a darabokat birtokló szereplők nem tudják elkészíteni az jelzőrakétát

                    }
                } else {
                    //TODO: Egyik karakternél sincs patron

                }
            } else {
                //TODO: Egyik karakternél sincs pisztoly

            }
        } else {
            //TODO: Egyik karakternél sincs jelzőfény

        }
    }

    private void menuRescueFriend() {
        boolean answer = getYesNo("Does the character have a rope?");

        if (answer) {
            //TODO: Van kötél

        } else {
            //TODO: Nincs kötél

        }
    }

    private void menuUseSpecial() {
        int option = getMenuOption(new String[]{"Analyze Tile - Researcher", "Build Iglu - Eskimo"});

        if (option == 0) {
            int suboption = getMenuOption(new String[]{"Analyze Hole", "Analyze Instable", "Analyze Stable"});

            switch (suboption) {
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
            int suboption = getMenuOption(new String[]{"Build Iglu On Hole", "Build Iglu On Instable", "Build Iglu On Stable"});

            switch (suboption) {
                case 1:
                    //TODO: Lyukra épít iglut
                case 2:
                    //TODO: Instablra épít iglut
                case 3:
                    //TODO: Stabilra épít iglut
                    break;
            }
        }
    }

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

    private void menuMakeStorm() {
        int igluInside = getNumber("How many characters are inside of an iglu?", 10);
        int igluOutside = getNumber("How many characters are outside of an iglu?\n (Don't enter a huge number, because you will be asked to give their body heat individually)", 10);


        for (int i = 0; i < igluOutside; i++) {
            int bodyheat = getNumber("Enter the body heat for character " + (i + 1) + "/" + igluOutside, 100); //TODO: Jó lesz max 100?
            //TODO: Itt végig kell menni a játékosokon akik nincsennek igluban, és a bekért hőérzetet kell nekik beállítani
        }

        //TODO: Itt szimulálni kell a vihart, aki bent van sebződik (azokat a karaktereket is érdemes lehet létrehozni, akik igluban vannak a megfelelő szimuláció érdekében)
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
