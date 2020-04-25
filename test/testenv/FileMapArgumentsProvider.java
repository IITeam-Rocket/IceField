package testenv;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.io.File;
import java.io.FileFilter;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;


public class FileMapArgumentsProvider implements ArgumentsProvider {
    Map<File, File> fileMap = new TreeMap<>();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        getFiles();

        Map.Entry<File, File>[] testFiles = fileMap.entrySet().toArray(new Map.Entry[]{});

        return Stream.of(testFiles).map(Arguments::of);
    }

    private void getFiles() {
        File wd = new File(System.clearProperty("user.dir"));
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
                    fileMap.put(f, v);
                }
            }
        }
    }
}
