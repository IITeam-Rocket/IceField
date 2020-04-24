import controllers.Prototype;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import testenv.IntArgumentsProvider;
import testenv.hackOStream;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Integration")
public class FileTest {
    private final hackOStream consoleOut = new hackOStream();
    private final PrintStream os = System.out;
    private final InputStream is = System.in;
    private File wd;
    private Map<File, File> testEnv;

    FileTest() throws IOException {
    }

    @BeforeEach
    public void setup() {
        testEnv = new TreeMap<File, File>();
        wd = new File(System.clearProperty("user.dir"));
        File[] files = wd.listFiles();

        for (File f :
                files) {
            if (f.isDirectory() && f.getName().equals("test")) {
                wd = f;
                break;
            }
        }
        files = wd.listFiles();

        for (File f :
                files) {
            if (f.isDirectory() && f.getName().equals("resources")) {
                wd = f;
                break;
            }
        }
        FileFilter testFilter = new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().endsWith("Test");
            }
        };

        FileFilter expectedFilter = new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().endsWith("Expected");
            }
        };

        File[] testfiles = wd.listFiles(testFilter);
        File[] expected = wd.listFiles(expectedFilter);

        for (File f : testfiles) {
            for (File v : expected) {
                if (v.getName().startsWith(f.getName())) {
                    testEnv.put(f, v);
                }
            }
        }
        System.setOut(consoleOut);
    }


    @ParameterizedTest
    @ArgumentsSource(IntArgumentsProvider.class)
    void test(int arg) {
        System.out.println(arg);
    }

    @Test
    public void tester() throws IOException, FileTestFailedException {
        for (Map.Entry<File, File> entry : testEnv.entrySet()) {

            File testInputFile = entry.getKey();
            File testExpectedOutput = entry.getValue();
            String testFilename = testInputFile.getName();
            String testExpectedFilename = testExpectedOutput.getName();

            FileInputStream fis = new FileInputStream(testInputFile);
            System.setIn(fis);

            Prototype game = new Prototype();
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
    }

    @AfterEach
    public void cleanup() {
        System.setOut(os);
        System.setIn(is);
    }
}
