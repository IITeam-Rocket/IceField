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
                UseCaseExecutor.moveCharacterToStable();
                break;
            case 2:
                UseCaseExecutor.moveCharacterToInstable();
                break;
            case 3:
                UseCaseExecutor.moveCharacterToInstableWithDiveSuit();
                break;
            case 4:
                UseCaseExecutor.moveCharacterToInstableNoDiveSuit();
                break;
            case 5:
                UseCaseExecutor.moveCharacterToUndiscoveredHole();
                break;
            case 6:
                UseCaseExecutor.moveCharacterToDiscoveredHole();
                break;
            case 7:
                UseCaseExecutor.craftSignalFlare();
                break;
            case 8:
                UseCaseExecutor.clearPatch();
                break;
            case 9:
                UseCaseExecutor.analyzeStable();
                break;
            case 10:
                UseCaseExecutor.analyzeInstable();
                break;
            case 11:
                UseCaseExecutor.analyzeHole();
                break;
            case 12:
                UseCaseExecutor.buildIglu();
                break;
            case 13:
                UseCaseExecutor.rescueFriendWithRope();
                break;
            case 14:
                UseCaseExecutor.rescueFriendWithNothing();
                break;
            case 15:
                UseCaseExecutor.makeStormWithoutIglu();
                break;
            case 16:
                UseCaseExecutor.makeStormWithIglu();
                break;
            case 17:
                UseCaseExecutor.unburyFood();
                break;
            case 18:
                UseCaseExecutor.unburyDiveSuit();
                break;
            case 19:
                UseCaseExecutor.unburyRope();
                break;
            case 20:
                UseCaseExecutor.unburyShovel();
                break;
            case 21:
                UseCaseExecutor.unburyCartridge();
                break;
            case 22:
                UseCaseExecutor.unburyBeacon();
                break;
            case 23:
                UseCaseExecutor.unburyGun();
                break;
            default:
                System.out.println("Please enter a number! (1-" + (useCases.length + 1) + ")");
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
