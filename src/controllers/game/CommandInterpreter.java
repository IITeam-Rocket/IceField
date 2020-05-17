package controllers.game;

import controllers.game.commands.Command;

class CommandInterpreter {
    private final Game game;

    public CommandInterpreter(Game game) {
        this.game = game;
    }


    public void interpret(Command cmd) {
        cmd.execute();
    }
}
