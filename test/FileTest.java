import controllers.Prototype;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        wd = new File(System.clearProperty("user.dir"));
        File[] files = wd.listFiles();
        for (File f : files) System.out.println(f.getName());
        for (File f :
                files) {
            if (f.isDirectory() && f.getName().equals("test")) {
                wd = f;
                break;
            }
        }
        files = wd.listFiles();
        for (File f : files) System.out.println(f.getName());
        for (File f :
                files) {
            if (f.isDirectory() && f.getName().equals("resource")) {
                wd = f;
                break;
            }
        }
        for (File f : files) System.out.println(f.getName());
        FileFilter testFilter = new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().endsWith("Test.txt");
            }
        };

        FileFilter expectedFilter = new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().endsWith("Expected.txt");
            }
        };

        File[] testfiles = wd.listFiles(testFilter);
        File[] expected = wd.listFiles(expectedFilter);

        for (File f : testfiles) {
            String testname = f.getName().split(".")[0];
            for (File v : expected) {
                if (v.getName().startsWith(testname)) {
                    testEnv.put(f, v);
                }
            }
        }
        System.setOut(consoleOut);
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
                if (actualLine == null)
                    throw new FileTestFailedException(String.format("Nem teljesített teszt %s - %s", testFilename, testExpectedFilename));

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
