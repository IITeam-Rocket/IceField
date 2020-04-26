import controllers.Prototype;
import models.exceptions.EndOfGameException;

public class Main {

  public static void main(String[] args) {
        Prototype prototype = new Prototype();
      try {
          prototype.run();
      } catch (EndOfGameException e) {
          e.printStackTrace();
      }
    }
}
