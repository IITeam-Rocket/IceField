package controllers.game;

import controllers.game.commands.Command;

class CommandInterpreter {

    public CommandInterpreter() {
    }


    public void interpret(Command cmd) {
        cmd.execute();
    }
}
