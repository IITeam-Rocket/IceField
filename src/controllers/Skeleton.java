package controllers;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Skeleton {

    private boolean running;
    private Scanner in;

    private void printInfo()
    {
        System.out.println("Szoftver projekt laboratórium - Skeleton");
        System.out.println("21 - team_rocket");
        System.out.println("");
        System.out.println("Konzulens: Dr. Goldschmidt Balázs");
        System.out.println("");
        System.out.println("Ábrahám Dániel          DASGYJ  d.abraham96@icloud.com");
        System.out.println("Matyasi Lilla Nóra      X986BV  lilla.matyasi@gmail.com");
        System.out.println("Kovács Marcell          U1UOXZ  kovacs.marcell99@gmail.com");
        System.out.println("Józsa György Bence      PAYR41  jozsa.gyuri9910@gmail.com");
        System.out.println("Tóth Máté               HBFE3R  extralarge3@gmail.com");
        System.out.println("");
    }

    private void printMenu()
    {
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

    private int getMenuOption(String[] answers)
    {
        if(answers.length == 0)
            return -1;

        System.out.println("Please choose a menu option (1-" + answers.length + "):");

        for(int i = 0; i < answers.length; i++)
        {
            System.out.println((i + 1) + ". " + answers[i]);
        }

        boolean answered = false;

        int input = -1;

        while(!answered)
        {
            System.out.print("> ");

            try
            {
                input = in.nextInt();

               if(input <= 0 || input > answers.length)
                   System.out.println("Please enter a number between 1-" + answers.length + "!");
               else
                   answered = true;
            }
            catch(InputMismatchException exception)
            {
                System.out.println("Please enter a number! (1-" + answers.length + ")");
            }
        }

        return input;
    }

    private boolean getYesNo(String question)
    {
        boolean answered = false;

        System.out.println(question + " (y/n)");

        while(!answered)
        {
            System.out.print("> ");

            try
            {
                String input = in.next();

                if(input.equals("y"))
                    return true;
                else if(input.equals("n"))
                    return false;
                else
                    System.out.println("Please enter y/n!");
            }
            catch(InputMismatchException exception)
            {
                System.out.println("Please enter y/n!");
            }
        }

        return false;
    }

    private int getNumber(String question)
    {
        boolean answered = false;

        System.out.println(question + " (Number 0>=)");

        int input = -1;

        while(!answered)
        {
            System.out.print("> ");

            try
            {
                input = in.nextInt();

                if(input >= 0)
                    answered = true;
                else
                    System.out.println("Please enter a number (>=0)!");
            }
            catch(InputMismatchException exception)
            {
                System.out.println("Please enter a number (>=0)!");
            }
        }

        return input;
    }

    private void menuMoveCharacter()
    {
        int option = getMenuOption(new String[]{"Move To Hole", "Move To Instable", "Move To Stable"});

        switch (option)
        {
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

    private void menuCraftSignalFlare()
    {
        boolean answer = getYesNo("Does a character have a rope?");
    }

    private void menuRescueFriend()
    {
        boolean answer = getYesNo("Does the character have a rope?");

        if(answer)
        {
            //TODO: Van kötél
        }
        else
        {
            //TODO: Nincs kötél
        }
    }

    private void menuUseSpecial()
    {
        int option = getMenuOption(new String[]{"Analyze Tile - Researcher", "Build Iglu - Eskimo"});

        if(option == 0)
        {
            int suboption = getMenuOption(new String[]{"Analyze Hole", "Analyze Instable", "Analyze Stable"});

            switch (suboption)
            {
                case 1:
                    //TODO: Lyukat analizál
                    break;
                case 2:
                    //TODO Instablit analizál
                    break;
                case 3:
                    //TODO Stabilt analizál
                    break;
            }
        }
        else
        {
            int suboption = getMenuOption(new String[]{"Build Iglu On Hole", "Build Iglu On Instable", "Build Iglu On Stable"});

            switch (suboption)
            {
                case 1:
                    //TODO: Lyukra épít iglut
                    break;
                case 2:
                    //TODO Instablra épít iglut
                    break;
                case 3:
                    //TODO Stabilra épít iglut
                    break;
            }
        }
    }

    private void menuUnburyItem()
    {
        int option = getMenuOption(new String[]{"Unbury Food", "Unbury Divesuit", "Unbury Shovel", "Unbury Rope", "Unbury Beacon", "Unbury Gun", "Unbury Cartridge"});

        switch (option)
        {
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

    private void menuMakeStorm()
    {
        int igluInside = getNumber("How many characters are inside of an iglu?");
        int igluOutside = getNumber("How many characters are outside of an iglu?\n (Don't enter a really big number you will be asked to give their)");

        for(int i = 0; i < igluOutside; i++)
        {
            //int igluOutside = getNumber("How many characters are outside of an iglu?");
        }
    }

    private void menuClearPatch()
    {

    }

    public void run()
    {
        printInfo();

        printMenu();

        running = true;

        in = new Scanner(System.in);

        while(running) {
            int option;

            try {
                System.out.print("> ");
                option = in.nextInt();

                switch (option)
                {
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
                        running = false;
                        break;
                    default:
                        System.out.println("Please enter a number between 1-8!");
                }
            }
            catch(InputMismatchException exception)
            {
                System.out.println("Please enter a number! (1-8)");
            }
        }
    }
}
