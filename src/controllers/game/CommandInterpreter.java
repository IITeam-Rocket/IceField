package controllers.game;

import controllers.game.commands.Command;

class CommandInterpreter {

    /**
     * Constructor
     *
     */
    public CommandInterpreter() {
    }


    /**
     * Command interpreter logic.
     *
     */
    public void interpret(Command cmd) {
        cmd.execute();
    }
}
