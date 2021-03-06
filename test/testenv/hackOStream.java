package testenv;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayDeque;

public class hackOStream extends PrintStream {
    private final ArrayDeque<String> lines;

    public hackOStream() throws IOException {
        super(File.createTempFile("logtmp-", ".txt"));
        lines = new ArrayDeque<>();
    }

    @Override
    public void println(String x) {
        super.println(x);
        lines.addLast(x);
    }

    public String ReadLine() {
        if (lines.isEmpty()) return null;
        return lines.pop();
    }
}
