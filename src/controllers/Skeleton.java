package controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A class that controls the menu and executes the use-cases
 */
public class Skeleton {

    private Scanner in = new Scanner(System.in);
    String[] useCases = {
            "Move Character to Stable IcePatch",
            "Move Character to Instable IcePatch without flip",
            "Move Character to Instable IcePatch flipping with DiveSuit",
            "Move Character to Instable IcePatch flipping without DiveSuit",
            "Move Character to  Undiscovered Hole",
            "Move Character to Discovered Hole",
            "Craft Signal Flare",
            "Clear Patch",
            "Analyze an Stable IcePatch",
            "Analyze an Instable IcePatch",
            "Analyze a Hole",
            "Build an Igloo",
            "Rescue a Friend with a Rope",
            "Rescue a Friend with Nothing",
            "Make a Storm without an Igloo",
            "Make a Storm with an Igloo",
            "Unbury Food",
            "Unb8ury DiveSuit",
            "Unbury Rope",
            "Unbury Shovel",
            "Unbury Cartridge",
            "Unbury Beacon",
            "Unbury Gun"};

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


        System.out.println("Please choose a menu option (1-" + (useCases.length + 1) + "):");
        for (int i = 1; i <= useCases.length; ++i) {
            System.out.println(i + ". " + useCases[i - 1]);
        }
        System.out.println((useCases.length + 1) + ". Exit");
    }

    /**
     * Executes the proper menu item specified by selectedItem.
     *
     * @param selectedItem the menu item the player has selected.
     */
    private void executeSelected(int selectedItem) {
        switch (selectedItem) {
            case 1:
                //TODO: Move Character to Stable IcePatch
                break;
            case 2:
                //TODO: Move Character to Instable IcePatch without flip
                break;
            case 3:
                //TODO: Move Character to Instable IcePatch flipping with DiveSuit
                break;
            case 4:
                //TODO: Move Character to Instable IcePatch flipping without DiveSuit
                break;
            case 5:
                //TODO: Move Character to  Undiscovered Hole
                break;
            case 6:
                //TODO: Craft Signal Flare
                break;
            case 7:
                //TODO: Clear Patch
                break;
            case 8:
                //TODO: Analyze an Stable IcePatch
                break;
            case 9:
                //TODO: Analyze an Instable IcePatch
                break;
            case 10:
                //TODO: Analyze a Hole
                break;
            case 11:
                //TODO: Build an Igloo
                break;
            case 12:
                //TODO: Rescue a Friend with a Rope
                break;
            case 13:
                //TODO: Rescue a Friend with Nothing
                break;
            case 14:
                //TODO: Make a Storm without an Igloo
                break;
            case 15:
                //TODO: Make a Storm with an Igloo
                break;
            case 16:
                //TODO: Unbury Food
                break;
            case 17:
                //TODO: Unbury DiveSuit
                break;
            case 18:
                //TODO: Unbury Rope
                break;
            case 19:
                //TODO: Unbury Shovel
                break;
            case 20:
                //TODO: Unbury Cartridge
                break;
            case 21:
                //TODO: Unbury Beacon
                break;
            case 22:
                //TODO: Unbury Gun
                break;
        }
    }

    /**
     * Executes the Skeleton program used to
     * test the work-in-progress game.
     */
    public void run() {
        printInfo();
        printMenu();

        int selectedItem = 0;

        while (selectedItem != useCases.length + 1) {
            try {
                System.out.print("> ");
                selectedItem = in.nextInt();
                executeSelected(selectedItem);
            } catch (InputMismatchException exception) {
                System.out.println("Please enter a number! (1-" + (useCases.length + 1) + ")");
            }
        }
    }
}
