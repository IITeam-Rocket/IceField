import controllers.Prototype;
import controllers.Skeleton;
import models.exceptions.EndOfGameException;

public class Main {

  public static void main(String[] args) {
        Prototype prototype = new Prototype();
      try {
          prototype.run();
      } catch (EndOfGameException e) {
          e.printStackTrace();
      }

      //Skeleton skeleton = new Skeleton();
        //skeleton.run();
        //this is a comment
    }
}
