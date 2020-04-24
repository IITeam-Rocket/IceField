package controllers;

public class RandomController {

    static private boolean random = true;

    static public boolean getRandom() {
        return random;
    }

    static public void setRandom(boolean newValue) {
        random = newValue;
    }
}