import controllers.game.Game;
import controllers.game.GameJFrame;

public class Main {

  public static void main(String[] args) {
      GameJFrame frame = GameJFrame.getInstance();
      Game game = new Game();
      game.playGame();
    }
}
