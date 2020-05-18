import controllers.game.GameJFrame;

public class Main {

  public static void main(String[] args) {
      GameJFrame frame = GameJFrame.getInstance();

      frame.getGame().playGame();
    }
}
