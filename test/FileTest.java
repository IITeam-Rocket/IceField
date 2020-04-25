import controllers.Prototype;
import models.exceptions.EndOfGameException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import testenv.FileMapArgumentsProvider;
import testenv.hackOStream;

import java.io.*;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Integration")
public class FileTest {
    private final hackOStream consoleOut = new hackOStream();
    private final PrintStream os = System.out;
    private final InputStream is = System.in;
    private Prototype game;

    FileTest() throws IOException {
    }

    @BeforeEach
    public void setup() {
        game = new Prototype(true);
        System.setOut(consoleOut);
    }

    @ParameterizedTest(name = "{index} => {0}")
    @ArgumentsSource(FileMapArgumentsProvider.class)
    public void tester(Map.Entry<File, File> entry) throws IOException, EndOfGameException {
        File testInputFile = entry.getKey();
        File testExpectedOutput = entry.getValue();
        String testFilename = testInputFile.getName();
        String testExpectedFilename = testExpectedOutput.getName();

        FileInputStream fis = new FileInputStream(testInputFile);
        System.setIn(fis);

        game.run();
        FileInputStream efis = new FileInputStream(testExpectedOutput);
        InputStreamReader isr = new InputStreamReader(efis);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            String expectedLine = br.readLine();
            String actualLine = consoleOut.ReadLine();

            if (expectedLine == null) break;

            assertEquals(expectedLine, actualLine, String.format("Error in testfile: %s expected output file: %s", testFilename, testExpectedFilename));
        }
    }

    @AfterEach
    public void cleanup() {
        System.setOut(os);
        System.setIn(is);
    }
}
