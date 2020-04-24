import controllers.Prototype;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

public class FileTest {
    private final hackOStream consoleOut = new hackOStream();
    private final PrintStream os = System.out;
    private final InputStream is = System.in;


    FileTest() throws IOException {
    }

    @BeforeEach

    public void setup() {
        System.setOut(consoleOut);
    }

    @Test
    public void tester() throws IOException {
        File file = new File("/setRandomOffTest");
        FileInputStream fis = new FileInputStream(file);
        Prototype game = new Prototype();
        System.setIn(fis);

        game.run();

    }

    @AfterEach
    public void cleanup() {
        System.setOut(os);
        System.setIn(is);
    }
}
