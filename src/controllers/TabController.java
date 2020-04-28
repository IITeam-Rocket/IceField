package controllers;

/**
 * Singleton class that controls indentations
 * for readable output.
 */
public class TabController {
    private static final TabController instance = new TabController();
    private static int indentCount = 0;

    /**
     * Private constructor for singleton use.
     */
    private TabController() {
    }

    /**
     * Returns the instance of the singleton.
     *
     * @return the instance of the class
     */
    public static TabController getInstance() {
        return instance;
    }

    /**
     * Adds one tab of indentation to be used
     * when printing.
     */
    public static void addIndent() {
        indentCount++;
    }

    /**
     * Removes one tab of indentation to be used
     * when printing.
     */
    public static void removeIndent() {
        indentCount--;
    }

    /**
     * Prints the current number of tabs to the
     * standard output.
     */
    public static void printIndents() {
        for (int i = 0; i < indentCount; ++i) {
            System.out.print("\t");
        }
    }
    /**
     * Prints the current number of tabs to the
     * standard output and prints the s String to the standard output.
     */
    public static void printlnWithIndents(String s){
        printIndents();
        System.out.println(s);
    }
}
